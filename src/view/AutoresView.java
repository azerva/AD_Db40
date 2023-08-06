/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ControladorConsultAutor;

/**
 *
 * @author ROZER
 */
public class AutoresView extends javax.swing.JDialog {

    private final controller.ControladorConsultAutor control;

    /**
     * Creates new form AutoresView
     */
    public AutoresView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        control = new ControladorConsultAutor(this);
        setLocationRelativeTo(this);
        setTitle("CONSULTA AUTORES.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelTittle = new javax.swing.JLabel();
        rbBuscarPorTipoAutor = new javax.swing.JRadioButton();
        comboTipoAutor = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutores = new javax.swing.JTable();
        btnSalirAutores = new javax.swing.JButton();
        btnRegistrosAutores = new javax.swing.JButton();
        rbBuscarPorNombre = new javax.swing.JRadioButton();
        txtBuscarPorNombre = new javax.swing.JTextField();
        rbBuscarAutoresEsp = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));

        labelTittle.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        labelTittle.setForeground(new java.awt.Color(0, 0, 0));
        labelTittle.setText("Consulta por Autores");

        buttonGroup1.add(rbBuscarPorTipoAutor);
        rbBuscarPorTipoAutor.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbBuscarPorTipoAutor.setText("Buscar por tipo de Autor");

        comboTipoAutor.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboTipoAutor.setForeground(new java.awt.Color(0, 0, 0));
        comboTipoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA OPCIÓN...", "ANÓNIMO", "DE AUTOR" }));

        btnBuscar.setBackground(new java.awt.Color(204, 0, 204));
        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");

        tablaAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaAutores);

        btnSalirAutores.setBackground(new java.awt.Color(255, 0, 51));
        btnSalirAutores.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSalirAutores.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirAutores.setText("Salir");

        btnRegistrosAutores.setBackground(new java.awt.Color(0, 102, 153));
        btnRegistrosAutores.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRegistrosAutores.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrosAutores.setText("Ver todos los registros");

        buttonGroup1.add(rbBuscarPorNombre);
        rbBuscarPorNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbBuscarPorNombre.setText("Buscar libros por nombre de Autor");

        txtBuscarPorNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtBuscarPorNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarPorNombreKeyTyped(evt);
            }
        });

        buttonGroup1.add(rbBuscarAutoresEsp);
        rbBuscarAutoresEsp.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbBuscarAutoresEsp.setText("Buscar todos los Autores españoles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelTittle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbBuscarPorNombre)
                                    .addComponent(rbBuscarPorTipoAutor))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBuscarPorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                    .addComponent(comboTipoAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnRegistrosAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(btnSalirAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbBuscarAutoresEsp))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBuscarPorTipoAutor)
                    .addComponent(comboTipoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBuscarPorNombre)
                    .addComponent(txtBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(rbBuscarAutoresEsp)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnRegistrosAutores))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirAutores)
                .addGap(67, 67, 67))
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

    private void txtBuscarPorNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreKeyTyped
        char c = evt.getKeyChar();
        //	if ((c < 'a' || c > 'z') && (c < 'A') | c > 'Z') {
        //	    evt.consume();//Solo dejo ingresar letras minúsculas y  mayusculas (no numeros ni caracteres)
        //	}
        if (Character.isLowerCase(c)) {//Todo lo que ingresa se pone em mayúscula
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtBuscarPorNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnRegistrosAutores;
    public javax.swing.JButton btnSalirAutores;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> comboTipoAutor;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTittle;
    public javax.swing.JRadioButton rbBuscarAutoresEsp;
    public javax.swing.JRadioButton rbBuscarPorNombre;
    public javax.swing.JRadioButton rbBuscarPorTipoAutor;
    public javax.swing.JTable tablaAutores;
    public javax.swing.JTextField txtBuscarPorNombre;
    // End of variables declaration//GEN-END:variables
}