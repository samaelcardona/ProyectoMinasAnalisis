/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AristaGrafoMina;
import Modelo.MinaGrafo;
import Modelo.NodoGrafoMina;
import Modelo.ValorCola;
import Vista.FrameAdministrarMinas;
import java.util.LinkedList;

/**
 *
 * @author SAMAEL
 */
public final class ControladorAnimacion {
    
    LinkedList<MinaGrafo> minas;
    FrameAdministrarMinas frameAdministrarMinas;
    

    public ControladorAnimacion(LinkedList<MinaGrafo> minas,FrameAdministrarMinas frameAdministrarMinas) {
        this.minas = minas;
        this.frameAdministrarMinas=frameAdministrarMinas;
        
        this.unificarListaDeMineros();
    }
    
    public void unificarListaDeMineros(){
        for (int i = 0; i < this.minas.size(); i++) {
            this.minas.get(i).setListaTotalDeMineros(this.minas.get(i).getListaDeMinerosEspecializadosEnMina());
            for (int j = 0; j < this.minas.get(i).getListaDeMinerosComodinsEnMina().size(); j++) {
                this.minas.get(i).getListaTotalDeMineros().add(this.minas.get(i).getListaDeMinerosComodinsEnMina().get(j));
            }
        }
    }
    
    
    public LinkedList rutaParaMinero(MinaGrafo mina,String idFuente,String idDestino ){
        
        LinkedList<ValorCola> listaDijkstra;
        
        listaDijkstra=this.dijkstra(mina, mina.getMatrizGrafoMapaAdyacenciaRutaMasCorta(),this.buscarIdEnlistaDeNodos(idFuente, mina) );
        
        return this.rutaParaMoverMinero(listaDijkstra, this.buscarIdEnlistaDeNodos(idFuente, mina), this.buscarIdEnlistaDeNodos(idDestino, mina));
    }
    
    private LinkedList rutaParaMoverMinero(LinkedList<ValorCola> listaDijkstra, Integer nodoOrigen, Integer nodoDestino) {

        int nodoAir = nodoDestino;
        LinkedList<Integer> listaRutaAlReves = new LinkedList<>();
        listaRutaAlReves.addFirst(nodoAir);

        while (nodoAir != nodoOrigen) {
            for (int j = 0; j < listaDijkstra.size(); j++) {
                if (listaDijkstra.get(j).getIdNodo() == nodoAir) {
                    listaRutaAlReves.addFirst(listaDijkstra.get(j).getPadre());
                    nodoAir = listaDijkstra.get(j).getPadre();
                }
            }
        }
        return listaRutaAlReves;
    }
    
    
    private LinkedList dijkstra(MinaGrafo mina,int[][] matrizGrafoMapaAdyacenciaRutaMasCorta, Integer nodoFuente) {

        int distancias[] = new int[matrizGrafoMapaAdyacenciaRutaMasCorta.length];
        int padre[] = new int[matrizGrafoMapaAdyacenciaRutaMasCorta.length];
        boolean visto[] = new boolean[matrizGrafoMapaAdyacenciaRutaMasCorta.length];
        LinkedList<ValorCola> cola = new LinkedList<>();
        int contador = 0;

        for (int i = 0; i < matrizGrafoMapaAdyacenciaRutaMasCorta.length; i++) {
            distancias[i] = Integer.MAX_VALUE;
            padre[i] = -1;
            visto[i] = false;
        }

        distancias[nodoFuente] = 0;

        cola.add(new ValorCola(nodoFuente, nodoFuente, distancias[nodoFuente]));

        while (this.estanTodosVistos(visto) == false) {

            int nodoCostoMin = this.buscarEnColaElValorMin(cola, visto);

            if (nodoCostoMin != -1) {
                visto[nodoCostoMin] = true;

                LinkedList<Integer> adyacentesANodoCostoMin = this.retornarAdyacentesDeNodo(mina, nodoCostoMin);

                if (adyacentesANodoCostoMin.size() > 0) {
                    for (int i = 0; i < adyacentesANodoCostoMin.size(); i++) {
                        if (visto[adyacentesANodoCostoMin.get(i)] == false) {
                            if (distancias[adyacentesANodoCostoMin.get(i)] > (distancias[nodoCostoMin] + matrizGrafoMapaAdyacenciaRutaMasCorta[nodoCostoMin][adyacentesANodoCostoMin.get(i)])) {

                                distancias[adyacentesANodoCostoMin.get(i)] = distancias[nodoCostoMin] + matrizGrafoMapaAdyacenciaRutaMasCorta[nodoCostoMin][adyacentesANodoCostoMin.get(i)];
                                padre[adyacentesANodoCostoMin.get(i)] = nodoCostoMin;
                                cola.add(new ValorCola(adyacentesANodoCostoMin.get(i), padre[adyacentesANodoCostoMin.get(i)], distancias[adyacentesANodoCostoMin.get(i)]));
                            }
                        }
                    }
                }

            }
            if (contador > matrizGrafoMapaAdyacenciaRutaMasCorta.length) {
                for (int i = 0; i < visto.length; i++) {
                    visto[i] = true;
                }
            }
            contador++;
        }
        if (contador < matrizGrafoMapaAdyacenciaRutaMasCorta.length + 1) {
            return cola;
        }
        return new LinkedList();
    }
    
    
    private boolean estanTodosVistos(boolean[] visto) {
        for (int i = 0; i < visto.length; i++) {
            if (visto[i] == false) {
                return false;
            }
        }
        return true;
    }
    
    
    private int buscarEnColaElValorMin(LinkedList<ValorCola> cola, boolean[] visto) {
        int menor = Integer.MAX_VALUE;
        int idMenorCosto = -1;
        for (int i = 0; i < cola.size(); i++) {
            if (cola.get(i).getCosto() < menor) {
                if (visto[cola.get(i).getIdNodo()] == false) {
                    menor = cola.get(i).getCosto();
                    idMenorCosto = cola.get(i).getIdNodo();
                }
            }
        }
        return idMenorCosto;
    }
    
    
    private LinkedList<Integer> retornarAdyacentesDeNodo(MinaGrafo mina, int nodoCostoMin) {
        LinkedList<Integer> adyacentes = new LinkedList<>();

      
            for (int i = 0; i < mina.getListaDeAristasGrafoMina().size(); i++) {
                if (this.buscarIdEnlistaDeNodos(mina.getListaDeAristasGrafoMina().get(i).getNodoA().getIdNodoGrafoMina(),mina) == nodoCostoMin) {
                    adyacentes.add(this.buscarIdEnlistaDeNodos(mina.getListaDeAristasGrafoMina().get(i).getNodoB().getIdNodoGrafoMina(),mina));
                }
            }
       

        return adyacentes;
    }
    
    
    public int buscarIdEnlistaDeNodos(String id,MinaGrafo mina) {

        for (int i = 0; i < mina.getListaDeNodosGrafoMina().size(); i++) {
            if (id.equals(mina.getListaDeNodosGrafoMina().get(i).getIdNodoGrafoMina())) {
                return i;
            }
        }
        return -1;
    }

    public String buscarEntradaALaMinaNodo(MinaGrafo get) {
        for (int i = 0; i < get.getListaTunelesMina().size(); i++) {
            if (get.getListaTunelesMina().get(i).isEsEntradaOSalida()) {
                return get.getListaTunelesMina().get(i).getListadeNodosEnElTunel().get(0).getIdNodoGrafoMina()+"";
            }
        }
        return "";
    }

  
    
}
