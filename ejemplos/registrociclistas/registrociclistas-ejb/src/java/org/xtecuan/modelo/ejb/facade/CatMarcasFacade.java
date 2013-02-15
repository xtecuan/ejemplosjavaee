/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.xtecuan.modelo.ejb.facade.impl.AbstractFacade;
import org.xtecuan.modelo.entidades.CatMarcas;

/**
 *
 * @author xtecuan
 */
@Stateless
public class CatMarcasFacade extends AbstractFacade<CatMarcas> {
    @PersistenceContext(unitName = "registrociclistas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatMarcasFacade() {
        super(CatMarcas.class);
    }
    
}
