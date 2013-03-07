/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.DepartamentoDao;
import org.xtecuan.apps.cloud.entities.Departamento;

/**
 *
 * @author xtecuan
 */
@Repository
public class DepartamentoDaoImpl extends GenericDaoImpl<Departamento> implements DepartamentoDao, Serializable {

    private static final long serialVersionUID = 1L;

    public DepartamentoDaoImpl() {
        super(Departamento.class);
    }
    
    public List<Departamento> findByCodpais(Integer idPais) {

        List<Departamento> salida = new ArrayList<Departamento>(0);


        try {

            Query query = getEm().createNamedQuery("Departamento.findByCodPais", Departamento.class);

            query.setParameter("idPais", idPais);

            salida = query.getResultList();

        } catch (Exception e) {

            getLogger().error("Error al encontrar los departamentos para el idPais: " + idPais, e);
        }


        return salida;

    }
}
