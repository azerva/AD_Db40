/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.db4o.ObjectSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Autores;
import model.DataBase_Db4o;
import model.Libros;
import view.AddLibroView;

/**
 *
 * @author ROZER
 */
public class ControladorAddLibro implements ActionListener {

    private final AddLibroView v;
    StringBuilder mensajeErrorDatos = new StringBuilder();

    public ControladorAddLibro(AddLibroView aThis) {
        this.v = aThis;

        events();
        DataBase_Db4o.getDb();

        fillAutorComboBox();
        setEditableCamposAutor();
    }

    private void events() {
        v.btnSalir.addActionListener(this);
        v.btnAgregarLibro.addActionListener(this);
        v.btnCompleteDataAutor.addActionListener(this);
    }

    /**
     * Establecemos el comportamiento de las acciones de los botones o
     * componentes que vayan a crear algun eventos al ser pulsados.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object ae = e.getSource();

        if (ae == v.btnSalir) {
            exit();
        }
        if (ae == v.btnAgregarLibro) {
            if (datosCorrectos()) {
                addLibro();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(v, mensajeErrorDatos, ".: ERROR :.", JOptionPane.OK_OPTION);
            }
        }

        if (ae == v.btnCompleteDataAutor) {
            rellenarCamposAutor();
        }

    }

    private void exit() {
        int salir = JOptionPane.showConfirmDialog(v, "¿Está seguro que desea salir de la aplicación?\n Si sale se cerrará la conexión con el servidor.",
                "SALIR", JOptionPane.YES_NO_OPTION);

        if (salir == 0) {
            DataBase_Db4o.closeDb();
            v.dispose();
        }
    }

    private boolean datosCorrectos() {
        boolean correct = false;

        if (v.etTitutloLibro.getText().isEmpty() || v.etPrecioLibro.getText().isEmpty() || v.etEditorialLibro.getText().isEmpty()
                || v.comboBoxCategoriaLibro.getSelectedIndex() == 0) {
            correct = false;
            mensajeErrorDatos.append("Rellene todos los campos del Libro y escoja una Categoría.");
            /**
             * Falta verificar los campos del autor
             */
        } else if (v.etNacimientoAutor.getText().isEmpty() || v.etNacimientoAutor.getText().isEmpty() || v.etNacionAutor.getText().isEmpty()
                || v.etTipoAutor.getText().isEmpty() || v.etReferenciaAutor.getText().isEmpty()) {
            correct = false;
            mensajeErrorDatos.append("Seleccione un autor de la lista desplegable.\nEn el caso de no existir el autor agreguelo desde el apartado agregar autor.");
        } else {
            correct = true;
        }
        return correct;

    }

    private void addLibro() {
        Double precio = Double.parseDouble(v.etPrecioLibro.getText());

        Autores autor = new Autores(v.etReferenciaAutor.getText(), v.etNombreAutor.getText(), v.etNacionAutor.getText(),
                v.etNacimientoAutor.getText(), v.etTipoAutor.getText());

        Libros libro = new Libros(v.etTitutloLibro.getText(), precio, v.etEditorialLibro.getText(),
                v.comboBoxCategoriaLibro.getSelectedItem().toString(), autor);
        try {

            DataBase_Db4o.getDb();

            DataBase_Db4o.guardarLibro(libro);
            DataBase_Db4o.getDb().commit();

        } catch (Exception ex) {
            System.out.println("Error al guardar el libro en la base de datos: " + ex.getMessage());
            JOptionPane.showMessageDialog(v, "Error al libro el autor en la base de datos: " + ex.getMessage());
        } finally {
            DataBase_Db4o.closeDb();
        }
    }

    private void fillAutorComboBox() {
        JComboBox list = v.comboAutores;
        List<Autores> a = DataBase_Db4o.obtenerTodosAutores();

        list.removeAllItems();
        list.addItem("SELECCIONE UN AUTOR...");

        for (Autores autor : a) {
            list.addItem(autor.getNombre().toString());
        }
    }

    private void rellenarCamposAutor() {

        DataBase_Db4o.getDb();
        ObjectSet<Autores> resultado = DataBase_Db4o.obtenerDatosAutor(v.comboAutores.getSelectedItem().toString());

        if (resultado.hasNext()) {
            // Obtener el objeto recuperado
            Autores autores = resultado.next();

            //Mostrar los elementos del objeto en JTextField
            v.etNombreAutor.setText(autores.getNombre());
            v.etNacimientoAutor.setText(autores.getFecha_nacimiento());
            v.etNacionAutor.setText(autores.getNacionalidad());
            v.etReferenciaAutor.setText(autores.getReferencia());
            v.etTipoAutor.setText(autores.getTipo());

        }

    }

    private void setEditableCamposAutor() {
        v.etNombreAutor.setEditable(false);
        v.etNacimientoAutor.setEditable(false);
        v.etNacionAutor.setEditable(false);
        v.etReferenciaAutor.setEditable(false);
        v.etTipoAutor.setEditable(false);
    }

    private void limpiarCampos() {
        v.etNombreAutor.setText("");
        v.etNacimientoAutor.setText("");
        v.etNacionAutor.setText("");
        v.etReferenciaAutor.setText("");
        v.etTipoAutor.setText("");
        v.comboAutores.setSelectedIndex(0);
        v.etTitutloLibro.setText("");
        v.etPrecioLibro.setText("");
        v.etEditorialLibro.setText("");
        v.comboBoxCategoriaLibro.setSelectedIndex(0);
    }

}
