/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.servicios;

import java.io.Serializable;
import sv.edu.ufg.modelo.entidades.Municipios;

/**
 *
 * @author xtecuan
 */
public interface MunicipiosService extends Serializable {

    public Municipios findById(Integer idMuni);

    public int contarTodos();

    public Municipios guardarMuni(Municipios muni);
}
