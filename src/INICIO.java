
import clases.Cliente;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN_01
 */
public class INICIO extends javax.swing.JFrame {

    String password = " ";
    
    public static String nombre=" ",apellido= " ",usuario = " ";

    /**
     * Creates new form INICIO
     */
    public INICIO() {
        initComponents();

        setLocationRelativeTo(null);

        txtusuario.setText("Ingrese su usuario");
        txtcontra.setText("Ingrese su contraseña");
    }

   // public static String direccion = "C:\\Users\\Lenovo.User\\Documents\\base_orientada\\base_datos_orientada.yap";
    //public static String direccionBD = "C:\\Users\\PC01\\Documents\\GitHub\\AlquilerInterfaz.yap";
    //public static String direccionBD = "C:\\Users\\ADMIN_01\\Documents\\MINI PROYECTO BDOO\\AlquilerInterfaz.yap";
     public static String direccion = "C:\\Users\\HP\\Documents\\GitHub\\basepaa.yap";

    //public static String direccion = "C:\\Users\\eliza\\OneDrive\\Documentos\\GitHub\\MiniProyecto.yap";
    //public static String direccion = "C:\\Users\\Lenovo\\Desktop\\MiniProyecto\\MiniProyecto.yap";
//    private void cerrarBaseVentana() {
//        // Cerrar la base de datos cuando se presiona la x de le ventana principal
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                baseD.close();
//            }
//        });
//    }
//
//    public void cerrarBaseDeDatos() {
//        baseD.close(); // Cierra la conexión con la base de datos
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtusuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        LOGOKAME4HOUSE = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        Fondo.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 630));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 910, 20));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        Fondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 20, 630));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0, 50));

        txtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusuarioMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_9826496.png"))); // NOI18N

        txtcontra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcontraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        Fondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 300, 360));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Inicio1.jpg"))); // NOI18N
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 500, 530));

        LOGOKAME4HOUSE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        Fondo.add(LOGOKAME4HOUSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Iniciar Sesion");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Fondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 140, 40));

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Registrarse");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Fondo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 140, 40));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel2.setText("Tu perfecta");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel4.setText("casa");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel5.setText("\" Explora un mundo de posibilidades en el alquiler de casas, ");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel6.setText("donde cada rincon cuenca una historia, y cada espacio ");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel7.setText("se convierte en el lienzo de tus momentos inolvidables \"");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel8.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel8.setText("BIENVENIDO");
        Fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 230, -1));

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 204));

        jMenu1.setBackground(new java.awt.Color(0, 102, 204));
        jMenu1.setText("Iniciar como:");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/users-altV.png"))); // NOI18N
        jMenuItem6.setText("Administrador");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/users-altV.png"))); // NOI18N
        jMenuItem4.setText("Agente Inmoviliario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-x.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 102, 204));
        jMenu2.setText("Información");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();
        RgeistroDelCliente registro = new RgeistroDelCliente();
        registro.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("cedula").constrain(txtusuario.getText().trim());
        query.descend("contraseña").constrain(txtcontra.getText().trim());

        ObjectSet<Cliente> result = query.execute();

        if (!result.isEmpty()) {

            for (Cliente cliente1 : result) {
                usuario = cliente1.getCedula();
                password = cliente1.getContraseña();
                nombre=cliente1.getNombre();
                apellido=cliente1.getApellido();

            }

            txtusuario.setText(usuario.trim());
            txtcontra.setText(password.trim());
            this.dispose();
            menu_cliente cli = new menu_cliente();
            cli.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

        base.close();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        Administrador_Login login = new Administrador_Login();
        login.setVisible(true);


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.dispose();
        LOGIN_AGENTE ini = new LOGIN_AGENTE();
        ini.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuarioMouseClicked
        txtusuario.setText("");   // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioMouseClicked

    private void txtcontraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcontraMouseClicked
        txtcontra.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraMouseClicked

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
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INICIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LOGOKAME4HOUSE;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
