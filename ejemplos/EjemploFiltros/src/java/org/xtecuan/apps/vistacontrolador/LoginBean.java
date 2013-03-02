/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.vistacontrolador;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.xtecuan.apps.vistacontrolador.dto.UserDTO;

/**
 *
 * @author xtecuan
 */
public class LoginBean implements Serializable {

    private static final Logger logger = Logger.getLogger(LoginBean.class);
    private static final String ERROR = "index.jsf";
    private static final String EXITO_ADMIN = "exito_admin";
    private static final String EXITO_USER = "exito_usuario";
    private InputText usuario;
    private Password clave;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public InputText getUsuario() {
        return usuario;
    }

    public void setUsuario(InputText usuario) {
        this.usuario = usuario;
    }

    public Password getClave() {
        return clave;
    }

    public void setClave(Password clave) {
        this.clave = clave;
    }

    public String autenticarse() {
        String outcome = ERROR;

        //Cierta Logica de negocio

        String usuario1 = (String) this.usuario.getValue();

        String clave1 = (String) this.clave.getValue();

        logger.info("usuario: " + usuario1 + " clave: " + clave1);


        //addMessage("Datos: ", "usuario: " + usuario1 + " clave: " + clave1);

        if (usuario1 != null && usuario1.length() > 0 && clave1 != null && clave1.length() > 0) {

            boolean entro = false;

            if (usuario1.equals(UserDTO.ADMIN) && clave1.equals(UserDTO.ADMIN_PWD)) {

                outcome = EXITO_ADMIN;
                entro = true;
            }

            if (usuario1.equals(UserDTO.USER) && clave1.equals(UserDTO.USER_PWD)) {

                outcome = EXITO_USER;
                entro = true;
            }

            if (entro == false) {

                addMessage("Error de Autenticacion", "Usuario/Clave invalidas");
            } else {

                UserDTO dtoUsuario = new UserDTO(usuario1, clave1);
                agregarASession(dtoUsuario, "login");
            }



        } else {

            addMessage("Error de Autenticacion: ", "El Usuario y Clave son requeridos!!!");
        }


        FacesContext.getCurrentInstance().renderResponse();

        return outcome;
    }

    private void addMessage(String resumen, String mensaje) {

        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(resumen, mensaje));

    }

    private void agregarASession(Object valor, String key) {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(key, valor);
    }
}
