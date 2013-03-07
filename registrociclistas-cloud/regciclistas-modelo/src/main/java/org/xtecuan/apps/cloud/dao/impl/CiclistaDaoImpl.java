/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.CiclistaDao;
import org.xtecuan.apps.cloud.entities.Ciclista;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;
import org.xtecuan.apps.cloud.utils.SecurityToolsBean;

/**
 *
 * @author xtecuan
 */
@Repository
public class CiclistaDaoImpl extends GenericDaoImpl<Ciclista> implements CiclistaDao, Serializable {

    private static final long serialVersionUID = 1L;

    public CiclistaDaoImpl() {
        super(Ciclista.class);
    }

    public Ciclista guardarCiclista(Ciclista ciclista, DetalleCiclista detalle) {
        try {
            ciclista.setClave(SecurityToolsBean.md5Hex(ciclista.getClave()));
            detalle.setIdCiclista(ciclista);
            List<DetalleCiclista> det = new ArrayList<DetalleCiclista>(0);
            det.add(detalle);
            ciclista.setDetalleCiclistaList(det);
            create(ciclista);
            getEm().flush();
        } catch (Exception e) {
            getLogger().error("Error al ejecutar el metodo: guardarCiclista ", e);
        }

        return ciclista;

    }

    public Ciclista actualizarCiclista(Ciclista ciclista, DetalleCiclista detalle) {
        try {

            ciclista.setClave(SecurityToolsBean.md5Hex(ciclista.getClave()));

            detalle.setIdCiclista(ciclista);
            List<DetalleCiclista> det = new ArrayList<DetalleCiclista>(0);
            det.add(detalle);
            ciclista.setDetalleCiclistaList(det);
            edit(ciclista);
            getEm().flush();

        } catch (Exception e) {
            getLogger().error("Error al ejecutar el metodo: actualizarCiclista ", e);
        }


        return ciclista;
    }

    public void borrarCiclista(Ciclista ciclista) {
        try {
            remove(ciclista);
            getEm().flush();

        } catch (Exception e) {
            getLogger().error("Error al ejecutar el metodo: borrarCiclista ", e);
        }
    }
}
