/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import conexion.Conexion;


import entidad.Registro_direccion;
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
public class Direccion extends javax.swing.JFrame {
    private Connection con;
    int id;
    private DefaultTableModel tabla;

    public Direccion()throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConnection();
        Registro_direccion objecto = new Registro_direccion();
        MostrarRegistro();
        IDDIRECCION.setEnabled(false);
    }
    
       public void reiniciarTexto() {
       
        IDDIRECCION.setText("");
       ID_CLIENTE.setText("");
       DOMICILIO.setText("");
       IDPROVINCIA.setText("");
       IDCANTON.setText("");
       IDDISTRITO.setText("");
        
        
    }

    
    public void insertar ( Registro_direccion objecto) throws SQLException{
        CallableStatement sql = con.prepareCall("{call DIRECCION_DB.INGRESAR_DIRECCION(?,?,?,?,?)}");
        
            try{
                sql.setInt(1, objecto.getID_CLIENTE());
                sql.setString(2, objecto.getDOMICILIO());
                sql.setInt(3, objecto.getIDPROVINCIA());
                sql.setInt(4, objecto.getIDCANTON());
                sql.setInt(5, objecto.getIDDISTRITO());
                
            
                
                ResultSet rs = sql.executeQuery();
                JOptionPane.showMessageDialog(null, "¡INGRESADOS DE MANERA CORRECTA!");
                reiniciarTexto();
                rs.close();
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+ex);
            }
    }
    
     public void actualizar(Registro_direccion objecto) throws SQLException{
            CallableStatement sql = con.prepareCall("{call DIRECCION_DB.ACTUALIZAR_DATOSS_DIRECCION(?,?,?,?,?,?)}");
            try{
                sql.setInt(1,objecto.getIDDIRECCION());
                sql.setInt(2,objecto.getID_CLIENTE());
                sql.setString(3,objecto.getDOMICILIO());
                sql.setInt(4,objecto.getIDPROVINCIA());
                sql.setInt(5,objecto.getIDCANTON());
                sql.setInt(6,objecto.getIDDISTRITO());
                ResultSet rs = sql.executeQuery();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "¡ERROR AL ACTUALIZAR!");
            }
            
        }
        
      public void eliminar (int id) throws Exception{
            CallableStatement sql = con.prepareCall("{call DIRECCION_DB.DELETE_DATOSS_DIRECCION(?)}");
            sql.setInt(1, id);
            sql.execute();
            sql.close();
        }
      
        public void MostrarRegistro(){
            String sql = "SELECT * FROM DIRECCION";
            
            DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
            
            try{
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        Object[] fila = new Object[6];
                        
                        fila[0] = rs.getString("IDDIRECCION");
                        fila[1] = rs.getString("ID_CLIENTE");
                        fila[2] = rs.getString("DOMICILIO");
                        fila[3] = rs.getString("IDPROVINCIA");
                        fila[4] = rs.getString("IDCANTON");
                        fila[5] = rs.getString("IDDISTRITO");
                        
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
                 
                 this.IDDIRECCION.setText(this.jTable1.getValueAt(fila, 0).toString().trim());
                 this.ID_CLIENTE.setText(this.jTable1.getValueAt(fila, 1).toString().trim());
                 this.DOMICILIO.setText(this.jTable1.getValueAt(fila, 2).toString().trim());
                 this.IDPROVINCIA.setText(this.jTable1.getValueAt(fila, 3).toString().trim());
                 this.IDCANTON.setText(this.jTable1.getValueAt(fila,4).toString().trim());
                 this.IDDISTRITO.setText(this.jTable1.getValueAt(fila,5).toString().trim());
                
                 
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
        IDPROVINCIA = new javax.swing.JTextField();
        DOMICILIO = new javax.swing.JTextField();
        IDCANTON = new javax.swing.JTextField();
        IDDISTRITO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MODIFICAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        limpiarR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        IDDIRECCION = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_CLIENTEActionPerformed(evt);
            }
        });
        getContentPane().add(ID_CLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 59, 98, -1));

        jLabel1.setText("IDCLIENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 57, -1, -1));

        IDPROVINCIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDPROVINCIAActionPerformed(evt);
            }
        });
        getContentPane().add(IDPROVINCIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 165, 98, -1));

        DOMICILIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOMICILIOActionPerformed(evt);
            }
        });
        getContentPane().add(DOMICILIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 117, 98, -1));

        IDCANTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCANTONActionPerformed(evt);
            }
        });
        getContentPane().add(IDCANTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 205, 98, -1));

        IDDISTRITO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDDISTRITOActionPerformed(evt);
            }
        });
        getContentPane().add(IDDISTRITO, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 259, 98, -1));

        jLabel2.setText("DOMICILIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 117, 67, -1));

        jLabel3.setText("IDPROVINCIA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 167, 80, -1));

        jLabel4.setText("IDCANTON");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 208, 80, -1));

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
                "ID", "ID_CLIENTE", "DOMCILIO", "PROVINCIA(ID)", "CANTON(ID)", "DISTRITO(ID)"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 59, 711, 229));

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
        jLabel7.setText("DIRECCIONES CLIENTES");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 16, 234, -1));

        IDDIRECCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDDIRECCIONActionPerformed(evt);
            }
        });
        getContentPane().add(IDDIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 13, 53, -1));

        jLabel9.setText("IDDISTRITO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 262, 71, -1));

        jLabel5.setText("ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 16, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 970, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDPROVINCIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDPROVINCIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDPROVINCIAActionPerformed

    private void DOMICILIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOMICILIOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOMICILIOActionPerformed

    private void IDCANTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCANTONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCANTONActionPerformed

    private void IDDISTRITOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDDISTRITOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDDISTRITOActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.ID_CLIENTE.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL VEHICULO");
            return;
        }

        if (this.DOMICILIO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL CLIENTE");
            return;
        }

        if (this.IDPROVINCIA.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA PLACA DEL VEHICULO");
            return;
        }

        if (this.IDCANTON.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL MODELO DEL VEHICULO");
            return;
        }

        if (this.IDDISTRITO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA MARCA DEL VEHICULO");
            return;
        }

      
        else{
            int id_cliente = Integer.parseInt(ID_CLIENTE.getText());
            String domicilio = DOMICILIO.getText();
            int idprovincia = Integer.parseInt(IDPROVINCIA.getText());
            int idcanton = Integer.parseInt(IDCANTON.getText());
            int iddistrito = Integer.parseInt(IDDISTRITO.getText());
           

            try{
                entidad.Registro_direccion objectos = new Registro_direccion(id_cliente , domicilio, idprovincia, idcanton , iddistrito);
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
            String sql =("{call DIRECCION_DB.ACTUALIZAR_DATOSS_DIRECCION(?,?,?,?,?,?)}");

            CallableStatement ps= cn.prepareCall(sql);
            ps.setInt(1, Integer.valueOf(IDDIRECCION.getText()));
            ps.setInt(2, Integer.valueOf(ID_CLIENTE.getText()));
            ps.setString(3, DOMICILIO.getText());
            ps.setInt(4, Integer.valueOf(IDPROVINCIA.getText()));
            ps.setInt(5, Integer.valueOf(IDCANTON.getText()));
            ps.setInt(6, Integer.valueOf(IDDISTRITO.getText()));
           

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
            entidad.Registro_direccion en = new Registro_direccion();
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

    private void ID_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_CLIENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_CLIENTEActionPerformed

    private void IDDIRECCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDDIRECCIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDDIRECCIONActionPerformed

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
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try{
                      new Direccion().setVisible(true); 
                      
                }catch(SQLException ex){
                    Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null , ex);
                    
                }   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DOMICILIO;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField IDCANTON;
    private javax.swing.JTextField IDDIRECCION;
    private javax.swing.JTextField IDDISTRITO;
    private javax.swing.JTextField IDPROVINCIA;
    private javax.swing.JTextField ID_CLIENTE;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarR;
    // End of variables declaration//GEN-END:variables
}
