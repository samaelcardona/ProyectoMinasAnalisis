/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author SAMAEL
 */
public class Tunel {
    
    private int idTunel;
    private double x1Tunel;// para que x1,x2,y1,????????????
    private double y1Tunel;
    private double x2Tunel;
    private double y2Tunel;
    private int anchoTunel;
    private int altoTunel;
    private ImageIcon imagenTunel;
    private Deposito depositoEnElTunel;
    private boolean esEntradaOSalida;
    private boolean tieneDeposito;
    private LinkedList<NodoGrafoMina> listadeNodosEnElTunel;

    
    public Tunel(int idTunel, double x1Tunel, double y1Tunel, double x2Tunel, double y2Tunel, int anchoTunel, int altoTunel, ImageIcon imagenTunel, Deposito depositoEnElTunel, boolean esEntradaOSalida, boolean tieneDeposito) {
        this.idTunel = idTunel;
        this.x1Tunel = x1Tunel;
        this.y1Tunel = y1Tunel;
        this.x2Tunel = x2Tunel;
        this.y2Tunel = y2Tunel;
        this.anchoTunel = anchoTunel;
        this.altoTunel = altoTunel;
        this.imagenTunel = imagenTunel;
        this.depositoEnElTunel = depositoEnElTunel;
        this.esEntradaOSalida = esEntradaOSalida;
        this.tieneDeposito = tieneDeposito;
        this.listadeNodosEnElTunel = new LinkedList<>();
    }

    public Tunel(){
        this.idTunel = 0;
        this.x1Tunel = 0;
        this.y1Tunel = 0;
        this.x2Tunel = 0;
        this.y2Tunel = 0;
        this.anchoTunel = 0;
        this.altoTunel = 0;
        this.imagenTunel = null;
        this.depositoEnElTunel = null;
        this.esEntradaOSalida = false;
        this.tieneDeposito = false;
        this.listadeNodosEnElTunel = new LinkedList<>();
    }

    
    
    public boolean isEsEntradaOSalida() {
        return esEntradaOSalida;
    }

    public void setEsEntradaOSalida(boolean esEntradaOSalida) {
        this.esEntradaOSalida = esEntradaOSalida;
    }
    
    public int getIdTunel() {
        return idTunel;
    }

    public void setIdTunel(int idTunel) {
        this.idTunel = idTunel;
    }

    public double getX1Tunel() {
        return x1Tunel;
    }

    public void setX1Tunel(double x1Tunel) {
        this.x1Tunel = x1Tunel;
    }

    public double getY1Tunel() {
        return y1Tunel;
    }

    public void setY1Tunel(double y1Tunel) {
        this.y1Tunel = y1Tunel;
    }

    public double getX2Tunel() {
        return x2Tunel;
    }

    public void setX2Tunel(double x2Tunel) {
        this.x2Tunel = x2Tunel;
    }

    public double getY2Tunel() {
        return y2Tunel;
    }

    public void setY2Tunel(double y2Tunel) {
        this.y2Tunel = y2Tunel;
    }

   

    public int getAnchoTunel() {
        return anchoTunel;
    }

    public void setAnchoTunel(int anchoTunel) {
        this.anchoTunel = anchoTunel;
    }

    public int getAltoTunel() {
        return altoTunel;
    }

    public void setAltoTunel(int altoTunel) {
        this.altoTunel = altoTunel;
    }

    public ImageIcon getImagenTunel() {
        return imagenTunel;
    }

    public void setImagenTunel(ImageIcon imagenTunel) {
        this.imagenTunel = imagenTunel;
    }

    public Deposito getDepositoEnElTunel() {
        return depositoEnElTunel;
    }

    public void setDepositoEnElTunel(Deposito depositoEnElTunel) {
        this.depositoEnElTunel = depositoEnElTunel;
    }

    public boolean isTieneDeposito() {
        return tieneDeposito;
    }

    public void setTieneDeposito(boolean tieneDeposito) {
        this.tieneDeposito = tieneDeposito;
    }

    public LinkedList<NodoGrafoMina> getListadeNodosEnElTunel() {
        return listadeNodosEnElTunel;
    }

    public void setListadeNodosEnElTunel(LinkedList<NodoGrafoMina> listadeNodosEnElTunel) {
        this.listadeNodosEnElTunel = listadeNodosEnElTunel;
    }
    
    
    
    
    
}
