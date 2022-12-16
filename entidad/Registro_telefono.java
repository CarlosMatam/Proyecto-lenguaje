/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author carlo
 */
public class Registro_telefono {
    int ID_CLIENTE;
    String ID_TELEFONO;
    String NUMERO;
    
    public Registro_telefono(){
    }

    public String getID_TELEFONO() {
        return ID_TELEFONO;
    }

    public void setID_TELEFONO(String ID_TELEFONO) {
        this.ID_TELEFONO = ID_TELEFONO;
    }
    
    

    public Registro_telefono(int ID_CLIENTE, String NUMERO) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.NUMERO = NUMERO;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    @Override
    public String toString() {
        return "Registro_telefono{" + "ID_CLIENTE=" + ID_CLIENTE + ", ID_TELEFONO=" + ID_TELEFONO + ", NUMERO=" + NUMERO + '}';
    }

   
    
    
    
    
}
