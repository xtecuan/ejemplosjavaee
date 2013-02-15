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

    public List<CatDepartamentos> findByCodpais(Integer idPais) {

        List<CatDepartamentos> salida = new ArrayList<CatDepartamentos>(0);


        try {

            Query query = getEntityManager().createNamedQuery("CatDepartamentos.findByCodPais", CatDepartamentos.class);

            query.setParameter("idPais", idPais);

            salida = query.getResultList();

        } catch (Exception e) {

            getLogger().error("Error al encontrar los departamentos para el idPais: " + idPais, e);
        }


        return salida;

    }
}
