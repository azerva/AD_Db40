package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.DataBase_Db4o;
import view.AddAutorView;
import view.AddLibroView;
import view.AutoresView;
import view.BibliotecaView;
import view.LibrosView;

/**
 *
 * @author ROZER
 */
public class ControladorBiblioteca implements ActionListener {

    private final BibliotecaView view;

    private final String connectionFail = "No se ha establecido conexión con la base de datos";
    private final String connectionOk = "Conexión establecida con la base de datos";

    public ControladorBiblioteca(BibliotecaView view) {
        this.view = view;

        connectioStatus();
        DataBase_Db4o.getDb();
        events();
    }

    public final void events() {
        view.btnSalir.addActionListener(this);
        view.btnLibrosConsulta.addActionListener(this);
        view.btnAutorConsulta.addActionListener(this);
        view.btnAddAutores.addActionListener(this);
        view.btnAddLibros.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.btnSalir) {
            int salir = JOptionPane.showConfirmDialog(view, "¿Está seguro que desea salir de la aplicación?\n Si sale se cerrará la conexión con el servidor.",
                    "SALIR", JOptionPane.YES_NO_OPTION);

            if (salir == 0) {
                DataBase_Db4o.closeDb();
//                JOptionPane.showMessageDialog(view, "Se ha cerrado la conexión con la base de datos.");
                view.dispose();
            }
        }

        if (e.getSource() == view.btnAddLibros) {
            JDialog libro = new AddLibroView(view, true);
            libro.setVisible(true);
        }

        if (e.getSource() == view.btnLibrosConsulta) {
            JDialog libros = new LibrosView(view, true);
            libros.setVisible(true);
        }

        if (e.getSource() == view.btnAutorConsulta) {
            JDialog autores = new AutoresView(view, true);
            autores.setVisible(true);
        }
        
        if (e.getSource() == view.btnAddAutores) {
            JDialog autores = new AddAutorView(view, true);
            autores.setVisible(true);
        }
    }

    private void connectioStatus() {

        if (DataBase_Db4o.getDb() == null) {
            view.txtConecctionStatus.setText(connectionFail);
        }

        if (DataBase_Db4o.getDb() != null) {
            view.txtConecctionStatus.setText(connectionOk);
        }

    }

}
