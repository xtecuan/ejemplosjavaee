/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import java.util.ArrayList;
import java.util.List;
import org.xtecuan.modelo.ejb.facade.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<CatMunicipios> findByCoddepto(Integer coddepto) {

        List<CatMunicipios> salida = new ArrayList<CatMunicipios>(0);


        try {

            Query query = getEntityManager().createNamedQuery("CatMunicipios.findByCoddepto", CatMunicipios.class);

            query.setParameter("coddepto", coddepto);

            salida = query.getResultList();

        } catch (Exception e) {

            getLogger().error("Error al encontrar los municipios para el depto dado: " + coddepto, e);
        }

        return salida;
    }
}
