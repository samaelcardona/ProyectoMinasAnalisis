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
public class MinaGrafo {
    
    private int idMina;
    private String mineralEnLaMina;
    private LinkedList<Minero> listaDeMinerosEspecializadosEnMina;
    private LinkedList<Minero> listaDeMinerosComodinsEnMina;
    private LinkedList<Tunel> listaTunelesMina;
    private LinkedList<AristaGrafoMina> listaDeAristasGrafoMina;
    private LinkedList<NodoGrafoMina> listaDeNodosGrafoMina;
    private Tunel [][] matrizTuneles;
    private double costoMina;

    public MinaGrafo(int idMina, String mineralEnLaMina, Tunel[][] matrizTuneles) {
        this.idMina = idMina;
        this.mineralEnLaMina = mineralEnLaMina;
        this.matrizTuneles = matrizTuneles;
        this.idMina = idMina;
        this.mineralEnLaMina = mineralEnLaMina;
        this.listaDeMinerosEspecializadosEnMina = new LinkedList<>();
        this.listaDeMinerosComodinsEnMina = new LinkedList<>();
        this.listaTunelesMina = new LinkedList<>();
        this.listaDeAristasGrafoMina = new LinkedList<>();
        this.listaDeNodosGrafoMina = new LinkedList<>();
        this.matrizTuneles = new Tunel[20][10];
        this.costoMina=0;
    }

    
    
    public double getCostoMina() {
        return costoMina;
    }

    public void setCostoMina(double costoMina) {
        this.costoMina = costoMina;
    }

    
    public int getIdMina() {
        return idMina;
    }

    public void setIdMina(int idMina) {
        this.idMina = idMina;
    }

    public String getMineralEnLaMina() {
        return mineralEnLaMina;
    }

    public void setMineralEnLaMina(String mineralEnLaMina) {
        this.mineralEnLaMina = mineralEnLaMina;
    }

    public LinkedList<Minero> getListaDeMinerosEspecializadosEnMina() {
        return listaDeMinerosEspecializadosEnMina;
    }

    public void setListaDeMinerosEspecializadosEnMina(LinkedList<Minero> listaDeMinerosEspecializadosEnMina) {
        this.listaDeMinerosEspecializadosEnMina = listaDeMinerosEspecializadosEnMina;
    }

    public LinkedList<Minero> getListaDeMinerosComodinsEnMina() {
        return listaDeMinerosComodinsEnMina;
    }

    public void setListaDeMinerosComodinsEnMina(LinkedList<Minero> listaDeMinerosComodinsEnMina) {
        this.listaDeMinerosComodinsEnMina = listaDeMinerosComodinsEnMina;
    }

    public LinkedList<Tunel> getListaTunelesMina() {
        return listaTunelesMina;
    }

    public void setListaTunelesMina(LinkedList<Tunel> listaTunelesMina) {
        this.listaTunelesMina = listaTunelesMina;
    }

    public LinkedList<AristaGrafoMina> getListaDeAristasGrafoMina() {
        return listaDeAristasGrafoMina;
    }

    public void setListaDeAristasGrafoMina(LinkedList<AristaGrafoMina> listaDeAristasGrafoMina) {
        this.listaDeAristasGrafoMina = listaDeAristasGrafoMina;
    }

    public LinkedList<NodoGrafoMina> getListaDeNodosGrafoMina() {
        return listaDeNodosGrafoMina;
    }

    public void setListaDeNodosGrafoMina(LinkedList<NodoGrafoMina> listaDeNodosGrafoMina) {
        this.listaDeNodosGrafoMina = listaDeNodosGrafoMina;
    }

    public Tunel[][] getMatrizTuneles() {
        return matrizTuneles;
    }

    public void setMatrizTuneles(Tunel[][] matrizTuneles) {
        this.matrizTuneles = matrizTuneles;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
