package base;


import clases.Agente_inmobiliario;
import clases.CasaVacacional;
import clases.Cliente;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author zhuniox
 */
public class ReporteCasa extends javax.swing.JDialog {
    
    public static String direccion = "src/base/base_datos_orientada.yap";
    ObjectContainer base = Db4o.openFile(direccion);
    ArrayList<CasaVacacional> listaCasas = new ArrayList<>();
    Agente_inmobiliario agente;

    /**
     * Creates new form ReporteCasa
     */
    public ReporteCasa(java.awt.Frame parent, boolean modal, Agente_inmobiliario agente) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
        this.agente = agente;
    }
    
    // Inicializa todas estadisiticas y reporte
    public void init() {
        cargarDatos();
        estadisticaTipoCasa();
        estadisticasDisponiblidad();
        
    }
    
    // Otenemos todos los registros de la base de datos
    public void cargarDatos() {
        
        ObjectSet<CasaVacacional> result = base.queryByExample(CasaVacacional.class);
        if (result.isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "NO podemos mostrar datos estadisticas y reportes debido a que no existen registros");
        } 
        
        while(result.hasNext()) {
            CasaVacacional casa = result.next();
            listaCasas.add(casa);
        }
        
        base.close();
        
    }

    public void estadisticasDisponiblidad() {
        int cantDisponible = 0, cantNoDisponible = 0;
        
        for(CasaVacacional casa: listaCasas) {
            if (casa.isDisponibilidad()) {
                cantDisponible++;
            } else {
                cantNoDisponible++;
            }
        }
        
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Disponibles", cantDisponible);
        data.setValue("No disponible", cantNoDisponible);

        
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
        
        lbDisponible.setText(String.valueOf(cantDisponible));
        lbNoDisponible.setText(String.valueOf(cantNoDisponible));
        
        pack();
        repaint();
    }
    
    public void estadisticaTipoCasa() {
 
        int bloque = 0, ladrillo = 0, piedra = 0, madera = 0;
        
        for (CasaVacacional casa: listaCasas) {
            if (casa.getTipo_casa().equals("De Bloque")) { bloque++; }
            if (casa.getTipo_casa().equals("De Ladrillo")) { ladrillo++; }
            if (casa.getTipo_casa().equals("De Piedra")) { piedra++; }
            if (casa.getTipo_casa().equals("De Madera")) { madera++; }         
        }
                
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        data.setValue(bloque, "Bloque", "Bloque");
        data.setValue(ladrillo, "Ladrillo", "Ladrillo");
        data.setValue(piedra, "Piedra", "Piedra");
        data.setValue(madera, "Madera", "Madera");
        
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "", 
                "", 
                "Cantidad", 
                data,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(pnGrTipoCasa.getSize());
        
        pnGrTipoCasa.setLayout(new BorderLayout());
        pnGrTipoCasa.add(panel, BorderLayout.NORTH);
        
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
        lbNoDisponible = new javax.swing.JLabel();
        lbDisponible = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnGrTipoCasa = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1010, 800));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(900, 1000));

        pnBase.setBackground(new java.awt.Color(255, 255, 255));
        pnBase.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOS DE KAME HOUSE.PNG"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estadisticas de las casas vacacionales");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrDisponibleLayout = new javax.swing.GroupLayout(pnGrDisponible);
        pnGrDisponible.setLayout(pnGrDisponibleLayout);
        pnGrDisponibleLayout.setHorizontalGroup(
            pnGrDisponibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        pnGrDisponibleLayout.setVerticalGroup(
            pnGrDisponibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Disponibilidad");

        lbNoDisponible.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbNoDisponible.setForeground(new java.awt.Color(204, 51, 0));
        lbNoDisponible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbDisponible.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbDisponible.setForeground(new java.awt.Color(51, 204, 0));
        lbDisponible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Disponible");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("No disponible");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)))
                .addComponent(pnGrDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnGrDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 76, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrTipoCasaLayout = new javax.swing.GroupLayout(pnGrTipoCasa);
        pnGrTipoCasa.setLayout(pnGrTipoCasaLayout);
        pnGrTipoCasaLayout.setHorizontalGroup(
            pnGrTipoCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );
        pnGrTipoCasaLayout.setVerticalGroup(
            pnGrTipoCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tipos de casas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnGrTipoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGrTipoCasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
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
                .addGap(57, 57, 57)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pnBase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            JRBeanArrayDataSource emptyDataSource = new JRBeanArrayDataSource(listaCasas.toArray());
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("CasaVacacional.jasper"));
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listaCasas.toArray());
            InputStream inputStreamImagen = new FileInputStream(new File("src/imagenes/logokame.PNG"));

            Map<String, Object> params = new HashMap<String, Object>();
            
            params.put("ds", ds);
            params.put("rutaImagen", inputStreamImagen);
            params.put("codigoAgente", agente.getCodigo_agente());
            params.put("nombreAgente", agente.getNombre());
            params.put("apellidoAgente", agente.getApellido());
            params.put("emailAgente", agente.getEmail());
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, emptyDataSource);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDisponible;
    private javax.swing.JLabel lbNoDisponible;
    private javax.swing.JPanel pnBase;
    private javax.swing.JPanel pnGrDisponible;
    private javax.swing.JPanel pnGrTipoCasa;
    // End of variables declaration//GEN-END:variables
}
