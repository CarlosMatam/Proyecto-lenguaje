/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author carlo
 */
public class Registro_direccion {
    int IDDIRECCION;
    int ID_CLIENTE;
    String DOMICILIO;
    int IDPROVINCIA;
    int IDCANTON;
    int IDDISTRITO;
    
    
    
    public Registro_direccion(){
}

    public Registro_direccion(int ID_CLIENTE, String DOMICILIO, int IDPROVINCIA, int IDCANTON, int IDDISTRITO) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.DOMICILIO = DOMICILIO;
        this.IDPROVINCIA = IDPROVINCIA;
        this.IDCANTON = IDCANTON;
        this.IDDISTRITO = IDDISTRITO;
    }

    

    public int getIDDIRECCION() {
        return IDDIRECCION;
    }

    public void setIDDIRECCION(int IDDIRECCION) {
        this.IDDIRECCION = IDDIRECCION;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public String getDOMICILIO() {
        return DOMICILIO;
    }

    public void setDOMICILIO(String DOMICILIO) {
        this.DOMICILIO = DOMICILIO;
    }

    public int getIDPROVINCIA() {
        return IDPROVINCIA;
    }

    public void setIDPROVINCIA(int IDPROVINCIA) {
        this.IDPROVINCIA = IDPROVINCIA;
    }

    public int getIDCANTON() {
        return IDCANTON;
    }

    public void setIDCANTON(int IDCANTON) {
        this.IDCANTON = IDCANTON;
    }

    public int getIDDISTRITO() {
        return IDDISTRITO;
    }

    public void setIDDISTRITO(int IDDISTRITO) {
        this.IDDISTRITO = IDDISTRITO;
    }

    @Override
    public String toString() {
        return "Registro_direccion{" + "IDDIRECCION=" + IDDIRECCION + ", ID_CLIENTE=" + ID_CLIENTE + ", DOMICILIO=" + DOMICILIO + ", IDPROVINCIA=" + IDPROVINCIA + ", IDCANTON=" + IDCANTON + ", IDDISTRITO=" + IDDISTRITO + '}';
    }
    
    
    
}
