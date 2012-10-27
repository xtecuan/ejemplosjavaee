/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.ejb;

import sv.edu.ufg.modelo.ejb.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ufg.modelo.entidades.Alumnos;

/**
 *
 * @author ufg
 */
@Stateless
public class AlumnosFacade extends AbstractFacade<Alumnos> implements AlumnosFacadeLocal {
    @PersistenceContext(unitName = "AlumnosApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnosFacade() {
        super(Alumnos.class);
    }
    
}
