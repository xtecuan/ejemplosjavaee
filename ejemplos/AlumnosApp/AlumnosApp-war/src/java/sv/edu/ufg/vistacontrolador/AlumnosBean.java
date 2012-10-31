/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.ufg.modelo.ejb.AlumnosFacadeLocal;
import sv.edu.ufg.modelo.entidades.Alumnos;

/**
 *
 * @author ufg
 */
public class AlumnosBean implements Serializable {

    private static Logger logger = Logger.getLogger(AlumnosBean.class);
    @EJB
    private AlumnosFacadeLocal alumnosFacade;
//    private ListDataModel<Alumnos> modeloTabla = new ListDataModel<Alumnos>();
    private Alumnos selected = new Alumnos();
//    private DataTable tabla = new DataTable();
    private LazyDataModel<Alumnos> modeloTabla;

    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
    }

    @PostConstruct
    private void init() {
//        List<Alumnos> listado = alumnosFacade.findAll();
//        modeloTabla = new ListDataModel<Alumnos>(listado);
        initLazyModel();
    }

    private void initLazyModel() {
        modeloTabla = new LazyDataModel<Alumnos>() {
            @Override
            public Alumnos getRowData(String rowKey) {



                Integer id = Integer.valueOf(rowKey);

                return alumnosFacade.find(id);

            }

            @Override
            public Object getRowKey(Alumnos object) {
                return object.getId();
            }

            @Override
            public List<Alumnos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
                List<Alumnos> listado = new ArrayList<Alumnos>(0);

                this.setRowCount(alumnosFacade.count());

                int[] rango = {first * pageSize, first * pageSize + pageSize};

                listado = alumnosFacade.findRange(rango);

                return listado;
            }
        };
    }

    public LazyDataModel<Alumnos> getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(LazyDataModel<Alumnos> modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

//    public ListDataModel<Alumnos> getModeloTabla() {
//        return modeloTabla;
//    }
//
//    public void setModeloTabla(ListDataModel<Alumnos> modeloTabla) {
//        this.modeloTabla = modeloTabla;
//    }
    public Alumnos getSelected() {
        return selected;
    }

    public void setSelected(Alumnos selected) {
        this.selected = selected;
    }

//    public DataTable getTabla() {
//        return tabla;
//    }
//
//    public void setTabla(DataTable tabla) {
//        this.tabla = tabla;
//    }

    public void prepararEdicion(ActionEvent event) {



        logger.info("Se selecciono para edicion el registro: " + this.selected);
    }

    public void borrar(ActionEvent event) {

        if (selected != null) {

            logger.info("Se selecciono para borrar el registro: " + this.selected);

            try {

                alumnosFacade.remove(selected);
                adicionarMensaje("Se borro el registro con id: " + selected.getId());

                initLazyModel();

            } catch (Exception e) {

                adicionarError("Hubo un error borrando el registro con id: " + selected.getId());
            }
        }else{
            adicionarError("Seleccione un registro para borrar!!!");
        }

    }

    private void adicionarMensaje(String mensaje) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje));
    }

    private void adicionarError(String error) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", error));
    }
}
