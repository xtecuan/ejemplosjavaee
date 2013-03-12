/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.ejemplos.obtenerentrada.teclado;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author javaee
 */
public class LectorGrafico {
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de alumnos!!!");
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet");
        String nombres = JOptionPane.showInputDialog("Ingrese los nombres");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos");
        String correo = JOptionPane.showInputDialog("Ingrese el correo");
        String fechanacTexto = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento dd/MM/yyyy");
        
        Alumno alumno = new Alumno();
        
        alumno.setCarnet(carnet);
        alumno.setNombres(nombres);
        alumno.setApellidos(apellidos);
        alumno.setCorreo(correo);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechanac = sdf.parse(fechanacTexto);
            if(fechanac!=null){
                alumno.setFechanac(fechanac);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        alumno.imprimirInfoAlumno();
        System.out.println("--------->Tratando de escribir archivo");
        alumno.escribirArchivoTexto();
        System.out.println("--------->Mostrando Archivo");
        alumno.mostrarArchivoAlumno("/home/javaee/info-alumno.txt");
        JOptionPane.showMessageDialog(null, alumno);
        
    }
    
}
