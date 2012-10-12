/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import sv.edu.ufg.modelo.ejb.HolaMundoBeanLocal;

/**
 *
 * @author xtecuan
 */
public class HolaMundoManagedBean implements Serializable{

    @EJB
    private HolaMundoBeanLocal holaMundoBean;
    private String nombreUsuario;
    private String saludo;

    /**
     * Creates a new instance of HolaMundoManagedBean
     */
    public HolaMundoManagedBean() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
    
    
    

    public void saludar(ActionEvent event) {
        
        System.out.println(nombreUsuario);

        try {

            saludo = holaMundoBean.holaMundo(nombreUsuario);
            
            System.out.println(saludo);
            
        } catch (Exception ex) {
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error al saludar el usuario tiene que introducir un nombre de usuario"));
        }
        
        
        FacesContext.getCurrentInstance().renderResponse();

    }
}
