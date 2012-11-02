/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.proveedormsg.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;

/**
 *
 * @author ufg
 */
public class PropertiesProveedor implements ProveedorMensajes{
    
    private static final String KEY="hello_key";
    
    private static Properties config;

    public static Properties getConfig() {
        
        if(config==null){
            config = new Properties();
            
            File file = new File("./conf/holamundoprovider.properties");
            try {
                FileInputStream fis = new FileInputStream(file);
                
                config.load(fis);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return config;
    }
    
    

    @Override
    public String obtenerMensaje() {
        return getConfig().getProperty(KEY);
    }
    
}
