
import clases.Agente_inmobiliario;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo.User
 */
public class Reporte_agentes extends javax.swing.JPanel {

    /**
     * Creates new form Reporte_agentes
     */
    public static ArrayList<Agente_inmobiliario> listaagentes = new ArrayList<>();

    public Reporte_agentes() {

        initComponents();
        actualizarDatos();

        /*
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        ObjectSet<Agente_inmobiliario> result = base.queryByExample(new Agente_inmobiliario());

        String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "EDAD", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};

        Object[][] data = new Object[result.size()][9];

        int i = 0;
        for (Agente_inmobiliario agente : result) {
            data[i][0] = agente.getCodigo_agente();
            data[i][1] = agente.getCedula();
            data[i][2] = agente.getNombre();
            data[i][3] = agente.getApellido();
            data[i][4] = agente.getEdad();
            data[i][5] = agente.getTelefono();
            data[i][6] = agente.getEmail();
            data[i][7] = agente.getGenero();
            data[i][8] = agente.getFecha_nac();

            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbagentes.setModel(model);

        base.close();
         */
    }

    public void actualizarDatos() {
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        AsignarRegistrosArray(base);

        // Limpia los datos de la tabla y actualiza los datos en la tabla con los nuevos registros del ArrayList
        tbagentes.setModel(new DefaultTableModel());

        String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};
        Object[][] data = new Object[listaagentes.size()][8];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < listaagentes.size(); i++) {
            data[i][0] = listaagentes.get(i).getCodigo_agente();
            data[i][1] = listaagentes.get(i).getCedula();
            data[i][2] = listaagentes.get(i).getNombre();
            data[i][3] = listaagentes.get(i).getApellido();
            data[i][4] = listaagentes.get(i).getTelefono();
            data[i][5] = listaagentes.get(i).getEmail();
            data[i][6] = listaagentes.get(i).getGenero();
            data[i][7] = listaagentes.get(i).getFecha_nac() != null ? sdf.format(listaagentes.get(i).getFecha_nac()) : null;
        }

        this.validate();
        tbagentes.repaint();

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbagentes.setModel(model);

        base.close();
    }

    public void AsignarRegistrosArray(ObjectContainer base) {

        Query query = base.query();
        query.constrain(Agente_inmobiliario.class);
        ObjectSet<Agente_inmobiliario> agentes = query.execute();

        // Elimina todos los elementos del ArrayList existente
        listaagentes.clear();

        // Agrega los nuevos registros al ArrayList
        for (Agente_inmobiliario agente : agentes) {
            listaagentes.add(agente);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbagentes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTE  DE AGENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbagentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbagentes);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 920, 520));

        jButton1.setText("Actualizar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actualizarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbagentes;
    // End of variables declaration//GEN-END:variables
}
