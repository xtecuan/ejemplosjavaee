/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.MarcaDao;
import org.xtecuan.apps.cloud.entities.Marca;

/**
 *
 * @author xtecuan
 */
@Repository
public class MarcaDaoImpl extends GenericDaoImpl<Marca> implements MarcaDao, Serializable {

    private static final long serialVersionUID = 1L;

    public MarcaDaoImpl() {
        super(Marca.class);
    }
}
