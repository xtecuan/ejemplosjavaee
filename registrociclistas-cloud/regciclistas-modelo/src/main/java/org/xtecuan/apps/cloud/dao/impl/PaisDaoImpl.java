/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.PaisDao;
import org.xtecuan.apps.cloud.entities.Pais;

/**
 *
 * @author xtecuan
 */
@Repository
public class PaisDaoImpl extends GenericDaoImpl<Pais> implements PaisDao, Serializable {

    private static final long serialVersionUID = 1L;

    public PaisDaoImpl() {
        super(Pais.class);
    }
}
