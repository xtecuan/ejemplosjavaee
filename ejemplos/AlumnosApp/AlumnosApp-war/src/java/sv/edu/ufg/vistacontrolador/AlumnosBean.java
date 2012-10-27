/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.ListDataModel;
import sv.edu.ufg.modelo.ejb.AlumnosFacadeLocal;
import sv.edu.ufg.modelo.entidades.Alumnos;

/**
 *
 * @author ufg
 */
public class AlumnosBean implements Serializable{
    @EJB
    private AlumnosFacadeLocal alumnosFacade;

    
    
    private ListDataModel<Alumnos> modeloTabla = new ListDataModel<Alumnos>();
    
    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
    }
    
    @PostConstruct
    private void init(){
        
        List<Alumnos> listado = alumnosFacade.findAll();
        modeloTabla = new ListDataModel<Alumnos>(listado);
        
    }

    public ListDataModel<Alumnos> getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(ListDataModel<Alumnos> modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    
    
    
}
