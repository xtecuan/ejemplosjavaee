/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.renderizadormsg.impl;

import javax.swing.JOptionPane;
import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;
import sv.edu.ufg.vistacontrolador.app.renderizadormsg.RenderizarMensaje;

/**
 *
 * @author ufg
 */
public class RenderizadorGui implements RenderizarMensaje{

    private ProveedorMensajes mensajes;

    public RenderizadorGui(ProveedorMensajes mensajes) {
        this.mensajes = mensajes;
    }
    
    
    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, mensajes.obtenerMensaje());
    }
    
}
