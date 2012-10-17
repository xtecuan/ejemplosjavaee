/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.vistacontrolador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.ejb.AlumnosFacadeLocal;
import org.xtecuan.ejemplos.modelo.excepciones.ManttoTablaAlumnosException;

/**
 *
 * @author xtecuan
 */
public class AlumnosBean implements Serializable {

    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    private AlumnosDTO alumno;
    private static final Logger logger = Logger.getLogger(AlumnosBean.class);
    private List<SelectItem> itemsDias = new ArrayList<SelectItem>(0);
    private List<SelectItem> itemsMeses = new ArrayList<SelectItem>(0);
    private List<SelectItem> itemsAnnios = new ArrayList<SelectItem>(0);
    private static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
    private Integer dia;
    private Integer mes;
    private Integer annio;

    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
        init();
    }

    //@PostConstruct
    private void init() {
        popularDias();
        popularMeses();
        popularAnnios();
    }

    private void popularDias() {

//        if (itemsDias.size()==0) {

            for (int i = 1; i <= 31; i++) {

                itemsDias.add(new SelectItem(Integer.valueOf(i), Integer.valueOf(i).toString()));

            }
//        }
    }

    private void popularMeses() {

//        if (itemsMeses.isEmpty()) {

            for (int i = 1; i <= 12; i++) {

                itemsMeses.add(new SelectItem(Integer.valueOf(i), Integer.valueOf(i).toString()));

            }
//        }
    }

    private void popularAnnios() {

        Date fa = new Date();

        String annio = sdfYear.format(fa);

//        if (itemsAnnios.isEmpty()) {

            for (int i = 1900; i <= Integer.valueOf(annio).intValue(); i++) {
                itemsAnnios.add(new SelectItem(Integer.valueOf(i), Integer.valueOf(i).toString()));

            }
//        }
    }

    public AlumnosDTO getAlumno() {

        if (alumno == null) {
            alumno = new AlumnosDTO();
        }

        return alumno;
    }

    public void setAlumno(AlumnosDTO alumno) {
        this.alumno = alumno;
    }

    public void guardarInformacion(ActionEvent event) {
        AlumnosDTO salida = null;

        if (alumno != null) {
            try {
                salida = alumnosFacade.guardarAlumnos(alumno);

                if (salida != null) {

                    adicionarMensaje("Se ingreso un alumno con id: " + salida.getId());
                }

            } catch (ManttoTablaAlumnosException ex) {

                logger.error("Error al guardar el alumno!!!", ex);

                adicionarError("Error al guardar el alumno en la base de datos!!!");
            }
        }

    }

    private void adicionarMensaje(String mensaje) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje));
    }

    private void adicionarError(String error) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", error));
    }

    public List<SelectItem> getItemsDias() {
        return itemsDias;
    }

    public void setItemsDias(List<SelectItem> itemsDias) {
        this.itemsDias = itemsDias;
    }

    public List<SelectItem> getItemsMeses() {
        return itemsMeses;
    }

    public void setItemsMeses(List<SelectItem> itemsMeses) {
        this.itemsMeses = itemsMeses;
    }

    public List<SelectItem> getItemsAnnios() {
        return itemsAnnios;
    }

    public void setItemsAnnios(List<SelectItem> itemsAnnios) {
        this.itemsAnnios = itemsAnnios;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }
    
    
}
