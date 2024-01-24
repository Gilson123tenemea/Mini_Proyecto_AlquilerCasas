package base;


import clases.Agente_inmobiliario;
import clases.CasaVacacional;
import clases.Cliente;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author zhuniox
 */
public class ReporteCliente extends javax.swing.JDialog {
    
    ObjectContainer base = Db4o.openFile(ReporteCasa.direccion);
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    Agente_inmobiliario agente;
    /**
     * Creates new form ReporteCasa
     */
    public ReporteCliente(java.awt.Frame parent, boolean modal, Agente_inmobiliario agente) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
        this.agente = agente;
    }
    
    // Inicializa todas estadisiticas y reporte
    public void init() {
        cargarDatos();
        estadisticasEdad();
        estadisticasDiscapacidad();
        estadisticasGeneroRangoEdad();
        
    }
    
    // Otenemos todos los registros de la base de datos
    public void cargarDatos() {
        
        ObjectSet<Cliente> result = base.queryByExample(Cliente.class);
        if (result.isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "NO podemos mostrar datos estadisticas y reportes debido a que no existen registros");
        } 
        
        while(result.hasNext()) {
            Cliente cliente = result.next();
            cliente.setEdad();
            listaClientes.add(cliente);
        }
        
        base.close();
        
    }

    public void estadisticasEdad() {
        int edad_18_25 = 0, edad_26_45 = 0, edad_46_80 = 0;
                
        Date fechaActual = new Date();
        for(Cliente cliente: listaClientes) {
            
            LocalDateTime fechaNacimiento = LocalDateTime.ofInstant(cliente.getFecha_nac().toInstant(), ZoneId.systemDefault());
            int edad = Period.between(fechaNacimiento.toLocalDate(), LocalDate.now()).getYears();
            
            if (edad <= 25) { 
                edad_18_25++; 
            } else if(edad <= 45) {
                edad_26_45++;
            } else {
                edad_46_80++;
            }  
            
        }
        
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Edad 18 25", edad_18_25);
        data.setValue("Edad 26 45", edad_26_45);
        data.setValue("Edad 46 80", edad_46_80);

        
        JFreeChart graficos_circular = ChartFactory.createPieChart(
            "", // title
            data,  // fuente de datos 
            false, // nombre de las categorias 
            true, // herramientas  
            false // generacion de URL
        );
        
        PiePlot plot = (PiePlot) graficos_circular.getPlot();
        
        plot.setLabelBackgroundPaint(new Color(255, 255, 255)); // Color de fondo
        plot.setLabelOutlinePaint(Color.WHITE); // Color del borde
        plot.setLabelFont(new Font("Arial", Font.BOLD, 12)); // Fuente y tamaño
        plot.setLabelShadowPaint(null);

        
        graficos_circular.getPlot().setBackgroundPaint(new Color(255, 255, 255));
        graficos_circular.getPlot().setOutlinePaint(null);       
        
        ChartPanel panel = new ChartPanel(graficos_circular);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(pnGrDisponible.getSize());
        panel.setBackground(new Color(250, 250, 250));
        
        pnGrDisponible.setLayout(new BorderLayout());
        pnGrDisponible.add(panel, BorderLayout.NORTH);
        
        lbEdad18_25.setText(String.valueOf(edad_18_25));
        lbEdad26_45.setText(String.valueOf(edad_26_45));
        lbEdad46_80.setText(String.valueOf(edad_46_80));
        
        pack();
        repaint();
    }
    
    public void estadisticasDiscapacidad() {
 
        int cantDiscapacidad = 0, cantNoDiscapacidad = 0;
        
        for (Cliente cliente: listaClientes) {
            if (cliente.getDiscapacidad().equals("Si")) { 
                cantDiscapacidad++; 
            } else {
                cantNoDiscapacidad++;
            }
                    
        }
                
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        data.setValue(cantDiscapacidad, "Con discapacidad", "Con discapacidad");
        data.setValue(cantNoDiscapacidad, "Sin Discapacidad", "Sin Discapacidad");
       

        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "", 
                "", 
                "Numero", 
                data,
                PlotOrientation.HORIZONTAL,
                false,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(pnGrDiscapacidad.getSize());
        
        pnGrDiscapacidad.setLayout(new BorderLayout());
        pnGrDiscapacidad.add(panel, BorderLayout.NORTH);
        
        pack();
        repaint();
        
    }
    
    public void estadisticasGeneroRangoEdad() {
 
        int edad_18_25_ho = 0, edad_18_25_mu = 0;
        int edad_26_45_ho = 0, edad_26_45_mu = 0;
        int edad_46_80_ho = 0, edad_46_80_mu = 0;
                
        Date fechaActual = new Date();
        for(Cliente cliente: listaClientes) {
            
            LocalDateTime fechaNacimiento = LocalDateTime.ofInstant(cliente.getFecha_nac().toInstant(), ZoneId.systemDefault());
            int edad = Period.between(fechaNacimiento.toLocalDate(), LocalDate.now()).getYears();
            
            if (edad <= 25) { 
                if(cliente.getGenero().equals("Masculino")) {
                    edad_18_25_ho++;
                } else {
                    edad_18_25_mu++;
                }
            } 
            
            if(edad >= 26 && edad <= 45) {
                if(cliente.getGenero().equals("Masculino")) {
                    edad_26_45_ho++;
                } else {
                    edad_26_45_mu++;
                }
            } 
            
            if (edad >= 46) {
                if(cliente.getGenero().equals("Masculino")) {
                    edad_46_80_ho++;
                } else {
                    edad_46_80_mu++;
                }
                
            }         
            
        }
                
        DefaultCategoryDataset data = new DefaultCategoryDataset();
 
        data.setValue(edad_18_25_ho, "Hombre", "Edad 18 25");
        data.setValue(edad_18_25_mu, "Femenino", "Edad 18 25");
        data.setValue(edad_26_45_ho, "Hombre", "Edad 25 45");
        data.setValue(edad_26_45_mu, "Femenino", "Edad 25 45");
        data.setValue(edad_46_80_ho, "Hombre", "Edad 46 80");
        data.setValue(edad_46_80_mu, "Femenino", "Edad 46 80");

        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "", 
                "", 
                "Numero", 
                data,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(pnGrDiscapacidad.getSize());
        
        pnGrGenero.setLayout(new BorderLayout());
        pnGrGenero.add(panel, BorderLayout.NORTH);
        
        pack();
        repaint();
        
    }
    
    public void estadistica() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        pnBase = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnGrDisponible = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbEdad46_80 = new javax.swing.JLabel();
        lbEdad26_45 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbEdad18_25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnGrDiscapacidad = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnGenero = new javax.swing.JPanel();
        pnGrGenero = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(900, 1000));

        pnBase.setBackground(new java.awt.Color(255, 255, 255));
        pnBase.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estadisticas de los clientes");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrDisponibleLayout = new javax.swing.GroupLayout(pnGrDisponible);
        pnGrDisponible.setLayout(pnGrDisponibleLayout);
        pnGrDisponibleLayout.setHorizontalGroup(
            pnGrDisponibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        pnGrDisponibleLayout.setVerticalGroup(
            pnGrDisponibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rangos de edad");

        lbEdad46_80.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad46_80.setForeground(new java.awt.Color(204, 51, 0));
        lbEdad46_80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbEdad26_45.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad26_45.setForeground(new java.awt.Color(0, 102, 0));
        lbEdad26_45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("18 - 25");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("46 - 80");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("26 - 45");

        lbEdad18_25.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad18_25.setForeground(new java.awt.Color(204, 204, 0));
        lbEdad18_25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbEdad26_45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad46_80, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdad18_25, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)))
                .addGap(70, 70, 70)
                .addComponent(pnGrDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGrDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(lbEdad18_25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdad26_45, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad46_80, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrDiscapacidadLayout = new javax.swing.GroupLayout(pnGrDiscapacidad);
        pnGrDiscapacidad.setLayout(pnGrDiscapacidadLayout);
        pnGrDiscapacidadLayout.setHorizontalGroup(
            pnGrDiscapacidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );
        pnGrDiscapacidadLayout.setVerticalGroup(
            pnGrDiscapacidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Personas con y sin Discapacidad");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnGrDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGrDiscapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnGenero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrGeneroLayout = new javax.swing.GroupLayout(pnGrGenero);
        pnGrGenero.setLayout(pnGrGeneroLayout);
        pnGrGeneroLayout.setHorizontalGroup(
            pnGrGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );
        pnGrGeneroLayout.setVerticalGroup(
            pnGrGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Generos");

        javax.swing.GroupLayout pnGeneroLayout = new javax.swing.GroupLayout(pnGenero);
        pnGenero.setLayout(pnGeneroLayout);
        pnGeneroLayout.setHorizontalGroup(
            pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeneroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGrGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnGeneroLayout.setVerticalGroup(
            pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeneroLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnGeneroLayout.createSequentialGroup()
                .addComponent(pnGrGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setIconTextGap(8);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBaseLayout = new javax.swing.GroupLayout(pnBase);
        pnBase.setLayout(pnBaseLayout);
        pnBaseLayout.setHorizontalGroup(
            pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaseLayout.createSequentialGroup()
                .addGroup(pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(pnGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        pnBaseLayout.setVerticalGroup(
            pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pnBase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
            JRBeanArrayDataSource emptyDataSource = new JRBeanArrayDataSource(listaClientes.toArray());
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteClientejrxml.jasper"));
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listaClientes.toArray());
            InputStream inputStreamImagen = new FileInputStream(new File("src/imagenes/logokame.PNG"));
            
            Cliente cliente = new Cliente(); // Asegúrate de instanciar correctamente
            System.out.println("Propiedades de la instancia de Cliente: " + cliente);


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
            
            this.dispose();
            pv.setVisible(true);

            
            
        } catch (JRException ex) {
            System.out.println("NO SE ENCONTRO LA PLANTILLA RUTA NO ENCONTRADA");
            Logger.getLogger(ReporteCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            System.out.println("NO SE ENCONTRO LA PLANTILLA RUTA NO ENCONTRADA DE LA IMAGEN");
            Logger.getLogger(ReporteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
            
        
    }//GEN-LAST:event_btnGuardarActionPerformed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbEdad18_25;
    private javax.swing.JLabel lbEdad26_45;
    private javax.swing.JLabel lbEdad46_80;
    private javax.swing.JPanel pnBase;
    private javax.swing.JPanel pnGenero;
    private javax.swing.JPanel pnGrDiscapacidad;
    private javax.swing.JPanel pnGrDisponible;
    private javax.swing.JPanel pnGrGenero;
    // End of variables declaration//GEN-END:variables
}
