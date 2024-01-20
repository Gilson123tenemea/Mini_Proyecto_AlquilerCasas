
import clases.Agente_inmobiliario;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
public class Consulta_agente extends javax.swing.JPanel {

    public static ArrayList<Agente_inmobiliario> listaeliminados = new ArrayList<>();

    /**
     * Creates new form Consulta_agente
     */
    public Consulta_agente() {
        initComponents();
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
        txtconsulta = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTAR AGENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("INGRESE LA CEDULA DEL AGENTE A BUSCAR :");

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtconsulta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO DEL AGENTE", "CEDULA", "NOMBRE", "APELLIDO", "EDAD", "TELEFONO", "FECHA DE NACIMIENTO", "CORREO", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:

        /*
        for (int i = 0; i < Reporte_agentes.listaagentes.size(); i++) {
            if (txtconsulta.getText().equals(Reporte_agentes.listaagentes.get(i).getCedula())) {
                String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "EDAD", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};
                Object[][] data = new Object[Reporte_agentes.listaagentes.size()][9];

                for (int j = 0; j < Reporte_agentes.listaagentes.size(); j++) {
                    data[j][0] = Reporte_agentes.listaagentes.get(i).getCodigo_agente();
                    data[j][1] = Reporte_agentes.listaagentes.get(i).getCedula();
                    data[j][2] = Reporte_agentes.listaagentes.get(i).getNombre();
                    data[j][3] = Reporte_agentes.listaagentes.get(i).getApellido();
                    data[j][4] = Reporte_agentes.listaagentes.get(i).getEdad();
                    data[j][5] = Reporte_agentes.listaagentes.get(i).getTelefono();
                    data[j][6] = Reporte_agentes.listaagentes.get(i).getEmail();
                    data[j][7] = Reporte_agentes.listaagentes.get(i).getGenero();
                    data[j][8] = Reporte_agentes.listaagentes.get(i).getFecha_nac();

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    jTable1.setModel(model);

                    j = Reporte_agentes.listaagentes.size();
                }

            }
            JOptionPane.showMessageDialog(null, "Cedula ingresada no pertenece a ningun Agente inmobiliario");

        }
         */
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        Query query = base.query();
        query.constrain(Agente_inmobiliario.class);
        query.descend("cedula").constrain(txtconsulta.getText().trim());

        ObjectSet<Agente_inmobiliario> result = query.execute();

        String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};

        Object[][] data = new Object[result.size()][8];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int i = 0;
        for (Agente_inmobiliario agente : result) {
            data[i][0] = agente.getCodigo_agente();
            data[i][1] = agente.getCedula();
            data[i][2] = agente.getNombre();
            data[i][3] = agente.getApellido();
            data[i][4] = agente.getTelefono();
            data[i][5] = agente.getEmail();
            data[i][6] = agente.getGenero();
            data[i][7] = agente.getFecha_nac() != null ? sdf.format(agente.getFecha_nac()) : null;

            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

        base.close();

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        /*
        for (int i = 0; i < Reporte_agentes.listaagentes.size(); i++) {
            if (txtconsulta.getText().equals(Reporte_agentes.listaagentes.get(i).getCedula())) {
                String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "EDAD", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};
                Object[][] data = new Object[Reporte_agentes.listaagentes.size()][9];

                for (int j = 0; j < Reporte_agentes.listaagentes.size(); j++) {
                    data[j][0] = Reporte_agentes.listaagentes.get(i).getCodigo_agente();
                    data[j][1] = Reporte_agentes.listaagentes.get(i).getCedula();
                    data[j][2] = Reporte_agentes.listaagentes.get(i).getNombre();
                    data[j][3] = Reporte_agentes.listaagentes.get(i).getApellido();
                    data[j][4] = Reporte_agentes.listaagentes.get(i).getEdad();
                    data[j][5] = Reporte_agentes.listaagentes.get(i).getTelefono();
                    data[j][6] = Reporte_agentes.listaagentes.get(i).getEmail();
                    data[j][7] = Reporte_agentes.listaagentes.get(i).getGenero();
                    data[j][8] = Reporte_agentes.listaagentes.get(i).getFecha_nac();

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    jTable1.setModel(model);

                    j = Reporte_agentes.listaagentes.size();

                    int result = JOptionPane.showConfirmDialog(null, " Estas seguro de borrar los datos", "Confirmacio", JOptionPane.YES_OPTION);

                    if (result == JOptionPane.YES_OPTION) {

                        for (int k = 0; i < Reporte_agentes.listaagentes.size(); k++) {
                            // Obtener la instancia del objeto agente que deseas eliminar
                            Agente_inmobiliario agente = Reporte_agentes.listaagentes.get(i);

                            // Crear una consulta para buscar el agente en la base de datos db4o
                            ObjectContainer base = Db4o.openFile(INICIO.direccion);

                            Agente_inmobiliario agenteDB = (Agente_inmobiliario) base.queryByExample(agente).next();

                            // Eliminar el agente de la base de datos db4o
                            base.delete(agenteDB);

                            // Cerrar la conexión con la base de datos db4o
                            base.close();
                        }

                        Reporte_agentes.listaagentes.remove(j);

                    }
                }

            }


        }

         */
        ObjectContainer base = Db4o.openFile(INICIO.direccion);

        Query query = base.query();
        query.constrain(Agente_inmobiliario.class);
        query.descend("cedula").constrain(txtconsulta.getText().trim());

        ObjectSet<Agente_inmobiliario> result = query.execute();

        String[] columnNames = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO", "SEXO", "FECHA DE NACIMIENTO"};

        Object[][] data = new Object[result.size()][8];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int i = 0;
        for (Agente_inmobiliario agente : result) {
            data[i][0] = agente.getCodigo_agente();
            data[i][1] = agente.getCedula();
            data[i][2] = agente.getNombre();
            data[i][3] = agente.getApellido();
            data[i][4] = agente.getTelefono();
            data[i][5] = agente.getEmail();
            data[i][6] = agente.getGenero();
            data[i][7] = agente.getFecha_nac() != null ? sdf.format(agente.getFecha_nac()) : null;

            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

        int resul = JOptionPane.showConfirmDialog(null, "Deseas eliminar los datos del agente", "Confirmacio", JOptionPane.YES_NO_OPTION);

        if (resul == JOptionPane.YES_OPTION) {
            for (Agente_inmobiliario agenteDB : result) {

                // Eliminar el agente de la base de datos db4o
                base.delete(agenteDB);
                JOptionPane.showMessageDialog(null, "Se estan borrando los datos del agente");

            }
        } else if (resul == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Datos del agente no eliminados");
        }

        txtconsulta.setText(" ");
        vaciarTabla();

        base.close();


    }//GEN-LAST:event_jButton1ActionPerformed

    public void vaciarTabla() {
        // Obtenemos el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Borramos las filas antiguas del modelo de tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtconsulta;
    // End of variables declaration//GEN-END:variables
}
