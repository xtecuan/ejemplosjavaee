/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.services;

import java.io.Serializable;
import java.util.List;
import org.xtecuan.apps.cloud.dao.CiclistaDao;
import org.xtecuan.apps.cloud.entities.Ciclista;
import org.xtecuan.apps.cloud.entities.Departamento;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;
import org.xtecuan.apps.cloud.entities.Municipio;
import org.xtecuan.apps.cloud.entities.Pais;

/**
 *
 * @author xtecuan
 */
public interface ManttoCiclistasService extends Serializable {

    public List<Pais> findAllPaises();

    public List<Departamento> findDeptosByIdPais(Integer idPais);

    public List<Municipio> findMunisByCodDepto(Integer coddepto);

    public List<Ciclista> findCiclistasByRange(int[] range);

    public Ciclista guardarCiclista(Ciclista ciclista, DetalleCiclista detalle);

    public Ciclista actualizarCiclista(Ciclista ciclista, DetalleCiclista detalle);

    public void borrarCiclista(Ciclista ciclista);
    
    public CiclistaDao getServiceCiclista();
}
