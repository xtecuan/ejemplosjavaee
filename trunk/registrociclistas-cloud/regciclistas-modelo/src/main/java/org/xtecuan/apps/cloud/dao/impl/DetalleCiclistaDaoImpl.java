/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.DetalleCiclistaDao;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;

/**
 *
 * @author xtecuan
 */
@Repository
public class DetalleCiclistaDaoImpl extends GenericDaoImpl<DetalleCiclista> implements DetalleCiclistaDao, Serializable {

    private static final long serialVersionUID = 1L;

    public DetalleCiclistaDaoImpl() {
        super(DetalleCiclista.class);
    }
}
