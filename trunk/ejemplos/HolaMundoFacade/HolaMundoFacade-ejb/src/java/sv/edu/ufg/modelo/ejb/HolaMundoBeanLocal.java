/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.ejb;

import javax.ejb.Local;

/**
 *
 * @author xtecuan
 */
@Local
public interface HolaMundoBeanLocal {

    String holaMundo(String nombreUsuario);
    
}
