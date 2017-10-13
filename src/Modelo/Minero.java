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
public class Minero {
    
    private int idMinero;
    private String EspecialidadDelMinero; ///plata, oro, bronce, comodin
    private double gananciaMinero;
    private int velocidadMinero;
    private boolean estadoMineroActivo;
    private int cantidadDeMineralExtraido;
    private int xMinero;
    private int yMinero;
    private int anchoMinero;
    private int altoMinero;

    public Minero(int idMinero, String EspecialidadDelMinero, boolean estadoMineroActivo, int xMinero, int yMinero, int anchoMinero, int altoMinero) {
        this.idMinero = idMinero;
        this.EspecialidadDelMinero = EspecialidadDelMinero;
        this.estadoMineroActivo = estadoMineroActivo;
        this.xMinero = xMinero;
        this.yMinero = yMinero;
        this.anchoMinero = anchoMinero;
        this.altoMinero = altoMinero;
    }

    

    public int getIdMinero() {
        return idMinero;
    }

    public void setIdMinero(int idMinero) {
        this.idMinero = idMinero;
    }

    public String getEspecialidadDelMinero() {
        return EspecialidadDelMinero;
    }

    public void setEspecialidadDelMinero(String EspecialidadDelMinero) {
        this.EspecialidadDelMinero = EspecialidadDelMinero;
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
