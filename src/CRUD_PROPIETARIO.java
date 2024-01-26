
import base.ReporteCliente;
import base.ReportePropietarios;
import clases.CasaVacacional;
import clases.Propietario;
import clases.Validaciones;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.awt.Color;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class CRUD_PROPIETARIO extends javax.swing.JPanel {

    String sexo;
    int Edad = 0;

    public CRUD_PROPIETARIO() {
        initComponents();

    }

    public void Agrupar() {
        ButtonGroup botones = new ButtonGroup();
        botones.add(rbfemeninoPro);
        botones.add(rbmasculinoPro);

    }

    public boolean validarCampos() {// Método para validar los campos de la interfaz
        Validaciones miValidaciones = new Validaciones();
        boolean ban_confirmar = true;
        if (txtcedulaPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del propietario");
            ban_confirmar = false;
        } else if (!miValidaciones.validarCedula(txtcedulaPro.getText())) {
            JOptionPane.showMessageDialog(this, "Cédula incorrecta. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtnombrePro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del propietario");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarNomApe(txtnombrePro.getText())) {
            JOptionPane.showMessageDialog(this, "Nombre incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtapellidoPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el apellido del propietario");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarNomApe(txtapellidoPro.getText())) {
            JOptionPane.showMessageDialog(this, "Apellido incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txtemailPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el correo del propietario");
            ban_confirmar = false;
        } else if (!miValidaciones.ValidarCorreo(txtemailPro.getText())) {
            JOptionPane.showMessageDialog(this, "Correo incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }

        if (txttelefonoPro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el celular del propietario");
            ban_confirmar = false;
        } else if (!miValidaciones.validarCedula(txttelefonoPro.getText())) {
            JOptionPane.showMessageDialog(this, "Celular incorrecto. Ingrese de nuevo");
            ban_confirmar = false;
        }
        if (Datefechapro.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ingrese una Fecha");
            ban_confirmar = false;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaComoCadena = sdf.format(Datefechapro.getDate());

            if (!miValidaciones.validarFecha(fechaComoCadena)) {
                JOptionPane.showMessageDialog(this, "Fecha incorrecta. Ingrese de nuevo");
                ban_confirmar = false;
            }
        }

        return ban_confirmar;
    }

    public void crearPropietario(ObjectContainer Base) {
        try {
            if (!validarCampos()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rbmasculinoPro.isSelected()) {
                sexo = "Masculino";
            } else if (rbfemeninoPro.isSelected()) {
                sexo = "Femenino";
            }

            Date seleccion = Datefechapro.getDate();

            // Validar edad (mayor a 18 años)
            if (!esMayorDeEdad1(Datefechapro.getDate())) {
                JOptionPane.showMessageDialog(this, "El personal debe ser mayor de 18 años.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Query query = Base.query();
            query.constrain(Propietario.class);
            query.descend("codigo_propie").orderDescending();
            ObjectSet<Propietario> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Propietario ultimoPropietario = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPropietario.getCodigo_propie().substring(4)) + 1;
            }

            String nuevoCodigo = String.format("PRO-%03d", ultimoCodigo);
            txtcodigoPro.setText(nuevoCodigo);

            result = Base.queryByExample(new Propietario(null, null, txtcedulaPro.getText().trim(), null, null, null, null, null, null));
            if (!result.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un Propietario con la cedula ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //  Propietario(String codigo_propie, String ocupacion, String cedula, String nombre, String apellido, String email, String telefono, String genero, Date fecha_nac) {
            Propietario propietario = new Propietario(nuevoCodigo, txtOcupacion.getText(), txtcedulaPro.getText().trim(), txtnombrePro.getText(), txtapellidoPro.getText(), txtemailPro.getText(), txttelefonoPro.getText(), sexo, seleccion);
            Base.store(propietario);

            JOptionPane.showMessageDialog(null, "Propietario Creado");
            cargarTabla(Base);

        } finally {
            Base.close();
        }
        limpiarCamposPropietario();
    }

    // Método para validar si la fecha de nacimiento indica que la persona es mayor de 18 años
    private boolean esMayorDeEdad1(Date fechaNacimiento) {
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

    private void limpiarCamposPropietario() {
        txtcedulaPro.setText("");
        txtnombrePro.setText("");
        txtapellidoPro.setText("");
        txtemailPro.setText("");
        txttelefonoPro.setText("");
        rbfemeninoPro.setSelected(false);
        rbmasculinoPro.setSelected(false);
        txtcodigoPro.setText("");
        txtOcupacion.setText("");
        Datefechapro.setDate(null);
    }

    public void cargarTabla(ObjectContainer base) {

        DefaultTableModel model = (DefaultTableModel) jTablePropietario.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Crear una consulta ordenada por el campo deseado (por ejemplo, nombre)
        Query query = base.query();
        query.constrain(Propietario.class);
        query.descend("cedula").orderAscending();

        // Obtener los resultados ordenados
        ObjectSet<Propietario> pro = query.execute();

        while (pro.hasNext()) {
            Propietario propie = pro.next();
            Object[] row = {
                propie.getCodigo_propie(),
                propie.getCedula(),
                propie.getNombre(),
                propie.getApellido(),
                propie.getEmail(),
                propie.getTelefono(),
                propie.getOcupacion(),
                propie.getGenero(),
                propie.getFecha_nac() != null ? sdf.format(propie.getFecha_nac()) : null
            };
            model.addRow(row);
        }
        base.close();

    }

    public void limpiar() {
        txtnombrePro.setText("");
        txtapellidoPro.setText("");
        txtemailPro.setText("");
        txttelefonoPro.setText("");
        txtOcupacion.setText("");
        txtcodigoPro.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbmasculinoPro = new javax.swing.JRadioButton();
        rbfemeninoPro = new javax.swing.JRadioButton();
        txttelefonoPro = new javax.swing.JTextField();
        txtemailPro = new javax.swing.JTextField();
        txtapellidoPro = new javax.swing.JTextField();
        txtnombrePro = new javax.swing.JTextField();
        txtcedulaPro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Datefechapro = new com.toedter.calendar.JDateChooser();
        BtnGuardar = new javax.swing.JButton();
        BtnModi = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnReporte = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePropietario = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtOcupacion = new javax.swing.JTextField();
        txtcodigoPro = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(950, 650));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N

        jLabel3.setText("Código Comentario:");

        jLabel4.setText("CódigoCliente:");

        jLabel5.setText("Código Casa:");

        jLabel6.setText("Descripción:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Comentario", "Código Cliente", "Código Casa", "Descripción"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("GUARDAR");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("MODIFICAR");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton3.setText("ELIMINAR");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton4.setText("REPORTE");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton5.setText("BUSCAR");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(124, 124, 124)
                        .addComponent(jButton2)
                        .addGap(144, 144, 144)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jLabel2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(70, 70, 70))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Comentario");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(372, 372, 372))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 260, 150));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Cedula:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Apellido:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Telefono:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Genero:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        rbmasculinoPro.setText("Masculino");
        rbmasculinoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmasculinoProActionPerformed(evt);
            }
        });
        jPanel1.add(rbmasculinoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        rbfemeninoPro.setText("Femenino");
        rbfemeninoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfemeninoProActionPerformed(evt);
            }
        });
        jPanel1.add(rbfemeninoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        txttelefonoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoProActionPerformed(evt);
            }
        });
        jPanel1.add(txttelefonoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 180, -1));

        txtemailPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailProActionPerformed(evt);
            }
        });
        jPanel1.add(txtemailPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 180, -1));

        txtapellidoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoProActionPerformed(evt);
            }
        });
        jPanel1.add(txtapellidoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 180, -1));

        txtnombrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreProActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 180, -1));

        txtcedulaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaProActionPerformed(evt);
            }
        });
        jPanel1.add(txtcedulaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 180, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setText("Codigo _ Propietario:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));
        jPanel1.add(Datefechapro, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 210, -1));

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 120, 40));

        BtnModi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        BtnModi.setText("MODIFICAR");
        BtnModi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModiActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 130, 40));

        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        BtnReporte.setText("REPORTE");
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 120, 40));

        BtnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        BtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        BtnBuscar.setBorder(null);
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jTablePropietario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cedula", "Nombre", "Apellido", "Email", "Telefono", "Ocupacion", "Genero", "F.Nacimiento"
            }
        ));
        jScrollPane3.setViewportView(jTablePropietario);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 900, 180));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setText("Ocupacion:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));
        jPanel1.add(txtOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 210, -1));
        jPanel1.add(txtcodigoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 70, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("REGISTRAR PROPIETARIO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void txttelefonoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoProActionPerformed

    }//GEN-LAST:event_txttelefonoProActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        ObjectContainer baseD = Db4o.openFile(INICIO.direccion);
        crearPropietario(baseD);
        baseD.close();

    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnModiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModiActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        ActualizarDatos(base);
        base.close();

    }//GEN-LAST:event_BtnModiActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        String codigopro = txtcodigoPro.getText().trim();

        try {
            // Verificar si el propietario tiene una Casa Vacacional asociada
            CasaVacacional casaAsociada = new CasaVacacional(null, null, null, 0, 0, 0, 0, codigopro, 0.0, false, null, null, null);
            ObjectSet resultCasa = base.get(casaAsociada);

            if (resultCasa.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el Propietario porque tiene una Casa en Alquiler", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar y mostrar datos del Propietario
            Query queryPropietario = base.query();
            queryPropietario.constrain(Propietario.class);
            queryPropietario.descend("codigo_propie").constrain(codigopro);

            ObjectSet<Propietario> resultPropietario = queryPropietario.execute();

            if (resultPropietario.size() > 0) {
                String[] columnNames = {"Cedula", "Nombre", "Apellido", "Email", "Telefono", "Ocupacion", "Genero", "Codigo", "FGénero"};
                Object[][] data = new Object[resultPropietario.size()][9];

                int i = 0;
                for (Propietario propie : resultPropietario) {
                    data[i][0] = propie.getCedula();
                    data[i][1] = propie.getNombre();
                    data[i][2] = propie.getApellido();
                    data[i][3] = propie.getEmail();
                    data[i][4] = propie.getTelefono();
                    data[i][5] = propie.getOcupacion();
                    data[i][6] = propie.getGenero();
                    data[i][7] = propie.getCodigo_propie();
                    data[i][8] = propie.getFecha_nac();
                    i++;
                }

                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                jTablePropietario.setModel(model);

                // Preguntar al usuario si desea eliminar al Propietario
                int resul = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar los datos del Propietario?", "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (resul == JOptionPane.YES_OPTION) {
                    // Eliminar al Propietario
                    for (Propietario PORBD : resultPropietario) {
                        base.delete(PORBD);
                        JOptionPane.showMessageDialog(null, "Se están borrando los datos del Propietario");
                    }
                } else if (resul == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Datos del Propietario no eliminados");
                }

                // Limpiar la tabla después de la eliminación
                vaciarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Propietario con la cédula ingresada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada
        } finally {
            base.close();
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    public void vaciarTabla() {
        // Obtenemos el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTablePropietario.getModel();

        // Borramos las filas antiguas del modelo de tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);

        base.close();
        
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(this);
        ReportePropietarios vista = new ReportePropietarios(parentFrame, true, Administrador_Login.agente);
        vista.setVisible(true);
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        String nombre = "", apellido = "", email = "", telefono = "", codigo = "";
        Date fecha = null;
        int edad = 0;

        Query query = base.query();
        query.constrain(Propietario.class);
        query.descend("cedula").constrain(txtcedulaPro.getText().trim());

        ObjectSet<Propietario> result = query.execute();

        if (!result.isEmpty()) {
            // Si se encontraron resultados, cargarlos en la tabla
            String[] columnNames = {"CEDULA", "NOMBRE", "APELLIDO", "EMAIL", "TELEFONO", "OCUPACION", "GENERO", "CODIGO", "F.NACIMIENTO"};
            Object[][] data = new Object[result.size()][9];
            int i = 0;

            for (Propietario propietario : result) {
                data[i][0] = propietario.getCedula();
                data[i][1] = propietario.getNombre();
                data[i][2] = propietario.getApellido();
                data[i][3] = propietario.getEmail();
                data[i][4] = propietario.getTelefono();
                data[i][5] = propietario.getOcupacion();
                data[i][6] = propietario.getGenero();
                data[i][7] = propietario.getCodigo_propie();
                data[i][8] = propietario.getFecha_nac();
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            jTablePropietario.setModel(model);
            jTablePropietario.repaint();

            // Obtener el primer resultado para mostrar los datos en los campos
            Propietario primerResultado = result.get(0);
            txtnombrePro.setText(primerResultado.getNombre().trim());
            txtapellidoPro.setText(primerResultado.getApellido().trim());
            txtemailPro.setText(primerResultado.getEmail().trim());
            txttelefonoPro.setText(primerResultado.getTelefono().trim());
            txtOcupacion.setText(primerResultado.getOcupacion().trim());
            txtcodigoPro.setText(primerResultado.getCodigo_propie().trim());
            Datefechapro.setDate(primerResultado.getFecha_nac());
        } else {
            // Si no se encontraron resultados, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "No se encontró ningún propietario con la cedula ingresada");
        }

        base.close();


    }//GEN-LAST:event_BtnBuscarActionPerformed

    public void ActualizarDatos(ObjectContainer base) {
        if (rbmasculinoPro.isSelected()) {
            sexo = "Masculino";
        } else if (rbfemeninoPro.isSelected()) {
            sexo = "Femenino";
        }

        // Validar edad (mayor a 18 años)
        if (!esMayorDeEdad(Datefechapro.getDate())) {
            JOptionPane.showMessageDialog(this, "El personal debe ser mayor de 18 años.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Propietario mipro = new Propietario(null, null, txtcedulaPro.getText().trim(), null, null, null, null, null, null);

        try {
            ObjectSet res = base.get(mipro);

            if (res.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún propietario con la cédula proporcionada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Propietario mipropietario = (Propietario) res.next();
            mipropietario.setNombre(txtnombrePro.getText().trim());
            mipropietario.setApellido(txtapellidoPro.getText().trim());
            mipropietario.setEmail(txtemailPro.getText().trim());
            mipropietario.setTelefono(txttelefonoPro.getText().trim());
            mipropietario.setOcupacion(txtOcupacion.getText().trim());
            mipropietario.setGenero(sexo.trim());
            mipropietario.setCodigo_propie(txtcodigoPro.getText().trim());
            mipropietario.setFecha_nac(Datefechapro.getDate());

            base.set(mipropietario);
            JOptionPane.showMessageDialog(this, "Modificación exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error durante la modificación. Consulta los registros para obtener más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            base.close();
        }

        limpiar();
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

    public void inhabiltarDatos() {

        txtnombrePro.setEnabled(false);
        txtapellidoPro.setEnabled(false);
        txtemailPro.setEnabled(false);
        txttelefonoPro.setEnabled(false);
        txtOcupacion.setEnabled(false);
        rbmasculinoPro.setEnabled(false);
        rbfemeninoPro.setEnabled(false);
        txtcodigoPro.setEnabled(false);
        Datefechapro.setEnabled(false);
    }

    public void habiltarDatos() {

        txtnombrePro.setEnabled(true);
        txtapellidoPro.setEnabled(true);
        txtemailPro.setEnabled(true);
        txttelefonoPro.setEnabled(true);
        txtOcupacion.setEnabled(true);
        rbmasculinoPro.setEnabled(true);
        rbfemeninoPro.setEnabled(true);
        txtcodigoPro.setEnabled(true);
        Datefechapro.setEnabled(true);

    }

    private void rbmasculinoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmasculinoProActionPerformed

    }//GEN-LAST:event_rbmasculinoProActionPerformed

    private void rbfemeninoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfemeninoProActionPerformed

    }//GEN-LAST:event_rbfemeninoProActionPerformed

    private void txtcedulaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaProActionPerformed

    }//GEN-LAST:event_txtcedulaProActionPerformed

    private void txtnombreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreProActionPerformed

    }//GEN-LAST:event_txtnombreProActionPerformed

    private void txtapellidoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoProActionPerformed

    }//GEN-LAST:event_txtapellidoProActionPerformed

    private void txtemailProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailProActionPerformed

    }//GEN-LAST:event_txtemailProActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModi;
    private javax.swing.JButton BtnReporte;
    private com.toedter.calendar.JDateChooser Datefechapro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablePropietario;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JRadioButton rbfemeninoPro;
    private javax.swing.JRadioButton rbmasculinoPro;
    private javax.swing.JTextField txtOcupacion;
    private javax.swing.JTextField txtapellidoPro;
    private javax.swing.JTextField txtcedulaPro;
    private javax.swing.JLabel txtcodigoPro;
    private javax.swing.JTextField txtemailPro;
    private javax.swing.JTextField txtnombrePro;
    private javax.swing.JTextField txttelefonoPro;
    // End of variables declaration//GEN-END:variables
}
