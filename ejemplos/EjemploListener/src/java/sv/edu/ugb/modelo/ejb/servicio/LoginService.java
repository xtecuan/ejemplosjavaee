/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.modelo.ejb.servicio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import sv.edu.ugb.modelo.ejb.facade.UsuarioFacade;
import sv.edu.ugb.modelo.entidades.Usuario;

/**
 *
 * @author xtecuan
 */
@Stateless
public class LoginService {

    private static final Logger logger = Logger.getLogger(LoginService.class);
    @EJB
    private UsuarioFacade usuarioFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Usuario doLogin(String login, String password) {

        Usuario usuario = null;

        try {

            Query query = usuarioFacade.getEm().createNamedQuery("Usuario.doLogin");
            query.setParameter("login", login);
            query.setParameter("password", password);

            usuario = (Usuario) query.getSingleResult();

        } catch (Exception ex) {
            logger.error("Login Invalido: ", ex);
        }

        return usuario;
    }
}
