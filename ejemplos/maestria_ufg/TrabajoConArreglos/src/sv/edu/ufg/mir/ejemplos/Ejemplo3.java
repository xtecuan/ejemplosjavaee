/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.mir.ejemplos;

/**
 *
 * @author xtecuan
 */
public class Ejemplo3 {

    public static void main(String[] args) {
        //x y  z
        double[][][] vector = new double[3][3][3];

        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                for (int k = 0; k < vector.length; k++) {

                    vector[i][j][k] = i + j + k + 1;
                    System.out.println("vector[" + i + "][" + j + "][" + k + "]=" + vector[i][j][k]);

                }

            }
        }

    }
}
