/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.poo.basica;

import sv.edu.ufg.poo.basica.modelo.Carro;

/**
 *
 * @author xtecuan
 */
public class POOBasica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Instanciando con el constructor por defecto
        Carro carro1 = new Carro();
        
        Carro carro2 = new Carro("RPTY45", "Rojo", "Kia", 315);
        
        Carro r  = new Carro();
        
        carro1.acelerar(110);
        carro2.acelerar(75);
        
        carro1.frenar();
        
        carro2.girar(270);
        
        System.out.println(carro1);
        System.out.println(carro2);
        
        System.out.println("Numero de carros: "+Carro.obtenerNumeroDeCarros());
        
    }
}
