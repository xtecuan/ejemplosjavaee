/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import org.xtecuan.modelo.ejb.facade.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.xtecuan.modelo.entidades.CatMunicipios;

/**
 *
 * @author xtecuan
 */
@Stateless
public class CatMunicipiosFacade extends AbstractFacade<CatMunicipios> {
    @PersistenceContext(unitName = "registrociclistas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatMunicipiosFacade() {
        super(CatMunicipios.class);
    }
    
}
