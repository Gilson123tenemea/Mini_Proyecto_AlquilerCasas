
import clases.Propietario;
import clases.Servicio;
import clases.Servicio_Adicional;
import clases.Ubicacion;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class Intefaz_SAdional extends javax.swing.JPanel {

    /**
     * Creates new form Intefaz_SAdional
     */
    public Intefaz_SAdional() {
        initComponents();

        txtcedula.setText(INICIO.usuario);
        txtnombre.setText(INICIO.nombre);
        txtapellido.setText(INICIO.apellido);
    }

    public void cargarServicios() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cboxservicio.removeAllItems();
        Query query = Base.query();
        query.constrain(Servicio.class);

        ObjectSet<Servicio> adicio = query.execute();

        if (adicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen Servicios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (adicio.hasNext()) {
                Servicio pro = adicio.next();
                cboxservicio.addItem(pro.getCodigo_servicio());
            }
        }
        Base.close();
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
        jLabel1 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboxservicio = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cédula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txtcedula.setEditable(false);
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 176, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txtnombre.setEditable(false);
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 176, -1));

        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txtapellido.setEditable(false);
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 176, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Código Servicio Adicional:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        lblcodigo.setBackground(new java.awt.Color(255, 255, 255));
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 67, 28));

        jLabel4.setText("Servicios Adicionales");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        cboxservicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboxservicioMouseClicked(evt);
            }
        });
        jPanel1.add(cboxservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 153, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 55, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("SERVICIO ADICIONAL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(51, 102, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 61, 192, 10));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/servicio-al-cliente.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboxservicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxservicioMouseClicked

        cargarServicios();
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxservicioMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarServicios(base);
        base.close();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public void crearServicioA(ObjectContainer base) {

        try {
            Query query = base.query();
            query.constrain(Servicio_Adicional.class);
            query.descend("codigo_servicio_adi").orderDescending();
            ObjectSet<Servicio_Adicional> result = query.execute();

            int ultimoCodigo = 1; // Por defecto, si no hay registros previos
            if (!result.isEmpty()) {
                Servicio_Adicional ultimaUbicacion = result.next();
                ultimoCodigo = Integer.parseInt(ultimaUbicacion.getCodigo_servicio_adi().substring(4)) + 1;
            }

            String nuevoCodigo = String.format("SRA-%03d", ultimoCodigo);
            lblcodigo.setText(nuevoCodigo);

            result = base.queryByExample(new Servicio_Adicional(nuevoCodigo, null, null));

            if (!result.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un Servicio Adicional con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Servicio_Adicional nuevaUbicacion = new Servicio_Adicional(nuevoCodigo, cboxservicio.getSelectedItem().toString(), txtcedula.getText().trim());
            base.store(nuevaUbicacion);

            JOptionPane.showMessageDialog(this, "Ubicación creada exitosamente");

        } finally {
            base.close();
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        crearServicioA(base);
        base.close();        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private void mostrarServicios(ObjectContainer bases) {
        try {
            Object selectedItem = cboxservicio.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Servicio.class);
                query.descend("codigo_servicio").constrain(codigoSelec);
                ObjectSet<Servicio> result = query.execute();

                if (!result.isEmpty()) {
                    Servicio ubica = result.next();
                    String mensaje = "Nombre: " + ubica.getNombre_ser() + "\n"
                            + "Descripcion: " + ubica.getDescripcionSer() + "\n"
                            + "Costo: " + ubica.getCostoAdicional();

                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Servicios", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un Servicio con el código seleccionado.", "Servicio no encontrado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de Servicios.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxservicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}
