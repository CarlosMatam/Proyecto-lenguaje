/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author carlo
 */
public class Registro_mantenimiento {
    int IDMANTENIMIENTO;
    String PLACA;
    String DESCRIPCION;
    String FECHAHORALL;
    String FECHAHORASA;
    
    
    public Registro_mantenimiento(){  
    }

    public Registro_mantenimiento(String PLACA, String DESCRIPCION, String FECHAHORALL, String FECHAHORASA) {
        this.PLACA = PLACA;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHAHORALL = FECHAHORALL;
        this.FECHAHORASA = FECHAHORASA;
    }

    public int getIDMANTENIMIENTO() {
        return IDMANTENIMIENTO;
    }

    public void setIDMANTENIMIENTO(int IDMANTENIMIENTO) {
        this.IDMANTENIMIENTO = IDMANTENIMIENTO;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getFECHAHORALL() {
        return FECHAHORALL;
    }

    public void setFECHAHORALL(String FECHAHORALL) {
        this.FECHAHORALL = FECHAHORALL;
    }

    public String getFECHAHORASA() {
        return FECHAHORASA;
    }

    public void setFECHAHORASA(String FECHAHORASA) {
        this.FECHAHORASA = FECHAHORASA;
    }

    @Override
    public String toString() {
        return "Registro_mantenimiento{" + "IDMANTENIMIENTO=" + IDMANTENIMIENTO + ", PLACA=" + PLACA + ", DESCRIPCION=" + DESCRIPCION + ", FECHAHORALL=" + FECHAHORALL + ", FECHAHORASA=" + FECHAHORASA + '}';
    }
    
    
}
