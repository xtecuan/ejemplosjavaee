/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.modelo.app.cmd;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.servicios.JdbcService;
import org.xtecuan.ejemplos.modelo.servicios.impl.JdbcServiceImpl;

/**
 *
 * @author ufg
 */
public class App {
    
    private static XmlBeanFactory factory;
    private static final String SPRING_CFG="/myBeans.xml";
    private static final String JDBC_SERVICE="JdbcService";
    
    static{
        if(factory==null){
            factory = new XmlBeanFactory(new ClassPathResource(SPRING_CFG));
        }
    }

    public static XmlBeanFactory getFactory() {
        return factory;
    }
    
    public static JdbcService getService(){
        return (JdbcService) getFactory().getBean(JDBC_SERVICE);
    }
    
    public static void main(String[] args) {
        
        JdbcService service = getService();
        
        AlumnosDTO a =new AlumnosDTO();
        
        a.setCarnet("9999999999");
        a.setNombres("Franco");
        a.setApellidos("De Vitta");
        a.setCorreo("fdevitta@gmail.com");
        a.setFechanac(JdbcServiceImpl.getDateFromString("01-01-1967"));
        
        AlumnosDTO salida = service.guardarAlumnos(a);
        
        System.out.println(salida.getId());
        
        
        
    }
}
