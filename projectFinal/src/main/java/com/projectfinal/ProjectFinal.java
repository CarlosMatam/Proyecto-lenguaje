

package com.projectfinal;


import com.projectfinal.config.Conexion;
import com.projectfinal.view.PrincipalProject;
import java.util.List;



public class ProjectFinal {

    public static void main(String[] args) {
     /* Conexion cn = new Conexion();
      String query = "Select * from cliente";
     List rest = cn.getResult(query);
     
     for(Object e: rest){
         System.out.println(e.toString()); 
     }*/
      new PrincipalProject().setVisible(true);
    }
}
