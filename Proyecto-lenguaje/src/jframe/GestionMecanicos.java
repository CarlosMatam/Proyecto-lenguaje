/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import conexion.Conexion;
import static conexion.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionMecanicos extends javax.swing.JFrame {

    /**
     * Creates new form GestionClientes
     */
    private Connection con;

    private DefaultTableModel modeloOrden;
    private String operacion = "insertar";

    public GestionMecanicos() throws SQLException {
        initComponents();
        modeloOrden = (DefaultTableModel) tblMecanicos.getModel();
        con = Conexion.getConnection();
        getMaxCodMecanico();
        cargarTabla();

    }

    public void cargarTabla() {
        modeloOrden.setRowCount(0);
        String query = "Select * from mecanicos order by idmecanicos asc";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                modeloOrden.addRow(new Object[]{String.valueOf(rs.getInt(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMaxCodMecanico() {
        String query = "Select max(idmecanicos) from mecanicos";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                txtCodigo.setText(String.valueOf(rs.getInt(1) + 1));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrarMecanico() {
        if (operacion.equals("insertar")) {

            try {
                CallableStatement sql = con.prepareCall("{ call PK_MECANICO_DB.INSERTAR_MECANICO(?,?,?,?)}");

                sql.setString(1, txtCedula.getText());
                sql.setString(2, txtNombre.getText());
                sql.setString(3, txtApellido.getText());
                sql.setDate(4, (Date) dcFecha.getDate());

              
                ResultSet rs = sql.executeQuery();
                limpiarControles();
                rs.close();
                cargarTabla();
                  JOptionPane.showMessageDialog(null, "Mecanico Ingresado Correctamente");

            } catch (SQLException ex) {
                Logger.getLogger(GestionMecanicos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
           
            try {
               CallableStatement sql = con.prepareCall("{ call PK_MECANICO_DB.MODIFICAR_MECANICO(?,?,?,?,?)}");

                sql.setInt(1, Integer.valueOf(txtCodigo.getText()));
               sql.setString(2, txtCedula.getText());
                sql.setString(3, txtNombre.getText());
                sql.setString(4, txtApellido.getText());
                sql.setDate(5,  (Date) dcFecha.getDate());
                
                sql.executeUpdate();
               sql.close();
               cargarTabla();
                 JOptionPane.showMessageDialog(null, "Mecanico Actualizado Correctamente");
               
                operacion = "insertar";
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void limpiarControles() {
        txtCodigo.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        dcFecha.setDateFormatString("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMecanicos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modulo de Gestion de Clientes");
        getContentPane().setLayout(null);

        tblMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cedula", "Nombre", "Apellido", "Fecha Ingreso"
            }
        ));
        jScrollPane1.setViewportView(tblMecanicos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 219, 766, 267);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Mecanico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("Codigo:");

        txtCodigo.setEditable(false);
        txtCodigo.setDragEnabled(true);

        jLabel2.setText("Cedula:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Ingreso:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(6, 6, 766, 140);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(663, 159, 109, 35);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(664, 513, 108, 35);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(550, 513, 108, 35);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 780, 570);

        setSize(new java.awt.Dimension(800, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarControles()) {
            registrarMecanico();
            limpiarControles();
            getMaxCodMecanico();
            for (int j = 0; tblMecanicos.getRowCount() >= j; j++) {
                modeloOrden.removeRow(0);
                j = 0;
            }
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar los datos del mecanico que desea registrar");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed
    private void actualizarMecanico() {
        int fila = -1;
        if (tblMecanicos.getSelectedRow() > -1) {
            fila = tblMecanicos.getSelectedRow();
            txtCodigo.setText((String) tblMecanicos.getValueAt(fila, 0));
            txtCedula.setText((String) tblMecanicos.getValueAt(fila, 1));
            txtNombre.setText((String) tblMecanicos.getValueAt(fila, 2));
            txtApellido.setText((String) tblMecanicos.getValueAt(fila, 3));
            dcFecha.setDateFormatString((String) tblMecanicos.getValueAt(fila, 4));
            operacion = "actualizar";
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el mecanico que desea actualizar..!");

        }

    }

    private void eliminarMecanico() {
        int fila = -1;
        if (tblMecanicos.getSelectedRow() > -1) {
              fila = tblMecanicos.getSelectedRow();
            try {
                 CallableStatement sql = con.prepareCall("{ call PK_MECANICO_DB.ELIMINAR_MECANICO(?,?)}");

                sql.setInt(1, Integer.valueOf(String.valueOf(tblMecanicos.getValueAt(fila, 0))));
                sql.setString(2, String.valueOf(tblMecanicos.getValueAt(fila, 1)));
                
                sql.executeUpdate();
               sql.close();
               cargarTabla();
                 JOptionPane.showMessageDialog(null, "Mecanico Eliminado Correctamente");
                getMaxCodMecanico();
                for (int j = 0; tblMecanicos.getRowCount() >= j; j++) {
                    modeloOrden.removeRow(0);
                    j = 0;
                }
                cargarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(GestionMecanicos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el mecanico que desea eliminar..!");

        }
    }

    public boolean validarControles() {
        if ("".equals(txtCedula.getText().trim()) || "".equals(txtNombre.getText().trim())
                || "".equals(txtApellido.getText().trim()) || "".equals(dcFecha.getDateFormatString().trim())) {
            return false;
        }
        return true;
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        actualizarMecanico();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarMecanico();
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionMecanicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionMecanicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionMecanicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionMecanicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GestionMecanicos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GestionMecanicos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMecanicos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
