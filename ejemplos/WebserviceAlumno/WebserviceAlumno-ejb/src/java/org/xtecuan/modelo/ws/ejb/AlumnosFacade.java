/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ws.ejb;

import org.xtecuan.modelo.ws.ejb.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.xtecuan.modelo.ws.entidades.Alumnos;

/**
 *
 * @author xtecuan
 */
@Stateless
public class AlumnosFacade extends AbstractFacade<Alumnos> {
    @PersistenceContext(unitName = "WebserviceAlumno-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnosFacade() {
        super(Alumnos.class);
    }
    
}
