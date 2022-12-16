/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import conexion.Conexion;
import entidad.Registro_auto;
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

public class Autos extends javax.swing.JFrame {
    
    private Connection con;
    int id;
    private DefaultTableModel tabla;
 
    public Autos() throws SQLException{
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConnection();
        Registro_auto objecto = new Registro_auto();
        MostrarRegistro();
        
    }
     public void reiniciarTexto() {
       
        IDCLIENTE.setText("");
        IDVEHICULO.setText("");
        MARCA.setText("");
        MODELO.setText("");
        PLACA.setText("");
        TIPOVEHICULO.setText("");
        
    }

    
    public void insertar ( Registro_auto objecto) throws SQLException{
        CallableStatement sql = con.prepareCall("{call AUTOS_DB.INSERTAR_AUTO(?,?,?,?,?,?)}");
        
            try{
                sql.setInt(1, objecto.getIDVEHICULO());
                sql.setInt(2, objecto.getID_CLIENTE());
                sql.setString(3, objecto.getMARCA());
                sql.setString(4, objecto.getMODELO());
                sql.setString(5, objecto.getPLACA());
                sql.setString(6, objecto.getTIPOVEHICULO());
            
                JOptionPane.showMessageDialog(null, "¡INGRESADOS DE MANERA CORRECTA!");
                ResultSet rs = sql.executeQuery();
                reiniciarTexto();
                rs.close();
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+ex);
            }
    }
    
        public void actualizar(Registro_auto objecto) throws SQLException{
            CallableStatement sql = con.prepareCall("{call AUTOS_DB.MODIFICAR_AUTO(?,?,?,?,?,?)}");
            try{
                sql.setInt(1,objecto.getIDVEHICULO());
                sql.setInt(2,objecto.getID_CLIENTE());
                sql.setString(3,objecto.getPLACA());
                sql.setString(4,objecto.getMODELO());
                sql.setString(5,objecto.getMARCA());
                sql.setString(6,objecto.getTIPOVEHICULO());
                ResultSet rs = sql.executeQuery();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "¡ERROR AL ACTUALIZAR!");
            }
            
        }
        
        public void eliminar (int id) throws Exception{
            CallableStatement sql = con.prepareCall("{call AUTOS_DB.ELIMINAR_AUTO(?)}");
            sql.setInt(1, id);
            sql.execute();
            sql.close();
        }
        
        
        public void MostrarRegistro(){
            String sql = "SELECT * FROM VEHICULO";
            
            DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
            
            try{
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        Object[] fila = new Object[6];
                        fila[0] = rs.getString("IDVEHICULO");
                        fila[1] = rs.getString("ID_CLIENTE");
                        fila[2] = rs.getString("PLACA");
                        fila[3] = rs.getString("MODELO");
                        fila[4] = rs.getString("MARCA");
                        fila[5] = rs.getString("TIPOVEHICULO");
                        
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
                 this.IDVEHICULO.setText(this.jTable1.getValueAt(fila, 0).toString().trim());
                 this.IDCLIENTE.setText(this.jTable1.getValueAt(fila, 1).toString().trim());
                 this.PLACA.setText(this.jTable1.getValueAt(fila, 2).toString().trim());
                 this.MODELO.setText(this.jTable1.getValueAt(fila,3).toString().trim());
                 this.MARCA.setText(this.jTable1.getValueAt(fila,4).toString().trim());
                 this.TIPOVEHICULO.setText(this.jTable1.getValueAt(fila,5).toString().trim());
                 
             }
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDVEHICULO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PLACA = new javax.swing.JTextField();
        IDCLIENTE = new javax.swing.JTextField();
        MODELO = new javax.swing.JTextField();
        MARCA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TIPOVEHICULO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MODIFICAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        limpiarR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        IDVEHICULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDVEHICULOActionPerformed(evt);
            }
        });
        getContentPane().add(IDVEHICULO);
        IDVEHICULO.setBounds(110, 50, 98, 22);

        jLabel1.setText("IDVEHICULO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 67, 16);

        PLACA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLACAActionPerformed(evt);
            }
        });
        getContentPane().add(PLACA);
        PLACA.setBounds(110, 160, 98, 22);

        IDCLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCLIENTEActionPerformed(evt);
            }
        });
        getContentPane().add(IDCLIENTE);
        IDCLIENTE.setBounds(110, 110, 98, 22);

        MODELO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODELOActionPerformed(evt);
            }
        });
        getContentPane().add(MODELO);
        MODELO.setBounds(110, 200, 98, 22);

        MARCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MARCAActionPerformed(evt);
            }
        });
        getContentPane().add(MARCA);
        MARCA.setBounds(110, 240, 98, 22);

        jLabel2.setText("IDCLIENTE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 110, 67, 16);

        jLabel3.setText("PLACA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 160, 67, 16);

        jLabel4.setText("MODELO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 201, 59, 16);

        jLabel5.setText("MARCA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 240, 59, 16);

        TIPOVEHICULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIPOVEHICULOActionPerformed(evt);
            }
        });
        getContentPane().add(TIPOVEHICULO);
        TIPOVEHICULO.setBounds(110, 280, 98, 22);

        jLabel6.setText("TIPOVEHICULO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 280, 81, 16);

        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(251, 339, 87, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-VEHICULO", "ID-CLIENTE", "PLACA", "MODELO", "MARCA", "TIPO-VEHICULO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(251, 32, 621, 229);

        MODIFICAR.setText("MODIFICAR");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR);
        MODIFICAR.setBounds(369, 339, 95, 25);

        ELIMINAR.setText("ELIMINAR");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINAR);
        ELIMINAR.setBounds(496, 339, 85, 25);

        limpiarR.setText("Limpiar-Registro");
        limpiarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarRActionPerformed(evt);
            }
        });
        getContentPane().add(limpiarR);
        limpiarR.setBounds(607, 339, 150, 25);

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("VEHICULOS INGRESADOS EN EL TALLER");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(450, 10, 234, 16);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(-3, -7, 960, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDVEHICULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDVEHICULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDVEHICULOActionPerformed

    private void PLACAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLACAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLACAActionPerformed

    private void IDCLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCLIENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCLIENTEActionPerformed

    private void MODELOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODELOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MODELOActionPerformed

    private void MARCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MARCAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MARCAActionPerformed

    private void TIPOVEHICULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIPOVEHICULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIPOVEHICULOActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.IDVEHICULO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL VEHICULO");
            return;
        }
        
         if (this.IDCLIENTE.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL CLIENTE");
            return;
        }
         
         if (this.PLACA.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA PLACA DEL VEHICULO");
            return;
        }
         
         if (this.MODELO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL MODELO DEL VEHICULO");
            return;
        }
         
          if (this.MARCA.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA MARCA DEL VEHICULO");
            return;
        }
          
           if (this.TIPOVEHICULO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL TIPO DE VEHICULO");
            return;
        }
           else{
               int id_vehiculo = Integer.parseInt(IDVEHICULO.getText());
               int id_cliente = Integer.parseInt(IDCLIENTE.getText());
               String placa = PLACA.getText();
               String modelo = MODELO.getText();
               String marca = MARCA.getText();
               String tipo = TIPOVEHICULO.getText();
               
               try{
                   entidad.Registro_auto objectos = new Registro_auto(id_vehiculo , id_cliente, placa, modelo , marca ,tipo);
                   insertar(objectos);
                   reiniciarTexto();
                   limpiar_tabla();
                   MostrarRegistro();
                   
                   
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(rootPane, "ERRORR");
               }
               
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        // TODO add your handling code here:
        try{
             Connection cn= Conexion.getConnection();
             String sql =("{call AUTOS_DB.MODIFICAR_AUTO(?,?,?,?,?,?)}");
             
             CallableStatement ps= cn.prepareCall(sql);
             ps.setInt(1, Integer.valueOf(IDVEHICULO.getText()));
             ps.setInt(2, Integer.valueOf(IDCLIENTE.getText()));
             ps.setString(3, PLACA.getText());
             ps.setString(4, MODELO.getText());
             ps.setString(5, MARCA.getText());
             ps.setString(6, TIPOVEHICULO.getText());
             
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        cargo_seleccionado(); 
    }//GEN-LAST:event_jTable1MouseClicked

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        // TODO add your handling code here:
        try{
        id = Integer.parseInt(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
        eliminar(id);
        entidad.Registro_auto en = new Registro_auto();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                      new Autos().setVisible(true); 
                      
                }catch(SQLException ex){
                    Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null , ex);
                    
                }   
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField IDCLIENTE;
    private javax.swing.JTextField IDVEHICULO;
    private javax.swing.JTextField MARCA;
    private javax.swing.JTextField MODELO;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField PLACA;
    private javax.swing.JTextField TIPOVEHICULO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarR;
    // End of variables declaration//GEN-END:variables
}
