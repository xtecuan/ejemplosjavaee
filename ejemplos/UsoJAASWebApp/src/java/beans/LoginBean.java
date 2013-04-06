/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author xtecuan
 */
public class LoginBean {

    private String usuario;
    private String clave;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String login() {

        String outcome = "login";


        try {



            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            request.login(usuario, clave);

            outcome = "/app/principal?faces-redirect=true";


        } catch (Exception e) {
            e.printStackTrace();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y clave invalidos"));
        }


        return outcome;

    }
}
