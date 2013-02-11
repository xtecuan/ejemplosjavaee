/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.ejb.facade.CiclistasFacade;
import org.xtecuan.modelo.entidades.Ciclistas;
import org.xtecuan.modelo.entidades.DetCiclistas;
import org.xtecuan.vistacontrolador.modelo.CiclistasDataModel;

/**
 *
 * @author xtecuan
 */
public class ManttoCiclistas implements Serializable {

    private static final Logger logger = Logger.getLogger(ManttoCiclistas.class);
    @EJB
    private CiclistasFacade ciclistasFacade;
    private Ciclistas current;
    private String clave1;
    private CiclistasDataModel modeloTabla;

    /**
     * Creates a new instance of ManttoCiclistas
     */
    public ManttoCiclistas() {
    }

    @PostConstruct
    private void init() {
        initInstance();
        initModeloTabla();
    }

    private void initModeloTabla() {

        modeloTabla = new CiclistasDataModel(ciclistasFacade);
    }

    private void initInstance() {

        current = new Ciclistas();
//        current.setDetCiclistas(new DetCiclistas());
        clave1 = "";

    }

    public Ciclistas getCurrent() {
        return current;
    }

    public void setCurrent(Ciclistas current) {
        this.current = current;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public void guardarCiclista(ActionEvent event) {

        if (current.getClave().equals(clave1)) {

            ciclistasFacade.create(current);

            logger.info("Se creo un ciclista con id: " + current.getIdCiclista());
            addMessage("Se creo un ciclista: ", "Id: " + current.getIdCiclista());

            initInstance();
            initModeloTabla();

        } else {
            logger.error("Se requiere que las dos claves coincidan para el registro de ciclistas!!!");

            addError("Error al validar las claves: ", "Las dos claves deben coincidir");
        }

    }

    public void addMessage(String summary, String detail) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                summary, detail));
    }

    public void addError(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                summary, detail));
    }

    public CiclistasDataModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(CiclistasDataModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
}
