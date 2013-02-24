/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ws.webservice;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.xtecuan.modelo.ws.dto.AlumnosDTO;
import org.xtecuan.modelo.ws.ejb.AlumnosService;

/**
 *
 * @author xtecuan
 */
@WebService(serviceName = "AlumnosWebService")
@Stateless()
public class AlumnosWebService {
    @EJB
    private AlumnosService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "buscarAlumnoPorId")
    public AlumnosDTO buscarAlumnoPorId(@WebParam(name = "id") String id) {
        return ejbRef.buscarAlumnoPorId(id);
    }

    @WebMethod(operationName = "buscarTodosLosAlumnos")
    public List<AlumnosDTO> buscarTodosLosAlumnos() {
        return ejbRef.buscarTodosLosAlumnos();
    }
    
}
