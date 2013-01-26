/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xtecuan
 */
public class GruposDTO implements Serializable{
    
    private Integer idGrupo;
    private List<AlumnosDTO> alumnos;
    private String nombreGrupo;
    private Date fechaCreacion;

    public List<AlumnosDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnosDTO> alumnos) {
        this.alumnos = alumnos;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public GruposDTO() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idGrupo != null ? this.idGrupo.hashCode() : 0);
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
        final GruposDTO other = (GruposDTO) obj;
        if (this.idGrupo != other.idGrupo && (this.idGrupo == null || !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GruposDTO{" + "idGrupo=" + idGrupo + ", alumnos=" + alumnos + ", nombreGrupo=" + nombreGrupo + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
    
    
}
