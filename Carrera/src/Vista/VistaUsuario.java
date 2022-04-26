package Vista;

public class VistaUsuario extends javax.swing.JFrame {
    
    
    public VistaUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Caballo1 = new javax.swing.JLabel();
        Caballo2 = new javax.swing.JLabel();
        Caballo3 = new javax.swing.JLabel();
        Caballo4 = new javax.swing.JLabel();
        Caballo5 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabResultados = new javax.swing.JTable();
        jMnu = new javax.swing.JMenuBar();
        JmnuOpc = new javax.swing.JMenu();
        JMnuiIniciar = new javax.swing.JMenuItem();
        JMnuiPausar = new javax.swing.JMenuItem();
        JMnuiReanudar = new javax.swing.JMenuItem();
        JMnuiReiniciar = new javax.swing.JMenuItem();
        JMnuiGuardar = new javax.swing.JMenuItem();
        JMnuiAbrir = new javax.swing.JMenuItem();
        JMnuSal = new javax.swing.JMenu();
        JMnuiSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 440));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(112, 216, 207));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 440));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 440));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Caballo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C1.png"))); // NOI18N
        Caballo1.setName(""); // NOI18N
        jPanel1.add(Caballo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 40));

        Caballo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C2.png"))); // NOI18N
        Caballo2.setName(""); // NOI18N
        jPanel1.add(Caballo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 50, 40));

        Caballo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C3.png"))); // NOI18N
        Caballo3.setName(""); // NOI18N
        jPanel1.add(Caballo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 50, 40));

        Caballo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C4.png"))); // NOI18N
        Caballo4.setName(""); // NOI18N
        jPanel1.add(Caballo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 50, 40));

        Caballo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C5.png"))); // NOI18N
        Caballo5.setName(""); // NOI18N
        jPanel1.add(Caballo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 50, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RunningTracker.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        jPanel2.setBackground(new java.awt.Color(0, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTabResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Puesto", "Color", "Tiempo"
            }
        ));
        JTabResultados.setCellSelectionEnabled(true);
        JTabResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(JTabResultados);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 290, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        JmnuOpc.setText("Opciones");

        JMnuiIniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        JMnuiIniciar.setText("Iniciar");
        JmnuOpc.add(JMnuiIniciar);

        JMnuiPausar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        JMnuiPausar.setText("Pausar");
        JmnuOpc.add(JMnuiPausar);

        JMnuiReanudar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        JMnuiReanudar.setText("Reanudar");
        JmnuOpc.add(JMnuiReanudar);

        JMnuiReiniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        JMnuiReiniciar.setText("Reiniciar");
        JmnuOpc.add(JMnuiReiniciar);

        JMnuiGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        JMnuiGuardar.setText("Guardar");
        JmnuOpc.add(JMnuiGuardar);

        JMnuiAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        JMnuiAbrir.setText("Abrir");
        JmnuOpc.add(JMnuiAbrir);

        jMnu.add(JmnuOpc);

        JMnuSal.setText("Salir");

        JMnuiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        JMnuiSalir.setText("Salir");
        JMnuSal.add(JMnuiSalir);

        jMnu.add(JMnuSal);

        setJMenuBar(jMnu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Caballo1;
    public javax.swing.JLabel Caballo2;
    public javax.swing.JLabel Caballo3;
    public javax.swing.JLabel Caballo4;
    public javax.swing.JLabel Caballo5;
    private javax.swing.JLabel Fondo;
    private javax.swing.JMenu JMnuSal;
    public javax.swing.JMenuItem JMnuiAbrir;
    public javax.swing.JMenuItem JMnuiGuardar;
    public javax.swing.JMenuItem JMnuiIniciar;
    public javax.swing.JMenuItem JMnuiPausar;
    public javax.swing.JMenuItem JMnuiReanudar;
    public javax.swing.JMenuItem JMnuiReiniciar;
    public javax.swing.JMenuItem JMnuiSalir;
    public javax.swing.JTable JTabResultados;
    private javax.swing.JMenu JmnuOpc;
    private javax.swing.JMenuBar jMnu;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
