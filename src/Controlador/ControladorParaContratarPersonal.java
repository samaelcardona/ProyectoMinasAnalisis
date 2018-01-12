package Controlador;

import Modelo.Minero;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SAMAEL
 */
public class ControladorParaContratarPersonal {

    LinkedList<Minero> listadeMineros;

    public ControladorParaContratarPersonal(LinkedList<Minero> listadeMineros) {
        this.listadeMineros = listadeMineros;
    }

    ///metodo para verificar el porcentaje de la cantidad de mineros comodin 
    public boolean verificarMinerosComodin() {
        int oro = 0;
        int plata = 0;
        int bronce = 0;
        int comodin = 0;

        for (int i = 0; i < listadeMineros.size(); i++) {
            if ("ORO".equals(listadeMineros.get(i).getEspecialidadDelMinero())) {
                oro++;
            }
            if ("PLATA".equals(listadeMineros.get(i).getEspecialidadDelMinero())) {
                plata++;
            }
            if ("BRONCE".equals(listadeMineros.get(i).getEspecialidadDelMinero())) {
                bronce++;
            }
            if ("COMODIN".equals(listadeMineros.get(i).getEspecialidadDelMinero())) {
                comodin++;
            }
        }
        if (!listadeMineros.isEmpty()) {
            if ((((comodin + 1) / (oro + plata + bronce)) * 100) <= 10) {
                return true;
            }
            if ((((comodin + 1) / (oro + plata + bronce)) * 100) > 10) {
                return false;
            }
        }

        return false;
    }

}
