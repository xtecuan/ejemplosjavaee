/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.xtecuan.modelo.ejb.SaludoBean;

/**
 *
 * @author xtecuan
 */
public class SaludoMB implements Serializable {

    @EJB
    private SaludoBean saludoBean;
    private String nombres;
    private String apellidos;
    private String saludo;

    /**
     * Creates a new instance of SaludoMB
     */
    public SaludoMB() {
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

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public void saludarUsuario(ActionEvent event) {

        saludo = saludoBean.saludarUsuario(nombres, apellidos);

        FacesContext.getCurrentInstance().renderResponse();

    }
}
