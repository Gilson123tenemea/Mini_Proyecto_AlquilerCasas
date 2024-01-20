
import clases.Agente_inmobiliario;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo.User
 */
public class Modificar_agente extends javax.swing.JPanel {

    /**
     * Creates new form Ingreso_agente
     */
    /**
     * Creates new form menu_agente
     */
    String sexo;

    public Modificar_agente() {

        initComponents();
        inhabiltarDatos();
        Agrupar();

    }

    public void Agrupar() {
        ButtonGroup botones = new ButtonGroup();
        botones.add(rbnfemenino);
        botones.add(rbnmasculino);

    }

    public void validar() {

        if (txtcedula.getText().isEmpty()) {
            lblced.setText("Campo requerido");

        } else {
            lblced.setText(" ");
        }

        if (txtnombre.getText().isEmpty()) {
            lblnom.setText("Campo requerido");

        } else {
            lblnom.setText(" ");
        }

        if (txtapellido.getText().isEmpty()) {
            lblape.setText("Campo requerido");

        } else {
            lblape.setText(" ");
        }

        if (txttelefono.getText().isEmpty()) {
            lblcelular.setText("Campo requerido");

        } else {
            lblcelular.setText(" ");
        }

        if (jDateChooser1.getDate() == null) {
            lbldate.setText("Campo requerido");

        } else {
            lbldate.setText(" ");
        }

        if (!rbnfemenino.isSelected() || !rbnmasculino.isSelected()) {
            lblgenero.setText("Campo requerido");

        } else {
            lblgenero.setText(" ");
        }

        if (txtcorreo.getText().isEmpty()) {
            lblcorreo.setText("Campo Obligatoria");
        } else if (!txtcorreo.getText().contains("@") || !txtcorreo.getText().contains(".")) {
            lblcorreo.setText("Correo invalido");
        } else {
            lblcorreo.setText("");
        }

        if (txtcedula.getText().isEmpty() || txtnombre.getText().isEmpty() || txtapellido.getText().isEmpty() || txttelefono.getText().isEmpty() || jDateChooser1.getDate() == null || txtcorreo.getText().isEmpty()) {

            btnguardar.setEnabled(false);
        } else {
            btnguardar.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlingreso = new javax.swing.JPanel();
        lbltelefono = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        lblsexo = new javax.swing.JLabel();
        lblcod = new javax.swing.JLabel();
        rbnmasculino = new javax.swing.JRadioButton();
        lblcedula = new javax.swing.JLabel();
        rbnfemenino = new javax.swing.JRadioButton();
        lblemail = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        lbldate = new javax.swing.JLabel();
        lbled = new javax.swing.JLabel();
        lblgenero = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        lblape = new javax.swing.JLabel();
        lblcorreo = new javax.swing.JLabel();
        lblcelular = new javax.swing.JLabel();
        lblced = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        pnlingreso.setBackground(new java.awt.Color(255, 255, 255));
        pnlingreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 36))); // NOI18N
        pnlingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbltelefono.setText("TELEFONO :");
        pnlingreso.add(lbltelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 220, 20));

        lblapellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblapellido.setText("APELLIDO:");
        pnlingreso.add(lblapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 100, 20));

        lblfecha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblfecha.setText("FECHA DE NACIMIENTO :");
        pnlingreso.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 250, 20));

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        pnlingreso.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 230, -1));

        lblnombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblnombre.setText("NOMBRE :");
        pnlingreso.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 100, 20));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        pnlingreso.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, -1));

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });
        pnlingreso.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, -1));

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        pnlingreso.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 220, -1));

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        pnlingreso.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 220, -1));

        lblsexo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblsexo.setText("SEXO :");
        pnlingreso.add(lblsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 100, 20));

        lblcod.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pnlingreso.add(lblcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 180, -1));

        rbnmasculino.setText("Masculino");
        rbnmasculino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbnmasculinoItemStateChanged(evt);
            }
        });
        rbnmasculino.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbnmasculinoStateChanged(evt);
            }
        });
        rbnmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnmasculinoActionPerformed(evt);
            }
        });
        rbnmasculino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rbnmasculinoKeyReleased(evt);
            }
        });
        pnlingreso.add(rbnmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        lblcedula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblcedula.setText("CEDULA :");
        pnlingreso.add(lblcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 100, 20));

        rbnfemenino.setText("Femenino");
        rbnfemenino.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbnfemeninoStateChanged(evt);
            }
        });
        rbnfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnfemeninoActionPerformed(evt);
            }
        });
        rbnfemenino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rbnfemeninoKeyReleased(evt);
            }
        });
        pnlingreso.add(rbnfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));

        lblemail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblemail.setText("CORREO ELECTRONICO:");
        pnlingreso.add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 270, 20));

        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcorreoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });
        pnlingreso.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 220, -1));

        lbldate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbldate.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        lbled.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbled.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lbled, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        lblgenero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblgenero.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        lblnom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblnom.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        lblape.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblape.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblape, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        lblcorreo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcorreo.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        lblcelular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcelular.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        lblced.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblced.setForeground(new java.awt.Color(204, 0, 0));
        pnlingreso.add(lblced, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        pnlingreso.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 180, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlingreso.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbnfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnfemeninoActionPerformed
        validar();
    }//GEN-LAST:event_rbnfemeninoActionPerformed

    public void ActualizarDatos(ObjectContainer base) {

        if (rbnmasculino.isSelected()) {

            sexo = "Masculino";

        } else if (rbnfemenino.isSelected()) {
            sexo = "Femenino";
        }

        // Validar edad (mayor a 18 años)
        if (!esMayorDeEdad(jDateChooser1.getDate())) {
            JOptionPane.showMessageDialog(this, "El personal debe ser mayor de 18 años.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Agente_inmobiliario miagente = new Agente_inmobiliario(null, null, null, txtcedula.getText().trim(), null, null, null, null, null, null);

        ObjectSet res = base.get(miagente);
        Agente_inmobiliario miagent = (Agente_inmobiliario) res.next();
        miagent.setNombre(txtnombre.getText().trim());
        miagent.setApellido(txtapellido.getText().trim());
        miagent.setEmail(txtcorreo.getText().trim());
        miagent.setGenero(sexo.trim());
        miagent.setTelefono(txttelefono.getText().trim());

        miagent.setFecha_nac(jDateChooser1.getDate());
        miagent.setCodigo_agente(lblcod.getText().trim());

        base.set(miagent);

        JOptionPane.showMessageDialog(this, "Modificacion exitosa");

        txtcedula.setText(" ");
        lblcod.setText(" ");
        txtnombre.setText(" ");
        txttelefono.setText(" ");
        txtapellido.setText("");
        jDateChooser1.setDate(null);

        rbnfemenino.setSelected(false);
        rbnmasculino.setSelected(false);

        txtcorreo.setText(" ");

        inhabiltarDatos();

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
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        ActualizarDatos(base);
        base.close();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped

        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }

        if (txtcedula.getText().trim().length() > 9) {
            evt.consume();
        }

    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        validar();
    }//GEN-LAST:event_txtcedulaKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char letra = evt.getKeyChar();
        if (Character.isDigit(letra)) {
            evt.consume();
        }

        if (txtnombre.getText().trim().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        validar();
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped

        char letra = evt.getKeyChar();
        if (Character.isDigit(letra)) {
            evt.consume();
        }

        if (txtapellido.getText().trim().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased

        validar();
    }//GEN-LAST:event_txtapellidoKeyReleased

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:

        char letra = evt.getKeyChar();
        if (!Character.isDigit(letra)) {
            evt.consume();
        }

        if (txttelefono.getText().trim().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtcorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoKeyReleased

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
        if (txtcorreo.getText().trim().length() > 24) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcorreoKeyTyped

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        validar();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void rbnmasculinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbnmasculinoKeyReleased
    }//GEN-LAST:event_rbnmasculinoKeyReleased

    private void rbnfemeninoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbnfemeninoKeyReleased


    }//GEN-LAST:event_rbnfemeninoKeyReleased

    private void rbnmasculinoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbnmasculinoStateChanged
        validar();
    }//GEN-LAST:event_rbnmasculinoStateChanged

    private void rbnfemeninoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbnfemeninoStateChanged
        validar();
    }//GEN-LAST:event_rbnfemeninoStateChanged

    private void rbnmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnmasculinoActionPerformed
        validar();
    }//GEN-LAST:event_rbnmasculinoActionPerformed

    private void rbnmasculinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbnmasculinoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnmasculinoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        String nombre = " ", apellido = " ", telefono = " ", correo = " ", genero = " ", cod = " ";
        Date fecha = null;
        int ed = 0;
        Query query = base.query();
        query.constrain(Agente_inmobiliario.class);
        query.descend("cedula").constrain(txtcedula.getText().trim());
        ObjectSet<Agente_inmobiliario> result = query.execute();

        if (!result.isEmpty()) {
            habiltarDatos();
            for (Agente_inmobiliario agente : result) {
                nombre = agente.getNombre();
                telefono = agente.getTelefono();
                apellido = agente.getApellido();
                correo = agente.getEmail();
                genero = agente.getGenero();
                fecha = agente.getFecha_nac();

                cod = agente.getCodigo_agente();

            }
            txtnombre.setText(nombre.trim());
            txttelefono.setText(telefono.trim());
            txtapellido.setText(apellido.trim());
            txtcorreo.setText(correo.trim());
            jDateChooser1.setDate(fecha);

            lblcod.setText(cod.trim());

            if (genero.equalsIgnoreCase("Masculino")) {
                rbnmasculino.setSelected(true);
            } else if (genero.equalsIgnoreCase("Femenino")) {
                rbnfemenino.setSelected(true);
            }

        } else {

            JOptionPane.showMessageDialog(null, "No se encontró ningún agente inmobiliario con la cedula ingresada");

        }

        base.close();

    }//GEN-LAST:event_jButton1ActionPerformed

    public void inhabiltarDatos() {

        txtapellido.setEnabled(false);
        txttelefono.setEnabled(false);
        txtnombre.setEnabled(false);
        txtcorreo.setEnabled(false);
        jDateChooser1.setEnabled(false);
        rbnfemenino.setEnabled(false);
        rbnmasculino.setEnabled(false);

    }

    public void habiltarDatos() {

        txtapellido.setEnabled(true);
        txttelefono.setEnabled(true);
        txtnombre.setEnabled(true);
        txtcorreo.setEnabled(true);
        jDateChooser1.setEnabled(true);
        rbnfemenino.setEnabled(true);
        rbnmasculino.setEnabled(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel lblape;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lblced;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblcelular;
    private javax.swing.JLabel lblcod;
    private javax.swing.JLabel lblcorreo;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbled;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblgenero;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JPanel pnlingreso;
    private javax.swing.JRadioButton rbnfemenino;
    private javax.swing.JRadioButton rbnmasculino;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
