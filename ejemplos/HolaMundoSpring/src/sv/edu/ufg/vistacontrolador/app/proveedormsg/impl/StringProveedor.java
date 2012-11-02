/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.proveedormsg.impl;

import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;

/**
 *
 * @author ufg
 */
public class StringProveedor implements ProveedorMensajes{
    
    private static final String MSG_HOLA="Hola Mundo!!!";

    @Override
    public String obtenerMensaje() {
        return MSG_HOLA;
    }
    
}
