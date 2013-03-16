/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.cliente.conectores;

import org.xtecuan.mir.conectores.mysql.MySQLConn;
import org.xtecuan.mir.facade.AlumnosFacade;
import sv.edu.ufg.ejemplos.obtenerentrada.teclado.Alumno;

/**
 *
 * @author javaee
 */
public class UsoConectoresCursoJava {

    private static final int ALUMNOS_SIZE = 25;

    public static String generarCarnet(int i) {

        String salida = "";

        int tamanno = String.valueOf(i).length();

        if (tamanno == 2) {
            salida = "00000000" + i;
        } else {
            salida = "000000000" + i;
        }

        return salida;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Alumno[] alumnos = new Alumno[ALUMNOS_SIZE];

        // TODO code application logic here
        for (int i = 0; i < alumnos.length; i++) {

            alumnos[i] = new Alumno(generarCarnet(i), "Alumno_" + (i + 1),
                    "Apellido_" + (i + 1), "correo_" + (i + 1) + "@ufg.edu.sv", null);

        }

        AlumnosFacade.guardarAlumnos(alumnos);
    }
}
