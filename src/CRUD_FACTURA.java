
import base.ReporteCliente;
import clases.Agente_inmobiliario;
import clases.CasaVacacional;
import clases.Cliente;
import clases.Encabezado_Factura;
import clases.Promocion;
import clases.Reservar;
import clases.Servicio;
import clases.Servicio_Adicional;
import clases.Tipo_Actividad;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CRUD_FACTURA extends javax.swing.JPanel {

    public CRUD_FACTURA() {
        initComponents();
        txtagente.setText(Administrador_Login.usuario);
        spnPromo.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        spndias.setModel(new SpinnerNumberModel(1, 1, 30, 1));
    }

     public void creaFactura(ObjectContainer base) {
        if (cbCliente.getSelectedItem() == null || txtagente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos antes de realizar la factura", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Obtener el último código de reserva
            Query query = base.query();
            query.constrain(Encabezado_Factura.class);
            query.descend("codigo_fac").orderDescending();
            ObjectSet<Encabezado_Factura> result = query.execute();

            int ultimoCodigo = 1;
            if (!result.isEmpty()) {
                Encabezado_Factura ultimoPersonal = result.next();
                ultimoCodigo = Integer.parseInt(ultimoPersonal.getCodigo_fac().substring(4)) + 1;
            }

            String nuevoCodigo = String.format("FAC-%03d", ultimoCodigo);
            lblcodFac.setText(nuevoCodigo);

            // Verificar si ya existe una reserva con el código generado
            ObjectSet<Encabezado_Factura> resul = base.queryByExample(new Encabezado_Factura(nuevoCodigo, null, null, null, null,0,null,null,null,null));
            if (!resul.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ya existe una reserva con el código generado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
 
            Date mifecha = new Date(); 
            String preciototal = txtTotal.getText();
            double total = Double.valueOf(preciototal);
            //String codigo_fac, String cod_cliente, String cod_agente, String cod_casa, Date fecha, double valor_cancelar, String cod_reserva, String cod_servicio, String cod_promocion, String doc_ser_adici
            Encabezado_Factura res = new Encabezado_Factura(nuevoCodigo, cbCliente.getSelectedItem().toString(),txtagente.getText().trim() ,cbCasa.getSelectedItem().toString(), mifecha, total,cbReserva.getSelectedItem().toString(),jComboBox1.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString(), jComboBox3.getSelectedItem().toString());
            base.store(res);
            JOptionPane.showMessageDialog(this, "Reserva realizada exitosamente");
              cargarTabla(base);
             limpiar();
        } catch (Exception e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada
        }

    }
     
    public void limpiar() {
        cbCliente.setSelectedItem("");  
        cbCasa.setSelectedItem("");
        txtTotal.setText("");
        txtagente.setText("");
        lblcodFac.setText("");
        cbReserva.setSelectedItem("");
        jComboBox1.setSelectedItem("");
        jComboBox2.setSelectedItem("");
        jComboBox3.setSelectedItem("");
        
    }
    
    public void cargarTabla(ObjectContainer base) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); 
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ObjectSet<Encabezado_Factura> result = base.queryByExample(new Encabezado_Factura());
       
        while (result.hasNext()) {
            Encabezado_Factura acti = result.next();
             Object[] row = {
                 acti.getCodigo_fac(),
                 acti.getCod_agente(),
                 acti.getCod_casa(),
                 acti.getCod_cliente(),
                 acti.getFecha()!= null ? sdf.format(acti.getFecha()) : null,
                 acti.getCod_reserva(),
                 acti.getValor_cancelar()
             };
             model.addRow(row);
        }
    }
    
     public void cargarCasas() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cbCasa.removeAllItems();
        Query query = Base.query();
        query.constrain(CasaVacacional.class);
        
        ObjectSet<CasaVacacional> casas = query.execute();
        
         if (casas.isEmpty()) {             
             JOptionPane.showMessageDialog(this, "No hay casas vacacionales disponibles", "Error", JOptionPane.ERROR_MESSAGE);    
         } else {
             while (casas.hasNext()) {
                CasaVacacional casa = casas.next();
                cbCasa.addItem(casa.getCod_casa());
             }
             
         }
         Base.close();   
     }
      private void mostrarDatosCasaSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cbCasa.getSelectedItem();

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
                            + "Baños: " + casa.getNum_baños() + "\n"
                            + "Servicio: " + casa.getCod_servicio() + "\n"
                            + "Promocion: " + casa.getCod_promocion() + "\n"
                            + "Precio: " + casa.getPrecio() + "\n";
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
    
       public void cargarClientes() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        cbCliente.removeAllItems();
        Query query = Base.query();
        query.constrain(Cliente.class);
        
        ObjectSet<Cliente> casas = query.execute();
        
         if (casas.isEmpty()) {             
             JOptionPane.showMessageDialog(this, "No hay Clientes reguistrados", "Error", JOptionPane.ERROR_MESSAGE);    
         } else {
             while (casas.hasNext()) {
                Cliente casa = casas.next();
                cbCliente.addItem(casa.getCodigo_cli());
             }
             
         }
         Base.close();   
     }
       
     public void cargareserva() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        
        cbReserva.removeAllItems();
        Query query = Base.query();
        query.constrain(Reservar.class);
        
        ObjectSet<Reservar> casas = query.execute();
        
         if (casas.isEmpty()) {             
             JOptionPane.showMessageDialog(this, "No hay Reservaciones reguistrados", "Error", JOptionPane.ERROR_MESSAGE);    
         } else {
             while (casas.hasNext()) {
                Reservar casa = casas.next();
                cbReserva.addItem(casa.getCodigo_rese());
             }
             
         }
         Base.close();   
     }
     
    private void mostrarDatosReservaSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cbReserva.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Reservar.class);
                query.descend("codigo_rese").constrain(codigoSelec);
                ObjectSet<Reservar> result = query.execute();

                if (!result.isEmpty()) {
                    Reservar reserva = result.next();
                    String mensaje = "Cliente: " + reserva.getCoidigo_cli() + "\n"
                            + "Casa: " + reserva.getCodigo_casa() + "\n"
                            + "Fecha Inicio: " + (reserva.getFecha_ini() != null ? sdf.format(reserva.getFecha_ini()) : "No disponible") + "\n"
                            + "Fecha Final: " + (reserva.getFecha_fin() != null ? sdf.format(reserva.getFecha_fin()) : "No disponible");
                    JOptionPane.showMessageDialog(this, mensaje, "Datos de la Reservacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una Reservacion con el código seleccionado.", "Reservacion no encontrada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de las Reservas.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }
     
     
       
       
      private void mostrarDatosClienteSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = cbCliente.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Cliente.class);
                query.descend("codigo_cli").constrain(codigoSelec);
                ObjectSet<Cliente> result = query.execute();

                if (!result.isEmpty()) {
                    Cliente casa = result.next();
                    String mensaje = "Nombre: " + casa.getNombre()+ "\n"
                            + "Tipo: " + casa.getApellido()+ "\n"
                            + "Pisos: " + casa.getTelefono()+ "\n"
                            + "Capacidad: " + casa.getEmail()+ "\n"
                            + "Habitaciones: " + casa.getTelefono()+ "\n"
                            + "Baños: " + casa.getCodigo_cli();
                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Cliente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una cliente con el código seleccionado.", "Cliente no encontrada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de los clientes.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }
    }
    
      public void cargarPromocion() {
        ObjectContainer Base = Db4o.openFile(INICIO.direccion);
        jComboBox2.removeAllItems();
        Query query = Base.query();
        query.constrain(Promocion.class);

        ObjectSet<Promocion> pro = query.execute();

        if (pro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen Promociones ingresadas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            while (pro.hasNext()) {
                Promocion ub = pro.next();
                jComboBox2.addItem(ub.getCod_promo());
            }
        }
        Base.close();

    }
        public void cargaServicio() {
    ObjectContainer Base = Db4o.openFile(INICIO.direccion);
    jComboBox1.removeAllItems();
    Query query = Base.query();
    query.constrain(Servicio.class);

    ObjectSet<Servicio> servi = query.execute();

    if (servi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No existen Servicios ingresados", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        while (servi.hasNext()) {
            Servicio ub = servi.next();
            jComboBox1.addItem(ub.getCodigo_servicio());  // Corregido aquí
        }
    }
    Base.close();
    }

    private void mostrarDatosPromocionSeleccionado(ObjectContainer bases) {
        try {
            int selectedIndex = jComboBox2.getSelectedIndex();

            if (selectedIndex != -1) {
                String codigoSelec = jComboBox2.getItemAt(selectedIndex).toString();

                Query query = bases.query();
                query.constrain(Promocion.class);
                query.descend("cod_promo").constrain(codigoSelec);
                ObjectSet<Promocion> result = query.execute();

                if (!result.isEmpty()) {
                    Promocion promo = result.next();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String mensaje = "Descuento: " + promo.getDescuento() + "%" + "\n"
                            + "Descripcion: " + promo.getDescripcion() + "\n"
                            + "Fecha Inicio: " + (promo.getFecha_inicio() != null ? sdf.format(promo.getFecha_inicio()) : "No disponible") + "\n"
                            + "Fecha Fin: " + (promo.getFecha_fin() != null ? sdf.format(promo.getFecha_fin()) : "No disponible");

                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Promoción", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró una Promoción con el código seleccionado.", "Promoción no encontrada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de Promoción.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }

    }

    private void mostrarDatosServicioSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = jComboBox1.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Servicio.class);
                query.descend("codigo_servicio").constrain(codigoSelec);
                ObjectSet<Servicio> result = query.execute();

                if (!result.isEmpty()) {
                    Servicio servi = result.next();
                    String mensaje = "Nombre: " + servi.getNombre_ser() + "\n"
                            + "Descripcion: " + servi.getDescripcionSer() + "\n"
                            + "Costo: " + servi.getCostoAdicional();

                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Servicio", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un Servicio con el código seleccionado.", "Servicio no encontrado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de Servicio.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }

    }
    public void cargaServicioadicionales() {
    ObjectContainer Base = Db4o.openFile(INICIO.direccion);
    jComboBox3.removeAllItems();
    Query query = Base.query();
    query.constrain(Servicio_Adicional.class);

    ObjectSet<Servicio_Adicional> servi = query.execute();

    if (servi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No existen Servicios Adicionales", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        while (servi.hasNext()) {
            Servicio_Adicional ub = servi.next();
            jComboBox3.addItem(ub.getCodigo_servicio_adi());  // Corregido aquí
        }
    }
    Base.close();
    }
    
    private void mostrarDatosServicioAdicionalesSeleccionado(ObjectContainer bases) {
        try {
            Object selectedItem = jComboBox3.getSelectedItem();

            if (selectedItem != null) {
                String codigoSelec = selectedItem.toString();

                Query query = bases.query();
                query.constrain(Servicio_Adicional.class);
                query.descend("codigo_servicio_adi").constrain(codigoSelec);
                ObjectSet<Servicio_Adicional> result = query.execute();

                if (!result.isEmpty()) {
                    Servicio_Adicional servi = result.next();
                    String mensaje = "Servicio: " + servi.getCodigo_servi()+ "\n"
                            + "Cliente: " + servi.getCodigo_cli()+ "\n"
                            + "Verifique el costo y tipo de servicio adicional en servicio ";

                    JOptionPane.showMessageDialog(this, mensaje, "Datos de Servicio Adicionales", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un Servicio Adicionales con el código seleccionado.", "Servicio no encontrado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún código.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar datos de Servicio.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            bases.close();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblcodFac = new javax.swing.JLabel();
        txtagente = new javax.swing.JTextField();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbCasa = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbReserva = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtcasa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spnPromo = new javax.swing.JSpinner();
        txtServicio = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spndias = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtadicional = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jLabel10.setText("jLabel10");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Codigo Cliente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setText("Cedula del Agente:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 20));

        jLabel6.setText("Costo total:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));
        jPanel1.add(lblcodFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 30));
        jPanel1.add(txtagente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 180, -1));

        cbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbClienteMouseClicked(evt);
            }
        });
        jPanel1.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 180, -1));

        jLabel8.setText("Casa Vacacional:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        cbCasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCasaMouseClicked(evt);
            }
        });
        jPanel1.add(cbCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 180, -1));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 80, -1));

        jButton1.setText("GENERAR FACTURA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Fac", "Cedula Agente", "Casa Vacacional", "Cod_Cliente", "Fecha", "Cod_Reserva", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 860, 100));

        jButton2.setText("REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 120, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 40, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel7.setText("Reservacion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        cbReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbReservaMouseClicked(evt);
            }
        });
        jPanel1.add(cbReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 180, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel2.setText("Servicios:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel5.setText("Promocion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 180, -1));

        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 180, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));
        jPanel1.add(txtcasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 70, -1));

        jLabel9.setText("Costo Casa:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jLabel11.setText("Costo Servicio:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jLabel12.setText("Promocion");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));
        jPanel1.add(spnPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 70, -1));
        jPanel1.add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 70, -1));

        jButton8.setText("CALCULAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, -1, -1));

        jLabel13.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel13.setText("$");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 20, 30));

        jLabel14.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel14.setText("$");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 20, -1));

        jLabel15.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jLabel15.setText("%");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 20, -1));

        jLabel16.setText("Numero de Dias");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));
        jPanel1.add(spndias, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 60, -1));

        jLabel17.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel17.setText("$");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 20, -1));

        jLabel18.setText("Servicio Adicional:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 180, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VER.jpg"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        jLabel19.setText("Costo Adicional:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));
        jPanel1.add(txtadicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 70, -1));

        jLabel20.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel20.setText("$");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 20, -1));

        jLabel21.setText("\"En caso de que tenga\"");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        creaFactura(base);
        
        base.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void mostrarReporte(Agente_inmobiliario agente, ObjectContainer base) {
        boolean flag = true;
        ArrayList<Encabezado_Factura> listaTipoActividad = new ArrayList<>();
        ObjectSet<Encabezado_Factura> result = base.queryByExample(Encabezado_Factura.class);
        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO podemos mostrar datos estadisticas y reportes debido a que no existen registros");
            flag = false;
        } else {

        }

        if (flag) {
            while (result.hasNext()) {
                Encabezado_Factura factura = result.next();
                listaTipoActividad.add(factura);
            }

            try {
                JRBeanArrayDataSource emptyDataSource = new JRBeanArrayDataSource(listaTipoActividad.toArray());
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/base/Facturas.jasper"));
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listaTipoActividad.toArray());
                InputStream inputStreamImagen = new FileInputStream(new File("src/imagenes/logokame.PNG"));

                Map<String, Object> params = new HashMap<String, Object>();

                params.put("ds", emptyDataSource);
                params.put("rutaImagen", inputStreamImagen);
                params.put("codigoAgente", agente.getCodigo_agente());
                params.put("nombreAgente", agente.getNombre());
                params.put("apellidoAgente", agente.getApellido());
                params.put("emailAgente", agente.getEmail());

                JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);
                // JasperExportManager.exportReportToPdfStream(jp, out);
                JasperViewer pv = new JasperViewer(jp, false);
                pv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                pv.setVisible(true);

            } catch (JRException ex) {
                System.out.println("NO SE ENCONTRO LA PLANTILLA RUTA NO ENCONTRADA");
                Logger.getLogger(ReporteCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                System.out.println("NO SE ENCONTRO LA PLANTILLA RUTA NO ENCONTRADA DE LA IMAGEN");
                Logger.getLogger(ReporteCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
        }
    }

    private void cbCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCasaMouseClicked
       cargarCasas();
    }//GEN-LAST:event_cbCasaMouseClicked

    private void cbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbClienteMouseClicked
      cargarClientes();
    }//GEN-LAST:event_cbClienteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosCasaSeleccionado(base);
        base.close();
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosClienteSeleccionado(base);
        base.close();  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        cargarTabla(base);
        mostrarReporte(Administrador_Login.agente,base);

        base.close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbReservaMouseClicked
        cargareserva();
    }//GEN-LAST:event_cbReservaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      ObjectContainer base = Db4o.openFile(INICIO.direccion);
        mostrarDatosReservaSeleccionado(base);
        base.close();    
   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
       cargaServicio();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        cargarPromocion();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       ObjectContainer bases = Db4o.openFile(INICIO.direccion);
        mostrarDatosServicioSeleccionado(bases);
        bases.close(); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ObjectContainer bases = Db4o.openFile(INICIO.direccion);
        mostrarDatosPromocionSeleccionado(bases);
        bases.close();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            String precioCasaStr = txtcasa.getText();
            String cosserviStr = txtServicio.getText();
            String seradicionalStr = txtadicional.getText();
            Object promoObject = spnPromo.getValue();
            Object diazObject = spndias.getValue();

            double precioCasa = Double.parseDouble(precioCasaStr);
            double cosservi = Double.parseDouble(cosserviStr);
            double seradicional = seradicionalStr.isEmpty() ? 0 : Double.parseDouble(seradicionalStr);
            int promo = (int) promoObject;
            int dias = (int) diazObject;

            double precioTotal = precioCasa * dias;
            precioTotal += cosservi;
            precioTotal += seradicional; // Sumar el campo adicional
            precioTotal -= (precioTotal * promo / 100);

            txtTotal.setText(String.valueOf(precioTotal));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Ingresa números válidos en los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
       cargaServicioadicionales();
    }//GEN-LAST:event_jComboBox3MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       ObjectContainer bases = Db4o.openFile(INICIO.direccion);
        mostrarDatosServicioAdicionalesSeleccionado(bases);
        bases.close(); 
    }//GEN-LAST:event_jButton9ActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCasa;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbReserva;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblcodFac;
    private javax.swing.JSpinner spnPromo;
    private javax.swing.JSpinner spndias;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtadicional;
    private javax.swing.JTextField txtagente;
    private javax.swing.JTextField txtcasa;
    // End of variables declaration//GEN-END:variables
}
