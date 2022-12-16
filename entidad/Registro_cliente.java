/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author carlo
 */
public class Registro_cliente {
   int ID_CLIENTE;
   String CEDULA;
   String NOMBRE;
   String APELLIDO;
   
   
   public Registro_cliente(){   
   }

    public Registro_cliente(String CEDULA, String NOMBRE, String APELLIDO) {
        this.CEDULA = CEDULA;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
        this.CEDULA = CEDULA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    @Override
    public String toString() {
        return "Registro_cliente{" + "ID_CLIENTE=" + ID_CLIENTE + ", CEDULA=" + CEDULA + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + '}';
    }
   
   
   
   
}
