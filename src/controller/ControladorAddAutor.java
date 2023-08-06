/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.db4o.ObjectContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Autores;
import model.DataBase_Db4o;
import view.AddAutorView;

/**
 *
 * @author ROZER
 */
public class ControladorAddAutor implements ActionListener {

    private final AddAutorView view;
    private ObjectContainer oc;
    DataBase_Db4o db = new DataBase_Db4o();

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = sdf.format(date);

    StringBuilder mensajeErrorDatos = new StringBuilder();
    String referencia = "Introduzca la referenica del autor\n";
    String nombre = "Introduzca el nombre del autor\n";
    String nacionalidad = "Introduzca la nacionalidad del autor\n";
    String fechaNac = "Introduzca correctamente la fecha de nacimiento del autor\n";
    String tipo = "Seleccione el tipo de autor.";
    String patronFecha = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}";

    public ControladorAddAutor(AddAutorView view) {
        this.view = view;

        events();

    }

    private void events() {
        view.btnAgregarAutor.addActionListener(this);
        view.btnSalir.addActionListener(this);
        view.comboBoxTipoAutor.addActionListener(this);
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

        JComboBox<String> type = view.comboBoxTipoAutor;

        if (ae == view.btnSalir) {
            exit();
        }

        if (ae == type) {
            if (type.getSelectedIndex() == 1) {
                editComponentsAutor();
            }
            if (type.getSelectedIndex() == 2) {
                editComponentsAnonimo();
            }
        }

        if (ae == view.btnAgregarAutor) {
            if (datosCorrectos()) {
                if (!addedAuthor()) {
                    addAutor();
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "El autor introducido ya existe en la base de datos");
                    limpiarCampos();
                }
            } else {
                JOptionPane.showMessageDialog(view, mensajeErrorDatos, "Faltan datos", JOptionPane.INFORMATION_MESSAGE);
                mensajeErrorDatos.setLength(0);
            }
        }

    }

    /**
     * Rellenamos el JComboBox con una lista de paises para agregar la
     * nacionalidad del autor.
     */
    /*
    private void rellenarListaPaises() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("lista_paises.txt"));
            String linea;

            view.comboBoxListPaises.removeAllItems();

            while ((linea = br.readLine()) != null) {

                view.comboBoxListPaises.addItem(linea.toUpperCase());

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorAddAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAddAutor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorAddAutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
     */
    private void exit() {
        int salir = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea salir de la aplicación?\n Si sale se cerrará la conexión con el servidor.",
                "SALIR", JOptionPane.YES_NO_OPTION);

        if (salir == 0) {
            DataBase_Db4o.closeDb();
            view.dispose();
        }
    }

    private void editComponentsAnonimo() {
        view.etReferencia.setText("000");
        view.etNombre.setText("ANÓNIMO");
        view.etFechaNacimiento.setText("00/00/0000");
        view.etNacionalidad.setText("SIN DEFINIR");
        view.etReferencia.setEditable(false);
        view.etNombre.setEditable(false);
        view.etFechaNacimiento.setEditable(false);
        view.etNacionalidad.setEditable(false);
    }

    private void editComponentsAutor() {
        view.etReferencia.setText("");
        view.etNombre.setText("");
        view.etFechaNacimiento.setText(fecha);
        view.etNacionalidad.setText("");
        view.etReferencia.setEditable(true);
        view.etNombre.setEditable(true);
        view.etFechaNacimiento.setEditable(true);
        view.etNacionalidad.setEditable(true);

    }

    private void limpiarCampos() {
        view.etReferencia.setText("");
        view.etNombre.setText("");
        view.etFechaNacimiento.setText("");
    }

    private boolean datosCorrectos() {
        boolean correct = false;

        String fechaIntroducida = view.etFechaNacimiento.getText();

        if (view.etReferencia.getText().isEmpty()) {
            correct = false;
            mensajeErrorDatos.append(referencia);
        } else if (view.etNombre.getText().isEmpty()) {
            correct = false;
            mensajeErrorDatos.append(nombre);
        } else if (view.etNacionalidad.getText().isEmpty()) {
            correct = false;
            mensajeErrorDatos.append(nacionalidad);
        } else if (fechaIntroducida.equalsIgnoreCase(fecha)) {
            correct = false;
            mensajeErrorDatos.append(fechaNac);
            /*}//verificamos que la fecha no sea posterior a la actual  
        else if (fechaIntroducida.equalsIgnoreCase(date.after(date))) {
            valido = false;
            mensajeErrorDatos.append(fechaNac);*/
            //verificamos que el patron introducido para la fecha sea correcto
        } else if (!fechaIntroducida.matches(patronFecha)) {
            correct = false;
            mensajeErrorDatos.append(fechaNac);
        } else if (view.comboBoxTipoAutor.getSelectedIndex() == 0) {
            mensajeErrorDatos.append(tipo);
        } else {
            correct = true;
        }

        return correct;
    }

    private void addAutor() {
	try {

	    Autores a = new Autores(view.etReferencia.getText(), view.etNombre.getText(), view.etNacionalidad.getText(),
		    view.etFechaNacimiento.getText(), view.comboBoxTipoAutor.getSelectedItem().toString());

	    DataBase_Db4o.getDb();

	    DataBase_Db4o.guardarAutor(a);

	    DataBase_Db4o.getDb().commit();

	} catch (Exception ex) {
	    System.out.println("Error al guardar el autor en la base de datos: " + ex.getMessage());
	    JOptionPane.showMessageDialog(view, "Error al guardar el autor en la base de datos: " + ex.getMessage());
	} finally {
	    DataBase_Db4o.closeDb();
	}
    }

    private boolean addedAuthor() {
        boolean added = false;

        try {
            DataBase_Db4o.getDb();

            List<Autores> a = DataBase_Db4o.obtenerTodosAutores();
            for (Autores autores : a) {

                if (autores.getNombre().equals(view.etNombre.getText())) {
                    added = true;
                } else {
                    added = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DataBase_Db4o.closeDb();
        }
        return added;
    }

}
