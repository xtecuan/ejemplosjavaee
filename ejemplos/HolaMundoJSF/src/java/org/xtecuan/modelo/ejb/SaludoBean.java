/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author xtecuan
 */
@Stateless
public class SaludoBean {

    public String saludarUsuario(String nombres, String apellidos) {
        return "Bienvenido al sistema: "+nombres+" "+apellidos;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    

}
