/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    ///Crear lista para guardar ruta del minero revisar proyecto pasado! 
    

    public Minero(int idMinero, String especialidadDelMinero, int xMinero, int yMinero, int anchoMinero, int altoMinero,String rutaImagen) {
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
        this.capacidadCarga=6;
        
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
