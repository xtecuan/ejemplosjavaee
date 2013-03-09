/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.vistacontrolador.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;
import sv.edu.ugb.modelo.entidades.Usuario;

/**
 * Web application lifecycle listener.
 *
 * @author xtecuan
 */
public class ListenerParaSesiones implements HttpSessionListener, HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(ListenerParaSesiones.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("Se creo la sesion con Id: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("Se invalido la sesion con id: " + se.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();

        if (name.equals("USERLOGIN")) {

            Usuario user = (Usuario) event.getSession().getAttribute(name);

            logger.info("El usuario: " + user.getLogin() + " esta en la session con id: " + event.getSession().getId());
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        logger.info("Nada por hacer");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logger.info("Nada por hacer");
    }
}
