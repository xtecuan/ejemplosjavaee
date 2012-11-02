/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.renderizadormsg.impl;

import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;
import sv.edu.ufg.vistacontrolador.app.renderizadormsg.RenderizarMensaje;

/**
 *
 * @author ufg
 */
public class RenderizadorCmd implements RenderizarMensaje{
    
    private ProveedorMensajes mensajes;

    @Override
    public void mostrar() {
        System.out.println(mensajes.obtenerMensaje());
    }

    public void setMensajes(ProveedorMensajes mensajes) {
        this.mensajes = mensajes;
    }
    
    
    
}
