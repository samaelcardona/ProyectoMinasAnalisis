/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MinaGrafo;
import Modelo.Minero;
import Modelo.Tunel;
import Vista.FrameAdministrarEmpresa;
import java.awt.Frame;
import java.util.LinkedList;

/**
 *
 * @author SAMAEL
 */
public class ControladorAsignacionDeMineros {

    LinkedList<MinaGrafo> listaDeMinas;
    LinkedList<Minero> listaDeMineros;
    LinkedList<MinaGrafo> listaMinasOro;
    LinkedList<MinaGrafo> listaMinasPlata;
    LinkedList<MinaGrafo> listaMinasBronce;
    LinkedList<Minero> listaMinerosOro;
    LinkedList<Minero> listaMinerosPlata;
    LinkedList<Minero> listaMinerosBronce;
    LinkedList<Minero> listaMinerosComodin;
    int cantidadMinerosOro;
    int cantidadMinerosPlata;
    int cantidadMinerosBronce;
    int cantidadMinerosComodin;
    int cantidadDepositosOro;
    int cantidadDepositosPlata;
    int cantidadDepositosBronce;
    FrameAdministrarEmpresa frameAdministrarPersonal;

    public ControladorAsignacionDeMineros(LinkedList<MinaGrafo> listaDeMinas, LinkedList<Minero> listaDeMineros, FrameAdministrarEmpresa frameAdministrarPersonal) {
        this.listaDeMinas = listaDeMinas;
        this.listaDeMineros = listaDeMineros;
        this.frameAdministrarPersonal = frameAdministrarPersonal;
        this.cantidadMinerosOro = 0;
        this.cantidadMinerosPlata = 0;
        this.cantidadMinerosBronce = 0;
        this.cantidadMinerosComodin = 0;
        this.cantidadDepositosOro = 0;
        this.cantidadDepositosPlata = 0;
        this.cantidadDepositosBronce = 0;
        this.listaMinasOro = new LinkedList<>();
        this.listaMinasPlata = new LinkedList<>();
        this.listaMinasBronce = new LinkedList<>();
        this.listaMinerosOro = new LinkedList<>();
        this.listaMinerosPlata = new LinkedList<>();
        this.listaMinerosBronce = new LinkedList<>();
        this.listaMinerosComodin = new LinkedList<>();
        this.retornarCantidadDeMinas(listaDeMinas);
        this.retornarCantidadDeMineros(listaDeMineros);
    }

    public void asignarMineros() {

        this.asignarMinerosOro();
        this.asignarMinerosPlata();
        this.asignarMinerosBronce();
        this.unificarListasDeMinas();
        this.asignarMinerosComodin();
        this.modificarPosicionesMineros();
        this.frameAdministrarPersonal.modificarListasMinas(listaDeMinas);

    }

    public void modificarPosicionesMineros() {

        for (int i = 0; i < listaDeMinas.size(); i++) {
            for (int j = 0; j < listaDeMinas.get(i).getListaDeMinerosEspecializadosEnMina().size(); j++) {
                listaDeMinas.get(i).getListaDeMinerosEspecializadosEnMina().get(j).setxMinero((int)this.retornarXDeEntradaMina(listaDeMinas.get(i).getListaTunelesMina()));
                listaDeMinas.get(i).getListaDeMinerosEspecializadosEnMina().get(j).setyMinero((int)this.retornarYDeEntradaMina(listaDeMinas.get(i).getListaTunelesMina()));
            }
            for (int j = 0; j < listaDeMinas.get(i).getListaDeMinerosComodinsEnMina().size(); j++) {
                listaDeMinas.get(i).getListaDeMinerosComodinsEnMina().get(j).setxMinero((int)this.retornarXDeEntradaMina(listaDeMinas.get(i).getListaTunelesMina()));
                listaDeMinas.get(i).getListaDeMinerosComodinsEnMina().get(j).setyMinero((int)this.retornarYDeEntradaMina(listaDeMinas.get(i).getListaTunelesMina()));
            }
            
        }

    }

    //para asignar los mineros especializados en oro
    public void asignarMinerosOro() {

        this.ordenarListaMinasOro();

        //para cuando hay mayor cantidad de mineros que de depositos
        if (cantidadDepositosOro < cantidadMinerosOro) {
            int ida = 0;
            int vuelta = listaMinasOro.size() - 1;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosOro.size(); i++) {

                if (ida < listaMinasOro.size()) {
                    listaMinasOro.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosOro.get(i));

                    if (contadorMinerosAsignados == listaMinasOro.get(ida).getListaTunelesMinaDepositos().size()) {
                        ida++;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;
                } else {
                    if (listaMinasOro.get(vuelta).getListaDeMinerosEspecializadosEnMina().size() == listaMinasOro.get(vuelta).getCantidadDeMinerosMax()) {
                        vuelta--;
                    }
                    listaMinasOro.get(vuelta).getListaDeMinerosEspecializadosEnMina().add(listaMinerosOro.get(i));

                }

            }
        }

        //para cuando hay mayor cantidad de despositos que mineros 
        if (cantidadDepositosOro > cantidadMinerosOro) {
            boolean encontroMinaConIgualCantidad = false;
            int i = 0;
            while (encontroMinaConIgualCantidad == false && i < listaMinasOro.size()) {
                if (listaMinasOro.get(i).getListaTunelesMinaDepositos().size() == cantidadMinerosOro) {
                    encontroMinaConIgualCantidad = true;
                    listaMinasOro.get(i).setListaDeMinerosEspecializadosEnMina(listaMinerosOro);
                }
                i++;
            }
            if (encontroMinaConIgualCantidad == false) {
                int x = listaMinasOro.size() - 1;
                int contadorMinerosAsignados = 1;
                for (int j = 0; j < listaMinerosOro.size(); j++) {
                    listaMinasOro.get(x).getListaDeMinerosEspecializadosEnMina().add(listaMinerosOro.get(j));

                    if (contadorMinerosAsignados == listaMinasOro.get(x).getListaTunelesMinaDepositos().size()) {
                        x--;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;

                }
            }
        }

        //para cuando hay igual cantidad de mineros que de depositos
        if (cantidadDepositosOro == cantidadMinerosOro) {
            int ida = 0;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosOro.size(); i++) {
                listaMinasOro.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosOro.get(i));

                if (contadorMinerosAsignados == listaMinasOro.get(ida).getListaTunelesMinaDepositos().size()) {
                    ida++;
                    contadorMinerosAsignados = 0;
                }
                contadorMinerosAsignados++;
            }

        }

    }

    //para asignar los mineros especializados en plata
    public void asignarMinerosPlata() {

        this.ordenarListaMinasPlata();

        //para cuando hay mayor cantidad de mineros que de depositos
        if (cantidadDepositosPlata < cantidadMinerosPlata) {
            int ida = 0;
            int vuelta = listaMinasPlata.size() - 1;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosPlata.size(); i++) {

                if (ida < listaMinasPlata.size()) {
                    listaMinasPlata.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosPlata.get(i));

                    if (contadorMinerosAsignados == listaMinasPlata.get(ida).getListaTunelesMinaDepositos().size()) {
                        ida++;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;
                } else {
                    if (listaMinasPlata.get(vuelta).getListaDeMinerosEspecializadosEnMina().size() == listaMinasPlata.get(vuelta).getCantidadDeMinerosMax()) {
                        vuelta--;
                    }
                    listaMinasPlata.get(vuelta).getListaDeMinerosEspecializadosEnMina().add(listaMinerosPlata.get(i));

                }

            }
        }

        //para cuando hay mayor cantidad de despositos que mineros 
        if (cantidadDepositosPlata > cantidadMinerosPlata) {
            boolean encontroMinaConIgualCantidad = false;
            int i = 0;
            while (encontroMinaConIgualCantidad == false && i < listaMinasPlata.size()) {
                if (listaMinasPlata.get(i).getListaTunelesMinaDepositos().size() == cantidadMinerosPlata) {
                    encontroMinaConIgualCantidad = true;
                    listaMinasPlata.get(i).setListaDeMinerosEspecializadosEnMina(listaMinerosPlata);
                }
                i++;
            }
            if (encontroMinaConIgualCantidad == false) {
                int x = listaMinasPlata.size() - 1;
                int contadorMinerosAsignados = 1;
                for (int j = 0; j < listaMinerosPlata.size(); j++) {
                    listaMinasPlata.get(x).getListaDeMinerosEspecializadosEnMina().add(listaMinerosPlata.get(j));

                    if (contadorMinerosAsignados == listaMinasPlata.get(x).getListaTunelesMinaDepositos().size()) {
                        x--;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;

                }
            }
        }

        //para cuando hay igual cantidad de mineros que de depositos
        if (cantidadDepositosPlata == cantidadMinerosPlata) {
            int ida = 0;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosPlata.size(); i++) {
                listaMinasPlata.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosPlata.get(i));

                if (contadorMinerosAsignados == listaMinasPlata.get(ida).getListaTunelesMinaDepositos().size()) {
                    ida++;
                    contadorMinerosAsignados = 0;
                }
                contadorMinerosAsignados++;
            }

        }
    }

    //para asignar los mineros especializados en bronce
    public void asignarMinerosBronce() {

        this.ordenarListaMinasBronce();

        //para cuando hay mayor cantidad de mineros que de depositos
        if (cantidadDepositosBronce < cantidadMinerosBronce) {
            int ida = 0;
            int vuelta = listaMinasBronce.size() - 1;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosBronce.size(); i++) {

                if (ida < listaMinasBronce.size()) {
                    listaMinasBronce.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosBronce.get(i));

                    if (contadorMinerosAsignados == listaMinasBronce.get(ida).getListaTunelesMinaDepositos().size()) {
                        ida++;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;
                } else {
                    if (listaMinasBronce.get(vuelta).getListaDeMinerosEspecializadosEnMina().size() == listaMinasBronce.get(vuelta).getCantidadDeMinerosMax()) {
                        vuelta--;
                    }
                    listaMinasBronce.get(vuelta).getListaDeMinerosEspecializadosEnMina().add(listaMinerosBronce.get(i));

                }

            }
        }

        //para cuando hay mayor cantidad de despositos que mineros 
        if (cantidadDepositosBronce > cantidadMinerosBronce) {
            boolean encontroMinaConIgualCantidad = false;
            int i = 0;
            while (encontroMinaConIgualCantidad == false && i < listaMinasBronce.size()) {
                if (listaMinasBronce.get(i).getListaTunelesMinaDepositos().size() == cantidadMinerosBronce) {
                    encontroMinaConIgualCantidad = true;
                    listaMinasBronce.get(i).setListaDeMinerosEspecializadosEnMina(listaMinerosBronce);
                }
                i++;
            }
            if (encontroMinaConIgualCantidad == false) {
                int x = listaMinasBronce.size() - 1;
                int contadorMinerosAsignados = 1;
                for (int j = 0; j < listaMinerosBronce.size(); j++) {
                    listaMinasBronce.get(x).getListaDeMinerosEspecializadosEnMina().add(listaMinerosBronce.get(j));

                    if (contadorMinerosAsignados == listaMinasBronce.get(x).getListaTunelesMinaDepositos().size()) {
                        x--;
                        contadorMinerosAsignados = 0;
                    }
                    contadorMinerosAsignados++;

                }
            }
        }

        //para cuando hay igual cantidad de mineros que de depositos
        if (cantidadDepositosBronce == cantidadMinerosBronce) {
            int ida = 0;
            int contadorMinerosAsignados = 1;

            for (int i = 0; i < listaMinerosBronce.size(); i++) {
                listaMinasBronce.get(ida).getListaDeMinerosEspecializadosEnMina().add(listaMinerosBronce.get(i));

                if (contadorMinerosAsignados == listaMinasBronce.get(ida).getListaTunelesMinaDepositos().size()) {
                    ida++;
                    contadorMinerosAsignados = 0;
                }
                contadorMinerosAsignados++;
            }

        }

    }

    //metodo para unificar todas las listas de las minas.
    private void unificarListasDeMinas() {

        for (int i = 0; i < listaDeMinas.size(); i++) {
            int j = 0;
            boolean encontroMinaOro = false;
            int k = 0;
            boolean encontroMinaPlata = false;
            int l = 0;
            boolean encontroMinaBronce = false;

            //oro
            while (j < listaMinasOro.size() && encontroMinaOro == false) {
                if (listaDeMinas.get(i).getIdMina() == listaMinasOro.get(j).getIdMina()) {
                    listaDeMinas.set(i, listaMinasOro.get(j));
                    encontroMinaOro = true;
                }
                j++;
            }
            //plata
            while (k < listaMinasPlata.size() && encontroMinaOro == false && encontroMinaPlata == false) {
                if (listaDeMinas.get(i).getIdMina() == listaMinasPlata.get(k).getIdMina()) {
                    listaDeMinas.set(i, listaMinasPlata.get(k));
                    encontroMinaPlata = true;
                }
                k++;
            }

            //bronce
            while (l < listaMinasBronce.size() && encontroMinaOro == false && encontroMinaPlata == false && encontroMinaBronce == false) {
                if (listaDeMinas.get(i).getIdMina() == listaMinasBronce.get(l).getIdMina()) {
                    listaDeMinas.set(i, listaMinasBronce.get(l));
                    encontroMinaBronce = true;
                }
                l++;
            }
        }

    }

    //para asignar los mineros especializados en comodin
    public void asignarMinerosComodin() {
        int i = 0;

        //busco si hay minas con faltante de mineros para igualar ... mineros
        for (int j = 0; j < listaDeMinas.size(); j++) {

            boolean hayParaIgualar = true;

            while (i < listaMinerosComodin.size() && hayParaIgualar == true) {
                //para cuando hay minas sin mineros o que haga falta llenar los depositos 
                hayParaIgualar = false;
                if ((listaDeMinas.get(j).getListaDeMinerosEspecializadosEnMina().size() + listaDeMinas.get(j).getListaDeMinerosComodinsEnMina().size()) < listaDeMinas.get(j).getListaTunelesMinaDepositos().size()) {
                    listaDeMinas.get(j).getListaDeMinerosComodinsEnMina().add(listaMinerosComodin.get(i));
                    i++;
                    hayParaIgualar = true;
                }
            }
        }

        //si no hay minas por completar.. 
        if (i < listaMinerosComodin.size()) {
            this.ordenarListaMinas();

            for (int j = listaDeMinas.size()-1; j >= 0; j--) {
                while (i < listaMinerosComodin.size() && ((listaDeMinas.get(j).getListaDeMinerosEspecializadosEnMina().size() + listaDeMinas.get(j).getListaDeMinerosComodinsEnMina().size()) < listaDeMinas.get(j).getCantidadDeMinerosMax())) {
                    listaDeMinas.get(j).getListaDeMinerosComodinsEnMina().add(listaMinerosComodin.get(i));
                    i++;
                }
            }

        }
    }

    ////le da valor a las variables para saber que cantidad de minas tenemos por cada uno de los minerales.
    private void retornarCantidadDeMinas(LinkedList<MinaGrafo> listaDeMinas) {

        for (int i = 0; i < listaDeMinas.size(); i++) {
            if (listaDeMinas.get(i).getMineralEnLaMina().equals("ORO")) {
                cantidadDepositosOro = cantidadDepositosOro + listaDeMinas.get(i).getListaTunelesMinaDepositos().size();
                listaMinasOro.add(listaDeMinas.get(i));
            }
            if (listaDeMinas.get(i).getMineralEnLaMina().equals("PLATA")) {
                cantidadDepositosPlata = cantidadDepositosPlata + listaDeMinas.get(i).getListaTunelesMinaDepositos().size();
                listaMinasPlata.add(listaDeMinas.get(i));
            }
            if (listaDeMinas.get(i).getMineralEnLaMina().equals("BRONCE")) {
                cantidadDepositosBronce = cantidadDepositosBronce + listaDeMinas.get(i).getListaTunelesMinaDepositos().size();
                listaMinasBronce.add(listaDeMinas.get(i));
            }
        }

    }

    //le da valor a las variables para saber que cantidad de mineros tenemos por cada una de las especialidades.
    private void retornarCantidadDeMineros(LinkedList<Minero> listaDeMineros) {

        for (int i = 0; i < listaDeMineros.size(); i++) {
            if (listaDeMineros.get(i).getEspecialidadDelMinero().equals("ORO")) {
                cantidadMinerosOro++;
                listaMinerosOro.add(listaDeMineros.get(i));
            }
            if (listaDeMineros.get(i).getEspecialidadDelMinero().equals("PLATA")) {
                cantidadMinerosPlata++;
                listaMinerosPlata.add(listaDeMineros.get(i));
            }
            if (listaDeMineros.get(i).getEspecialidadDelMinero().equals("BRONCE")) {
                cantidadMinerosBronce++;
                listaMinerosBronce.add(listaDeMineros.get(i));
            }
            if (listaDeMineros.get(i).getEspecialidadDelMinero().equals("COMODIN")) {
                cantidadMinerosComodin++;
                listaMinerosComodin.add(listaDeMineros.get(i));
            }
        }
    }

    //metodo para ordenar las minas de menor a mayor de oro
    private void ordenarListaMinasOro() {

        MinaGrafo aux = null;
        for (int i = 0; i < listaMinasOro.size(); i++) {
            for (int j = i + 1; j < listaMinasOro.size(); j++) {
                if (listaMinasOro.get(i).getListaTunelesMinaDepositos().size() < listaMinasOro.get(j).getListaTunelesMinaDepositos().size()) {
                    aux = listaMinasOro.get(i);
                    listaMinasOro.set(i, listaMinasOro.get(j));
                    listaMinasOro.set(j, aux);
                }
            }
        }
        System.out.println("Minas ORO");
        for (int i = 0; i < listaMinasOro.size(); i++) {
            System.out.println("id" + listaMinasOro.get(i).getIdMina() + "Cantidad" + listaMinasOro.get(i).getListaTunelesMinaDepositos().size());
        }

    }

    //metodo para ordenar las minas de menor a mayor de plata
    private void ordenarListaMinasPlata() {

        MinaGrafo aux = null;
        for (int i = 0; i < listaMinasPlata.size(); i++) {
            for (int j = i + 1; j < listaMinasPlata.size(); j++) {
                if (listaMinasPlata.get(i).getListaTunelesMinaDepositos().size() < listaMinasPlata.get(j).getListaTunelesMinaDepositos().size()) {
                    aux = listaMinasPlata.get(i);
                    listaMinasPlata.set(i, listaMinasPlata.get(j));
                    listaMinasPlata.set(j, aux);
                }
            }
        }

        System.out.println("Minas PLATA");
        for (int i = 0; i < listaMinasPlata.size(); i++) {

            System.out.println("id" + listaMinasPlata.get(i).getIdMina() + "Cantidad" + listaMinasPlata.get(i).getListaTunelesMinaDepositos().size());
        }

    }

    //metodo para ordenar las minas de menor a mayor de bronce.
    private void ordenarListaMinasBronce() {

        MinaGrafo aux = null;
        for (int i = 0; i < listaMinasBronce.size(); i++) {
            for (int j = i + 1; j < listaMinasBronce.size(); j++) {
                if (listaMinasBronce.get(i).getListaTunelesMinaDepositos().size() < listaMinasBronce.get(j).getListaTunelesMinaDepositos().size()) {
                    aux = listaMinasBronce.get(i);
                    listaMinasBronce.set(i, listaMinasBronce.get(j));
                    listaMinasBronce.set(j, aux);
                }
            }
        }

        System.out.println("Minas BRONCE");
        for (int i = 0; i < listaMinasBronce.size(); i++) {

            System.out.println("id" + listaMinasBronce.get(i).getIdMina() + "Cantidad" + listaMinasBronce.get(i).getListaTunelesMinaDepositos().size());
        }

    }

    //metodo para ordenar las minas de menor a mayor
    private void ordenarListaMinas() {
        MinaGrafo aux = null;
        for (int i = 0; i < listaDeMinas.size(); i++) {
            for (int j = i + 1; j < listaDeMinas.size(); j++) {
                if (listaDeMinas.get(i).getListaTunelesMinaDepositos().size() < listaDeMinas.get(j).getListaTunelesMinaDepositos().size()) {
                    aux = listaDeMinas.get(i);
                    listaDeMinas.set(i, listaDeMinas.get(j));
                    listaDeMinas.set(j, aux);
                }
            }
        }

        System.out.println("Minas");
        for (int i = 0; i < listaDeMinas.size(); i++) {

            System.out.println("id" + listaDeMinas.get(i).getIdMina() + "Cantidad" + listaDeMinas.get(i).getListaTunelesMinaDepositos().size());
        }

    }

    private double retornarXDeEntradaMina(LinkedList<Tunel> listaTunelesMina) {
        for (int i = 0; i < listaTunelesMina.size(); i++) {   
            if (listaTunelesMina.get(i).isEsEntradaOSalida()) {
               return listaTunelesMina.get(i).getX1Tunel();
            }
        }
        return 0;
    }
    
    private double retornarYDeEntradaMina(LinkedList<Tunel> listaTunelesMina) {
        for (int i = 0; i < listaTunelesMina.size(); i++) {
            if (listaTunelesMina.get(i).isEsEntradaOSalida()) {
               return listaTunelesMina.get(i).getY1Tunel();
            }
        }
        return 0;
    }

}
