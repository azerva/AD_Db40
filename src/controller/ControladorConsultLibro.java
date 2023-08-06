/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DataBase_Db4o;
import model.Libros;
import view.LibrosView;

/**
 *
 * @author ROZER
 */
public class ControladorConsultLibro implements ActionListener {

    private final LibrosView view;
    DefaultTableModel table;

    public ControladorConsultLibro(LibrosView view) {
        this.view = view;

        events();
        componentsDisable();
        view.txtPrecioDesde.setText("0.00");
        view.txtPrecioHasta.setText("0.00");

        DataBase_Db4o.getDb();
    }

    private void events() {
        view.btnSalir.addActionListener(this);
        view.rbConsultaLibrosPorPrecios.addActionListener(this);
        view.rbBorrarLibroPorTitulo.addActionListener(this);
        view.rbSubirPrecios.addActionListener(this);
        view.btnBuscarLibroPorPrecio.addActionListener(this);
        view.btnBorrarLibroPorTitulo.addActionListener(this);
        view.btnConfirmarSubidaPrecios.addActionListener(this);
        view.btnRegistros.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double max = Double.parseDouble(view.txtPrecioHasta.getText());
        double min = Double.parseDouble(view.txtPrecioDesde.getText());
        double porcentajeAumento = 5.0;
        String titulo = view.txtTitutloLibro.getText();

        List<Libros> listaPorPrecio = DataBase_Db4o.obtenerLibrosPorPrecio(min, max);
        List<Libros> registros = DataBase_Db4o.obtenerTodosLibros();

        if (e.getSource() == view.btnSalir) {
            int salir = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea salir?",
                    "SALIR", JOptionPane.OK_CANCEL_OPTION);

            if (salir == 0) {
                DataBase_Db4o.closeDb();
                JOptionPane.showMessageDialog(view, "Se ha cerrado la conexión con la base de datos.");
                view.dispose();
            }
        }
        if (e.getSource() == view.btnRegistros) {
            fillTable(registros);
        }

        if (e.getSource() == view.rbConsultaLibrosPorPrecios) {
            view.txtPrecioDesde.setEditable(true);
            view.txtPrecioHasta.setEditable(true);
            view.txtTitutloLibro.setEditable(false);
            view.btnConfirmarSubidaPrecios.setEnabled(false);
            view.btnBuscarLibroPorPrecio.setEnabled(true);
            view.btnBorrarLibroPorTitulo.setEnabled(false);

        }
        if (e.getSource() == view.btnBuscarLibroPorPrecio) {
            fillTable(listaPorPrecio);
        }
        if (e.getSource() == view.rbBorrarLibroPorTitulo) {
            view.txtPrecioDesde.setEditable(false);
            view.txtPrecioHasta.setEditable(false);
            view.txtTitutloLibro.setEditable(true);
            view.btnConfirmarSubidaPrecios.setEnabled(false);
            view.btnBuscarLibroPorPrecio.setEnabled(false);
            view.btnBorrarLibroPorTitulo.setEnabled(true);
            view.txtPrecioDesde.setText("0.00");
            view.txtPrecioHasta.setText("0.00");
            //table.fireTableDataChanged();

        }
        if (e.getSource() == view.btnBorrarLibroPorTitulo) {
            int borrar = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea borrar el libro?",
                    "BORRAR", JOptionPane.OK_CANCEL_OPTION);
            //view.txtTitutloLibro.setText(view.txtTitutloLibro.getText().toUpperCase());
            if (borrar == 0) {
                DataBase_Db4o.deleteLibro(titulo);
//		eliminarLibro(titulo);

            }
            //Intentamos que se actualice la lista de registros
            //fillTable(registros);
            //table.fireTableDataChanged();

        }
        if (e.getSource() == view.rbSubirPrecios) {
            view.txtPrecioDesde.setEditable(false);
            view.txtPrecioHasta.setEditable(false);
            view.txtTitutloLibro.setEditable(false);
            view.btnConfirmarSubidaPrecios.setEnabled(true);
            view.btnBuscarLibroPorPrecio.setEnabled(false);
            view.btnBorrarLibroPorTitulo.setEnabled(false);
            view.txtPrecioDesde.setText("0.00");
            view.txtPrecioHasta.setText("0.00");
            //table.fireTableDataChanged();

        }
        if (e.getSource() == view.btnConfirmarSubidaPrecios) {
            int borrar = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea aumentar un 5% el precio de los libros?",
                    "SUBIR PRECIOS", JOptionPane.OK_CANCEL_OPTION);
            if (borrar == 0) {
                DataBase_Db4o.aumentarPrecioLibros(porcentajeAumento);
            }
        }

    }

    /**
     * Método con le cual deshabilitaremos las opciones de consulta para cada
     * radioButton al acceder al formulario.
     */
    private void componentsDisable() {

        if (!view.rbConsultaLibrosPorPrecios.isSelected() || !view.rbBorrarLibroPorTitulo.isSelected()
                || !view.rbSubirPrecios.isSelected()) {
            view.txtPrecioDesde.setEditable(false);
            view.txtPrecioHasta.setEditable(false);
            view.txtTitutloLibro.setEditable(false);
            view.btnConfirmarSubidaPrecios.setEnabled(false);
            view.btnBuscarLibroPorPrecio.setEnabled(false);
            view.btnBorrarLibroPorTitulo.setEnabled(false);
        }

    }

    private void fillTable(List<Libros> list) {

        table = new DefaultTableModel();

        String[] columList = {"Título", "Precio", "Editorial", "Tipo"};

        for (String columList1 : columList) {
            table.addColumn(columList1);
        }

        Object[] filaList = new Object[4];

        for (int i = 0; i < list.size(); i++) {
            filaList[0] = list.get(i).getTitulo().toUpperCase();
            filaList[1] = list.get(i).getPrecio();
            filaList[2] = list.get(i).getEditorial().toUpperCase();
            filaList[3] = list.get(i).getTipo().toUpperCase();

            table.addRow(filaList);
        }
        view.tablaLibro.setModel(table);
        view.tablaLibro.updateUI();
        view.jScrollPane1.setViewportView(view.tablaLibro);

    }

}
