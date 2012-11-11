/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import sv.edu.ufg.modelo.entidades.Departamentos;
import sv.edu.ufg.modelo.entidades.Municipios;
import sv.edu.ufg.modelo.servicios.DepartamentosService;
import sv.edu.ufg.modelo.servicios.MunicipiosService;
import sv.edu.ufg.vistacontrolador.enums.CabeceraEnum;

/**
 *
 * @author xtecuan
 */
public class MunisBean extends GenericBean implements Serializable{
    
    private Municipios current;
    private MunicipiosService service;
    private DepartamentosService serviceDeptos;
    private List<SelectItem> itemsDeptos;
    private List<SelectItem> itemsCabecera;

    /**
     * Creates a new instance of MunisBean
     */
    public MunisBean() {
    }
    
    @PostConstruct
    private void init(){
        service = (MunicipiosService) getMyBean("MunicipiosService");
        serviceDeptos = (DepartamentosService) getMyBean("DepartamentosService");
        initItemsDeptos();
        initItemsCabecera();
        
    }
    
    private void initItemsDeptos(){
        List<Departamentos> deptos = serviceDeptos.encontrarTodos();
        itemsDeptos = new ArrayList<SelectItem>(0);
        for (Departamentos depto : deptos) {
            
            itemsDeptos.add(new SelectItem(depto.getIdDepto(), depto.getNombreDepto()));
        }
    }
    
    private void initItemsCabecera(){
        
        itemsCabecera = new ArrayList<SelectItem>(0);
        for (CabeceraEnum c : CabeceraEnum.values()) {
            
            itemsDeptos.add(new SelectItem(c.getValue(), c.getDescr()));
        }
    }

    public Municipios getCurrent() {
        
        if(current==null){
            current = new Municipios();
            current.setIdDepto(new Departamentos());
        }
        
        return current;
    }

    public void setCurrent(Municipios current) {
        this.current = current;
    }
    
    public void guardarMuni(ActionEvent event){
        
        if(current!=null && current.getNombreMuni()!=null &&  current.getCabecera()>-1){
            
            current = service.guardarMuni(current);
            addMessage("Se guardo una entidad con id: "+current.getIdMuni());
        }
        
        
        
        FacesContext.getCurrentInstance().renderResponse();
        
    }

    public List<SelectItem> getItemsDeptos() {
        return itemsDeptos;
    }

    public void setItemsDeptos(List<SelectItem> itemsDeptos) {
        this.itemsDeptos = itemsDeptos;
    }

    public List<SelectItem> getItemsCabecera() {
        return itemsCabecera;
    }

    public void setItemsCabecera(List<SelectItem> itemsCabecera) {
        this.itemsCabecera = itemsCabecera;
    }
    
    
}
