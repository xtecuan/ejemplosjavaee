/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao;

import java.util.List;
import org.xtecuan.apps.cloud.entities.Municipio;

/**
 *
 * @author xtecuan
 */
public interface MunicipioDao extends GenericDao<Municipio> {

    public List<Municipio> findByCoddepto(Integer coddepto);
}
