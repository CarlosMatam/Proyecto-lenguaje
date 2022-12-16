/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author carlo
 */
public class Registro_auto {
   int IDVEHICULO;
   int ID_CLIENTE;
   String PLACA;
   String MODELO;
   String MARCA;
   String TIPOVEHICULO;
   
   public Registro_auto(){
    
}

    public Registro_auto(int IDVEHICULO, int ID_CLIENTE, String PLACA, String MODELO, String MARCA, String TIPOVEHICULO) {
        this.IDVEHICULO = IDVEHICULO;
        this.ID_CLIENTE = ID_CLIENTE;
        this.PLACA = PLACA;
        this.MODELO = MODELO;
        this.MARCA = MARCA;
        this.TIPOVEHICULO = TIPOVEHICULO;
    }

    public int getIDVEHICULO() {
        return IDVEHICULO;
    }

    public void setIDVEHICULO(int IDVEHICULO) {
        this.IDVEHICULO = IDVEHICULO;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getTIPOVEHICULO() {
        return TIPOVEHICULO;
    }

    public void setTIPOVEHICULO(String TIPOVEHICULO) {
        this.TIPOVEHICULO = TIPOVEHICULO;
    }

    @Override
    public String toString() {
        return "registro_auto{" + "IDVEHICULO=" + IDVEHICULO + ", ID_CLIENTE=" + ID_CLIENTE + ", PLACA=" + PLACA + ", MODELO=" + MODELO + ", MARCA=" + MARCA + ", TIPOVEHICULO=" + TIPOVEHICULO + '}';
    }
    
}
