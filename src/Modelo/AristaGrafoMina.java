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
public class AristaGrafoMina {
 
    private NodoGrafoMina nodoA;
    private Tunel aristaTunel;
    private NodoGrafoMina nodoB;

    public AristaGrafoMina(NodoGrafoMina nodoA, Tunel aristaTunel, NodoGrafoMina nodoB) {
        this.nodoA = nodoA;
        this.aristaTunel = aristaTunel;
        this.nodoB = nodoB;
    }

    
    
    public NodoGrafoMina getNodoA() {
        return nodoA;
    }

    public void setNodoA(NodoGrafoMina nodoA) {
        this.nodoA = nodoA;
    }

    public Tunel getAristaTunel() {
        return aristaTunel;
    }

    public void setAristaTunel(Tunel aristaTunel) {
        this.aristaTunel = aristaTunel;
    }

    public NodoGrafoMina getNodoB() {
        return nodoB;
    }

    public void setNodoB(NodoGrafoMina nodoB) {
        this.nodoB = nodoB;
    }
    
    
    
    
    
}
