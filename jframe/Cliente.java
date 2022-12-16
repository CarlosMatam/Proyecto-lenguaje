/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import conexion.Conexion;


import entidad.Registro_cliente;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author carlo
 */
public class Cliente extends javax.swing.JFrame {

    private Connection con;
    int id;
    private DefaultTableModel tabla;
    
    public Cliente() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConnection();
        Registro_cliente objecto = new Registro_cliente();
        MostrarRegistro();
        ID_CLIENTE.setEnabled(false);
    }
    
    public void reiniciarTexto() {
       
       ID_CLIENTE.setText("");
       CEDULA1.setText("");
       NOMBRE.setText("");
       APELLIDO.setText("");
    
        
    }
    
    public void insertar ( Registro_cliente objecto) throws SQLException{
        CallableStatement sql = con.prepareCall("{call CLIENTE_DB.ingresar_datoss(?,?,?)}");
        
            try{
                sql.setString(1, objecto.getCEDULA());
                sql.setString(2, objecto.getNOMBRE());
                sql.setString(3, objecto.getAPELLIDO());
              
            
                JOptionPane.showMessageDialog(null, "¡INGRESADOS DE MANERA CORRECTA!");
                ResultSet rs = sql.executeQuery();
                reiniciarTexto();
                rs.close();
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+ex);
            }
    }
    
    public void actualizar(Registro_cliente objecto) throws SQLException{
            CallableStatement sql = con.prepareCall("{call CLIENTE_DB.actualizar_datoss_cliente(?,?,?,?)}");
            try{
                sql.setInt(1,objecto.getID_CLIENTE());
                sql.setString(2,objecto.getCEDULA());
                sql.setString(3,objecto.getNOMBRE());
                sql.setString(4,objecto.getAPELLIDO());
               
                ResultSet rs = sql.executeQuery();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "¡ERROR AL ACTUALIZAR!");
            }
            
        }
    
    public void eliminar (int id) throws Exception{
            CallableStatement sql = con.prepareCall("{call CLIENTE_DB.delete_datoss_clientes(?)}");
            sql.setInt(1, id);
            sql.execute();
            sql.close();
        }
    
    public void MostrarRegistro(){
            String sql = "SELECT * FROM CLIENTE";
            
            DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
            
            try{
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        Object[] fila = new Object[4];
                        fila[0] = rs.getString("ID_CLIENTE");
                        fila[1] = rs.getString("CEDULA");
                        fila[2] = rs.getString("NOMBRE");
                        fila[3] = rs.getString("APELLIDO");
                     
                        
                        tabla.addRow(fila);
                    }
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR REGISTROS");
            }
        }
    
     public void limpiar_tabla(){
        DefaultTableModel modelo =(DefaultTableModel) this.jTable1.getModel();
        modelo.setRowCount(0);
        }
     
      public void cargo_seleccionado(){
             int fila = this.jTable1.getSelectedRow();
             
             if(fila != -1){
                 this.ID_CLIENTE.setText(this.jTable1.getValueAt(fila, 0).toString().trim());
                 this.CEDULA1.setText(this.jTable1.getValueAt(fila, 1).toString().trim());
                 this.NOMBRE.setText(this.jTable1.getValueAt(fila, 2).toString().trim());
                 this.APELLIDO.setText(this.jTable1.getValueAt(fila,3).toString().trim());
         
                 
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

        ID_CLIENTE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        APELLIDO = new javax.swing.JTextField();
        NOMBRE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MODIFICAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        limpiarR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CEDULA1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_CLIENTEActionPerformed(evt);
            }
        });
        getContentPane().add(ID_CLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 30));

        jLabel1.setText("ID-CLIENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        APELLIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APELLIDOActionPerformed(evt);
            }
        });
        getContentPane().add(APELLIDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 98, -1));

        NOMBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMBREActionPerformed(evt);
            }
        });
        getContentPane().add(NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 98, -1));

        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 67, -1));

        jLabel3.setText("APELLIDO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 67, -1));

        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 346, 85, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CEDULA", "NOMBRE", "APELLIDO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 39, 621, 229));

        MODIFICAR.setText("MODIFICAR");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 346, -1, -1));

        ELIMINAR.setText("ELIMINAR");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 346, -1, -1));

        limpiarR.setText("Limpiar-Registro");
        limpiarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarRActionPerformed(evt);
            }
        });
        getContentPane().add(limpiarR, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 346, 150, -1));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("CLIENTES DEL TALLER");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 234, -1));

        CEDULA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEDULA1ActionPerformed(evt);
            }
        });
        getContentPane().add(CEDULA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 98, -1));

        jLabel4.setText("CEDULA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ID_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_CLIENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_CLIENTEActionPerformed

    private void APELLIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APELLIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_APELLIDOActionPerformed

    private void NOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMBREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOMBREActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.CEDULA1.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL VEHICULO");
            return;
        }

        if (this.NOMBRE.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL CLIENTE");
            return;
        }

        if (this.APELLIDO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA PLACA DEL VEHICULO");
            return;
        }

        else{
            String cedula = CEDULA1.getText();
            String nombre = NOMBRE.getText();
            String apellido = APELLIDO.getText();
         
     

            try{
                entidad.Registro_cliente objectos = new Registro_cliente(cedula , nombre ,apellido);
                insertar(objectos);
                reiniciarTexto();
                limpiar_tabla();
                MostrarRegistro();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "ERRORR");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        cargo_seleccionado();
    }//GEN-LAST:event_jTable1MouseClicked

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        // TODO add your handling code here:
        try{
            Connection cn= Conexion.getConnection();
            String sql =("{call CLIENTE_DB.actualizar_datoss_cliente(?,?,?,?)}");

            CallableStatement ps= cn.prepareCall(sql);
            ps.setInt(1, Integer.valueOf(ID_CLIENTE.getText()));
            ps.setString(2, CEDULA1.getText());
            ps.setString(3, NOMBRE.getText());
            ps.setString(4, APELLIDO.getText());
            

            ps.execute();
            ps.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO CORRECTAMENTE");
            limpiar_tabla();
            MostrarRegistro();
            reiniciarTexto();

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR REGISTRO");
        }

    }//GEN-LAST:event_MODIFICARActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        // TODO add your handling code here:
        try{
            id = Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
            eliminar(id);
            entidad.Registro_cliente en = new Registro_cliente();
            limpiar_tabla();
            MostrarRegistro();
            reiniciarTexto();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SELECCIONE EL REGISTRO QUE DESEA ELIMINAR!");

        }
        JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADADO CORRECTAMENTE!");

    }//GEN-LAST:event_ELIMINARActionPerformed

    private void limpiarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarRActionPerformed
        // TODO add your handling code here:
        reiniciarTexto();
        jTable1.clearSelection();

    }//GEN-LAST:event_limpiarRActionPerformed

    private void CEDULA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEDULA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEDULA1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                      new Cliente().setVisible(true); 
                      
                }catch(SQLException ex){
                    Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null , ex);
                    
                }   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField APELLIDO;
    private javax.swing.JTextField CEDULA1;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField ID_CLIENTE;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarR;
    // End of variables declaration//GEN-END:variables
}