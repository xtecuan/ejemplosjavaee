/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.ejemplos.obtenerentrada.teclado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author javaee
 */
public class Alumno {
    //Variable static

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //Variables de instancia
    private String carnet;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fechanac;

    //construtores
    public Alumno() {
    }

    public Alumno(String carnet) {
        this.carnet = carnet;
    }

    public Alumno(String carnet, String nombres, String apellidos, String correo, Date fechanac) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechanac = fechanac;
    }

    //Getters y Setters
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.carnet != null ? this.carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if ((this.carnet == null) ? (other.carnet != null) : !this.carnet.equals(other.carnet)) {
            return false;
        }
        return true;
    }

    private String generarTexto() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tcarnet: ").append(carnet).append("\n");
        sb.append("\tnombres:").append(nombres).append("\n");
        sb.append("\tapellidos:").append(apellidos).append("\n");
        sb.append("\tcorreo:").append(correo).append("\n");
        sb.append("\tFecha Nacimiento:").append(sdf.format(fechanac)).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        //return "Alumno{" + "carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", fechanac=" + fechanac + '}';
        return generarTexto();
    }

    public void imprimirInfoAlumno() {

        System.out.println(generarTexto() + " \n VERSION MODIFICADA");
    }

    public void escribirArchivoTexto() {
        FileWriter fichero = null;
        PrintWriter pw;

        try {
            fichero = new FileWriter("/home/javaee/info-alumno.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(generarTexto());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void mostrarArchivoAlumno(String ubicacion) {
        File archivo = null;
        FileReader fr = null; 
        BufferedReader br= null;
        
               
                
        try {
            archivo = new File(ubicacion);    
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea = null; 
            
            while ((linea = br.readLine()) != null)
                System.out.println(linea);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
            
                if(fr != null)
                    fr.close();
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
        
                
                
        
    }
}
