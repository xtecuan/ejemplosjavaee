/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.ModeloDao;
import org.xtecuan.apps.cloud.entities.Modelo;

/**
 *
 * @author xtecuan
 */
@Repository
public class ModeloDaoImpl extends GenericDaoImpl<Modelo> implements ModeloDao, Serializable {

    private static final long serialVersionUID = 1L;

    public ModeloDaoImpl() {
        super(Modelo.class);
    }
}
