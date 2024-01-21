
import clases.Cliente;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo.User
 */
public class Clientes extends javax.swing.JPanel {

    String sexo = " ";
    String discapacidad1 = " ";
    String cedulaModificar;

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        Agrupar();
        Agrupar1();
    }

    public void Agrupar() {
        ButtonGroup botones = new ButtonGroup();
        botones.add(rbmasculinoCli);
        botones.add(rbfemeninoCli);

    }

    public void Agrupar1() {

        ButtonGroup botones1 = new ButtonGroup();
        botones1.add(rbtNo);
        botones1.add(rbtSi);
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
        jLabel5 = new javax.swing.JLabel();
        lblced = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbmasculinoCli = new javax.swing.JRadioButton();
        rbfemeninoCli = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Datefechaclie = new com.toedter.calendar.JDateChooser();
        txtcontraseña = new javax.swing.JPasswordField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblDiscapacidad = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        txttelefonoCli = new javax.swing.JTextField();
        txtemailCli = new javax.swing.JTextField();
        txtapellidoCli = new javax.swing.JTextField();
        txtnombreCli = new javax.swing.JTextField();
        txtcedulaClie = new javax.swing.JTextField();
        btnCargart = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 40, -1));

        lblced.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblced.setText("Cedula:");
        jPanel1.add(lblced, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        genero.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        genero.setText("Genero:");
        jPanel1.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Discapacidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        rbtSi.setText("Si");
        rbtSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSiActionPerformed(evt);
            }
        });
        jPanel1.add(rbtSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        rbtNo.setText("No");
        rbtNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 40));

        rbmasculinoCli.setText("Masculino");
        rbmasculinoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmasculinoCliActionPerformed(evt);
            }
        });
        jPanel1.add(rbmasculinoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        rbfemeninoCli.setText("Femenino");
        rbfemeninoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfemeninoCliActionPerformed(evt);
            }
        });
        jPanel1.add(rbfemeninoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Contraseña:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 90, 20));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        jPanel1.add(Datefechaclie, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 160, -1));

        txtcontraseña.setText("jPasswordField1");
        jPanel1.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 160, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 250, 170));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("REGISTRAR CLIENTE");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO CLIENTE", "CEDULA", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "GENERO", "DISCAPACIDAD", "FECHA DE NACIMIENTO", "CONTRASEÑA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 810, 210));
        jPanel1.add(lblDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 90, 10));
        jPanel1.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 110, 10));

        txttelefonoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoCliActionPerformed(evt);
            }
        });
        jPanel1.add(txttelefonoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 180, -1));
        jPanel1.add(txtemailCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 180, -1));
        jPanel1.add(txtapellidoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 180, -1));
        jPanel1.add(txtnombreCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 180, -1));
        jPanel1.add(txtcedulaClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, -1));

        btnCargart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargando.png"))); // NOI18N
        btnCargart.setText("CARGAR TABLA");
        btnCargart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargartActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        jButton4.setText("LIMPIAR CAMPOS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbtSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSiActionPerformed
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_rbtSiActionPerformed

    private void rbtNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNoActionPerformed
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNoActionPerformed

    private void rbmasculinoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmasculinoCliActionPerformed
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_rbmasculinoCliActionPerformed

    private void rbfemeninoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfemeninoCliActionPerformed
        validar();// TODO add your handling code here:
    }//GEN-LAST:event_rbfemeninoCliActionPerformed

    public void ActualizarDatos(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (txtcedulaClie.getText().trim().isEmpty() || txtnombreCli.getText().trim().isEmpty()
                || txtapellidoCli.getText().trim().isEmpty() || txtemailCli.getText().trim().isEmpty()
                || txttelefonoCli.getText().trim().isEmpty() || Datefechaclie.getDate() == null
                || (!rbmasculinoCli.isSelected() && !rbfemeninoCli.isSelected())
                || (!rbtSi.isSelected() && !rbtNo.isSelected()) || txtcontraseña.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor llene en el Campo de Cedula de algun Cliente , para la Modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            // Resto del código para la modificación del cliente

            if (rbmasculinoCli.isSelected()) {
                sexo = "Masculino";
            } else if (rbfemeninoCli.isSelected()) {
                sexo = "Femenino";
            }

            if (rbtSi.isSelected()) {
                discapacidad1 = "Si";
            } else if (rbtNo.isSelected()) {
                discapacidad1 = "No";
            }

            // Validar edad (mayor a 18 años)
            if (!esMayorDeEdad(Datefechaclie.getDate())) {
                JOptionPane.showMessageDialog(this, "El personal debe ser mayor de 18 años.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un objeto Cliente con la cédula proporcionada para la búsqueda
            Cliente micliente = new Cliente(null, null, null, txtcedulaClie.getText().trim(), null, null, null, null, null, null);

            // Realizar la búsqueda
            ObjectSet res = base.get(micliente);

            // Verificar si se encontró el cliente
            if (res.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontró el cliente con la cédula proporcionada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el cliente encontrado
            Cliente micliente1 = (Cliente) res.next();

            // Actualizar los datos del cliente
            micliente1.setNombre(txtnombreCli.getText().trim());
            micliente1.setApellido(txtapellidoCli.getText().trim());
            micliente1.setEmail(txtemailCli.getText().trim());
            micliente1.setTelefono(txttelefonoCli.getText().trim());
            micliente1.setGenero(sexo.trim());
            micliente1.setDiscapacidad(discapacidad1.trim());
            micliente1.setFecha_nac(Datefechaclie.getDate());
            micliente1.setContraseña(txtcontraseña.getText().trim());

            // Actualizar el cliente en la base de datos
            base.set(micliente1);

            JOptionPane.showMessageDialog(this, "Modificacion exitosa");

            // Limpiar los campos después de la modificación
            txtcedulaClie.setText(" ");
            txtnombreCli.setText(" ");
            txtapellidoCli.setText(" ");
            txtemailCli.setText(" ");
            txttelefonoCli.setText("");
            Datefechaclie.setDate(null);

            rbmasculinoCli.setSelected(false);
            rbfemeninoCli.setSelected(false);

            rbtSi.setSelected(false);
            rbtNo.setSelected(false);

            txtcontraseña.setText("");

            HabilitarDatos();
            cargarTabla(base);
        }
    }

    // Método para validar si la fecha de nacimiento indica que la persona es mayor de 18 años
    private boolean esMayorDeEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            System.out.println("Fecha de nacimiento es nula");
            return false;
        }

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Convertir la fecha de nacimiento a LocalDate
        LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calcular la diferencia en años
        int edad = Period.between(fechaNac, fechaActual).getYears();

        // Verificar si la persona tiene al menos 18 años
        return edad >= 18;
    }

    public void HabilitarDatos() {

        txtcedulaClie.setEnabled(true);

    }

    public void inhabiltarDatosCed() {

        txtcedulaClie.setEnabled(false);

    }

    public void inhabiltarDatos() {

        txtnombreCli.setEnabled(false);
        txtapellidoCli.setEnabled(false);
        txtemailCli.setEnabled(false);
        txttelefonoCli.setEnabled(false);
        txtcontraseña.setEnabled(false);
        rbtSi.setEnabled(false);
        rbtNo.setEnabled(false);
        Datefechaclie.setEnabled(false);
        rbmasculinoCli.setEnabled(false);
        rbfemeninoCli.setEnabled(false);
    }

    public void validar() {

        if (!rbfemeninoCli.isSelected() || !rbmasculinoCli.isSelected()) {
            lblGenero.setText("Campo requerido");

        } else {
            lblGenero.setText(" ");
        }

        if (!rbtSi.isSelected() || !rbtNo.isSelected()) {
            lblDiscapacidad.setText("Campo requerido");

        } else {
            lblDiscapacidad.setText(" ");
        }

    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String cedulaBuscar = JOptionPane.showInputDialog("Ingrese el Codigo del Cliente a buscar, por favor");
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        boolean encontrado = false;

        cargarTabla(base);

        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("codigo_cli").constrain(cedulaBuscar);

        ObjectSet<Cliente> result = query.execute();

        String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "SEXO", "DISCAPACIDAD", "FECHA DE NACIMIENTO", "CONTRASEÑA"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Cliente cliente : result) {
            Object[] rowData = {
                cliente.getCodigo_cli(),
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getGenero(),
                cliente.getDiscapacidad(),
                cliente.getFecha_nac(),
                cliente.getContraseña()
            };
            model.addRow(rowData);
        }

        if (result.size() > 0) {
            encontrado = true;
            jTable1.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el Codigo del Cliente");
        }

        base.close();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

//        if (cedulaModificar == null || cedulaModificar.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Por favor si desea modificar, ingrese la cédula en el campo correspondiente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//            return; // No ejecutar más código si no hay cédula
//        }
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        ActualizarDatos(base);

        base.close();      // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cedulaEliminar = JOptionPane.showInputDialog("Ingrese la cedula a eliminar");
        boolean encontrado = false;
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("cedula").constrain(cedulaEliminar);

        ObjectSet<Cliente> result = query.execute();
        cargarTabla(base);
        if (result.size() > 0) {

            encontrado = true;

            int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos del Cliente", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (resul == JOptionPane.YES_OPTION) {
                for (Cliente ClienteDB : result) {
                    // Eliminar el Cliente de la base de datos db4o
                    base.delete(ClienteDB);
                    JOptionPane.showMessageDialog(null, "Se están borrando los datos del Cliente");
                    cargarTabla(base);
                }
            } else if (resul == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Datos del Cliente no eliminados");
            }

            // Comenta esta parte para no mostrar la tabla
            /*
    String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "EDAD", "SEXO", "DISCAPACIDAD", "FECHA DE NACIMIENTO", "CONTRASEÑA"};
    Object[][] data = new Object[result.size()][11];

    int i = 0;
    for (Cliente cliente : result) {
        data[i][0] = cliente.getCodigo_cli();
        data[i][1] = cliente.getCedula();
        data[i][2] = cliente.getNombre();
        data[i][3] = cliente.getApellido();
        data[i][4] = cliente.getEmail();
        data[i][5] = cliente.getTelefono();
        data[i][6] = cliente.getEdad();
        data[i][7] = cliente.getGenero();
        data[i][8] = cliente.getDiscapacidad();
        data[i][9] = cliente.getFecha_nac();
        data[i][10] = cliente.getContraseña();

        i++;
    }

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    jTable1.setModel(model);
             */
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la cédula");
            cargarTabla(base);
        }

        base.close();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void vaciarTabla() {
        // Obtenemos el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Borramos las filas antiguas del modelo de tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    public void habiltarDatos() {

        txtnombreCli.setEnabled(true);
        txtapellidoCli.setEnabled(true);
        txtemailCli.setEnabled(true);
        txttelefonoCli.setEnabled(true);
        rbmasculinoCli.setEnabled(true);
        rbfemeninoCli.setEnabled(true);
        rbtSi.setEnabled(true);
        rbtNo.setEnabled(true);
        Datefechaclie.setEnabled(true);
        txtcontraseña.setEnabled(true);

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        String nombre = " ", apellido = " ", email = " ", Telefono = " ", sexo1 = " ", discapacidad = " ", contraseña = " ";
        Date fecha = null;
        int ed = 0;
        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("cedula").constrain(txtcedulaClie.getText().trim());
        ObjectSet<Cliente> result = query.execute();

        if (!result.isEmpty()) {
            habiltarDatos();
            for (Cliente cliente : result) {
                nombre = cliente.getNombre();
                apellido = cliente.getApellido();
                email = cliente.getEmail();
                Telefono = cliente.getTelefono();
                sexo1 = cliente.getGenero();
                discapacidad = cliente.getDiscapacidad();
                fecha = cliente.getFecha_nac();
                contraseña = cliente.getContraseña();

            }

            txtnombreCli.setText(nombre.trim());
            txtapellidoCli.setText(apellido.trim());
            txtemailCli.setText(email.trim());
            txttelefonoCli.setText(Telefono.trim());
            Datefechaclie.setDate(fecha);
            txtcontraseña.setText(contraseña.trim());

            if (sexo1.equalsIgnoreCase("Masculino")) {
                rbmasculinoCli.setSelected(true);
            } else if (sexo1.equalsIgnoreCase("Femenino")) {
                rbfemeninoCli.setSelected(true);
            }

            if (discapacidad.equalsIgnoreCase("Si")) {
                rbtSi.setSelected(true);
            } else if (discapacidad.equalsIgnoreCase("No")) {
                rbtNo.setSelected(true);
            }
        } else {

            JOptionPane.showMessageDialog(null, "No se encontró ningún Cliente con la cedula ingresada");

        }

        inhabiltarDatosCed();
        base.close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txttelefonoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoCliActionPerformed

    private void btnCargartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargartActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);

        base.close();// TODO add your handling code here:
    }//GEN-LAST:event_btnCargartActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtnombreCli.setEnabled(true);
        txtapellidoCli.setEnabled(true);
        txtemailCli.setEnabled(true);
        txttelefonoCli.setEnabled(true);
        rbmasculinoCli.setEnabled(true);
        rbfemeninoCli.setEnabled(true);
        rbtSi.setEnabled(true);
        rbtNo.setEnabled(true);
        Datefechaclie.setEnabled(true);
        txtcontraseña.setEnabled(true);
        txtcedulaClie.setEnabled(true);

        txtcedulaClie.setText(" ");
        txtnombreCli.setText(" ");
        txtapellidoCli.setText(" ");
        txtemailCli.setText(" ");
        txttelefonoCli.setText("");
        Datefechaclie.setDate(null);

        rbmasculinoCli.setSelected(false);
        rbfemeninoCli.setSelected(false);

        rbtSi.setSelected(false);
        rbtNo.setSelected(false);

        txtcontraseña.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Datefechaclie;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargart;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel genero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDiscapacidad;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblced;
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

    private void cargarTabla(ObjectContainer base) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        ObjectSet<Cliente> result = base.queryByExample(Cliente.class);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (result.hasNext()) {
            Cliente cliente = result.next();

            Object[] row = {
                cliente.getCodigo_cli(),
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getGenero(),
                cliente.getDiscapacidad(),
                cliente.getFecha_nac() != null ? sdf.format(cliente.getFecha_nac()) : null,// Verificar si la fecha no es null antes de formatearla
                cliente.getContraseña()
            };
            model.addRow(row);
        }
    }

}
