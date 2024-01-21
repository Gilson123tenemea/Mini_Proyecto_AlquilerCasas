
import clases.CasaVacacional;
import clases.Promocion;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.SimpleDateFormat;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txadescripcion = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JSpinner();
        codpromocion = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 6, -1, -1));

        jLabel2.setText("Código Promoción:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 24, -1, -1));

        jLabel4.setText("Descuento:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, 34));

        jLabel5.setText("Fecha de Inicio:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel6.setText("Fecha de Fin:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, 19));
        jPanel6.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 216, 250, -1));
        jPanel6.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 274, 250, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Promoción", "Descripcion", "Descuento", "Fecha de inicio", "Fecha de fin"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 456, 830, 253));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mod.png"))); // NOI18N
        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 130, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 120, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton4.setText("REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jButton6.setText("BUSCAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 130, -1));

        jLabel7.setText("Descripcion del descuento");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, -1));

        txadescripcion.setColumns(20);
        txadescripcion.setRows(5);
        jScrollPane2.setViewportView(txadescripcion);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 63, 250, 53));
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 60, 30));
        jPanel6.add(codpromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 110, 30));

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (result.hasNext()) {
            Promocion promo1 = result.next();

            Object[] row = {
                promo1.getCod_promo(),
                promo1.getDescripcion(),
                promo1.getDescuento(),
                promo1.getFecha_inicio() != null ? sdf.format(promo1.getFecha_inicio()) : null,
                promo1.getFecha_fin() != null ? sdf.format(promo1.getFecha_fin()) : null,};
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
        if (txadescripcion.getText().trim().isEmpty()
                || jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Query query = base.query();
            query.constrain(Promocion.class);
            query.descend("cod_promo").orderDescending();
            ObjectSet<Promocion> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Promocion ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCod_promo().substring(4)) + 1;
            }

            // Formatear el código con ceros a la izquierda y agregar "ACT-"
            String nuevoCodigo = String.format("PRT-%03d", ultimoCodigo);
            codpromocion.setText(nuevoCodigo);

            // Obtener la edad como entero
            int edad = (int) jTextField3.getValue();

            // Crear objeto Promocion y almacenar en la base de datos
            Promocion promocion = new Promocion(nuevoCodigo, edad, jDateChooser1.getDate(), jDateChooser2.getDate(), txadescripcion.getText().trim());
            base.store(promocion);

            JOptionPane.showMessageDialog(this, "Promoción creada exitosamente");
            limpiar();
            cargarTabla(base);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al crear la promoción", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            base.close();
        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código de la casa a eliminar");
        boolean encontrado = false;

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        try {
            // Verificar si la promoción está asociada a alguna Casa Vacacional
            Query queryCasa = base.query();
            queryCasa.constrain(CasaVacacional.class);
            queryCasa.descend("cod_promocion").constrain(codigoEliminar);

            ObjectSet<CasaVacacional> resultCasa = queryCasa.execute();

            if (resultCasa.size() > 0) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar la promoción porque está asociada a una Casa Vacacional", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar y eliminar la promoción
            Query queryPromocion = base.query();
            queryPromocion.constrain(Promocion.class);
            queryPromocion.descend("cod_promo").constrain(codigoEliminar);

            ObjectSet<Promocion> resultPromocion = queryPromocion.execute();
            cargarTabla(base);

            if (resultPromocion.size() > 0) {
                encontrado = true;

                int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos de la Promoción", "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (resul == JOptionPane.YES_OPTION) {
                    for (Promocion promocionDB : resultPromocion) {
                        base.delete(promocionDB);
                        JOptionPane.showMessageDialog(null, "Se están borrando los datos de la Promoción");
                        cargarTabla(base);
                    }
                } else if (resul == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Datos de la Promoción no eliminados");
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

        base.close();      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        buscarPromocion(base);

        base.close();

    }//GEN-LAST:event_jButton6ActionPerformed

     public void ActualizarDatos(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (codpromocion.getText().trim().isEmpty() || txadescripcion.getText().trim().isEmpty()
                || jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {

            JOptionPane.showMessageDialog(null, "Por favor llene en el campo del Codigo para la Modificacion", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Promocion micasa = new Promocion(codpromocion.getText().trim(), 0, null, null, null);

            ObjectSet res = base.get(micasa);
            Promocion micasita = (Promocion) res.next();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codpromocion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
private void buscarPromocion(ObjectContainer base) {
        String codigoBusqueda = JOptionPane.showInputDialog(this, "Ingrese el código de la promoción a buscar:", "Buscar Promoción", JOptionPane.QUESTION_MESSAGE);

        if (codigoBusqueda != null && !codigoBusqueda.isEmpty()) {
            Query query = base.query();
            query.constrain(Promocion.class);
            query.descend("cod_promo").constrain(codigoBusqueda);
            ObjectSet<Promocion> result = query.execute();

            if (!result.isEmpty()) {
                // Si hay resultados, llenar la tabla
                String[] columnNames = {"CODIGO DE LA PROMOCION", "DESCRIPCION", "DESCUENTO", "FECHA DE INICIO", "FECHA DE FIN"};
                Object[][] data = new Object[result.size()][5];
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                int i = 0;
                for (Promocion promo : result) {
                    data[i][0] = promo.getCod_promo();
                    data[i][1] = promo.getDescripcion();
                    data[i][2] = promo.getDescuento();
                    data[i][3] = promo.getFecha_inicio() != null ? sdf.format(promo.getFecha_inicio()) : null;
                    data[i][4] = promo.getFecha_fin() != null ? sdf.format(promo.getFecha_fin()) : null;
                    i++;
                }

                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                jTable2.setModel(model);

                // Mostrar detalles de la primera promoción encontrada
                Promocion primeraPromocion = result.next();
                txadescripcion.setText(primeraPromocion.getDescripcion());
                jTextField3.setValue(primeraPromocion.getDescuento());
                jDateChooser1.setDate(primeraPromocion.getFecha_inicio());
                jDateChooser2.setDate(primeraPromocion.getFecha_fin());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna promoción con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        base.close();
    }

}
