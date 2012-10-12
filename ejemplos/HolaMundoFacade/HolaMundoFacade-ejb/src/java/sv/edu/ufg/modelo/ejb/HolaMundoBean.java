/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author xtecuan
 */
@WebService
@Stateless
public class HolaMundoBean implements HolaMundoBeanLocal {

    @WebMethod
    @Override
    public String holaMundo(@WebParam(name = "usuario") String nombreUsuario) {
        return "Hola Mundo usuario: " + nombreUsuario;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
