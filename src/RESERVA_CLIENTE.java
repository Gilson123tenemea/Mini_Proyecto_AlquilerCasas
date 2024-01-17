
import clases.CasaVacacional;
import clases.Cuerpo_reserva;
import clases.Enc_Reservacion;
import clases.Reservar;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Date;
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
public class RESERVA_CLIENTE extends javax.swing.JPanel {

    boolean disponibilidad = false;

    public static String casa = " ";
    public static double precio = 0.0;

    /**
     * Creates new form RESERVA_CLIENTE
     */
    public RESERVA_CLIENTE() {
        initComponents();
       

        btnreserva.setEnabled(false);

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxcasa = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnreserva = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        reservafin = new com.toedter.calendar.JDateChooser();
        reservai = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtcad_reserva = new javax.swing.JLabel();
        lblfechaf = new javax.swing.JLabel();
        lblcbx = new javax.swing.JLabel();
        lblfechai = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Fecha Inicio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Final:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Codigo Casa:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        cbxcasa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxcasaItemStateChanged(evt);
            }
        });
        cbxcasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxcasaMouseClicked(evt);
            }
        });
        jPanel1.add(cbxcasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 120, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, -1));

        btnreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        btnreserva.setText("RESERVAR");
        btnreserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 204)));
        btnreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreservaActionPerformed(evt);
            }
        });
        jPanel1.add(btnreserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 130, 40));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setText("REALIZE SU RESERVACION");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 260, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("NOMBRE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 60, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("APELLIDO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 260, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, 170));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 960, 10));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 10, 630));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RESERVAR.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 310, 280));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 470, 10));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 10, 240));

        reservafin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                reservafinPropertyChange(evt);
            }
        });
        jPanel1.add(reservafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 250, -1));

        reservai.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                reservaiPropertyChange(evt);
            }
        });
        jPanel1.add(reservai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 250, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 310, 10));

        jPanel7.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 10));

        jPanel8.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 10, 290));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/re.PNG"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 130, 330, 240));

        txtcad_reserva.setForeground(new java.awt.Color(255, 255, 255));
        txtcad_reserva.setText("jLabel11");
        jPanel1.add(txtcad_reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 130, 30));

        lblfechaf.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(lblfechaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 150, -1));

        lblcbx.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(lblcbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 150, -1));

        lblfechai.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(lblfechai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void cargar() {
        ObjectContainer based = Db4o.openFile(INICIO.direccion);

        try {
            cbxcasa.removeAllItems();
            Query query = based.query();
            query.constrain(CasaVacacional.class);

            ObjectSet<CasaVacacional> casas = query.execute();

            while (casas.hasNext()) {
                CasaVacacional casa1 = casas.next();
                cbxcasa.addItem(casa1.getCod_casa());
                disponibilidad = casa1.isDisponibilidad();
                precio = casa1.getPrecio();

            }

            System.out.println(disponibilidad);

        } finally {

            based.close();

        }
    }


    private void btnreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreservaActionPerformed
        // TODO add your handling code here:

        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        try {

            Query query = base.query();
            query.constrain(Reservar.class);
            query.descend("codigo_rese").orderDescending();
            ObjectSet<Reservar> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Reservar ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCodigo_rese().substring(4)) + 1;
            }

            String nuevoCodigo = String.format("RES-%03d", ultimoCodigo);
            txtcad_reserva.setText(nuevoCodigo);

            validar();
            //String codigo_rese, String coidigo_cli, String codigo_casa, Date fecha_ini, Date fecha_fin
            Reservar re = new Reservar(nuevoCodigo, INICIO.codigo, cbxcasa.getSelectedItem().toString(), reservai.getDate(), reservafin.getDate());

            JOptionPane.showMessageDialog(null, "Se envio la solicitud de reserva");

            base.store(re);
        } finally {
            base.close();

        }


    }//GEN-LAST:event_btnreservaActionPerformed

    private void mostrarDatosCasaSeleccionado(ObjectContainer bases) {
        String codigoSelec = cbxcasa.getSelectedItem().toString();
        Query query = bases.query();
        query.constrain(CasaVacacional.class);
        query.descend("cod_casa").constrain(codigoSelec);
        ObjectSet<CasaVacacional> result = query.execute();

        if (!result.isEmpty()) {
            CasaVacacional casa = result.next();
            String mensaje = "Nombre: " + casa.getNombre_casa() + "\n"
                    + "Disponibilidad: " + casa.isDisponibilidad() + "\n"
                    + "Tipo: " + casa.getTipo_casa() + "\n"
                    + "Pisos: " + casa.getNum_pisos() + "\n"
                    + "Capacidad: " + casa.getCapacidad_max() + "\n"
                    + "Habitaciones: " + casa.getNum_habitaciones() + "\n"
                    + "Baños: " + casa.getNum_baños() + "\n"
                    + "Precio: " + casa.getPrecio();
            JOptionPane.showMessageDialog(this, mensaje, "Datos de Casas Vacacionales", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró una casa con el codigo seleccionado.", "Ubicacion no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        bases.close();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ObjectContainer bases = Db4o.openFile(INICIO.direccion);

        mostrarDatosCasaSeleccionado(bases);

        bases.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxcasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxcasaMouseClicked
        // TODO add your handling code here:

        cargar();
    }//GEN-LAST:event_cbxcasaMouseClicked

    private void reservaiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_reservaiPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_reservaiPropertyChange

    private void reservafinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_reservafinPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_reservafinPropertyChange

    private void cbxcasaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxcasaItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbxcasaItemStateChanged

    public void validar() {

        if (reservai.getDate() == null) {

            lblfechai.setText("seleccione una fecha");

        } else {
            lblfechai.setText(" ");

        }

        if (reservafin.getDate() == null) {
            lblfechaf.setText("seleccione una fecha");
        } else {
            lblfechaf.setText(" ");
        }

        if (cbxcasa.getSelectedItem().toString().isEmpty()) {
            lblcbx.setText("Seleccione una casa");
        } else {
            lblcbx.setText(" ");

        }

        if (reservai.getDate() == null || reservafin.getDate() == null || cbxcasa.getSelectedItem().toString().isEmpty()) {
            btnreserva.setEnabled(false);
        } else {
            btnreserva.setEnabled(true);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreserva;
    private javax.swing.JComboBox<String> cbxcasa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblcbx;
    private javax.swing.JLabel lblfechaf;
    private javax.swing.JLabel lblfechai;
    private com.toedter.calendar.JDateChooser reservafin;
    private com.toedter.calendar.JDateChooser reservai;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JLabel txtcad_reserva;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
