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
public class Minero {
    
    private int idMinero;//identificacion del minero
    private String especialidadDelMinero; ///plata, oro, bronce, comodin
    private double gananciaMinero;//esto se va sumando dependiendo del tiempo laborado y el mineral
    private int velocidadMinero;//tiempo en que tarda en extraer mineral, igual numero para todos
    private boolean estadoMineroActivo;//si esta enfermo o incapacitado sera activo o no
    private int cantidadDeMineralExtraido;//dependiendo de lo laborado
    private int xMinero;//posicion x
    private int yMinero;//posicion y
    private int anchoMinero;// ancho minero
    private int altoMinero;// alto minero
    private ImageIcon imagen;//imagen del minero
    private boolean mover;//Si se puede mover o no
    private int capacidadCarga;
    private int cargaDeMineral;//carga que lleva del mineral
    private Deposito depositoActual;
    private LinkedList<String> rutaDeNodosAvisitar;//ruta de los nodos visitar .. los agrego .addlast.. y los elimino y visito . getfirst
    private NodoGrafoMina nodoA;
    private NodoGrafoMina nodoB;
    ///Crear lista para guardar ruta del minero revisar proyecto pasado! 
    

    public Minero(int idMinero, String especialidadDelMinero, int xMinero, int yMinero, int anchoMinero, int altoMinero,String rutaImagen,int capacidadCarga) {
        this.idMinero = idMinero;
        this.especialidadDelMinero = especialidadDelMinero;
        this.xMinero = xMinero;
        this.yMinero = yMinero;
        this.anchoMinero = anchoMinero;
        this.altoMinero = altoMinero;
        this.imagen=new ImageIcon(getClass().getResource(rutaImagen));
        //colocar las variables estaticas
        this.mover=true;
        this.estadoMineroActivo=true;
        this.gananciaMinero=0;
        this.velocidadMinero=10;
        this.cantidadDeMineralExtraido=0;
        this.capacidadCarga=capacidadCarga;
        this.depositoActual=new Deposito(0, 0, 0, 0, 0, 0);
        this.rutaDeNodosAvisitar=new LinkedList<>();
        this.nodoA=new NodoGrafoMina("", 0, 0, 0, 0);
        this.nodoB=new NodoGrafoMina("", 0, 0, 0, 0);
        
        
    }

    public int getCargaDeMineral() {
        return cargaDeMineral;
    }

    public void setCargaDeMineral(int cargaDeMineral) {
        this.cargaDeMineral = cargaDeMineral;
    }

    public Deposito getDepositoActual() {
        return depositoActual;
    }

    public void setDepositoActual(Deposito depositoActual) {
        this.depositoActual = depositoActual;
    }

    public LinkedList<String> getRutaDeNodosAvisitar() {
        return rutaDeNodosAvisitar;
    }

    public void setRutaDeNodosAvisitar(LinkedList<String> rutaDeNodosAvisitar) {
        this.rutaDeNodosAvisitar = rutaDeNodosAvisitar;
    }

    public NodoGrafoMina getNodoA() {
        return nodoA;
    }

    public void setNodoA(NodoGrafoMina nodoA) {
        this.nodoA = nodoA;
    }

    public NodoGrafoMina getNodoB() {
        return nodoB;
    }

    public void setNodoB(NodoGrafoMina nodoB) {
        this.nodoB = nodoB;
    }

    
    
    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    
    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }

    public int getIdMinero() {
        return idMinero;
    }

    public void setIdMinero(int idMinero) {
        this.idMinero = idMinero;
    }

    public String getEspecialidadDelMinero() {
        return especialidadDelMinero;
    }

    public void setEspecialidadDelMinero(String especialidadDelMinero) {
        this.especialidadDelMinero = especialidadDelMinero;
    }

    public double getGananciaMinero() {
        return gananciaMinero;
    }

    public void setGananciaMinero(double gananciaMinero) {
        this.gananciaMinero = gananciaMinero;
    }

    public int getVelocidadMinero() {
        return velocidadMinero;
    }

    public void setVelocidadMinero(int velocidadMinero) {
        this.velocidadMinero = velocidadMinero;
    }

    public boolean isEstadoMineroActivo() {
        return estadoMineroActivo;
    }

    public void setEstadoMineroActivo(boolean estadoMineroActivo) {
        this.estadoMineroActivo = estadoMineroActivo;
    }

    public int getCantidadDeMineralExtraido() {
        return cantidadDeMineralExtraido;
    }

    public void setCantidadDeMineralExtraido(int cantidadDeMineralExtraido) {
        this.cantidadDeMineralExtraido = cantidadDeMineralExtraido;
    }

    public int getxMinero() {
        return xMinero;
    }

    public void setxMinero(int xMinero) {
        this.xMinero = xMinero;
    }

    public int getyMinero() {
        return yMinero;
    }

    public void setyMinero(int yMinero) {
        this.yMinero = yMinero;
    }

    public int getAnchoMinero() {
        return anchoMinero;
    }

    public void setAnchoMinero(int anchoMinero) {
        this.anchoMinero = anchoMinero;
    }

    public int getAltoMinero() {
        return altoMinero;
    }

    public void setAltoMinero(int altoMinero) {
        this.altoMinero = altoMinero;
    }

    
    
    
    
    
    
    
}
