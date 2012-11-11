/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.enums;

import java.io.Serializable;

/**
 *
 * @author xtecuan
 */
public enum CabeceraEnum implements Serializable{
    
    SiesCabecera(Integer.valueOf("1"),"Cabecera"),
    NoesCabecera(Integer.valueOf("0"),"Municipio");
    
    private Integer value;
    private String descr;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

   

    private CabeceraEnum(Integer value, String descr) {
        this.value = value;
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "CabeceraEnum{" + "value=" + value + ", descr=" + descr + '}';
    }
    
    
}
