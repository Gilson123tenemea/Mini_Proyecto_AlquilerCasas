
import clases.CasaVacacional;
import clases.Cliente;
import clases.Contrato;
import clases.Reservar;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Contrato_agente extends javax.swing.JPanel {

    String agente = "";
    double precio=0.0;

    public Contrato_agente() {
        initComponents();
        txtcodagen.setText(Administrador_Login.nombre + " " + Administrador_Login.apellido);

    }

    private void mostrarDatosClienteSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cbxcliente.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Cliente.class);
                query.descend("codigo_cli").constrain(codigoSelec);
                ObjectSet<Cliente> result = query.execute();

                if (!result.isEmpty()) {
                    Cliente cli = result.next();
                    String mensaje = "Codigo: " + cli.getCodigo_cli() + "\n"
                            + "Nombre: " + cli.getNombre() + "\n"
                            + "Apellido: " + cli.getApellido() + "\n"
                            + "telefono: " + cli.getTelefono() + "\n"
                            + "Correo: " + cli.getEmail();
                    JOptionPane.showMessageDialog(this, mensaje, "Datos del Cliente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un cliente con el código seleccionado.", "Contrato no encontrada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos del Cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }

    public void crear(ObjectContainer base) {
        try {

            Query query = base.query();
            query.constrain(Contrato.class);
            query.descend("codigo_contrato").orderDescending();
            ObjectSet<Contrato> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Contrato ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCodigo_contrato().substring(4)) + 1;
            }
            String nuevoCodigo = String.format("CON-%03d", ultimoCodigo);
            lblcontrato.setText(nuevoCodigo);

            ObjectSet<Contrato> resul = base.queryByExample(new Contrato(nuevoCodigo, null, null, null, null, false));
            if (!resul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un contato con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                //String codigo_contrato, String codigo_cli, String codigo_age, String nombre_casa, String precio_casa, boolean TerminosCondiciones
                Contrato casa1 = new Contrato(nuevoCodigo, cbxcliente.getSelectedItem().toString(), txtcodagen.getText().trim(), cbxcasa.getSelectedItem().toString(), txtprecio.getText().trim(), false);
                base.store(casa1);

                JOptionPane.showMessageDialog(this, "Contrato creada exitosamente");
                limpiar();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor de precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } finally {
            base.close();
        }

    }

    public void limpiar() {
        lblcontrato.setText("");
        txtcodagen.setText("");
        txtprecio.setText("");
    }

    public void cargarCliente(ObjectContainer base) {

        try {
            cbxcliente.removeAllItems();
            Query query = base.query();
            query.constrain(Cliente.class);

            ObjectSet<Cliente> evento1 = query.execute();

            while (evento1.hasNext()) {

                Cliente mie = evento1.next();
                System.out.println("tipo:" + mie.getNombre());
                cbxcliente.addItem(mie.getCodigo_cli());

            }

        } finally {

            base.close();

        }
    }

    public void cargarCasa(ObjectContainer base) {

        try {
            cbxcasa.removeAllItems();
            Query query = base.query();
            query.constrain(CasaVacacional.class);

            ObjectSet<CasaVacacional> evento1 = query.execute();

            while (evento1.hasNext()) {

                CasaVacacional mie = evento1.next();
                cbxcasa.addItem(mie.getCod_casa());

            }

        } finally {

            base.close();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblcontrato = new javax.swing.JLabel();
        cbxcliente = new javax.swing.JComboBox<>();
        cbxcasa = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtcodagen = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("CONTRATO");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Con fundamento del articulo del código civíl del estado de Ecuador celebran el presente contrato de arrendamiento como arrendador");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("como arrendatario");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Usted se compromete a cuidar de la casa ");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("y aceptando todos los terminos de la cláusula.");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText(", la cual esta valorada para su arendamiento de");

        txtprecio.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText(", si existe algun suceso que dañe dicho bien usted sera el responsable de pagar el arreglo de la casa");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Cabe recalcar que casa casa lleva servicios los cuales puede aceptar o rechazar, si es que necesita de otros servicios no dude en  ");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("comunicarse con el arrendador.");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Este contrato finalizará hasta que termine su reserva.");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxclienteMouseClicked(evt);
            }
        });

        cbxcasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxcasaMouseClicked(evt);
            }
        });
        cbxcasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxcasaActionPerformed(evt);
            }
        });

        jButton2.setText("ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtcodagen.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblcontrato)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cbxcasa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcodagen, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(77, 77, 77))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(295, 295, 295))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(414, 414, 414))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblcontrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(txtcodagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(73, 73, 73)
                .addComponent(jButton1)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

        crear(base);
        base.close();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxcasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxcasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxcasaActionPerformed

    private void cbxclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxclienteMouseClicked
        // TODO add your handling code here:

        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarCliente(base);
        base.close();
    }//GEN-LAST:event_cbxclienteMouseClicked

    private void cbxcasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxcasaMouseClicked
        // TODO add your handling code here:
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarCasa(base);
        base.close();
    }//GEN-LAST:event_cbxcasaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosClienteSeleccionado(base);
        base.close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosCasaSeleccionado(base);
        base.close();
    }//GEN-LAST:event_jButton3ActionPerformed

     private void mostrarDatosCasaSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cbxcasa.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(CasaVacacional.class);
                query.descend("cod_casa").constrain(codigoSelec);
                ObjectSet<CasaVacacional> result = query.execute();

                if (!result.isEmpty()) {
                    CasaVacacional ca = result.next();
                    precio=ca.getPrecio();
                    String mensaje = "Codigo: " + ca.getCod_casa() + "\n"
                            + "Nombre: " + ca.getNombre_casa() + "\n"
                            + "tipo de casa: " + ca.getTipo_casa() + "\n"
                            + "Capacidad: " + ca.getCapacidad_max();
                    JOptionPane.showMessageDialog(this, mensaje, "Datos del Cliente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una casa con el código seleccionado.", "Contrato no encontrada", JOptionPane.ERROR_MESSAGE);
                }
                
                String p = String.valueOf(precio);
                txtprecio.setText(p);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de la casa", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxcasa;
    private javax.swing.JComboBox<String> cbxcliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblcontrato;
    private javax.swing.JTextField txtcodagen;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
