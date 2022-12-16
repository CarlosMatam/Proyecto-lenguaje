/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import conexion.Conexion;


import entidad.Registro_mantenimiento;
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
public class Mantenimiento extends javax.swing.JFrame {

    private Connection con;
    int id;
    private DefaultTableModel tabla;
    
    public Mantenimiento()throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConnection();
        Registro_mantenimiento objecto = new Registro_mantenimiento();
        MostrarRegistro();
        IDMANTENIMIENTO.setEnabled(false);
    }
    
    public void reiniciarTexto() {
       
        IDMANTENIMIENTO.setText("");
       PLACA.setText("");
       DESCRIPCION.setText("");
       FECHAHORALL.setText("");
       FECHAHORASA.setText("");
       
    }
    
    public void insertar ( Registro_mantenimiento objecto) throws SQLException{
        CallableStatement sql = con.prepareCall("{call MANTE_DB.ingresar_datoss_mantenimiento(?,?,?,?)}");
        
            try{
                sql.setString(1, objecto.getPLACA());
                sql.setString(2, objecto.getDESCRIPCION());
                sql.setString(3, objecto.getFECHAHORALL());
                sql.setString(4, objecto.getFECHAHORASA());
               
                
            
                
                ResultSet rs = sql.executeQuery();
                JOptionPane.showMessageDialog(null, "¡INGRESADOS DE MANERA CORRECTA!");
                reiniciarTexto();
                rs.close();
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+ex);
            }
            
    }
    
    public void actualizar(Registro_mantenimiento objecto) throws SQLException{
            CallableStatement sql = con.prepareCall("{call MANTE_DB.actualizar_datos_mantenimiento(?,?,?,?,?)}");
            try{
                sql.setInt(1,objecto.getIDMANTENIMIENTO());
                sql.setString(2,objecto.getPLACA());
                sql.setString(3,objecto.getDESCRIPCION());
                sql.setString(4,objecto.getFECHAHORALL());
                sql.setString(5,objecto.getFECHAHORASA());
                ResultSet rs = sql.executeQuery();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "¡ERROR AL ACTUALIZAR!");
            }
            
        }
    
    public void eliminar (int id) throws Exception{
            CallableStatement sql = con.prepareCall("{call MANTE_DB.delete_datoss_mantenimiento(?)}");
            sql.setInt(1, id);
            sql.execute();
            sql.close();
        }
    
    
    public void MostrarRegistro(){
            String sql = "SELECT * FROM MANTENIMIENTO";
            
            DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
            
            try{
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        Object[] fila = new Object[5];
                        
                        fila[0] = rs.getString("IDMANTENIMIENTO");
                        fila[1] = rs.getString("PLACA");
                        fila[2] = rs.getString("DESCRIPCION");
                        fila[3] = rs.getString("FECHAHORALL");
                        fila[4] = rs.getString("FECHAHORASA");
                        
                        
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
                 
                 this.IDMANTENIMIENTO.setText(this.jTable1.getValueAt(fila, 0).toString().trim());
                 this.PLACA.setText(this.jTable1.getValueAt(fila, 1).toString().trim());
                 this.DESCRIPCION.setText(this.jTable1.getValueAt(fila, 2).toString().trim());
                 this.FECHAHORALL.setText(this.jTable1.getValueAt(fila, 3).toString().trim());
                 this.FECHAHORASA.setText(this.jTable1.getValueAt(fila,4).toString().trim());
                 
                
                 
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

        PLACA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        FECHAHORALL = new javax.swing.JTextField();
        DESCRIPCION = new javax.swing.JTextField();
        FECHAHORASA = new javax.swing.JTextField();
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
        IDMANTENIMIENTO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PLACA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLACAActionPerformed(evt);
            }
        });
        getContentPane().add(PLACA, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 59, 98, -1));

        jLabel1.setText("PLACA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 57, -1, -1));

        FECHAHORALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FECHAHORALLActionPerformed(evt);
            }
        });
        getContentPane().add(FECHAHORALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 165, 98, -1));

        DESCRIPCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESCRIPCIONActionPerformed(evt);
            }
        });
        getContentPane().add(DESCRIPCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 117, 98, -1));

        FECHAHORASA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FECHAHORASAActionPerformed(evt);
            }
        });
        getContentPane().add(FECHAHORASA, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 205, 98, -1));

        jLabel2.setText("DESCRIPCION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 117, 67, -1));

        jLabel3.setText("HORA LLEGADA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 167, 80, -1));

        jLabel4.setText("HORA SALIDA");
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
                "ID", "PLACA", "DESCRIPCION", "LLEGADA", "SALIDA"
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
        jLabel7.setText("MANTENIMIENTOS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 16, 234, -1));

        IDMANTENIMIENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDMANTENIMIENTOActionPerformed(evt);
            }
        });
        getContentPane().add(IDMANTENIMIENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 13, 53, -1));

        jLabel5.setText("ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 16, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 970, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PLACAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLACAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLACAActionPerformed

    private void FECHAHORALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FECHAHORALLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHAHORALLActionPerformed

    private void DESCRIPCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESCRIPCIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DESCRIPCIONActionPerformed

    private void FECHAHORASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FECHAHORASAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FECHAHORASAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.PLACA.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL VEHICULO");
            return;
        }

        if (this.DESCRIPCION.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL CLIENTE");
            return;
        }

        if (this.FECHAHORALL.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA PLACA DEL VEHICULO");
            return;
        }

        if (this.FECHAHORASA.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL MODELO DEL VEHICULO");
            return;
        }

    

        else{
            
            String placa = PLACA.getText();
            String des = DESCRIPCION.getText();
            String llegada = FECHAHORALL.getText();
            String salida = FECHAHORASA.getText();

            try{
                entidad.Registro_mantenimiento objectos = new Registro_mantenimiento(placa, des, llegada , salida);
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
            String sql =("{call MANTE_DB.actualizar_datos_mantenimiento(?,?,?,?,?)}");

            CallableStatement ps= cn.prepareCall(sql);
            ps.setInt(1, Integer.valueOf(IDMANTENIMIENTO.getText()));
            ps.setString(2, PLACA.getText());
            ps.setString(3, DESCRIPCION.getText());
           ps.setString(4, FECHAHORALL.getText());
            ps.setString(5, FECHAHORASA.getText());
            
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
            entidad.Registro_mantenimiento en = new Registro_mantenimiento();
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

    private void IDMANTENIMIENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDMANTENIMIENTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDMANTENIMIENTOActionPerformed

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
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                      new Mantenimiento().setVisible(true); 
                      
                }catch(SQLException ex){
                    Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null , ex);
                    
                }   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DESCRIPCION;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JTextField FECHAHORALL;
    private javax.swing.JTextField FECHAHORASA;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField IDMANTENIMIENTO;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField PLACA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarR;
    // End of variables declaration//GEN-END:variables
}
