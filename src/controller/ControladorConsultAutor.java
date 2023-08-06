package controller;

import com.db4o.ObjectContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autores;
import model.DataBase_Db4o;
import model.Libros;
import view.AutoresView;

/**
 *
 * @author ROZER
 */
public class ControladorConsultAutor implements ActionListener {

    private final AutoresView view;
    DefaultTableModel dtf;
    DataBase_Db4o db = new DataBase_Db4o();
    ObjectContainer oc;

    public ControladorConsultAutor(AutoresView view) {
        this.view = view;

        events();
        DataBase_Db4o.getDb();
        view.tablaAutores.setEnabled(false);
        view.jScrollPane1.setEnabled(true);
        //componentsDisable();

        //Comprobamos por pantalla si hay algun autor registrado
        List<Autores> autoreslist = db.obtenerTodosAutores();
        for (Autores autores : autoreslist) {
            System.out.println(autores);

        }

    }

    private void events() {
        view.btnSalirAutores.addActionListener(this);
        view.btnRegistrosAutores.addActionListener(this);
        view.btnBuscar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        String tipo = view.comboTipoAutor.getSelectedItem().toString();
        String esp = "ESPAÑA";

        List<Autores> autoresEspList = DataBase_Db4o.obtenerAutoresPorNacionalidad(esp);
        List<Autores> tipoAutorList = DataBase_Db4o.obtenerAutoresPorTipo();
        List<Autores> registros = DataBase_Db4o.obtenerTodosAutores();
        List<Libros> listaLibrosPorAutor = DataBase_Db4o.obtenerLibrosPorAutor(view.txtBuscarPorNombre.getText());

        if (ae == view.btnSalirAutores) {
            int salir = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea salir?",
                    "SALIR", JOptionPane.OK_CANCEL_OPTION);

            if (salir == 0) {
                DataBase_Db4o.closeDb();
                JOptionPane.showMessageDialog(view, "Se ha cerrado la conexión con la base de datos.");
                view.dispose();
            }

        }

        if (ae == view.btnRegistrosAutores) {
            if (registros == null) {
                JOptionPane.showMessageDialog(view, "no se han encontrado datos en la base de datos.");

            } else {
                fillTableAutores(tipoAutorList);
            }
        }
        if (e.getSource() == view.btnBuscar) {
            if (view.rbBuscarPorTipoAutor.isSelected()) {
                fillTableAutores(tipoAutorList);
            }
            if (view.rbBuscarPorNombre.isSelected()) {
                fillTable(listaLibrosPorAutor);
            }
            if (view.rbBuscarAutoresEsp.isSelected()) {
                fillTableAutores(autoresEspList);
            }

        }
    }

    private void fillTableAutores(List<Autores> list) {

        dtf = new DefaultTableModel();

        String[] columList = {"Nombre", "Nacionalidad", "F_Nacimiento", "Tipo"};

        for (String header : columList) {
            dtf.addColumn(header);
        }

        Object[] filaList = new Object[4];

        for (int i = 0; i < list.size(); i++) {
            filaList[0] = list.get(i).getNombre().toUpperCase();
            filaList[1] = list.get(i).getNacionalidad().toUpperCase();
            filaList[2] = list.get(i).getFecha_nacimiento();
            filaList[3] = list.get(i).getTipo().toUpperCase();

            dtf.addRow(filaList);
        }
        view.tablaAutores.setModel(dtf);
        view.tablaAutores.updateUI();
        view.jScrollPane1.setViewportView(view.tablaAutores);

    }

    private void fillTable(List<Libros> list) {
        DefaultTableModel dtf = new DefaultTableModel();

        String[] columList = {"Título", "Precio", "Editorial", "Tipo"};

        for (String columList1 : columList) {
            dtf.addColumn(columList1);
        }

        Object[] filaList = new Object[4];

        for (int i = 0;
                i < list.size();
                i++) {
            filaList[0] = list.get(i).getTitulo().toUpperCase();
            filaList[1] = list.get(i).getPrecio();
            filaList[2] = list.get(i).getEditorial().toUpperCase();
            filaList[3] = list.get(i).getTipo().toUpperCase();

            dtf.addRow(filaList);
        }

        view.tablaAutores.setModel(dtf);

        view.tablaAutores.updateUI();

        view.jScrollPane1.setViewportView(view.tablaAutores);

    }

    /*private void componentsDisable() {

        if (!view.rbBuscarAutoresEsp.isSelected() || !view.rbBuscarPorNombre.isSelected()
                || !view.rbBuscarPorTipoAutor.isSelected()) {
            view.comboTipoAutor.setEnabled(false);
            view.txtBuscarPorNombre.setEditable(false);

        }

    }*/
}
