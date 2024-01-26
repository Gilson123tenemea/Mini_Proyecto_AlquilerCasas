
import clases.Agente_inmobiliario;
import clases.Cliente;
import clases.Contrato;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;

public class Contrato_cliente extends javax.swing.JPanel {

    String agente = "";
    String cleinte = "";
    String Casa_nombre = "";
    String precio_casa = "";
    String codigo_cliente = "";
    String nombree = " ", apellidoo = " ";
    String nombrec = " ", apellidoc = " ",nombrea = " ", apellidoa = " ";

    public Contrato_cliente() {
        initComponents();
        txtcliente.setText(INICIO.nombre + "  " + INICIO.apellido);
        
    }

    public void cargarCasas(ObjectContainer base) {

        Query query = base.query();
        query.constrain(Contrato.class);
        query.descend("codigo_cli").constrain(INICIO.codigo);
        ObjectSet<Contrato> result = query.execute();
        JOptionPane.showMessageDialog(null, INICIO.codigo + " ghhcewc" + result);

        if (!result.isEmpty()) {
            for (Contrato servi : result) {
                agente = servi.getCodigo_age();
                cleinte = servi.getCodigo_cli();
                Casa_nombre = servi.getNombre_casa();
                precio_casa = servi.getPrecio_casa();

            }

            txtcasa.setText(Casa_nombre);
            txtPrecio.setText(precio_casa);

        } else {
            JOptionPane.showMessageDialog(null, "Aun no se establece un contrato");
        }
    }

    public void cargarCliente(ObjectContainer base) {

        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("codigo_cli").constrain(cleinte);
        ObjectSet<Cliente> result = query.execute();

        if (!result.isEmpty()) {
            for (Cliente servi : result) {
                nombrec = servi.getNombre();
                apellidoc = servi.getApellido();

            }

            txtcliente.setText(nombrec + " " + apellidoc);

        }
    }

    public void cargarAgente(ObjectContainer base) {

        Query query = base.query();
        query.constrain(Agente_inmobiliario.class);
        query.descend("codigo_cli").constrain(cleinte);
        ObjectSet<Agente_inmobiliario> result = query.execute();

        if (!result.isEmpty()) {
            for (Agente_inmobiliario servi : result) {
                nombrea = servi.getNombre();
                apellidoa = servi.getApellido();

            }

            txtAgente.setText(nombrea + " " + apellidoa);

        }
    }

//    public void cargarContrato() {
//        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
//        cbxContrato.removeAllItems();
//        Query query = Base.query();
//        query.constrain(Contrato.class);
//
//        ObjectSet<Contrato> casas = query.execute();
//
//        if (casas.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "No hay contratos creados", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            while (casas.hasNext()) {
//                Contrato casa = casas.next();
//                cbxContrato.addItem(casa.getCodigo_contrato());
//            }
//
//        }
//        Base.close();
//    }

//    private void mostrarDatosContratoSeleccionado(ObjectContainer bases) {
//        try {
//            Object selectedItem = cbxContrato.getSelectedItem();
//
//            if (selectedItem != null) {
//                String codigoSelec = selectedItem.toString();
//
//                Query query = bases.query();
//                query.constrain(Contrato.class);
//                query.descend("codigo_contrato").constrain(codigoSelec);
//                ObjectSet<Contrato> result = query.execute();
//
//                if (!result.isEmpty()) {
//                    Contrato casa = result.next();
//                    String mensaje = "Codigo: " + casa.getCodigo_contrato() + "\n"
//                            + "Cliente: " + casa.getCodigo_cli() + "\n"
//                            + "Agente: " + casa.getCodigo_age() + "\n"
//                            + "Nombre de la casa: " + casa.getNombre_casa() + "\n"
//                            + "Precio de la casa: " + casa.getPrecio_casa();
//                    JOptionPane.showMessageDialog(this, mensaje, "Datos del Contrato", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(this, "No se encontró un contrato con el código seleccionado.", "Contrato no encontrada", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error al mostrar datos del Contrato.", "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            bases.close();
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcasa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btncontrato = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Con fundamento del articulo del codigo civil del estado de Ecuador celebran el presente contrato de arrendamiento como arrendador");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 74, 858, -1));

        txtAgente.setEditable(false);
        txtAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgenteActionPerformed(evt);
            }
        });
        jPanel2.add(txtAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 103, 171, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("como arrendatario");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 106, 127, -1));

        txtcliente.setEditable(false);
        jPanel2.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 103, 271, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usted se compromete a cuidar de la casa ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 188, 279, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("y aceptando todos los terminos de la clausula");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 157, 300, -1));

        txtcasa.setEditable(false);
        jPanel2.add(txtcasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 185, 203, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText(", la cual esta valorada para su arendamiento de");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 188, 309, -1));

        txtPrecio.setEditable(false);
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 221, 203, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText(", si existe algun suceso que dañe dicho bien usted sera el responsable de pagar el arreglo de la casa");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 228, 637, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cabe recalcar que casa casa lleva servicios los cuales puede aceptar o rechazar, si es que necesita de otros servicios no dude en  ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 263, 858, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("comunicarse con el arrendador");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 286, 219, -1));

        btncontrato.setBackground(new java.awt.Color(255, 255, 255));
        btncontrato.setText("MI  CONTRATO");
        btncontrato.setBorder(null);
        btncontrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontratoActionPerformed(evt);
            }
        });
        jPanel2.add(btncontrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 30, 156, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton2.setText("SOLICITAR FACTURA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 200, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void btncontratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontratoActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        cargarCasas(base);
        cargarAgente(base);
        cargarCliente(base);
        
        base.close();
    }//GEN-LAST:event_btncontratoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "Espera 1 minuto y su fatura se generada");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncontrato;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcliente;
    // End of variables declaration//GEN-END:variables
}
