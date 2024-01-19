
import clases.CasaVacacional;
import clases.Cliente;
import clases.Servicio;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eliza
 */
public class CRUD_Servicio extends javax.swing.JPanel {

    /**
     * Creates new form CRUD_Servicio
     */
    public CRUD_Servicio() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombreservicio = new javax.swing.JTextField();
        costoadicionaldouble = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripciontxt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtcodigo = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(436, 436, 436))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
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

        jLabel3.setText("Código Servicio:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 25, -1, -1));

        jLabel5.setText("Nombre Servicio:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel6.setText("Costo:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel7.setText("Descripción:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 188, -1, -1));
        jPanel6.add(txtnombreservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 82, 250, -1));
        jPanel6.add(costoadicionaldouble, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, -1));

        descripciontxt.setColumns(20);
        descripciontxt.setRows(5);
        jScrollPane1.setViewportView(descripciontxt);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 188, 480, 139));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Servicio", "Nombre Servicio", "Descripcion", "Costo"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 421, 840, 150));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 354, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 348, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 352, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton4.setText("REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 352, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 6, -1, -1));
        jPanel6.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 25, 250, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        crearServicio(base);
        base.close();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
         ObjectContainer base = Db4o.openFile(INICIO.direccion);

        String codservi = " ", codcli = " ", nombreserv = " ", descripcion = " ";
        double costoad = 0.0;

        int ed = 0;
        Query query = base.query();
        query.constrain(Servicio.class);
        query.descend("codigo_servicio").constrain(txtcodigo.getText().trim());
        ObjectSet<Servicio> result = query.execute();

        String[] columnNames = {"CODIGO DEL SERVICIO", "NOMBRE DEL SERVICIO", "COSTO ADICIONAL", "DESCRIPCION"};

        Object[][] data = new Object[result.size()][4];

        int i = 0;
        for (Servicio servi : result) {
            data[i][0] = servi.getCodigo_servicio();
            data[i][1] = servi.getNombre_ser();
            data[i][2] = servi.getDescripcionSer();
            data[i][3] = servi.getCostoAdicional();
            
            
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable2.setModel(model);

        jTable2.repaint();

        if (!result.isEmpty()) {
            //habiltarDatos();
            for (Servicio servi1 : result) {
                codservi = servi1.getCodigo_servicio();
                nombreserv = servi1.getNombre_ser();
                costoad = Double.parseDouble(servi1.getCostoAdicional());
                descripcion = servi1.getDescripcionSer();

                

            }

            txtnombreservicio.setText(nombreserv.trim());
            costoadicionaldouble.setText(Double.toString(costoad));
            descripciontxt.setText(descripcion.trim());
            
            //txtcodigoPropi.setText(cod.trim());

        } else {

            JOptionPane.showMessageDialog(null, "No se encontró ningúna Casa Vacional con la cedula ingresada");

        }

        base.close();
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código del servicio a eliminar");
        boolean encontrado = false;

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        try {
            // Verificar si el servicio está asociado a alguna Casa Vacacional
            Query queryCasa = base.query();
            queryCasa.constrain(CasaVacacional.class);
            queryCasa.descend("cod_servicio").constrain(codigoEliminar);

            ObjectSet<CasaVacacional> resultCasa = queryCasa.execute();

            if (resultCasa.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el servicio porque está asociado a una Casa Vacacional", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar y eliminar el servicio
            Query queryServicio = base.query();
            queryServicio.constrain(Servicio.class);
            queryServicio.descend("codigo_servicio").constrain(codigoEliminar);

            ObjectSet<Servicio> resultServicio = queryServicio.execute();
            cargarTabla(base);

            if (resultServicio.size() > 0) {
                encontrado = true;

                int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos del servicio", "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (resul == JOptionPane.YES_OPTION) {
                    for (Servicio servicio : resultServicio) {
                        base.delete(servicio);
                        JOptionPane.showMessageDialog(null, "Se están borrando los datos del servicio");
                        cargarTabla(base);
                    }
                } else if (resul == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Datos del servicio no eliminados");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el código");
                cargarTabla(base);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada
        } finally {
            base.close();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

   
    
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);

        base.close();     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        ActualizarDatos(base);
        base.close();
    }//GEN-LAST:event_jButton2ActionPerformed
   
    
     public void ActualizarDatos(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (txtcodigo.getText().trim().isEmpty() || txtnombreservicio.getText().trim().isEmpty() ||costoadicionaldouble.getText().trim().isEmpty() || descripciontxt.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor llene en el campo del Codigo para la Modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Servicio micasa = new Servicio(txtcodigo.getText().trim(), null, null, null);

            ObjectSet res = base.get(micasa);
            Servicio miServicio = (Servicio) res.next();

            // Obtener valores de los campos
           
            miServicio.setNombre_ser(txtnombreservicio.getText());
            miServicio.setCostoAdicional(costoadicionaldouble.getText());
            miServicio.setDescripcionSer(descripciontxt.getText());
            

           
            base.set(miServicio);

            JOptionPane.showMessageDialog(this, "Modificación exitosa");
            limpiar();
            
        } finally {
            base.close();
        }
    }
     
     public void crearServicio(ObjectContainer Base) {
        // Verificar si todos los campos están llenos
        if (txtnombreservicio.getText().trim().isEmpty() ||costoadicionaldouble.getText().trim().isEmpty() || descripciontxt.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor llene los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        
        }

        try {
            
            Query query = Base.query();
            query.constrain(Servicio.class);
            query.descend("codigo_servicio").orderDescending();
            ObjectSet<Servicio> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Servicio ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCodigo_servicio().substring(4)) + 1;
            }

            // Formatear el código con ceros a la izquierda y agregar "ACT-"
            String nuevoCodigo = String.format("SER-%03d", ultimoCodigo);
            txtcodigo.setText(nuevoCodigo);
            

            // Verificar si ya existe una casa con el mismo código
            result = Base.queryByExample(new Servicio(nuevoCodigo, null, null, null));

            if (!result.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un servicio con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear objeto CasaVacacional y almacenar en la base de datos
            Servicio casa1 = new Servicio(txtcodigo.getText().trim(),txtnombreservicio.getText().trim(),descripciontxt.getText().trim() ,costoadicionaldouble.getText().trim());

            Base.store(casa1);

            JOptionPane.showMessageDialog(this, "Servicio creado exitosamente");
            limpiar();
            cargarTabla(Base);
        } finally {
            Base.close();
        }
    }
     public void limpiar() {
        txtcodigo.setText("");
        txtnombreservicio.setText("");
        costoadicionaldouble.setText("");
        descripciontxt.setText("");
        
        
        //  txtcodigoPropi.setText(" ");
    }
    
    public void cargarTabla(ObjectContainer base) {

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        ObjectSet<Servicio> result = base.queryByExample(new Servicio());

        while (result.hasNext()) {
            Servicio servi1 = result.next();

            Object[] row = {
                servi1.getCodigo_servicio(),
                servi1.getNombre_ser(),
                servi1.getCostoAdicional(),
                servi1.getDescripcionSer(),
                

            };
            model.addRow(row);
        }

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField costoadicionaldouble;
    private javax.swing.JTextArea descripciontxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel txtcodigo;
    private javax.swing.JTextField txtnombreservicio;
    // End of variables declaration//GEN-END:variables
}
