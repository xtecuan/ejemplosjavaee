/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.vistacontrolador.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sv.edu.ugb.modelo.ejb.servicio.LoginService;
import sv.edu.ugb.modelo.entidades.Usuario;

/**
 *
 * @author xtecuan
 */
public class LoginBean implements Serializable {

    @EJB
    private LoginService loginService;
    private Usuario user;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    @PostConstruct
    private void init() {
        user = new Usuario();
    }

    public String doLogin() {

        String outcome = "login.jsf";

        if (user.getLogin() != null && user.getLogin().length() > 0
                && user.getPassword() != null && user.getPassword().length() > 0) {

            Usuario user1 = loginService.doLogin(user.getLogin(), user.getPassword());

            if (user1 != null) {
                outcome = "/app/principal.jsf";

                agregarASession("USERLOGIN", user1);

            } else {
                addMessage("LOGIN:", "Usuario y Clave Invalidas intente de NUEVO!!!");
            }

        }

        return outcome;

    }

    private void agregarASession(String key, Object valor) {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(key, valor);
    }

    private void addMessage(String resumen, String mensaje) {

        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(resumen, mensaje));

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
}
