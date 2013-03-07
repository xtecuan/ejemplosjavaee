/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.services.impl;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtecuan.apps.cloud.dao.CiclistaDao;
import org.xtecuan.apps.cloud.dao.DepartamentoDao;
import org.xtecuan.apps.cloud.dao.MunicipioDao;
import org.xtecuan.apps.cloud.dao.PaisDao;
import org.xtecuan.apps.cloud.entities.Ciclista;
import org.xtecuan.apps.cloud.entities.Departamento;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;
import org.xtecuan.apps.cloud.entities.Municipio;
import org.xtecuan.apps.cloud.entities.Pais;
import org.xtecuan.apps.cloud.services.ManttoCiclistasService;

/**
 *
 * @author xtecuan
 */
@Service("manttoCiclistasService")
public class ManttoCiclistasServiceImpl implements ManttoCiclistasService, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ManttoCiclistasServiceImpl.class);
    @Autowired
    private PaisDao paisDao;
    @Autowired
    private DepartamentoDao deptoDao;
    @Autowired
    private MunicipioDao muniDao;
    @Autowired
    private CiclistaDao ciclistaDao;

    @Transactional(readOnly = true)
    public List<Pais> findAllPaises() {
        return paisDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Departamento> findDeptosByIdPais(Integer idPais) {
        return deptoDao.findByCodpais(idPais);
    }

    @Transactional(readOnly = true)
    public List<Municipio> findMunisByCodDepto(Integer coddepto) {
        return muniDao.findByCoddepto(coddepto);
    }

    @Transactional(readOnly = true)
    public List<Ciclista> findCiclistasByRange(int[] range) {
        return ciclistaDao.findSomeRange(range[0], range[1]);
    }

    @Transactional
    public Ciclista guardarCiclista(Ciclista ciclista, DetalleCiclista detalle) {
        return ciclistaDao.guardarCiclista(ciclista, detalle);
    }

    @Transactional
    public Ciclista actualizarCiclista(Ciclista ciclista, DetalleCiclista detalle) {
        return ciclistaDao.actualizarCiclista(ciclista, detalle);
    }

    @Transactional
    public void borrarCiclista(Ciclista ciclista) {
        ciclistaDao.borrarCiclista(ciclista);
    }

    public void setPaisDao(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    public void setDeptoDao(DepartamentoDao deptoDao) {
        this.deptoDao = deptoDao;
    }

    public void setMuniDao(MunicipioDao muniDao) {
        this.muniDao = muniDao;
    }

    public void setCiclistaDao(CiclistaDao ciclistaDao) {
        this.ciclistaDao = ciclistaDao;
    }

    public CiclistaDao getServiceCiclista() {
        return ciclistaDao; //To change body of generated methods, choose Tools | Templates.
    }
}
