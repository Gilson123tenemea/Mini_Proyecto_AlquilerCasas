package base;

import clases.Agente_inmobiliario;
import clases.CasaVacacional;
import clases.Cliente;
import clases.Promocion;
import clases.Propietario;
import clases.Servicio_Adicional;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author zhuniox
 */
public class ReporteServicioAdicional extends javax.swing.JDialog {

    ObjectContainer base = Db4o.openFile(ReporteCasa.direccion);
    ArrayList<Servicio_Adicional> listaServiciosAdicionales = new ArrayList<>();
    Agente_inmobiliario agente;

    /**
     * Creates new form ReporteCasa
     */
    public ReporteServicioAdicional(java.awt.Frame parent, boolean modal, Agente_inmobiliario agente) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
        this.agente = agente;
    }

    // Inicializa todas estadisiticas y reporte
    public void init() {
        cargarDatos();
        estadisticasPorCLienteDemanda();
        estadisticasDemandaServicio();
        
        System.out.println("");

    }

    // Otenemos todos los registros de la base de datos
    public void cargarDatos() {

        ObjectSet<Servicio_Adicional> result = base.queryByExample(Servicio_Adicional.class);

        if (result.isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "NO podemos mostrar datos estadisticas y reportes debido a que no existen registros");
        }

        while (result.hasNext()) {
            Servicio_Adicional servicio = result.next();
            
            listaServiciosAdicionales.add(servicio);
        }
        

        base.close();

    }

    public void estadisticasPorCLienteDemanda() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> clientes_demandas = new TreeMap<>();

        for (Servicio_Adicional servicio : listaServiciosAdicionales) {
            clientes_demandas.put(servicio.getCodigo_cli(), clientes_demandas.getOrDefault(servicio.getCodigo_cli(), 0) + 1);
        }
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
         List<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(clientes_demandas.entrySet());
         
        listaEntradas.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Map.Entry<String, Integer>> topClientes = listaEntradas.subList(0, Math.min(5, listaEntradas.size()));

        System.out.println("Array size --> " + topClientes.size());
        // Mostrar los resultados de los top 5 clientes
        System.out.println("Top 5 Clientes con Mayor Demanda:");
        for (Map.Entry<String, Integer> entry : topClientes) {
            data.setValue(entry.getValue(), entry.getKey(), entry.getKey());
        }


       JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "", 
                "", 
                "Servcios Adicionales", 
                data,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(pnGrClientes.getSize());
        
        pnGrClientes.setLayout(new BorderLayout());
        pnGrClientes.add(panel, BorderLayout.NORTH);
        
        pack();
        repaint();
    }

    public void estadisticasDemandaServicio() {
 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> servicios_demanda = new TreeMap<>();
        
        for (Servicio_Adicional servicio : listaServiciosAdicionales) {
            servicios_demanda.put(servicio.getCodigo_servi(), servicios_demanda.getOrDefault(servicio.getCodigo_servi(), 0) + 1);
        }
 
        List<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(servicios_demanda.entrySet());
         
        listaEntradas.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Tomar los primeros 5 elementos de la lista (o más si hay menos de 5 elementos)
        List<Map.Entry<String, Integer>> topClientes = listaEntradas.subList(0, Math.min(5, listaEntradas.size()));

        // Agregar los valores al dataset en el orden inverso
        for (Map.Entry<String, Integer> entry : servicios_demanda.entrySet()) {
            dataset.addValue(entry.getValue(), "Demanda", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Servicios y sus demandas",
                "Servicios Adicionales",
                "Pedidos",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(pnGrDemanda.getSize());

        pnGrDemanda.setLayout(new BorderLayout());
        pnGrDemanda.add(chartPanel, BorderLayout.NORTH);

        pack();
        repaint();
    }

             

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        pnBase = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnGrClientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnGenero = new javax.swing.JPanel();
        pnGrDemanda = new javax.swing.JPanel();
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
        jLabel2.setText("Estadisticas de los servicios adicionales");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrClientesLayout = new javax.swing.GroupLayout(pnGrClientes);
        pnGrClientes.setLayout(pnGrClientesLayout);
        pnGrClientesLayout.setHorizontalGroup(
            pnGrClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        pnGrClientesLayout.setVerticalGroup(
            pnGrClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Clientes con alta demanda de servicios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnGrClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pnGrClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pnGenero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrDemandaLayout = new javax.swing.GroupLayout(pnGrDemanda);
        pnGrDemanda.setLayout(pnGrDemandaLayout);
        pnGrDemandaLayout.setHorizontalGroup(
            pnGrDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        pnGrDemandaLayout.setVerticalGroup(
            pnGrDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Demanda de servicios");

        javax.swing.GroupLayout pnGeneroLayout = new javax.swing.GroupLayout(pnGenero);
        pnGenero.setLayout(pnGeneroLayout);
        pnGeneroLayout.setHorizontalGroup(
            pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeneroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnGrDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addGroup(pnGeneroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnGeneroLayout.setVerticalGroup(
            pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeneroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnGrDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addGroup(pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
        );
        pnBaseLayout.setVerticalGroup(
            pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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
            JRBeanArrayDataSource emptyDataSource = new JRBeanArrayDataSource(listaServiciosAdicionales.toArray());
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("ServicioAdicional.jasper"));
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listaServiciosAdicionales.toArray());
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnBase;
    private javax.swing.JPanel pnGenero;
    private javax.swing.JPanel pnGrClientes;
    private javax.swing.JPanel pnGrDemanda;
    // End of variables declaration//GEN-END:variables
}
