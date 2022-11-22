/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projectfinal.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Connection conn = null;
    private static String usuario= "hr";
    private static String contraseña= "18476189";
    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url,usuario,contraseña);
            if (conn != null) {
                System.out.println("Conexion Exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Conexion Erronea " + e.getMessage());
        }
        return conn;
    }
    
  
    
}
