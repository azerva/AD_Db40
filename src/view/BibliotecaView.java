package view;

import controller.ControladorBiblioteca;
import java.awt.Font;

/**
 *
 * @author ROZER
 */
public class BibliotecaView extends javax.swing.JFrame {

    private final ControladorBiblioteca control;
    Font font;

    /**
     * Creates new form BibliotecaView
     */
    public BibliotecaView() {
        initComponents();

        setTitle("BIBLIOTECA");
        this.setLocationRelativeTo(this);
        control = new ControladorBiblioteca(this);
       
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        txtConecctionStatus = new javax.swing.JLabel();
        btnAddAutores = new javax.swing.JButton();
        txtAgregar = new javax.swing.JLabel();
        btnAddLibros = new javax.swing.JButton();
        txtAgregar1 = new javax.swing.JLabel();
        btnAutorConsulta = new javax.swing.JButton();
        btnLibrosConsulta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        labelHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        labelHeader.setForeground(new java.awt.Color(0, 0, 0));
        labelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeader.setText("BIBLIOTECA");

        txtConecctionStatus.setFont(new java.awt.Font("Dialog", 2, 10)); // NOI18N
        txtConecctionStatus.setForeground(new java.awt.Color(0, 0, 0));
        txtConecctionStatus.setText("*Status");

        btnAddAutores.setBackground(new java.awt.Color(153, 153, 0));
        btnAddAutores.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        btnAddAutores.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAutores.setText("AGREGAR AUTORES");

        txtAgregar.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        txtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        txtAgregar.setText("Agregar Autores o Libros");

        btnAddLibros.setBackground(new java.awt.Color(102, 0, 102));
        btnAddLibros.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        btnAddLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnAddLibros.setText("AGREGAR LIBROS");

        txtAgregar1.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        txtAgregar1.setForeground(new java.awt.Color(0, 0, 0));
        txtAgregar1.setText("Realizar consultas");

        btnAutorConsulta.setBackground(new java.awt.Color(255, 153, 0));
        btnAutorConsulta.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        btnAutorConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnAutorConsulta.setText("CONSULTAS SOBRE AUTORES");

        btnLibrosConsulta.setBackground(new java.awt.Color(0, 153, 153));
        btnLibrosConsulta.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        btnLibrosConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnLibrosConsulta.setText("CONSULTAS SOBRE LIBROS");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/exitBtn.png"))); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtConecctionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(41, 41, 41))
            .addComponent(labelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddAutores, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(btnAddLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(txtAgregar1)
                    .addComponent(btnAutorConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(btnLibrosConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(txtAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAgregar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLibrosConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(txtConecctionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BibliotecaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BibliotecaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BibliotecaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BibliotecaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddAutores;
    public javax.swing.JButton btnAddLibros;
    public javax.swing.JButton btnAutorConsulta;
    public javax.swing.JButton btnLibrosConsulta;
    public javax.swing.JButton btnSalir;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel txtAgregar;
    private javax.swing.JLabel txtAgregar1;
    public javax.swing.JLabel txtConecctionStatus;
    // End of variables declaration//GEN-END:variables
}
