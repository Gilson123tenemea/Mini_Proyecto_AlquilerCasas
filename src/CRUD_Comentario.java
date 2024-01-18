
import clases.CasaVacacional;
import clases.Cliente;
import clases.Comentario;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUD_Comentario extends javax.swing.JPanel {

    private ObjectContainer base;

    public CRUD_Comentario() {
        this.base = base;
        initComponents();
        cod_Cliente.setText(INICIO.usuario);
        txtnombre.setText(INICIO.nombre);
        txtapellido.setText(INICIO.apellido);
    }

   public void cargarCasas() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cod_casa.removeAllItems();
        Query query = Base.query();
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
         Base.close();   
     }

//    public void cargarCleinte() {
//        cod_Cliente.removeAllItems();
//        Query query = base.query();
//        query.constrain(Cliente.class);
//
//        ObjectSet<Cliente> cliente = query.execute();
//
//        if (cliente.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "No hay cleintes disponibles", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            while (cliente.hasNext()) {
//                Cliente cli = cliente.next();
//                cod_Cliente.addItem(cli.getCedula());
//            }
//
//        }
//
//    }

    private void mostrarDatosCasaSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cod_casa.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(CasaVacacional.class);
                query.descend("cod_casa").constrain(codigoSelec);
                ObjectSet<CasaVacacional> result = query.execute();

                if (!result.isEmpty()) {
                    CasaVacacional casa = result.next();
                    String mensaje = "Nombre: " + casa.getNombre_casa() + "\n"
                            + "Tipo: " + casa.getTipo_casa() + "\n"
                            + "Pisos: " + casa.getNum_pisos() + "\n"
                            + "Capacidad: " + casa.getCapacidad_max() + "\n"
                            + "Habitaciones: " + casa.getNum_habitaciones() + "\n"
                            + "Baños: " + casa.getNum_baños();
                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Casas Vacacionales", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una casa con el código seleccionado.", "Casa no encontrada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de Casa Vacacional.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }

    private void mostrarDatosClienteSeleccionada(ObjectContainer base) {
        String clienteSeleccionada = cod_casa.getSelectedItem().toString();
        Query query = base.query();
        query.constrain(Cliente.class);
        query.descend("codigo_cli").constrain(clienteSeleccionada);
        ObjectSet<Cliente> result = query.execute();

        if (!result.isEmpty()) {
            Cliente cliente = result.next();
            String mensaje = "Cedula: " + cliente.getCedula() + "\n"
                    + "Nombre: " + cliente.getNombre() + "\n"
                    + "Apellido: " + cliente.getApellido() + "\n"
                    + "Email: " + cliente.getTelefono() + "\n"
                    + "Telefono: " + cliente.getTelefono() + "\n"
                    + "Gerono: " + cliente.getGenero() + "\n"
                    + "Codigo_cliente: " + cliente.getCodigo_cli();

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        VER_CASA = new javax.swing.JButton();
        cod_casa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblcod = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        cod_Cliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código Comentario:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel5.setText("Código Casa:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel6.setText("Comentario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        jButton1.setText("COMENTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, -1, -1));

        VER_CASA.setBackground(new java.awt.Color(255, 255, 255));
        VER_CASA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        VER_CASA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_CASAActionPerformed(evt);
            }
        });
        jPanel2.add(VER_CASA, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 40, -1));

        cod_casa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cod_casaMouseClicked(evt);
            }
        });
        jPanel2.add(cod_casa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 150, -1));

        jLabel1.setFont(new java.awt.Font("Alef", 1, 14)); // NOI18N
        jLabel1.setText("REALIZE UN COMENTARIO EN BASE A SU EXPERIENCIA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 380, 10));

        lblcod.setBackground(new java.awt.Color(255, 255, 255));
        lblcod.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 150, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 400, 130));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("NOMBRE");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("APELLIDO");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel3.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, -1));
        jPanel3.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));
        jPanel3.add(cod_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        jLabel15.setText("CEDULA");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 260, 220));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/re.PNG"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 70, 330, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VER_CASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_CASAActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosCasaSeleccionado(base);
        base.close();
    }//GEN-LAST:event_VER_CASAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        crearComentario(base);
        base.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cod_casaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cod_casaMouseClicked
        cargarCasas();
    }//GEN-LAST:event_cod_casaMouseClicked

    public void crearComentario(ObjectContainer base) {
        // Verificar si todos los campos están llenos
        if (txtDescripcion.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos antes de ingresar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Query query = base.query();
            query.constrain(Comentario.class);
            query.descend("cod_comentario").orderDescending();
            ObjectSet<Comentario> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Comentario ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCod_comentario().substring(4)) + 1;
            }

            // Formatear el código con ceros a la izquierda
            String nuevoCodigo = String.format("COM-%03d", ultimoCodigo);
            lblcod.setText(nuevoCodigo);

            // Verificar si ya existe una casa con el mismo código
            result = base.queryByExample(new Comentario(nuevoCodigo, null, null, null));

            if (!result.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe un comentario con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear objeto CasaVacacional y almacenar en la base de datos
            Comentario casa1 = new Comentario(nuevoCodigo, cod_Cliente.getText().trim(), cod_casa.getSelectedItem().toString(), txtDescripcion.getText().trim());
            base.store(casa1);

            JOptionPane.showMessageDialog(this, "Comentario creado exitosamente");
            limpiar();
        } finally {
            base.close();
        }
    }

    public void limpiar() {
        cod_casa.setSelectedItem("");
        txtDescripcion.setText("");

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VER_CASA;
    private javax.swing.JTextField cod_Cliente;
    private javax.swing.JComboBox<String> cod_casa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblcod;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
