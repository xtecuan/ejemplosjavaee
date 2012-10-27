/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.ejb;

import java.util.List;
import javax.ejb.Local;
import sv.edu.ufg.modelo.entidades.Alumnos;

/**
 *
 * @author ufg
 */
@Local
public interface AlumnosFacadeLocal {

    void create(Alumnos alumnos);

    void edit(Alumnos alumnos);

    void remove(Alumnos alumnos);

    Alumnos find(Object id);

    List<Alumnos> findAll();

    List<Alumnos> findRange(int[] range);

    int count();
    
}
