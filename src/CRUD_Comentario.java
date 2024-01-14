
import clases.CasaVacacional;
import clases.Cliente;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;


public class CRUD_Comentario extends javax.swing.JPanel {
private ObjectContainer BaseD;
    public CRUD_Comentario() {
        this.BaseD = BaseD;
        initComponents();
        //cargarCasas();
        //cargarCleinte();
    }
    
    public void cargarCasas() {
        cod_casa.removeAllItems();
        Query query = BaseD.query();
        query.constrain(CasaVacacional.class);

        ObjectSet<CasaVacacional> casas = query.execute();

        if (casas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay casas vacacionales disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (casas.hasNext()) {
                CasaVacacional casa = casas.next();
                cod_casa.addItem(casa.getCod_casa());
            }
        }

    }

    public void cargarCleinte() {
        cod_Cliente.removeAllItems();
        Query query = BaseD.query();
        query.constrain(Cliente.class);

        ObjectSet<Cliente> cliente = query.execute();

        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay cleintes disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (cliente.hasNext()) {
                Cliente cli = cliente.next();
                cod_Cliente.addItem(cli.getCedula());
            }

        }

    }

    private void mostrarDatosCasaSeleccionada() {
        String casaSeleccionada = cod_casa.getSelectedItem().toString();
        Query query = BaseD.query();
        query.constrain(CasaVacacional.class);
        query.descend("cod_casa").constrain(casaSeleccionada);
        ObjectSet<CasaVacacional> result = query.execute();
        
        if (!result.isEmpty()) {
            CasaVacacional casa = result.next();
            String mensaje = "Codigo:: " + casa.getCod_casa()+ "\n"
                    + "Descripcion: " + casa.getNombre_casa() + "\n"
                    + "Tipo de casa: " + casa.getTipo_casa() + "\n"
                    + "Numero de pisos: " + casa.getNum_pisos() + "\n"
                    + "Capacidad maxima: " + casa.getCapacidad_max() + "\n"
                    + "Numero de habitaciones: " + casa.getNum_habitaciones() + "\n"
                    + "Numero de baño: " + casa.getNum_baños()
                    + "Cedula Propietario: "+ casa.getCodigo_propie()
                    + "Precio: "+ casa.getPrecio();

                    JOptionPane.showMessageDialog(this, mensaje, "Datos de La Casa", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la casa con el ID seleccionado.", "Casa no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void mostrarDatosClienteSeleccionada() {
        String clienteSeleccionada = cod_casa.getSelectedItem().toString();
        Query query = BaseD.query();
        query.constrain(Cliente.class);
        query.descend("codigo_cli").constrain(clienteSeleccionada);
        ObjectSet<Cliente> result = query.execute();
        
        if (!result.isEmpty()){
            Cliente cliente = result.next();
            String mensaje = "Cedula: "+ cliente.getCedula()+ "\n"
                    + "Nombre: "+ cliente.getNombre()+ "\n"
                    + "Apellido: "+ cliente.getApellido()+ "\n"
                    + "Email: "+ cliente.getTelefono()+ "\n"
                    + "Telefono: "+ cliente.getTelefono() + "\n"
                    + "Gerono: "+ cliente.getGenero()+ "\n"
                    + "Codigo_cliente: "+ cliente.getCodigo_cli();
            
            
                    JOptionPane.showMessageDialog(this, mensaje, "Datos del Cliente", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el cliente con el ID seleccionado.", "Casa no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        VER_CLIENTE = new javax.swing.JButton();
        VER_CASA = new javax.swing.JButton();
        cod_Cliente = new javax.swing.JComboBox<>();
        cod_casa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Código Comentario:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("CódigoCliente:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Código Casa:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Descripción:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 300, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 544, 140));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("COMENTAR");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        VER_CLIENTE.setBackground(new java.awt.Color(255, 255, 255));
        VER_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        VER_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_CLIENTEActionPerformed(evt);
            }
        });
        jPanel2.add(VER_CLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 40, -1));

        VER_CASA.setBackground(new java.awt.Color(255, 255, 255));
        VER_CASA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        VER_CASA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_CASAActionPerformed(evt);
            }
        });
        jPanel2.add(VER_CASA, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 40, -1));

        cod_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cod_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, -1));

        cod_casa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cod_casa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 150, -1));

        jLabel1.setFont(new java.awt.Font("Alef", 1, 14)); // NOI18N
        jLabel1.setText("REALIZE UN COMENTARIO EN BASE A SU EXPERIENCIA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 380, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VER_CASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_CASAActionPerformed
        mostrarDatosCasaSeleccionada();
    }//GEN-LAST:event_VER_CASAActionPerformed

    private void VER_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_CLIENTEActionPerformed
        mostrarDatosClienteSeleccionada();
    }//GEN-LAST:event_VER_CLIENTEActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VER_CASA;
    private javax.swing.JButton VER_CLIENTE;
    private javax.swing.JComboBox<String> cod_Cliente;
    private javax.swing.JComboBox<String> cod_casa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
