
import clases.Agente_inmobiliario;
import clases.Cliente;
import clases.Validaciones;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
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
public class RgeistroDelCliente extends javax.swing.JFrame {

    String sexo;
    String discapacidad1;
    boolean primeraMayusculaIngresada;
    String cedulaModificar;

    public RgeistroDelCliente() {
        initComponents();
        Agrupar();
        AgruparDis();
        setLocationRelativeTo(null);

    }

    public void Agrupar() {

        ButtonGroup mibuton = new ButtonGroup();
        mibuton.add(rbmasculinoCli);
        mibuton.add(rbfemeninoCli);

    }

    public void AgruparDis() {
        ButtonGroup mibutondis = new ButtonGroup();
        mibutondis.add(rbtSi);
        mibutondis.add(rbtNo);
    }

    public void CrearCliente(ObjectContainer base) {
        try {
            if (!validarCampos()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si ya existe un Cliente con la misma cédula
            ObjectSet<Cliente> resul = base.queryByExample(new Cliente(null, null, null, txtcedulaClie.getText(), null, null, null, null, null, null));
            if (!resul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un Cliente con la cédula ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el último código
            resul = base.queryByExample(new Cliente(null, null, null, null, null, null, null, null, null, null));
            int ultimoCodigo = resul.size() + 1;

            // Formatear el código con ceros a la izquierda
            String cod = String.format("%03d", ultimoCodigo);
            lblcod.setText(cod);

            // Obtener la información de género y discapacidad
            String sexo = rbmasculinoCli.isSelected() ? "Masculino" : "Femenino";
            String discapacidad1 = rbtSi.isSelected() ? "Si" : "No";

            Date seleccion = Datefechaclie.getDate();

            // Crear un nuevo Cliente y almacenarlo en la base de datos
            Cliente cliente1 = new Cliente(cod, discapacidad1, txtcontraseña.getText(), txtcedulaClie.getText(), txtnombreCli.getText(), txtapellidoCli.getText(), txtemailCli.getText(), txttelefonoCli.getText(), sexo, seleccion);
            base.store(cliente1);

            JOptionPane.showMessageDialog(null, "Cuenta Creada");

        } finally {
            base.close();
        }

        txtcedulaClie.setText(" ".trim());
        txtnombreCli.setText(" ".trim());
        txtapellidoCli.setText(" ".trim());
        txtemailCli.setText(" ".trim());
        txttelefonoCli.setText(" ".trim());
        Datefechaclie.setDate(null);
        txtcontraseña.setText(" ".trim());
        rbfemeninoCli.setSelected(false);
        rbmasculinoCli.setSelected(false);
        rbtSi.setSelected(false);
        rbtNo.setSelected(false);

    }

    public boolean validarCampos() {
        Validaciones miValidaciones = new Validaciones();
        boolean ban_confirmar = true;

        if (txtcedulaClie.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.validarCedula(txtcedulaClie.getText())) {
            JOptionPane.showMessageDialog(this, "Cédula incorrecta. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtnombreCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarNomApe(txtnombreCli.getText())) {
            JOptionPane.showMessageDialog(this, "Nombre incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtapellidoCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el apellido del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarNomApe(txtapellidoCli.getText())) {
            JOptionPane.showMessageDialog(this, "Apellido incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtemailCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el correo del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarCorreo(txtemailCli.getText())) {
            JOptionPane.showMessageDialog(this, "Correo incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        // Validar otros campos aquí...
        if (txttelefonoCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el celular del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.validarCedula(txttelefonoCli.getText())) {
            JOptionPane.showMessageDialog(this, "Celular incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }
        if (Datefechaclie.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ingrese una Fecha");
            ban_confirmar = false;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaComoCadena = sdf.format(Datefechaclie.getDate());

            if (!miValidaciones.validarFecha(fechaComoCadena)) {
                JOptionPane.showMessageDialog(this, "Fecha incorrecta. Ingrese de nuevo");
                ban_confirmar = false;
            }
        }

        if (txtcontraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la Contraseña del cliente");
            ban_confirmar = false;
        } else if (!miValidaciones.validarContrasena(txtcontraseña.getText())) {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Ingrese de nuevo");
            ban_confirmar = false;
        }
        return ban_confirmar;
    }

//   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();
        rbmasculinoCli = new javax.swing.JRadioButton();
        rbfemeninoCli = new javax.swing.JRadioButton();
        txttelefonoCli = new javax.swing.JTextField();
        txtemailCli = new javax.swing.JTextField();
        txtapellidoCli = new javax.swing.JTextField();
        txtnombreCli = new javax.swing.JTextField();
        txtcedulaClie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Datefechaclie = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JPasswordField();
        lblcod = new javax.swing.JLabel();

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(930, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 650));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 910, 20));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 20, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 260, 150));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Cedula:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Celular:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Genero:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Discapacidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, 20));

        rbtSi.setText("Si");
        jPanel1.add(rbtSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        rbtNo.setText("No");
        jPanel1.add(rbtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        rbmasculinoCli.setText("Masculino");
        jPanel1.add(rbmasculinoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        rbfemeninoCli.setText("Femenino");
        jPanel1.add(rbfemeninoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        txttelefonoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoCliActionPerformed(evt);
            }
        });
        txttelefonoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoCliKeyTyped(evt);
            }
        });
        jPanel1.add(txttelefonoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 180, -1));
        jPanel1.add(txtemailCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 180, -1));

        txtapellidoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoCliKeyTyped(evt);
            }
        });
        jPanel1.add(txtapellidoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 180, -1));

        txtnombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreCliKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombreCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 180, -1));

        txtcedulaClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaClieActionPerformed(evt);
            }
        });
        txtcedulaClie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaClieKeyTyped(evt);
            }
        });
        jPanel1.add(txtcedulaClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Codigo _ Cliente");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 100, 20));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));
        jPanel1.add(Datefechaclie, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 150, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        jLabel13.setText("CREA TU CUENTA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        btnGuardar.setText("CREAR CUENTA");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Contraseña:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 120, 40));

        txtcontraseña.setText("jPasswordField1");
        txtcontraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcontraseñaMouseClicked(evt);
            }
        });
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 150, -1));
        jPanel1.add(lblcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelefonoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoCliActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        INICIO ini = new INICIO();
        ini.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

//        if (cedulaModificar == null || cedulaModificar.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Por favor primero cree una cuenta , siga los pasos correspondientes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//            return; // No ejecutar más código si no hay cédula
//        }
        ObjectContainer baseD = Db4o.openFile(INICIO.direccion);
        CrearCliente(baseD);
        baseD.close();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtcontraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcontraseñaMouseClicked
        txtcontraseña.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtcedulaClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaClieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaClieActionPerformed

    private void txtcedulaClieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaClieKeyTyped
        char c = evt.getKeyChar();
        // Verificar si es un número y si la longitud actual es menor que 10
        if (!Character.isDigit(c) || txtcedulaClie.getText().length() >= 10) {
            // Si no es un número o la longitud es mayor o igual a 10, se consume el evento para evitar que se agregue al campo de texto
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaClieKeyTyped

    private void txtnombreCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreCliKeyTyped
        char c = evt.getKeyChar();
        // Verificar si es una letra minúscula y si la longitud actual es menor que 50 y si no es un espacio en blanco
        if ((!Character.isLetter(c) || !Character.isLowerCase(c) && primeraMayusculaIngresada) || txtnombreCli.getText().length() >= 20 || c == ' ') {
            // Si no es una letra minúscula, o no es la primera letra mayúscula, o la longitud es mayor o igual a 50, o el caracter es un espacio en blanco, se consume el evento para evitar que se agregue al campo de texto
            evt.consume();
        } else if (txtnombreCli.getText().length() == 0) {
            // Si es el primer caracter del campo de texto, verificar que sea mayúscula
            if (!Character.isUpperCase(c)) {
                // Si no es mayúscula, convertirla a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
                primeraMayusculaIngresada = true;
            }
        } else {
            // Si no es el primer caracter del campo de texto, verificar que sea minúscula
            String textoActual = txtnombreCli.getText();
            char ultimoCaracter = textoActual.charAt(textoActual.length() - 1);
            if (Character.isUpperCase(ultimoCaracter)) {
                // Si es mayúscula, convertirla a minúscula
                evt.setKeyChar(Character.toLowerCase(c));
                primeraMayusculaIngresada = true;
            }
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreCliKeyTyped

    private void txtapellidoCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoCliKeyTyped
        char c = evt.getKeyChar();
        // Verificar si es una letra minúscula y si la longitud actual es menor que 50 y si no es un espacio en blanco
        if ((!Character.isLetter(c) || !Character.isLowerCase(c) && primeraMayusculaIngresada) || txtapellidoCli.getText().length() >= 20 || c == ' ') {
            // Si no es una letra minúscula, o no es la primera letra mayúscula, o la longitud es mayor o igual a 50, o el caracter es un espacio en blanco, se consume el evento para evitar que se agregue al campo de texto
            evt.consume();
        } else if (txtapellidoCli.getText().length() == 0) {
            // Si es el primer caracter del campo de texto, verificar que sea mayúscula
            if (!Character.isUpperCase(c)) {
                // Si no es mayúscula, convertirla a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
                primeraMayusculaIngresada = true;
            }
        } else {
            // Si no es el primer caracter del campo de texto, verificar que sea minúscula
            String textoActual = txtapellidoCli.getText();
            char ultimoCaracter = textoActual.charAt(textoActual.length() - 1);
            if (Character.isUpperCase(ultimoCaracter)) {
                // Si es mayúscula, convertirla a minúscula
                evt.setKeyChar(Character.toLowerCase(c));
                primeraMayusculaIngresada = true;
            }
        }            // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoCliKeyTyped

    private void txttelefonoCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoCliKeyTyped
        char c = evt.getKeyChar();
        // Verificar si es un número y si la longitud actual es menor que 10
        if (!Character.isDigit(c) || txttelefonoCli.getText().length() >= 10) {
            // Si no es un número o la longitud es mayor o igual a 10, se consume el evento para evitar que se agregue al campo de texto
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoCliKeyTyped

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
            java.util.logging.Logger.getLogger(RgeistroDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RgeistroDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RgeistroDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RgeistroDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RgeistroDelCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Datefechaclie;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblcod;
    private javax.swing.JRadioButton rbfemeninoCli;
    private javax.swing.JRadioButton rbmasculinoCli;
    private javax.swing.JRadioButton rbtNo;
    private javax.swing.JRadioButton rbtSi;
    private javax.swing.JTextField txtapellidoCli;
    private javax.swing.JTextField txtcedulaClie;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtemailCli;
    private javax.swing.JTextField txtnombreCli;
    private javax.swing.JTextField txttelefonoCli;
    // End of variables declaration//GEN-END:variables
}
