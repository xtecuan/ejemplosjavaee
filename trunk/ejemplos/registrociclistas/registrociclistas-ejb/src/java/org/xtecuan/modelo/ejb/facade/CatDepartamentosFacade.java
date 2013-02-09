/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import org.xtecuan.modelo.ejb.facade.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.xtecuan.modelo.entidades.CatDepartamentos;

/**
 *
 * @author xtecuan
 */
@Stateless
public class CatDepartamentosFacade extends AbstractFacade<CatDepartamentos> {
    @PersistenceContext(unitName = "registrociclistas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatDepartamentosFacade() {
        super(CatDepartamentos.class);
    }
    
}
