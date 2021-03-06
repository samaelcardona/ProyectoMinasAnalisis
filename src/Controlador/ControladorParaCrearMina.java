/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AristaGrafoMina;
import Modelo.Deposito;
import Modelo.MinaGrafo;
import Modelo.NodoGrafoMina;
import Modelo.Tunel;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author SAMAEL
 */
public class ControladorParaCrearMina {
    //clase para crear toda la logica de crear minas.

    MinaGrafo minaNueva;
    int x;
    int y;
    int contadorParaIdTunelEnMina;
    int contadorIdDeposito;

    public ControladorParaCrearMina() {
        x = 20;
        y = 10;
        minaNueva = new MinaGrafo(0, "", new Tunel[x][y]);
        contadorParaIdTunelEnMina = 0;

        //llenar matriz 
        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                minaNueva.getMatrizTuneles()[i - 1][j - 1] = new Tunel();
                minaNueva.getMatrizTuneles()[i - 1][j - 1].setX1Tunel(((i - 1) * 56));
                minaNueva.getMatrizTuneles()[i - 1][j - 1].setX2Tunel((i * 56));
                minaNueva.getMatrizTuneles()[i - 1][j - 1].setY1Tunel(((j - 1) * 56));
                minaNueva.getMatrizTuneles()[i - 1][j - 1].setY2Tunel((j * 56));
                minaNueva.getMatrizTuneles()[i - 1][j - 1].setIdTunel(contadorParaIdTunelEnMina);
                contadorParaIdTunelEnMina++;
            }
        }

    }

    public void recibirDatosInicialesMina(int idMina, String mineralEnLaMina, int contadorIdDepositos, int cantidadDeMinerosMax, int cantidadDeMineral, int valorTotalMina) {
        this.minaNueva.setIdMina(idMina);
        this.minaNueva.setMineralEnLaMina(mineralEnLaMina);
        this.minaNueva.setCantidadDeMinerosMax(cantidadDeMinerosMax);
        this.minaNueva.setCantidadDeMineralPorDeposito(cantidadDeMineral);
        this.minaNueva.setCostoMina(valorTotalMina);
        this.contadorIdDeposito = contadorIdDepositos;

        //this.minaNueva.setCostoMina(COSTO); //revisar si se envia el costo de la mina o se calcula
    }

    public void agregarElementoTunelSencillo(int xClick, int yClick) {
        int[] posicionXY = new int[2];
        LinkedList<NodoGrafoMina> nodosEnTunel = new LinkedList<>();

        posicionXY = this.retornarPosicionCuadriculaSeleccionada(xClick, yClick);

        ///aca creo los nodos de cada tunel agrego la imagen respectiva
        //nodo superior   se coloca uno en la posicion X + tamano y Y en 0 
        //nodo inferior  se coloca en posicion X=0 y Y + tamano
        //verificar bien lo de arriba pintando.
        NodoGrafoMina nodo0 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 0), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo1 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 1), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo2 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 2), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);
        NodoGrafoMina nodo3 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 3), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);

        nodosEnTunel.add(nodo0);
        nodosEnTunel.add(nodo1);
        nodosEnTunel.add(nodo2);
        nodosEnTunel.add(nodo3);

        minaNueva.getListaDeNodosGrafoMina().add(nodo0);
        minaNueva.getListaDeNodosGrafoMina().add(nodo1);
        minaNueva.getListaDeNodosGrafoMina().add(nodo2);
        minaNueva.getListaDeNodosGrafoMina().add(nodo3);

        //creo las tranciciones de el 
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setImagenTunel(new ImageIcon("src\\imagenes\\2.png"));
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setListadeNodosEnElTunel(nodosEnTunel);
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAnchoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconWidth());
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAltoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconHeight());

        minaNueva.getListaTunelesMina().add(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]]);
        
        AristaGrafoMina arista0 = new AristaGrafoMina(nodo1, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo0);
        AristaGrafoMina arista1 = new AristaGrafoMina(nodo2, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo3);
        AristaGrafoMina arista2 = new AristaGrafoMina(nodo1, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo3);
        AristaGrafoMina arista3 = new AristaGrafoMina(nodo3, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo1);
        AristaGrafoMina arista4 = new AristaGrafoMina(nodo0, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo2);
        AristaGrafoMina arista5 = new AristaGrafoMina(nodo2, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo0);

        minaNueva.getListaDeAristasGrafoMina().add(arista0);
        minaNueva.getListaDeAristasGrafoMina().add(arista1);
        minaNueva.getListaDeAristasGrafoMina().add(arista2);
        minaNueva.getListaDeAristasGrafoMina().add(arista3);
        minaNueva.getListaDeAristasGrafoMina().add(arista4);
        minaNueva.getListaDeAristasGrafoMina().add(arista5);

    }

    public void agregarElementoTunelDeposito(int xClick, int yClick) {
        int[] posicionXY = new int[2];
        LinkedList<NodoGrafoMina> nodosEnTunel = new LinkedList<>();

        posicionXY = this.retornarPosicionCuadriculaSeleccionada(xClick, yClick);

        ///aca creo los nodos de cada tunel agrego la imagen respectiva
        //nodo superior   se coloca uno en la posicion X + tamano y Y en 0 
        //nodo inferior  se coloca en posicion X=0 y Y + tamano
        //verificar bien lo de arriba pintando.
        //verificar bien lo de los depositos
        NodoGrafoMina nodo0 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 0), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo1 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 1), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo2 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 2), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);
        NodoGrafoMina nodo3 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 3), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);

        nodosEnTunel.add(nodo0);
        nodosEnTunel.add(nodo1);
        nodosEnTunel.add(nodo2);
        nodosEnTunel.add(nodo3);

        minaNueva.getListaDeNodosGrafoMina().add(nodo0);
        minaNueva.getListaDeNodosGrafoMina().add(nodo1);
        minaNueva.getListaDeNodosGrafoMina().add(nodo2);
        minaNueva.getListaDeNodosGrafoMina().add(nodo3);

        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setImagenTunel(new ImageIcon("src\\imagenes\\1.png"));
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setListadeNodosEnElTunel(nodosEnTunel);
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setTieneDeposito(true);
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAnchoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconWidth());
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAltoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconHeight());
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setDepositoEnElTunel(new Deposito(this.contadorIdDeposito, /*Cantidad de mineral en el deposito puede ser igual para todos*/ 0, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getAnchoTunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getAltoTunel()));

        minaNueva.getListaTunelesMina().add(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]]);
        minaNueva.getListaTunelesMinaDepositos().add(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]]);
        
        //si es deposito internamente no tiene transiciones 
        
        
    }

    public void agregarElementoTunelEntrada(int xClick, int yClick) {
        int[] posicionXY = new int[2];
        LinkedList<NodoGrafoMina> nodosEnTunel = new LinkedList<>();

        posicionXY = this.retornarPosicionCuadriculaSeleccionada(xClick, yClick);

        ///aca creo los nodos de cada tunel agrego la imagen respectiva
        //nodo superior   se coloca uno en la posicion X + tamano y Y en 0 
        //nodo inferior  se coloca en posicion X=0 y Y + tamano
        //verificar bien lo de arriba pintando.
        NodoGrafoMina nodo0 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 0), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo1 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 1), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel(), 10, 10);
        NodoGrafoMina nodo2 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 2), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel(), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);
        NodoGrafoMina nodo3 = new NodoGrafoMina((minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getIdTunel() + "." + 3), (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getX1Tunel() + 45, (int) minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getY1Tunel() + 45, 10, 10);

        nodosEnTunel.add(nodo0);
        nodosEnTunel.add(nodo1);
        nodosEnTunel.add(nodo2);
        nodosEnTunel.add(nodo3);

        minaNueva.getListaDeNodosGrafoMina().add(nodo0);
        minaNueva.getListaDeNodosGrafoMina().add(nodo1);
        minaNueva.getListaDeNodosGrafoMina().add(nodo2);
        minaNueva.getListaDeNodosGrafoMina().add(nodo3);

        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setImagenTunel(new ImageIcon("src\\imagenes\\0.png"));
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setListadeNodosEnElTunel(nodosEnTunel);
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setEsEntradaOSalida(true);
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAnchoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconWidth());
        minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].setAltoTunel(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]].getImagenTunel().getIconHeight());

        minaNueva.getListaTunelesMina().add(minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]]);

        //Transiciones internas del nodo 
        AristaGrafoMina arista0 = new AristaGrafoMina(nodo1, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo0);
        AristaGrafoMina arista1 = new AristaGrafoMina(nodo2, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo3);
        AristaGrafoMina arista2 = new AristaGrafoMina(nodo1, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo3);
        AristaGrafoMina arista3 = new AristaGrafoMina(nodo3, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo1);
        AristaGrafoMina arista4 = new AristaGrafoMina(nodo0, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo2);
        AristaGrafoMina arista5 = new AristaGrafoMina(nodo2, minaNueva.getMatrizTuneles()[posicionXY[0]][posicionXY[1]], nodo0);

        minaNueva.getListaDeAristasGrafoMina().add(arista0);
        minaNueva.getListaDeAristasGrafoMina().add(arista1);
        minaNueva.getListaDeAristasGrafoMina().add(arista2);
        minaNueva.getListaDeAristasGrafoMina().add(arista3);
        minaNueva.getListaDeAristasGrafoMina().add(arista4);
        minaNueva.getListaDeAristasGrafoMina().add(arista5);

    }

    public void metodoParaCrearLasTransiciones() {

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (minaNueva.getMatrizTuneles()[i][j].getImagenTunel() != null) {
                    if (minaNueva.getMatrizTuneles()[i+1][j].getImagenTunel() != null) {
                        AristaGrafoMina arista0=new AristaGrafoMina(minaNueva.getMatrizTuneles()[i+1][j].getListadeNodosEnElTunel().get(0), minaNueva.getMatrizTuneles()[i][j], minaNueva.getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(1));
                        AristaGrafoMina arista1=new AristaGrafoMina(minaNueva.getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3), minaNueva.getMatrizTuneles()[i][j], minaNueva.getMatrizTuneles()[i+1][j].getListadeNodosEnElTunel().get(2));
                        
                        minaNueva.getListaDeAristasGrafoMina().add(arista0);
                        minaNueva.getListaDeAristasGrafoMina().add(arista1);
        
                    }
                    
                    if (minaNueva.getMatrizTuneles()[i][j+1].getImagenTunel() != null) {
                        AristaGrafoMina arista0=new AristaGrafoMina(minaNueva.getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(2), minaNueva.getMatrizTuneles()[i][j], minaNueva.getMatrizTuneles()[i][j+1].getListadeNodosEnElTunel().get(0));
                        AristaGrafoMina arista1=new AristaGrafoMina(minaNueva.getMatrizTuneles()[i][j+1].getListadeNodosEnElTunel().get(1), minaNueva.getMatrizTuneles()[i][j], minaNueva.getMatrizTuneles()[i][j].getListadeNodosEnElTunel().get(3));
                        
                        minaNueva.getListaDeAristasGrafoMina().add(arista0);
                        minaNueva.getListaDeAristasGrafoMina().add(arista1);
        
                    }

                }
            }
        }

    }
    
    public void metodoParaLlenarMatrizDeAdyacencia(){
        minaNueva.setMatrizGrafoMapaAdyacenciaRutaMasCorta(new int[minaNueva.getListaDeNodosGrafoMina().size()][minaNueva.getListaDeNodosGrafoMina().size()]);
        
        for (int i = 0; i < minaNueva.getMatrizGrafoMapaAdyacenciaRutaMasCorta().length; i++) {
            for (int j = 0; j < minaNueva.getMatrizGrafoMapaAdyacenciaRutaMasCorta().length; j++) {
                minaNueva.getMatrizGrafoMapaAdyacenciaRutaMasCorta()[j][i] = -1;
            }
        }
        
        
         for (int i = 0; i < minaNueva.getListaDeAristasGrafoMina().size(); i++) {
            minaNueva.getMatrizGrafoMapaAdyacenciaRutaMasCorta()[this.buscarIdEnlistaDeNodos(minaNueva.getListaDeAristasGrafoMina().get(i).getNodoA().getIdNodoGrafoMina())][this.buscarIdEnlistaDeNodos(minaNueva.getListaDeAristasGrafoMina().get(i).getNodoA().getIdNodoGrafoMina())] = 10;
        }
    }

    
    public int buscarIdEnlistaDeNodos(String id) {

        for (int i = 0; i < minaNueva.getListaDeNodosGrafoMina().size(); i++) {
            if (id.equals(minaNueva.getListaDeNodosGrafoMina().get(i).getIdNodoGrafoMina())) {
                return i;
            }
        }
        return -1;
    }
    
    public int[] retornarPosicionCuadriculaSeleccionada(int x, int y) {

        boolean encontroX = false;
        boolean encontroY = false;
        int i = 0;
        int j = 0;
        int[] datosXY = new int[2];

        //para encontrar limites en x 
        while (i < 20 && encontroX == false) {
            if (minaNueva.getMatrizTuneles()[i][j].getX1Tunel() <= x && minaNueva.getMatrizTuneles()[i][j].getX2Tunel() >= x) {
                encontroX = true;
                datosXY[0] = i;
            }
            i++;
        }

        //para encontrar limites en y despues de haber encontrado x
        if (encontroX == true) {
            while (j < 10 && encontroY == false) {
                if (minaNueva.getMatrizTuneles()[datosXY[0]][j].getY1Tunel() <= y && minaNueva.getMatrizTuneles()[datosXY[0]][j].getY2Tunel() >= y) {
                    encontroY = true;
                    datosXY[1] = j;
                }
                j++;
            }
        } else {
            System.out.println("verifique posiciones seleccionadas");
        }
        if (encontroY == true) {
            return datosXY;
        }
        return null;
    }

    public MinaGrafo getMinaNueva() {
        return minaNueva;
    }

    public void setMinaNueva(MinaGrafo minaNueva) {
        this.minaNueva = minaNueva;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
