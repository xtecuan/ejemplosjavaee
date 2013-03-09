/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.ejemplos.obtenerentrada.teclado;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javaee
 */
public class LectorConsola {

    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese su nombre:");
        try {
            String temp = dataIn.readLine();

            System.out.println("Su Nombre es: " + temp);

        } catch (IOException e) {
            System.err.println("Error de i/o al leer la terminal!!!");
        } finally {
            try {
                dataIn.close();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
    }
}
