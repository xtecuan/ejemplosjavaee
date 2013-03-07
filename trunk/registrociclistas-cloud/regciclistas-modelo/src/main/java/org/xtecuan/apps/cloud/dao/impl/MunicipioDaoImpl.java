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
import org.xtecuan.apps.cloud.dao.MunicipioDao;
import org.xtecuan.apps.cloud.entities.Municipio;

/**
 *
 * @author xtecuan
 */
@Repository
public class MunicipioDaoImpl extends GenericDaoImpl<Municipio> implements MunicipioDao, Serializable {

    private static final long serialVersionUID = 1L;

    public MunicipioDaoImpl() {
        super(Municipio.class);
    }

    public List<Municipio> findByCoddepto(Integer coddepto) {

        List<Municipio> salida = new ArrayList<Municipio>(0);


        try {

            Query query = getEm().createNamedQuery("Municipio.findByCoddepto", Municipio.class);

            query.setParameter("coddepto", coddepto);

            salida = query.getResultList();

        } catch (Exception e) {

            getLogger().error("Error al encontrar los municipios para el depto dado: " + coddepto, e);
        }

        return salida;
    }
}
