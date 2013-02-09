/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import org.xtecuan.modelo.ejb.facade.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.xtecuan.modelo.entidades.CatPaises;

/**
 *
 * @author xtecuan
 */
@Stateless
public class CatPaisesFacade extends AbstractFacade<CatPaises> {
    @PersistenceContext(unitName = "registrociclistas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatPaisesFacade() {
        super(CatPaises.class);
    }
    
}
