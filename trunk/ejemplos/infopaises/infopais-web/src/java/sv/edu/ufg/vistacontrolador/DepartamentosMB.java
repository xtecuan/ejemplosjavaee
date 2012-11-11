/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sv.edu.ufg.modelo.entidades.Departamentos;
import sv.edu.ufg.modelo.entidades.Municipios;
import sv.edu.ufg.modelo.servicios.DepartamentosService;
import sv.edu.ufg.modelo.servicios.MunicipiosService;

/**
 *
 * @author xtecuan
 */
public class DepartamentosMB extends GenericBean implements Serializable {

   
    
    private DepartamentosService service;
    private MunicipiosService serviceMunis;
    private LazyDataModel<Departamentos> modelo;
    private Departamentos selected;
    private LazyDataModel<Municipios> modeloMunis;

    /**
     * Creates a new instance of DepartamentosMB
     */
    public DepartamentosMB() {
    }

    @PostConstruct
    private void init() {

        service = (DepartamentosService) getMyBean("DepartamentosService");

        serviceMunis = (MunicipiosService) getMyBean("MunicipiosService");

        modelo = new LazyDataModel<Departamentos>() {
            @Override
            public Departamentos getRowData(String rowKey) {

                Integer idDepto = Integer.parseInt(rowKey);

                return service.encontrarPorId(idDepto);

            }

            @Override
            public Object getRowKey(Departamentos object) {
                return object.getIdDepto();
            }

            @Override
            public void setRowIndex(int rowIndex) {
                /*
                 * The following is in ancestor (LazyDataModel): this.rowIndex =
                 * rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
                 */
                if (rowIndex == -1 || getPageSize() == 0) {
                    super.setRowIndex(-1);
                } else {
                    super.setRowIndex(rowIndex % getPageSize());
                }
            }

            @Override
            public List<Departamentos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                this.setRowCount(service.contarTodos());

                this.setPageSize(pageSize);

                this.setRowIndex(first);

                return service.encontrarPorUnRango(first, pageSize);

            }
        };
    }

    

    public DepartamentosService getService() {
        return service;
    }

    public void setService(DepartamentosService service) {
        this.service = service;
    }

    public LazyDataModel<Departamentos> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<Departamentos> modelo) {
        this.modelo = modelo;
    }

    public Departamentos getSelected() {

        if (selected == null) {
            selected = new Departamentos();
        }

        return selected;
    }

    public void setSelected(Departamentos selected) {
        this.selected = selected;
    }

    public void mostrarMunis(ActionEvent event) {

        if (selected != null && selected.getIdDepto() > 0) {


            getLogger().info("Se selecciono el depto: "+selected);

            modeloMunis = new LazyDataModel<Municipios>() {
                @Override
                public Object getRowKey(Municipios object) {
                    return object.getIdMuni();
                }

                @Override
                public Municipios getRowData(String rowKey) {
                    Integer idMuni = Integer.valueOf(rowKey);

                    return serviceMunis.findById(idMuni);
                }

                @Override
                public void setRowIndex(int rowIndex) {
                    /*
                     * The following is in ancestor (LazyDataModel): this.rowIndex =
                     * rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
                     */
                    if (rowIndex == -1 || getPageSize() == 0) {
                        super.setRowIndex(-1);
                    } else {
                        super.setRowIndex(rowIndex % getPageSize());
                    }
                }

                @Override
                public List<Municipios> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
                    getLogger().info("Entro antes de fetch");
                    List<Municipios> munis = selected.getMunicipiosList();
                    
                    setRowCount(munis.size());
                    
                    
                    return munis;
                }
            };

        }
        
        FacesContext.getCurrentInstance().renderResponse();

    }

    public LazyDataModel<Municipios> getModeloMunis() {
        return modeloMunis;
    }

    public void setModeloMunis(LazyDataModel<Municipios> modeloMunis) {
        this.modeloMunis = modeloMunis;
    }
}
