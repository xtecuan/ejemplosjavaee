/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author xtecuan
 */
public class FormateadorFecha implements Serializable {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date fechaObj;

    public FormateadorFecha() {
    }

    public Date getFechaObj() {
        return fechaObj;
    }

    public void setFechaObj(Date fechaObj) {
        this.fechaObj = fechaObj;
    }

    public String getFechaFormato() {

        return sdf.format(fechaObj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.fechaObj != null ? this.fechaObj.hashCode() : 0);
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
        final FormateadorFecha other = (FormateadorFecha) obj;
        if (this.fechaObj != other.fechaObj && (this.fechaObj == null || !this.fechaObj.equals(other.fechaObj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormateadorFecha{" + "fechaObj=" + fechaObj + '}';
    }
}
