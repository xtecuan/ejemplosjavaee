/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.modelo.ejb.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ugb.modelo.entidades.Alumnos;

/**
 *
 * @author xtecuan
 */
@Stateless
public class AlumnosFacade extends AbstractFacade<Alumnos> {
    @PersistenceContext(unitName = "EjemploListenerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnosFacade() {
        super(Alumnos.class);
    }
    
}
