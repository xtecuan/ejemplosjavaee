/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import sv.edu.ufg.vistacontrolador.app.renderizadormsg.impl.RenderizadorCmd;
import sv.edu.ufg.vistacontrolador.app.renderizadormsg.impl.RenderizadorGui;

/**
 *
 * @author ufg
 */
public class HolaMundoSpring {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/beans.xml"));

        RenderizadorCmd cmd = (RenderizadorCmd) factory.getBean("RenderizadorCmd");

        cmd.mostrar();

        RenderizadorGui gui = (RenderizadorGui) factory.getBean("RenderizadorGui");

        gui.mostrar();


        RenderizadorCmd cmd1 = (RenderizadorCmd) factory.getBean("RenderizadorCmd1");

        cmd1.mostrar();

        RenderizadorGui gui1 = (RenderizadorGui) factory.getBean("RenderizadorGui1");

        gui1.mostrar();



    }
}
