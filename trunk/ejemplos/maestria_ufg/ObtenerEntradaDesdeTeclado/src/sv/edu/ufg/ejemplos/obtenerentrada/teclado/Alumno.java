/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.ejemplos.obtenerentrada.teclado;

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
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    private String generarTexto() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tid: ").append(id).append("\n");
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
}
