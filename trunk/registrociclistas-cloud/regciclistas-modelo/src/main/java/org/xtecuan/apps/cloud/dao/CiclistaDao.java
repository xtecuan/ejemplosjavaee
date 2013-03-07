/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao;

import org.xtecuan.apps.cloud.entities.Ciclista;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;

/**
 *
 * @author xtecuan
 */
public interface CiclistaDao extends GenericDao<Ciclista> {

    public Ciclista guardarCiclista(Ciclista ciclista, DetalleCiclista detalle);

    public Ciclista actualizarCiclista(Ciclista ciclista, DetalleCiclista detalle);

    public void borrarCiclista(Ciclista ciclista);
}
