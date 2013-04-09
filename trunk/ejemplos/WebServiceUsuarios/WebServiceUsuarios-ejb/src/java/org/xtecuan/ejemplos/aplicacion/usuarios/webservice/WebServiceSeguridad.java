/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.aplicacion.usuarios.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.aplicacion.usuarios.dto.UsuarioDTO;
import org.xtecuan.ejemplos.aplicacion.usuarios.entidades.Usuario;
import org.xtecuan.ejemplos.aplicacion.usuarios.facade.UsuarioFacade;

/**
 *
 * @author xtecuan
 */
@WebService(serviceName = "WebServiceSeguridad")
@Stateless()
public class WebServiceSeguridad {

    private static Logger logger = Logger.getLogger(WebServiceSeguridad.class);
    @EJB
    private UsuarioFacade facade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "autenticarUsuario")
    public UsuarioDTO autenticarUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        UsuarioDTO dto = null;

        Usuario ent = null;

        try {

            ent = facade.autenticarUsuario(usuario, clave);

            if (ent != null) {
                dto = facade.fromEntity2DTO(ent);
            }

        } catch (Exception e) {
            logger.error("Usuario y clave invalidos para las credenciales: " + usuario + "/" + clave);
        }

        return dto;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarUsuarios")
    public java.util.List<org.xtecuan.ejemplos.aplicacion.usuarios.dto.UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>(0);

        try {

            List<Usuario> ents = facade.findAll();

            for (Usuario ent : ents) {

                dtos.add(facade.fromEntity2DTO(ent));
            }


        } catch (Exception e) {
        }
        return dtos;
    }
}
