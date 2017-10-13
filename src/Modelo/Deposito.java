/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;

/**
 *
 * @author SAMAEL
 */
public class Deposito {
    
    private int idDeposito;
    private int cantidadDeMineralDeposito;
    private LinkedList<Minero> listaDeMinerosEspecializadosEnDeposito;
    private LinkedList<Minero> listaDeMinerosComodinEnDeposito;
    private int xDeposito;
    private int yDeposito;
    private int anchoDeposito;
    private int altoDeposito;

    
    public Deposito(int idDeposito, int cantidadDeMineralDeposito, int xDeposito, int yDeposito, int anchoDeposito, int altoDeposito) {
        this.idDeposito = idDeposito;
        this.cantidadDeMineralDeposito = cantidadDeMineralDeposito;
        this.listaDeMinerosEspecializadosEnDeposito = new  LinkedList<>();
        this.listaDeMinerosComodinEnDeposito = new  LinkedList<>();
        this.xDeposito = xDeposito;
        this.yDeposito = yDeposito;
        this.anchoDeposito = anchoDeposito;
        this.altoDeposito = altoDeposito;
    }

 
    
    
    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    public int getCantidadDeMineralDeposito() {
        return cantidadDeMineralDeposito;
    }

    public void setCantidadDeMineralDeposito(int cantidadDeMineralDeposito) {
        this.cantidadDeMineralDeposito = cantidadDeMineralDeposito;
    }

    public LinkedList<Minero> getListaDeMinerosEspecializadosEnDeposito() {
        return listaDeMinerosEspecializadosEnDeposito;
    }

    public void setListaDeMinerosEspecializadosEnDeposito(LinkedList<Minero> listaDeMinerosEspecializadosEnDeposito) {
        this.listaDeMinerosEspecializadosEnDeposito = listaDeMinerosEspecializadosEnDeposito;
    }

    public LinkedList<Minero> getListaDeMinerosComodinEnDeposito() {
        return listaDeMinerosComodinEnDeposito;
    }

    public void setListaDeMinerosComodinEnDeposito(LinkedList<Minero> listaDeMinerosComodinEnDeposito) {
        this.listaDeMinerosComodinEnDeposito = listaDeMinerosComodinEnDeposito;
    }

    public int getxDeposito() {
        return xDeposito;
    }

    public void setxDeposito(int xDeposito) {
        this.xDeposito = xDeposito;
    }

    public int getyDeposito() {
        return yDeposito;
    }

    public void setyDeposito(int yDeposito) {
        this.yDeposito = yDeposito;
    }

    public int getAnchoDeposito() {
        return anchoDeposito;
    }

    public void setAnchoDeposito(int anchoDeposito) {
        this.anchoDeposito = anchoDeposito;
    }

    public int getAltoDeposito() {
        return altoDeposito;
    }

    public void setAltoDeposito(int altoDeposito) {
        this.altoDeposito = altoDeposito;
    }
    
    
    
}
