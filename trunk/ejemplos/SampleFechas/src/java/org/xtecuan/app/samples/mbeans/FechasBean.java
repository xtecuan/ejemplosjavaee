/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.app.samples.mbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author xtecuan
 */
public class FechasBean implements Serializable {

    private Date fechaSeleccionada;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", new Locale("ES"));

    /**
     * Creates a new instance of FechasBean
     */
    public FechasBean() {
    }

    public Date getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public void setFechaSeleccionada(Date fechaSeleccionada) {
        this.fechaSeleccionada = fechaSeleccionada;
    }

    public void guardarAlgo(ActionEvent event) {

        if (fechaSeleccionada != null) {

            addMessage("Se selecciono la fecha", sdf.format(fechaSeleccionada));
        }

    }

    private void addMessage(String summary, String detail) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary, detail));
    }
}
