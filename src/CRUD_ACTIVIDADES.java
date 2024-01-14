
import clases.Actividades;
import clases.CasaVacacional;
import clases.Validaciones;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CRUD_ACTIVIDADES extends javax.swing.JPanel {

    public CRUD_ACTIVIDADES() {
        initComponents();
    }

    private void crearActividades(ObjectContainer Base) {
        if (txtIDacti.getText().trim().isEmpty() ||  cboxTipoActi.getSelectedItem() == null || spnCostos.getValue() == null){
            
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos antes de ingresar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
             ObjectSet<Actividades> resul = Base.queryByExample(new Actividades (txtIDacti.getText().trim(), null, null, null,null,null,null ));
             if (!resul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe una actividad con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
             
            Actividades acti = new Actividades (txtIDacti.getText().trim(), cboxCodigoClie.getSelectedItem().toString(), cbxNombreCasa.getSelectedItem().toString(), cboxTipoActi.getSelectedItem().toString(),spnCostos.getValue().toString() ,Date.getDate() , cboxHora.getSelectedItem().toString());
            Base.store(acti);
            JOptionPane.showMessageDialog(this, "Actividad creada exitosamente");
            limpiar();
            cargarTabla(Base);
 
        } finally {
            Base.close();
        }
        
    }
    
    public void cargarTabla(ObjectContainer base) {
        DefaultTableModel model = (DefaultTableModel) TableActi.getModel(); 
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos
        
        ObjectSet<Actividades> result = base.queryByExample(new Actividades());
       
        while (result.hasNext()) {
            Actividades acti = result.next();
             Object[] row = {
                 acti.getId_actividades(),
                 acti.getCod_cliente(),
                 acti.getCod_casa(),
                 acti.getTipo_actividad(),
                 acti.getCosto_adicional(),
                 acti.getFecha(),
                 acti.getHora()
                 
             };
             model.addRow(row);
        }
        
    }
    
    public void limpiar() {
        txtIDacti.setText("");  
    }
    
    
     public void cargarCasas() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cbxNombreCasa.removeAllItems();
        Query query = Base.query();
        query.constrain(CasaVacacional.class);
        
        ObjectSet<CasaVacacional> casas = query.execute();
        
         if (casas.isEmpty()) {             
             JOptionPane.showMessageDialog(this, "No hay casas vacacionales disponibles", "Error", JOptionPane.ERROR_MESSAGE);    
         } else {
             while (casas.hasNext()) {
                CasaVacacional casa = casas.next();
                cbxNombreCasa.addItem(casa.getCod_casa());
             }
             
         }
        
     }
    public void Modificar(ObjectContainer base) {
        if (txtIDacti.getText().trim().isEmpty() ||  cboxTipoActi.getSelectedItem() == null || spnCostos.getValue() == null){
            
            JOptionPane.showMessageDialog(null, "Por favor llene los datos que desee modificar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
          try {
              Actividades acti = new Actividades (txtIDacti.getText().trim(), null, null, null,null,null,null); 
              ObjectSet res = base.get(acti);
              Actividades actividad = (Actividades) res.next();
              
              actividad.setCod_cliente(cboxCodigoClie.getSelectedItem().toString());
              actividad.setCod_casa(cbxNombreCasa.getSelectedItem().toString());
              actividad.setTipo_actividad(cboxTipoActi.getSelectedItem().toString());
              actividad.setCosto_adicional(spnCostos.getValue().toString());
              actividad.setFecha(Date.getDate());
              actividad.setHora(cboxHora.getSelectedItem().toString());
              
              base.set(actividad);
              
              JOptionPane.showMessageDialog(this, "Modificación exitosa");
              limpiar();
  
          }finally {
            base.close();
        }
    }
    
    
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableActi = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cbxNombreCasa = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtIDacti = new javax.swing.JTextField();
        cboxTipoActi = new javax.swing.JComboBox<>();
        spnCostos = new javax.swing.JSpinner();
        cboxHora = new javax.swing.JComboBox<>();
        cboxCodigoClie = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actividades");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 6, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Código Cliente:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Casas Vacacionales:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de Actividad:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 164, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Costo Adicional:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Fecha:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Hora:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));
        jPanel6.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 190, -1));

        TableActi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Actividades", "Codigo Cliente", "Codigo Casa", "Tipo de Actividad", "Costo Adicional", "Fecha", "Hora"
            }
        ));
        jScrollPane1.setViewportView(TableActi);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 444, 815, 130));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton4.setText("REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton5.setText("CARGAR CODIGO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        cbxNombreCasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAS-001", "CAS-002", "CAS-003", "CAS-004", "CAS-005" }));
        cbxNombreCasa.setToolTipText("");
        jPanel6.add(cbxNombreCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Id Actividades:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel6.add(txtIDacti, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 140, -1));

        cboxTipoActi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descanso y Relajacion", "Asados y Comidas", "Senderismos y Actividades", "Observacion de la Naturaleza", "Pesca", "Juegos de mesa", "Excursiones Locales", "Actividades acuaticas", "Fotograficas", "Yoja y meditacion", "Jardineria y cuidado ", "Lectura y Escritura", "Tareas creativas", "Natacion", " " }));
        jPanel6.add(cboxTipoActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 200, -1));

        spnCostos.setModel(new javax.swing.SpinnerNumberModel(10.0d, 5.0d, 100.0d, 5.0d));
        jPanel6.add(spnCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 100, -1));

        cboxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM 12:00", "AM 01:00", "AM 02:00", "AM 03:00", "AM 04:00", "AM 05:00", "AM 06:00", "AM 07:00", "AM 08:00", "AM 09:00", "AM 10:00", "AM 11:00", "PM 12:00", "PM 01:00", "PM 02:00", "PM 03:00", "PM 04:00", "PM 05:00", "PM 06:00", "PM 07:00", "PM 08:00", "PM 09:00", "PM 10:00", "PM 11:00" }));
        cboxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxHoraActionPerformed(evt);
            }
        });
        jPanel6.add(cboxHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        cboxCodigoClie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0150698017", "0415325525", "0255289625", "0565668555", "0892523252" }));
        jPanel6.add(cboxCodigoClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 110, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cargarCasas();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código de la Actividad a eliminar");
        boolean encontrado = false;
        
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        Query query = base.query();
        query.constrain(Actividades.class);
        query.descend("id_actividades").constrain(codigoEliminar);
        
        ObjectSet<Actividades> result = query.execute();
        cargarTabla(base);
        
        if (result.size() > 0) {
            
            encontrado = true;
            int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos de la Actividad", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
             if (resul == JOptionPane.YES_OPTION) {
                 
                 for (Actividades activ : result) { 
                    base.delete(activ);
                    JOptionPane.showMessageDialog(null, "Se están borrando los datos de la Casa Vacacional");
                    cargarTabla(base);     
                 }
                 
                 
             }else if (resul == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Datos de la Casa Vacacional no eliminados");
            }
   
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el código");
            cargarTabla(base);
        }
        base.close();
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        crearActividades(base);
        base.close();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxHoraActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);

        base.close();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        
        String descripcion = " ", casas = " ", tipo = " ",costos = " ", hora = " ";
        Date fecha = null;
        
        Query query = base.query();
        query.constrain(Actividades.class);
        query.descend("id_actividades").constrain(txtIDacti.getText().trim());
        
        ObjectSet<Actividades> result = query.execute();
        String[] columnNames = {"ID ACTIVIDADES","CODIGO CLIENTE","CODIGO CASA","TIPO ACTIVIDAD","COSTO ADICIONAL","FECHA","HORA"};
        Object[][] data = new Object[result.size()][7];
        
        int i = 0;
        for (Actividades acti : result) {
            data[i][0] = acti.getId_actividades();
            data[i][1] = acti.getCod_cliente();
            data[i][2] = acti.getCod_casa();
            data[i][3] = acti.getTipo_actividad();
            data[i][4] = acti.getCosto_adicional();
            data[i][5] = acti.getFecha();
            data[i][6] = acti.getHora();
            
            i++;
            
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        TableActi.setModel(model);
        
        TableActi.repaint();
        if (!result.isEmpty()) {
            
            for (Actividades acti : result) {
                descripcion = acti.getCod_cliente();
                casas = acti.getCod_casa();
                tipo = acti.getTipo_actividad();
                costos= acti.getCosto_adicional();
                hora = acti.getHora();
            }
            
            cboxCodigoClie.setSelectedItem(descripcion.trim());
            cbxNombreCasa.setSelectedItem(casas.trim());
            cboxTipoActi.setSelectedItem(tipo.trim());
            spnCostos.setValue(costos);
            cboxHora.setSelectedItem(hora);
            
        }else {

            JOptionPane.showMessageDialog(null, "No se encontró ningúna Casa Vacional con la cedula ingresada");

        }

   
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JTable TableActi;
    private javax.swing.JComboBox<String> cboxCodigoClie;
    private javax.swing.JComboBox<String> cboxHora;
    private javax.swing.JComboBox<String> cboxTipoActi;
    private javax.swing.JComboBox<String> cbxNombreCasa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnCostos;
    private javax.swing.JTextField txtIDacti;
    // End of variables declaration//GEN-END:variables
}
