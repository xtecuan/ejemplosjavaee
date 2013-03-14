/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.mir.ejemplos;

/**
 *
 * @author xtecuan
 */
public class Ejemplo1 {

    public static final int TAMANNO_EDADES = 10;
    public static final int TAMANNO_NOMBRES = 3;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        //Declaraciones de arreglos
        int[] edades;
        String nombres[];
        char[] vocales;

        //Proceso de instanciacion

        edades = new int[TAMANNO_EDADES];
        nombres = new String[TAMANNO_NOMBRES];

        //Esto es cuando creamos la declaracion previamente
        vocales = new char[]{'a', 'e', 'i', 'o', 'u'};

        //Declaracion e instanciacion en una linea
        char[] vocales1 = {'a', 'e', 'i', 'o', 'u'};

        //Forma de acceso a los arreglos

        for (int x = 0; x < edades.length; x++) {

            edades[x] = x + 1;
            int i = edades[x];
            System.out.println("Edad[" + x + "]=" + i);

        }

        int i = 0;

        while (i < TAMANNO_NOMBRES) {

            nombres[i] = "Nombre_" + (i + 1);
            //System.out.println("Nombre[" + i + "]=" + nombres[i]);



            i++;

        }

        i = 0;
        for (String current : nombres) {
            System.out.println("Nombre[" + i + "]=" + current);
            
            char[] descomposicion = current.toCharArray();
            
            for (int j = 0; j < descomposicion.length; j++) {
                char c = descomposicion[j];
                System.out.print(c+",");
            }
            System.out.println("\n");
            
            i++;
        }




    }
}
