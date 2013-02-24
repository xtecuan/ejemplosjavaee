/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador.beans;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.ws.WebServiceRef;
import org.xtecuan.vistacontrolador.ws.client.AlumnosDTO;
import org.xtecuan.vistacontrolador.ws.client.AlumnosWebService_Service;

/**
 *
 * @author xtecuan
 */
public class ClienteWS implements Serializable{

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AlumnosWebService/AlumnosWebService.wsdl")
    private AlumnosWebService_Service service;
    private String id;
    private AlumnosDTO dto;

    /**
     * Creates a new instance of ClienteWS
     */
    public ClienteWS() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void buscarAlumno(ActionEvent event) {

        if (id != null && id.length() > 0) {


            dto = buscarAlumnoPorId(id);

            FacesContext.getCurrentInstance().renderResponse();

        }


    }

    private AlumnosDTO buscarAlumnoPorId(java.lang.String id) {
        org.xtecuan.vistacontrolador.ws.client.AlumnosWebService port = service.getAlumnosWebServicePort();
        return port.buscarAlumnoPorId(id);
    }

    public AlumnosDTO getDto() {
        return dto;
    }

    public void setDto(AlumnosDTO dto) {
        this.dto = dto;
    }
}
