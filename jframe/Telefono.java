/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import conexion.Conexion;


import entidad.Registro_telefono;
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
public class Telefono extends javax.swing.JFrame {
    private Connection con;
    int id;
    private DefaultTableModel tabla;
    
    
    public Telefono()throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConnection();
        Registro_telefono objecto = new Registro_telefono();
        MostrarRegistro();
        TIPOTELEFONO.setEnabled(false);
    }
    
       public void reiniciarTexto() {
       
        ID_CLIENTE.setText("");
        NUMERO.setText("");
        TIPOTELEFONO.setText("");
       
        
        
    }
       
       public void insertar ( Registro_telefono objecto) throws SQLException{
        CallableStatement sql = con.prepareCall("{call TELEFONO_DB.ingresar_telefonos(?,?)}");
        
            try{
                sql.setInt(1, objecto.getID_CLIENTE());
                sql.setString(2, objecto.getNUMERO());
                ResultSet rs = sql.executeQuery();
                JOptionPane.showMessageDialog(null, "¡INGRESADOS DE MANERA CORRECTA!");
                reiniciarTexto();
                rs.close();
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR"+ex);
            }
    }
       
       public void actualizar(Registro_telefono objecto) throws SQLException{
            CallableStatement sql = con.prepareCall("{call TELEFONO_DB.actualizar_datoss_telefonos(?,?,?)}");
            try{
                sql.setString(1,objecto.getID_TELEFONO());
                sql.setInt(2,objecto.getID_CLIENTE());
                sql.setString(3,objecto.getNUMERO());
                ResultSet rs = sql.executeQuery();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "¡ERROR AL ACTUALIZAR!");
            }
            
        }
       
        public void eliminar (int id) throws Exception{
            CallableStatement sql = con.prepareCall("{call TELEFONO_DB.delete_datoss_telefonos(?)}");
            sql.setInt(1, id);
            sql.execute();
            sql.close();
        }
        
        public void MostrarRegistro(){
            String sql = "SELECT * FROM TELEFONOS";
            
            DefaultTableModel tabla = (DefaultTableModel) this.jTable1.getModel();
            
            try{
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        Object[] fila = new Object[3];
                        
                        fila[0] = rs.getString("ID_TELEFONO");
                        fila[1] = rs.getString("ID_CLIENTE");
                        fila[2] = rs.getString("NUMERO");
                     
                        
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
                 
                 this.TIPOTELEFONO.setText(this.jTable1.getValueAt(fila, 0).toString().trim());
                 this.ID_CLIENTE.setText(this.jTable1.getValueAt(fila, 1).toString().trim());
                 this.NUMERO.setText(this.jTable1.getValueAt(fila, 2).toString().trim());
         
                
                 
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

        TIPOTELEFONO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        NUMERO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MODIFICAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        limpiarR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ID_CLIENTE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TIPOTELEFONO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIPOTELEFONOActionPerformed(evt);
            }
        });

        jLabel1.setText("NUMERO REGISTRADO NUM");

        NUMERO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMEROActionPerformed(evt);
            }
        });

        jLabel2.setText("NUMERO");

        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_TELEFONO", "ID_CLIENTE", "NUMERO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        MODIFICAR.setText("MODIFICAR");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });

        ELIMINAR.setText("ELIMINAR");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });

        limpiarR.setText("Limpiar-Registro");
        limpiarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarRActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("TELEFONOS CLIENTES");

        ID_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_CLIENTEActionPerformed(evt);
            }
        });

        jLabel4.setText("ID-CLIENTE");

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Proyecto-lenguaje.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TIPOTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(724, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(520, 520, 520)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(ID_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(limpiarR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(372, 372, 372)
                            .addComponent(MODIFICAR))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(499, 499, 499)
                            .addComponent(ELIMINAR))
                        .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TIPOTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(ID_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(346, 346, 346)
                            .addComponent(limpiarR))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(346, 346, 346)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(346, 346, 346)
                            .addComponent(MODIFICAR))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(346, 346, 346)
                            .addComponent(ELIMINAR))
                        .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TIPOTELEFONOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIPOTELEFONOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIPOTELEFONOActionPerformed

    private void NUMEROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMEROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NUMEROActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.ID_CLIENTE.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR EL ID DEL CLIENTE");
            return;
        }

        if (this.NUMERO.getText().trim() ==""){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR NUMERO DEL CLIENTE");
            return;
        }

      

        else{
            int id_cliente = Integer.parseInt(ID_CLIENTE.getText());
            String numero = NUMERO.getText();
          

            try{
                entidad.Registro_telefono objectos = new Registro_telefono(id_cliente, numero);
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
            String sql =("{call TELEFONO_DB.actualizar_datoss_telefonos(?,?,?)}");

            CallableStatement ps= cn.prepareCall(sql);
            ps.setString(1, TIPOTELEFONO.getText());
            ps.setString(2, ID_CLIENTE.getText());
            ps.setString(3, NUMERO.getText());
           

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
            entidad.Registro_telefono en = new Registro_telefono();
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
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try{
                      new Telefono().setVisible(true); 
                      
                }catch(SQLException ex){
                    Logger.getLogger(Autos.class.getName()).log(Level.SEVERE, null , ex);
                    
                }   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField ID_CLIENTE;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField NUMERO;
    private javax.swing.JTextField TIPOTELEFONO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiarR;
    // End of variables declaration//GEN-END:variables
}