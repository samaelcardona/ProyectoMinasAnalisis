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
public class NodoGrafoMina {
    
    private int idNodoGrafoMina;
    private int xNodoGrafoMina;
    private int yNOdoGrafoMina;
    private int anchoNodoGrafoMina;
    private int altoNodoGrafoMina;

    //todos los nodos con el mismo ancho y alto cambiar entonces cambio en el construcctor
    public NodoGrafoMina(int idNodoGrafoMina, int xNodoGrafoMina, int yNOdoGrafoMina, int anchoNodoGrafoMina, int altoNodoGrafoMina) {
        this.idNodoGrafoMina = idNodoGrafoMina;
        this.xNodoGrafoMina = xNodoGrafoMina;
        this.yNOdoGrafoMina = yNOdoGrafoMina;
        this.anchoNodoGrafoMina = anchoNodoGrafoMina;
        this.altoNodoGrafoMina = altoNodoGrafoMina;
    }

    
    
    public int getIdNodoGrafoMina() {
        return idNodoGrafoMina;
    }

    public void setIdNodoGrafoMina(int idNodoGrafoMina) {
        this.idNodoGrafoMina = idNodoGrafoMina;
    }

    public int getxNodoGrafoMina() {
        return xNodoGrafoMina;
    }

    public void setxNodoGrafoMina(int xNodoGrafoMina) {
        this.xNodoGrafoMina = xNodoGrafoMina;
    }

    public int getyNOdoGrafoMina() {
        return yNOdoGrafoMina;
    }

    public void setyNOdoGrafoMina(int yNOdoGrafoMina) {
        this.yNOdoGrafoMina = yNOdoGrafoMina;
    }

    public int getAnchoNodoGrafoMina() {
        return anchoNodoGrafoMina;
    }

    public void setAnchoNodoGrafoMina(int anchoNodoGrafoMina) {
        this.anchoNodoGrafoMina = anchoNodoGrafoMina;
    }

    public int getAltoNodoGrafoMina() {
        return altoNodoGrafoMina;
    }

    public void setAltoNodoGrafoMina(int altoNodoGrafoMina) {
        this.altoNodoGrafoMina = altoNodoGrafoMina;
    }
    
    
    
}
