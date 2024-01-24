package base;


import clases.Agente_inmobiliario;
import clases.CasaVacacional;
import clases.Cliente;
import clases.Propietario;
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
public class ReportePropietarios extends javax.swing.JDialog {
    
    ObjectContainer base = Db4o.openFile(ReporteCasa.direccion);
    ArrayList<Propietario> listaPropietarios = new ArrayList<>();
    ArrayList<CasaVacacional> listaCasas = new ArrayList<>();
    
    Agente_inmobiliario agente;

    /**
     * Creates new form ReporteCasa
     */
    public ReportePropietarios(java.awt.Frame parent, boolean modal, Agente_inmobiliario agente) {
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
        estadisticasCasaPorPersona();
        estadisticasGeneroRangoEdad();
        
    }
    
    // Otenemos todos los registros de la base de datos
    public void cargarDatos() {
        
        ObjectSet<Propietario> resultPropietario = base.queryByExample(Propietario.class);
        ObjectSet<CasaVacacional> resultCasa = base.queryByExample(CasaVacacional.class);

        if (resultPropietario.isEmpty() || resultCasa.isEmpty()) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "NO podemos mostrar datos estadisticas y reportes debido a que no existen registros");
        } 
        
        while(resultPropietario.hasNext()) {
            Propietario propietario = resultPropietario.next();
            propietario.setEdad();
            listaPropietarios.add(propietario);
        }
        while(resultCasa.hasNext()) {
            CasaVacacional casa = resultCasa.next();
            listaCasas.add(casa);
        }
        base.close();
        
    }

    public void estadisticasEdad() {
        int edad_18_25 = 0, edad_26_45 = 0, edad_46_80 = 0;
                
        Date fechaActual = new Date();
        for(Propietario propietario: listaPropietarios) {
            
            LocalDateTime fechaNacimiento = LocalDateTime.ofInstant(propietario.getFecha_nac().toInstant(), ZoneId.systemDefault());
            int edad = Period.between(fechaNacimiento.toLocalDate(), LocalDate.now()).getYears();
            
            if (edad <= 25) { 
                edad_18_25++; 
            } else if(edad <= 45) {
                edad_26_45++;
            } else {
                edad_46_80++;
            }  
            
        }
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.setValue(edad_18_25, "Edad", "Edad 18 25" );
        data.setValue( edad_26_45, "Edad", "Edad 26 45");
        data.setValue(edad_46_80, "Edad", "Edad 46 80");

        
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
        panel.setPreferredSize(pnGrCasaPorPersona.getSize());
        
        pnGrEdad.setLayout(new BorderLayout());
        pnGrEdad.add(panel, BorderLayout.NORTH);
        
        lbEdad18_25.setText(String.valueOf(edad_18_25));
        lbEdad26_45.setText(String.valueOf(edad_26_45));
        lbEdad46_80.setText(String.valueOf(edad_46_80));
        
        pack();
        repaint();
    }
    
    public void estadisticasCasaPorPersona() {
 
        int casas_0 = 0, casas_1_2 = 0, casas_3_5 = 0, casas_6_mas = 0;
        
        for (Propietario propietario: listaPropietarios) {
            int aux = 0;
            for (CasaVacacional casa: listaCasas) {
                if (propietario.getCodigo_propie().equals(casa.getCodigo_propie())) {
                    aux++;
                }
            }
            
            if (aux == 0) { casas_0++;}
            if (aux >= 1 || aux <= 2) { casas_1_2++;}
            if (aux >= 3 || aux <= 5) { casas_3_5++;}
            if (aux >= 6) { casas_6_mas++;}
                    
        }
                
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Casas 0", casas_0);
        data.setValue("Casas 1 o 2", casas_1_2);
        data.setValue("Casas 3 a 5", casas_3_5);
        data.setValue("Casas 6 o mas", casas_6_mas);

        
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
        panel.setPreferredSize(pnGrCasaPorPersona.getSize());
        panel.setBackground(new Color(250, 250, 250));
        
        pnGrCasaPorPersona.setLayout(new BorderLayout());
        pnGrCasaPorPersona.add(panel, BorderLayout.NORTH);
        
        pack();
        repaint();
         
        
    }
    
    public void estadisticasGeneroRangoEdad() {
 
        int mujeres = 0, hombres = 0;
        int edad_18_25_ho = 0, edad_18_25_mu = 0;
        int edad_26_45_ho = 0, edad_26_45_mu = 0;
        int edad_46_80_ho = 0, edad_46_80_mu = 0;
                
        Date fechaActual = new Date();
        for(Propietario propietario: listaPropietarios) {
            
            LocalDateTime fechaNacimiento = LocalDateTime.ofInstant(propietario.getFecha_nac().toInstant(), ZoneId.systemDefault());
            int edad = Period.between(fechaNacimiento.toLocalDate(), LocalDate.now()).getYears();
            
            if (edad <= 25) { 
                if(propietario.getGenero().equals("Masculino")) {
                    edad_18_25_ho++;
                    hombres++;
                } else {
                    edad_18_25_mu++;
                    mujeres++;
                }
            } 
            
            if(edad >= 26 && edad <= 45) {
                if(propietario.getGenero().equals("Masculino")) {
                    edad_26_45_ho++;
                    hombres++;
                } else {
                    edad_26_45_mu++;
                    mujeres++;
                }
            } 
            
            if (edad >= 46) {
                if(propietario.getGenero().equals("Masculino")) {
                    edad_46_80_ho++;
                    hombres++;
                } else {
                    edad_46_80_mu++;
                    mujeres++;
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
        panel.setPreferredSize(pnGrCasaPorPersona.getSize());
        
        pnGrGenero.setLayout(new BorderLayout());
        pnGrGenero.add(panel, BorderLayout.NORTH);
        
        lbMasculino.setText(String.valueOf(hombres));
        lbFemenino.setText(String.valueOf(mujeres));
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
        pnGrEdad = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbEdad26_45 = new javax.swing.JLabel();
        lbEdad18_25 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbEdad46_80 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnGrCasaPorPersona = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnGenero = new javax.swing.JPanel();
        pnGrGenero = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbMasculino = new javax.swing.JLabel();
        lbFemenino = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel2.setText("Estadisticas de los Propietarios");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrEdadLayout = new javax.swing.GroupLayout(pnGrEdad);
        pnGrEdad.setLayout(pnGrEdadLayout);
        pnGrEdadLayout.setHorizontalGroup(
            pnGrEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        pnGrEdadLayout.setVerticalGroup(
            pnGrEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rangos de edad");

        lbEdad26_45.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad26_45.setForeground(new java.awt.Color(204, 51, 0));
        lbEdad26_45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbEdad18_25.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad18_25.setForeground(new java.awt.Color(0, 102, 0));
        lbEdad18_25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("46 - 80");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("26 - 45");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("18 - 25");

        lbEdad46_80.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbEdad46_80.setForeground(new java.awt.Color(204, 204, 0));
        lbEdad46_80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnGrEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(lbEdad18_25, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                .addComponent(lbEdad26_45, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(221, 221, 221)
                        .addComponent(lbEdad46_80, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGrEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdad18_25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad26_45, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbEdad46_80, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrCasaPorPersonaLayout = new javax.swing.GroupLayout(pnGrCasaPorPersona);
        pnGrCasaPorPersona.setLayout(pnGrCasaPorPersonaLayout);
        pnGrCasaPorPersonaLayout.setHorizontalGroup(
            pnGrCasaPorPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        pnGrCasaPorPersonaLayout.setVerticalGroup(
            pnGrCasaPorPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Numero de domicilios por persona");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(pnGrCasaPorPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnGrCasaPorPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pnGenero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnGrGeneroLayout = new javax.swing.GroupLayout(pnGrGenero);
        pnGrGenero.setLayout(pnGrGeneroLayout);
        pnGrGeneroLayout.setHorizontalGroup(
            pnGrGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        pnGrGeneroLayout.setVerticalGroup(
            pnGrGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Generos");

        lbMasculino.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbMasculino.setForeground(new java.awt.Color(0, 102, 0));
        lbMasculino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbFemenino.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbFemenino.setForeground(new java.awt.Color(255, 0, 255));
        lbFemenino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Femenino");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Masculino");

        javax.swing.GroupLayout pnGeneroLayout = new javax.swing.GroupLayout(pnGenero);
        pnGenero.setLayout(pnGeneroLayout);
        pnGeneroLayout.setHorizontalGroup(
            pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeneroLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(pnGrGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
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
                .addGroup(pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGeneroLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnGeneroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnGrGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
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
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnBaseLayout.createSequentialGroup()
                .addGroup(pnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(pnGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            JRBeanArrayDataSource emptyDataSource = new JRBeanArrayDataSource(listaPropietarios.toArray());

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportePropietario.jasper"));
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(listaPropietarios.toArray());
            InputStream inputStreamImagen = new FileInputStream(new File("src/imagenes/logokame.PNG"));

            Map<String, Object> params = new HashMap<String, Object>();
            
            params.put("ds", ds);
            params.put("rutaImagen", inputStreamImagen);
            params.put("codigoAgente", agente.getCodigo_agente());
            params.put("nombreAgente", agente.getNombre());
            params.put("apellidoAgente", agente.getApellido());
            params.put("emailAgente", agente.getEmail());
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, emptyDataSource);
            // JasperExportManager.exportReportToPdfStream(jp, out);
            JasperViewer pv = new JasperViewer(jp, false);
            pv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            System.setProperty("net.sf.jasperreports.debug.view.shapes", "true");
            
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbEdad18_25;
    private javax.swing.JLabel lbEdad26_45;
    private javax.swing.JLabel lbEdad46_80;
    private javax.swing.JLabel lbFemenino;
    private javax.swing.JLabel lbMasculino;
    private javax.swing.JPanel pnBase;
    private javax.swing.JPanel pnGenero;
    private javax.swing.JPanel pnGrCasaPorPersona;
    private javax.swing.JPanel pnGrEdad;
    private javax.swing.JPanel pnGrGenero;
    // End of variables declaration//GEN-END:variables
}
