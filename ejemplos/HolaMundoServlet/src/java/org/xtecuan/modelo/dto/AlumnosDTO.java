/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xtecuan
 */
public class AlumnosDTO implements Serializable {

    private static final String SELECT_ALL_COUNT = "select count(*) from alumnos ";
    private static final String SELECT_ALL = "select * from alumnos ";
    private static final String INSERT = "insert into alumnos(carnet,nombres,apellidos,${0}) "
            + "values(?,?,?,${1})";
    private static final String DELETE = "delete from alumnos where id=?";
    private static final String UPDATE_BASE = "UPDATE alumnos SET ${0} WHERE id = ?";
    private static final String SELECT_LIKE_NOMBRES = "select * from alumnos where nombres like ?";
    private Integer id;
    private String carnet;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fechanac;

    public AlumnosDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AlumnosDTO other = (AlumnosDTO) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlumnosDTO{" + "id=" + id + ", carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", fechanac=" + fechanac + '}';

    }

    public static String getInsert(StringBuilder cols, StringBuilder marks) {

        if (cols.length() == 0 && marks.length() == 0) {

            return INSERT.replace(",${0}", "").replace(",${1}", "");
        } else {

            return INSERT.replace("${0}", cols.toString()).replace("${1}", marks.toString());
        }

    }

    public static String getUpdate(StringBuilder colsAndMarks) {

        if (colsAndMarks.length() == 0) {

            return UPDATE_BASE;
        } else {

            return UPDATE_BASE.replace("${0}", colsAndMarks.toString());
        }

    }

    public static String getSELECT_ALL() {
        return SELECT_ALL;
    }

    public static String getSELECT_ALL_COUNT() {
        return SELECT_ALL_COUNT;
    }

    public static String getDELETE() {
        return DELETE;
    }

    public static String getSELECT_LIKE_NOMBRES() {
        return SELECT_LIKE_NOMBRES;
    }
    
    
    
}
