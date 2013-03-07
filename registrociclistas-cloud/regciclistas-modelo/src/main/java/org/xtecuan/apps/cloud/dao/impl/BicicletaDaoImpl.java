/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.BicicletaDao;
import org.xtecuan.apps.cloud.entities.Bicicleta;

/**
 *
 * @author xtecuan
 */
@Repository
public class BicicletaDaoImpl extends GenericDaoImpl<Bicicleta> implements BicicletaDao, Serializable {

    private static final long serialVersionUID = 1L;

    public BicicletaDaoImpl() {
        super(Bicicleta.class);
    }
}
