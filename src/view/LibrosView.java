
package view;

import controller.ControladorConsultLibro;

/**
 *
 * @author ROZER
 */
public class LibrosView extends javax.swing.JDialog {

    private final ControladorConsultLibro control;
    /**
     * Creates new form LibrosView
     */
    public LibrosView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        control = new ControladorConsultLibro(this);
        setLocationRelativeTo(this);
        setTitle("CONSULTA LIBROS.");
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
        txtTittle = new javax.swing.JLabel();
        rbConsultaLibrosPorPrecios = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioDesde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrecioHasta = new javax.swing.JTextField();
        rbBorrarLibroPorTitulo = new javax.swing.JRadioButton();
        txtTitutloLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbSubirPrecios = new javax.swing.JRadioButton();
        btnConfirmarSubidaPrecios = new javax.swing.JButton();
        btnBorrarLibroPorTitulo = new javax.swing.JButton();
        btnBuscarLibroPorPrecio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        txtTittle.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtTittle.setForeground(new java.awt.Color(0, 0, 0));
        txtTittle.setText("Consultas de libros:");

        buttonGroup1.add(rbConsultaLibrosPorPrecios);
        rbConsultaLibrosPorPrecios.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbConsultaLibrosPorPrecios.setForeground(new java.awt.Color(0, 0, 0));
        rbConsultaLibrosPorPrecios.setText("Conusltar libros por precio");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Título:");

        txtPrecioDesde.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtPrecioDesde.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hasta:");

        txtPrecioHasta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtPrecioHasta.setForeground(new java.awt.Color(0, 0, 0));

        buttonGroup1.add(rbBorrarLibroPorTitulo);
        rbBorrarLibroPorTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbBorrarLibroPorTitulo.setForeground(new java.awt.Color(0, 0, 0));
        rbBorrarLibroPorTitulo.setText("Borrar Libro");

        txtTitutloLibro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtTitutloLibro.setForeground(new java.awt.Color(0, 0, 0));
        txtTitutloLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitutloLibroKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Desde:");

        buttonGroup1.add(rbSubirPrecios);
        rbSubirPrecios.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbSubirPrecios.setForeground(new java.awt.Color(0, 0, 0));
        rbSubirPrecios.setText("Subir precio de todos los Libros 5%");

        btnConfirmarSubidaPrecios.setBackground(new java.awt.Color(0, 102, 102));
        btnConfirmarSubidaPrecios.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnConfirmarSubidaPrecios.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarSubidaPrecios.setText(" Confirmar subida de precio");
        btnConfirmarSubidaPrecios.setToolTipText("Pulse para confirmar la subida de precio de todos los libros");

        btnBorrarLibroPorTitulo.setBackground(new java.awt.Color(255, 153, 51));
        btnBorrarLibroPorTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBorrarLibroPorTitulo.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarLibroPorTitulo.setText("Borrar");

        btnBuscarLibroPorPrecio.setBackground(new java.awt.Color(0, 204, 102));
        btnBuscarLibroPorPrecio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscarLibroPorPrecio.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarLibroPorPrecio.setText("Buscar");

        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaLibro);

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");

        btnRegistros.setBackground(new java.awt.Color(51, 102, 255));
        btnRegistros.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRegistros.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistros.setText("Ver todos los registros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitutloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrarLibroPorTitulo))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarLibroPorPrecio))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbBorrarLibroPorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbConsultaLibrosPorPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbSubirPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnConfirmarSubidaPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbConsultaLibrosPorPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibroPorPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbBorrarLibroPorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitutloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarLibroPorTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSubirPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarSubidaPrecios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(btnRegistros)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitutloLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitutloLibroKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        //	if ((c < 'a' || c > 'z') && (c < 'A') | c > 'Z') {
            //	    evt.consume();//Solo dejo ingresar letras minúsculas y  mayusculas (no numeros ni caracteres)
            //	}
        if (Character.isLowerCase(c)) {//Todo lo que ingresa se pone em mayúscula
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtTitutloLibroKeyTyped

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBorrarLibroPorTitulo;
    public javax.swing.JButton btnBuscarLibroPorPrecio;
    public javax.swing.JButton btnConfirmarSubidaPrecios;
    public javax.swing.JButton btnRegistros;
    public javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rbBorrarLibroPorTitulo;
    public javax.swing.JRadioButton rbConsultaLibrosPorPrecios;
    public javax.swing.JRadioButton rbSubirPrecios;
    public javax.swing.JTable tablaLibro;
    public javax.swing.JTextField txtPrecioDesde;
    public javax.swing.JTextField txtPrecioHasta;
    private javax.swing.JLabel txtTittle;
    public javax.swing.JTextField txtTitutloLibro;
    // End of variables declaration//GEN-END:variables
}
