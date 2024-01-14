
import clases.CasaVacacional;
import clases.Promocion;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Promocion_crud extends javax.swing.JPanel {

    public Promocion_crud() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codpromocion = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cbxcasa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txadescripcion = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JSpinner();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N

        jLabel2.setText("Código Promoción:");

        jLabel3.setText("Código Casa:");

        jLabel4.setText("Descuento:");

        jLabel5.setText("Fecha de Inicio:");

        jLabel6.setText("Fecha de Fin:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código Promoción", "Código Casa", "Descripcion", "Descuento", "Fecha de inicio", "Fecha de fin"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton4.setText("REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton5.setText("BUSCAR");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cbxcasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jLabel7.setText("Descripcion del descuento");

        txadescripcion.setColumns(20);
        txadescripcion.setRows(5);
        jScrollPane2.setViewportView(txadescripcion);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("CARGAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(codpromocion)
                                        .addComponent(cbxcasa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(92, 92, 92)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(29, 29, 29)
                                .addComponent(jButton8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(98, 98, 98)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(558, 558, 558)
                                .addComponent(jButton5))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codpromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbxcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton8))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 900, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        crearCasa(base);
        base.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void limpiar() {
        codpromocion.setText("");
        cbxcasa.setSelectedItem(false);
        txadescripcion.setText("");
        jTextField3.setValue(0);
        jDateChooser1.setDate(null); // Establecer la fecha a null o a un valor específico
        jDateChooser2.setDate(null); // Establecer la fecha a null o a un valor específico

        //  txtcodigoPropi.setText(" ");
    }

    public void cargarTabla(ObjectContainer base) {

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        ObjectSet<Promocion> result = base.queryByExample(new clases.Promocion());

        while (result.hasNext()) {
            Promocion promo1 = result.next();

            Object[] row = {
                promo1.getCod_promo(),
                promo1.getCod_casa(),
                promo1.getDescripcion(),
                promo1.getDescuento(),
                promo1.getFecha_inicio(),
                promo1.getFecha_fin(),};
            model.addRow(row);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        ActualizarDatos(base);
        base.close();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void crearCasa(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (codpromocion.getText().trim().isEmpty() || cbxcasa.getSelectedItem() == null || txadescripcion.getText().trim().isEmpty()
                || jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Verificar si ya existe una casa con el mismo código
            ObjectSet<Promocion> resultado = base.queryByExample(new Promocion(codpromocion.getText().trim(), null, 0, null, null, null));

            if (!resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe una casa con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la edad como entero
            int edad = (int) jTextField3.getValue();
            // Crear objeto Promocion y almacenar en la base de datos
            // public Promocion(String cod_promo, String cod_casa, int Descuento, Date fecha_inicio, Date fecha_fin, String descripcion) {

            Promocion casa1 = new Promocion(codpromocion.getText().trim(), cbxcasa.getSelectedItem().toString(), edad, jDateChooser1.getDate(), jDateChooser2.getDate(), txadescripcion.getText().trim());

            base.store(casa1);

            JOptionPane.showMessageDialog(this, "Casa creada exitosamente");
            limpiar();
            cargarTabla(base);
        } finally {
            base.close();
        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código de la casa a eliminar");
        boolean encontrado = false;

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        Query query = base.query();
        query.constrain(Promocion.class
        );
        query.descend("cod_promo").constrain(codigoEliminar);

        ObjectSet<Promocion> result = query.execute();
        cargarTabla(base);

        if (result.size() > 0) {
            encontrado = true;

            int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos de la Casa Vacacional", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (resul == JOptionPane.YES_OPTION) {
                for (Promocion vacacionalDB : result) {
                    // Eliminar la Casa Vacacional de la base de datos db4o
                    base.delete(vacacionalDB);
                    JOptionPane.showMessageDialog(null, "Se están borrando los datos de la Casa Vacacional");
                    cargarTabla(base);
                }
            } else if (resul == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Datos de la Casa Vacacional no eliminados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el código");
            cargarTabla(base);
        }

        base.close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);

        base.close();      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        String codcasa = " ", descripcion = " ";
        int descuento = 0;
        Date fechafin = null;
        Date fechainicio = null;

        int ed = 0;
        Query query = base.query();
        query.constrain(Promocion.class
        );
        query.descend("cod_promo").constrain(codpromocion.getText().trim());
        ObjectSet<Promocion> result = query.execute();

        String[] columnNames = {"CODIGO DE LA PROMOCION", "CODIGO DE LA CASA", "DESCRIPCION", "DESCUENTO", "FECHA DE INICIO", "FECHA DE FIN"};

        Object[][] data = new Object[result.size()][9];

        int i = 0;
        for (Promocion promo1 : result) {
            data[i][0] = promo1.getCod_promo();
            data[i][1] = promo1.getCod_casa();
            data[i][2] = promo1.getDescripcion();

            data[i][3] = promo1.getDescuento();
            data[i][4] = promo1.getFecha_inicio();
            data[i][5] = promo1.getFecha_fin();

            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable2.setModel(model);

        jTable2.repaint();

        if (!result.isEmpty()) {
            //habiltarDatos();
            for (Promocion promo1 : result) {
                codcasa = promo1.getCod_casa();
                descripcion = promo1.getDescripcion();
                descuento = promo1.getDescuento();
                fechainicio = promo1.getFecha_inicio();
                fechafin = promo1.getFecha_fin();

            }
            cbxcasa.setSelectedItem(codcasa);
            txadescripcion.setText(descripcion);
            jTextField3.setValue(descuento);
            jDateChooser1.setDate(fechainicio);
            jDateChooser2.setDate(fechafin);

            //txtcodigoPropi.setText(cod.trim());
        } else {

            JOptionPane.showMessageDialog(null, "No se encontró ningúna Casa Vacional con la cedula ingresada");

        }

        base.close();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cargarCasas(Base);
        Base.close();
 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        mostrarDatosCasaSeleccionado();
    }//GEN-LAST:event_jButton7ActionPerformed

    public void ActualizarDatos(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (codpromocion.getText().trim().isEmpty() || cbxcasa.getSelectedItem().toString() == null || txadescripcion.getText().trim().isEmpty()
                || jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

            JOptionPane.showMessageDialog(null, "Por favor llene en el campo del Codigo para la Modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Promocion micasa = new Promocion(codpromocion.getText().trim(), null, 0, null, null, null);

            ObjectSet res = base.get(micasa);
            Promocion micasita = (Promocion) res.next();
            micasita.setCod_casa(cbxcasa.getSelectedItem().toString());
            micasita.setDescripcion(txadescripcion.getText());

            micasita.setDescuento((int) jTextField3.getValue());
            micasita.setFecha_inicio(jDateChooser1.getDate());
            micasita.setFecha_fin(jDateChooser2.getDate());

            base.set(micasita);

            JOptionPane.showMessageDialog(this, "Modificación exitosa");
            limpiar();

        } finally {
            base.close();
        }
    }
    
    public void cargarCasas(ObjectContainer Base) {

        cbxcasa.removeAllItems();
        Query query = Base.query();
        query.constrain(CasaVacacional.class);
        
        ObjectSet<CasaVacacional> casas = query.execute();
        
         if (casas.isEmpty()) {             
             JOptionPane.showMessageDialog(this, "No hay casas vacacionales disponibles", "Error", JOptionPane.ERROR_MESSAGE);    
         } else {
             while (casas.hasNext()) {
                CasaVacacional casa = casas.next();
                cbxcasa.addItem(casa.getCod_casa());
             }
             
         }
        
     }
    
    private void mostrarDatosCasaSeleccionado() {
        ObjectContainer bases = Db4o.openFile(INICIO.direccion);
        String codigoSelec = cbxcasa.getSelectedItem().toString();
        Query query = bases.query();
        query.constrain(CasaVacacional.class);
        query.descend("cod_casa").constrain(codigoSelec);
        ObjectSet<CasaVacacional> result = query.execute();
        
        if (!result.isEmpty()) {
            CasaVacacional casa = result.next();
            String mensaje = "Nombre: " + casa.getNombre_casa()+ "\n"
                    + "Tipo: " + casa.getTipo_casa()+ "\n"
                    + "Pisos: " + casa.getNum_pisos()+ "\n"
                    + "Capacidad: "+ casa.getCapacidad_max()+ "\n"
                    + "Habitaciones: "+ casa.getNum_habitaciones()+ "\n"
                    + "Baños: "+ casa.getNum_baños();
            JOptionPane.showMessageDialog(this, mensaje, "Datos de Casas Vacacionales", JOptionPane.INFORMATION_MESSAGE);
            
        }else {
            JOptionPane.showMessageDialog(this, "No se encontró una casa con el codigo seleccionado.", "Ubicacion no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxcasa;
    private javax.swing.JTextField codpromocion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JSpinner jTextField3;
    private javax.swing.JTextArea txadescripcion;
    // End of variables declaration//GEN-END:variables
}
