/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.renderizadormsg.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;
import sv.edu.ufg.vistacontrolador.app.renderizadormsg.RenderizarMensaje;

/**
 *
 * @author ufg
 */
public class RenderizadorGedit implements RenderizarMensaje{

    private ProveedorMensajes mensajes;
    
    private static final String FILENAME=".gedit.txt";
    private static final String PATH=System.getProperty("user.home");
    private static File file;
    
    
    
    @Override
    public void mostrar() {
        try {
            if(file==null){
                file = new File(PATH, FILENAME);
            }
            
            String msg = mensajes.obtenerMensaje();
            
            List<String> texto = new ArrayList<String>(0);
            texto.add(msg);
            
            try {
                FileUtils.writeLines(file, texto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
           
            
            Runtime.getRuntime().exec("gedit "+file.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }

    public void setMensajes(ProveedorMensajes mensajes) {
        this.mensajes = mensajes;
    }
    
}
