/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao;

import java.util.List;
import org.xtecuan.apps.cloud.entities.Departamento;

/**
 *
 * @author xtecuan
 */
public interface DepartamentoDao extends GenericDao<Departamento> {

    public List<Departamento> findByCodpais(Integer idPais);
}
