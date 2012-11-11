/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author xtecuan
 */
public class GenericBean implements Serializable {

    private static Logger logger = Logger.getLogger(GenericBean.class);

    /**
     * Creates a new instance of GenericBean
     */
    public GenericBean() {
    }

    public HttpServletRequest getRequest() {

        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public HttpSession getSession() {

        return getRequest().getSession();
    }

    public Object getMyBean(String beanName) {

        ApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(this.getSession().getServletContext());

        return ctx.getBean(beanName);

    }

    public static Logger getLogger() {
        return logger;
    }

    public void addMessage(String msg) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito:", msg));

    }
}
