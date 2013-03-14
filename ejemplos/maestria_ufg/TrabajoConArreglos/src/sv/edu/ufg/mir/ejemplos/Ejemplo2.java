/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.mir.ejemplos;

import java.text.SimpleDateFormat;
import java.util.Date;
import sv.edu.ufg.ejemplos.obtenerentrada.teclado.Alumno;

/**
 *
 * @author xtecuan
 */
public class Ejemplo2 {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static final int ALUMNOS_SIZE = 2;

    public static Date fromStringToDate(String fecha) {

        Date salida = null;

        try {
            salida = sdf.parse(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salida;
    }

    public static void main(String[] args) {

        Alumno[] alumnos = new Alumno[ALUMNOS_SIZE];

        alumnos[0] = new Alumno("RP9533001", "Julian", "Rivera Pineda", "xtecuan@gmail.com",
                fromStringToDate("05/11/1976"));


        alumnos[1] = new Alumno("RP9533002", "Julio Adalberto", 
                "Rivera Pineda", "juliux@gmail.com",
                fromStringToDate("16/01/1978"));
        
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
        

    }
}
