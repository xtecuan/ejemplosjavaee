/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.vistacontrolador.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * Web application lifecycle listener.
 *
 * @author xtecuan
 */
public class ListenerContexto implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(ListenerContexto.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String nombreApp = sce.getServletContext().getContextPath();
        logger.info("Inicializando aplicacion blah: " + nombreApp);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info(sce.toString());
        String nombreApp = sce.getServletContext().getContextPath();
        logger.info("Destruyendo la aplicacion blah: " + nombreApp);
    }
}
