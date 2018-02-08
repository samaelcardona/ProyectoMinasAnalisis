/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SAMAEL
 */
public class ValorCola {
    
     int idNodo;
    int padre;
    int costo;

    public ValorCola(int idNodo,int padre, int costo) {
        this.idNodo = idNodo;
        this.padre=padre;
        this.costo = costo;
        
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }
    
}
