/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.spring.crud;

import com.xtesoft.xtecuannet.framework.viewcontroller.beans.XBaseBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xtecuan.ejemplos.spring.crud.modelo.services.AlumnosService;

/**
 *
 * @author xtecuan
 */
@Component(value = "alumnos")
@Scope(value = "view")
public class AlumnosBean extends XBaseBean implements Serializable{

    @Autowired
    AlumnosService service;
    
    private AlumnosTableModel model;

    public AlumnosTableModel getModel() {
        return model;
    }

    public void setModel(AlumnosTableModel model) {
        this.model = model;
    }
    
    
    

    public void setService(AlumnosService service) {
        this.service = service;
    }
    
    
    
    /**
     * Creates a new instance of Alumnos
     */
    public AlumnosBean() {
    }
    
    @PostConstruct
    private void init(){
        
        System.out.println(service.count());
        
        this.model = new AlumnosTableModel(service);
    }
    
}
