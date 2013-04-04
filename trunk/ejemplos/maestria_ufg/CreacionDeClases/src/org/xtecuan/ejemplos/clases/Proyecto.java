/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.clases;

import sv.edu.ufg.creacion.clases.Asignatura;
import sv.edu.ufg.creacion.clases.enums.Facultades;

/**
 *
 * @author xtecuan
 */
public class Proyecto {

    private static final int NUMASIG = 100;

    public static void main(String[] args) {

        Asignatura mate = new Asignatura();
        mate.setDesAsignatura("Matematica I");
        mate.setCodFacultad(Facultades.Ingenieria.getCodFacultad());
        mate.setNumUniVal(Integer.valueOf("4"));

        Asignatura introEcon = new Asignatura("Introducción a la Economia", Integer.valueOf(3),
                Facultades.Economia.getCodFacultad());
        introEcon.fijarEstadoAsignatura(Boolean.FALSE);
        
        introEcon = new Asignatura();

        System.out.println("Codigo para Matematica I: " + mate.getCodAsignatura());
        System.out.println("Intro a la Economia: " + introEcon.getCodAsignatura());


        for (int i = 1; i <= NUMASIG; i++) {

            Asignatura current = new Asignatura("rr" + 1, Integer.valueOf(3), Facultades.Humanidades.getCodFacultad());

            System.out.println("Codigo generado: " + current.getCodAsignatura());

        }

    }
}
