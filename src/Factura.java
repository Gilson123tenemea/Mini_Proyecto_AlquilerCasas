
import clases.Actividades;
import clases.CasaVacacional;
import clases.Encabezado_Factura;
import clases.Promocion;
import clases.Reservar;
import clases.Servicio;
import clases.Servicio_Adicional;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo.User
 */
public class Factura extends javax.swing.JPanel {

    String casa = "";
    String nombre = "";
    double precio = 0.0;
    int descuento = 0;
    String Nombre_ser = "";
    String cod_ser_adi = "";
    String precio_ser = null;
    String codigopromo = "";
    String codigoseradicional = "";
    String reserva = "";
    String nombrecas = "";
    double precicasa = 0.0;
    String cod_Factura = "";
    Date fehcaini = null;
    Date fehcafin = null;
    String precionServicio = "";

    public Factura() {

        initComponents();

        System.out.println(INICIO.codigo);
        txtcedula.setText(INICIO.usuario);
        txtnombre.setText(INICIO.nombre);
        txtapellido.setText(INICIO.apellido);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfechaini = new javax.swing.JTextField();
        txtfechafin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("NOMBRE");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 153, 80, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Mi factura");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 39, 178, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("CEDULA");
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 120, 80, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("APELLIDO");
        jLabel5.setToolTipText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 153, 80, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("VALOR A PAGAR");
        jLabel6.setToolTipText("");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 274, 140, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("PRECIO DE ALQUILER");
        jLabel7.setToolTipText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 201, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("CASA");
        jLabel8.setToolTipText("");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 205, 67, -1));

        txtcedula.setEditable(false);
        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        jPanel2.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 113, 265, -1));

        txtnombre.setEditable(false);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 149, 176, -1));

        txtapellido.setEditable(false);
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 149, 176, -1));

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(255, 255, 255));
        txttotal.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        txttotal.setText("000.00");
        jPanel2.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 351, 212, 77));

        txtcasa.setEditable(false);
        txtcasa.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtcasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 201, 182, -1));

        txtdescuento.setEditable(false);
        txtdescuento.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtdescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 80, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("DESCUENTOS");
        jLabel11.setToolTipText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 140, -1));

        txtprecio.setEditable(false);
        txtprecio.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 80, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diapositiva.png"))); // NOI18N
        jButton1.setText("VER FACTURA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("$");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 20, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText("%");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 30, 30));

        txtfechaini.setEditable(false);
        txtfechaini.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtfechaini, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 180, -1));

        txtfechafin.setEditable(false);
        txtfechafin.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtfechafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 180, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Fecha Inicio:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Fecha Fin:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 840, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void CalcularPago() {

    }

    public void Obtenerfacturas(ObjectContainer base) {
        Query query = base.query();
        query.constrain(Encabezado_Factura.class);
        query.descend("cod_cliente").constrain(INICIO.codigo);

        ObjectSet<Encabezado_Factura> result = query.execute();
        if (!result.isEmpty()) {

            for (Encabezado_Factura servi : result) {
                casa = servi.getCod_casa();
                codigopromo = servi.getCod_promocion();
                reserva = servi.getCod_servicio();
                cod_ser_adi = servi.getDoc_ser_adici();
                precio = servi.getValor_cancelar();
                cod_Factura = servi.getCodigo_fac();

            }

            String total = String.valueOf(precio);
            txttotal.setText(total);
        }

    }

    public void cargarCasas(ObjectContainer base) {

        Query query = base.query();
        query.constrain(CasaVacacional.class);
        query.descend("cod_casa").constrain(casa);
        ObjectSet<CasaVacacional> result = query.execute();
        if (!result.isEmpty()) {

            for (CasaVacacional servi : result) {
                nombrecas = servi.getNombre_casa();
                precicasa = servi.getPrecio();
            }
            txtcasa.setText(nombrecas);
            String precioalqioler = String.valueOf(precicasa);

            txtprecio.setText(precioalqioler);

        }
    }

    public void obtenerPromo(ObjectContainer base) {

        Query query = base.query();
        query.constrain(Promocion.class);
        query.descend("cod_promo").constrain(codigopromo);
        ObjectSet<Promocion> result = query.execute();
        if (!result.isEmpty()) {

            for (Promocion servi : result) {
                descuento = servi.getDescuento();
            }
            String descu = String.valueOf(descuento);
            txtdescuento.setText(descu);
        }
    }

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    public void ObtenerReserva(ObjectContainer base) {

        Query consulta = base.query();
        consulta.constrain(Reservar.class);

        consulta.descend("coidigo_cli").constrain(INICIO.codigo);

        ObjectSet<Reservar> result = consulta.execute();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Reservar reserva1 : result) {
            fehcaini = reserva1.getFecha_ini();
            fehcafin = reserva1.getFecha_fin();
        }

        String fechaIniFormateada = sdf.format(fehcaini);
        String fechaFinFormateada = sdf.format(fehcafin);

        txtfechaini.setText(fechaIniFormateada);
        txtfechafin.setText(fechaFinFormateada);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ObjectContainer base = Db4o.openFile(INICIO.direccion);
            Obtenerfacturas(base);
            cargarCasas(base);
            obtenerPromo(base);
            ObtenerReserva(base);
            base.close();
        } catch (Exception e) {
            // Mostrar un mensaje con JOptionPane
            JOptionPane.showMessageDialog(null, "Por favor, realice primero una reserva.", "Error", JOptionPane.ERROR_MESSAGE);
            // Opcionalmente, puedes registrar la excepción o tomar otras acciones según tus necesidades
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtfechafin;
    private javax.swing.JTextField txtfechaini;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
