/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.enums;

import java.io.Serializable;

/**
 *
 * @author xtecuan
 */
public enum SexoEnum implements Serializable {

    Masculino("MAS", "Masculino"),
    Femenino("FEM", "Femenino"),
    Otros("OTR","Otros");
    private String cod;
    private String des;

    private SexoEnum(String cod, String des) {
        this.cod = cod;
        this.des = des;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "SexoEnum{" + "cod=" + cod + ", des=" + des + '}';
    }
}
