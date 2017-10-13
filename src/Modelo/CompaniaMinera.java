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
public class CompaniaMinera {
    
    private int idCompania;
    private String nombreCompania;
    private LinkedList<Minero> listaDeMineros;
    private LinkedList<MinaGrafo> listaDeMinas;

    public CompaniaMinera(int idCompania, String nombreCompania) {
        this.idCompania = idCompania;
        this.nombreCompania = nombreCompania;
        this.listaDeMineros = new  LinkedList<>();
        this.listaDeMinas = new  LinkedList<>();
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public LinkedList<Minero> getListaDeMineros() {
        return listaDeMineros;
    }

    public void setListaDeMineros(LinkedList<Minero> listaDeMineros) {
        this.listaDeMineros = listaDeMineros;
    }

    public LinkedList<MinaGrafo> getListaDeMinas() {
        return listaDeMinas;
    }

    public void setListaDeMinas(LinkedList<MinaGrafo> listaDeMinas) {
        this.listaDeMinas = listaDeMinas;
    }
    
}
