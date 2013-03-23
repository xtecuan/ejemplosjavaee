/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.preespecializacion.proyectos.holamundospring_webapp.servicios;

import java.util.List;
import org.xtecuan.modelo.ws.dto.AlumnosDTO;

/**
 *
 * @author xtecuan
 */
public interface AlumnosDao {
    
    public List<AlumnosDTO> listarAlumnos();
    
}
