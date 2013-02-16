/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.ejb.facade.utils.SecurityToolsBean;
import org.xtecuan.modelo.entidades.CatDepartamentos;
import org.xtecuan.modelo.entidades.CatMunicipios;
import org.xtecuan.modelo.entidades.CatPaises;
import org.xtecuan.modelo.entidades.Ciclistas;
import org.xtecuan.modelo.entidades.DetCiclistas;

/**
 *
 * @author xtecuan
 */
@Stateless
public class ManttoCiclistasFacade {

    private static final Logger logger = Logger.getLogger(ManttoCiclistasFacade.class);
    @PersistenceContext(unitName = "registrociclistas-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    @EJB
    private DetCiclistasFacade detCiclistasFacade;
    @EJB
    private CiclistasFacade ciclistasFacade;
    @EJB
    private CatPaisesFacade catPaisesFacade;
    @EJB
    private CatMunicipiosFacade catMunicipiosFacade;
    @EJB
    private CatDepartamentosFacade catDepartamentosFacade;
    @EJB
    private BicicletasFacade bicicletasFacade;
    @EJB
    private CatModelosFacade catModelosFacade;
    @EJB
    private CatMarcasFacade catMarcasFacade;
    @EJB
    private SecurityToolsBean securityToolsBean;

    public List<CatPaises> findAllPaises() {
        return catPaisesFacade.findAll();
    }

    public List<CatDepartamentos> findDeptosByIdPais(Integer idPais) {
        return catDepartamentosFacade.findByCodpais(idPais);
    }

    public List<CatMunicipios> findMunisByCodDepto(Integer coddepto) {

        return catMunicipiosFacade.findByCoddepto(coddepto);

    }

    public List<Ciclistas> findCiclistasByRange(int[] range) {

        return ciclistasFacade.findRange(range);
    }

    public CiclistasFacade getFacadeCiclistas() {

        return ciclistasFacade;
    }

    public Ciclistas guardarCiclista(Ciclistas ciclista, DetCiclistas detalle) {

        try {

//            ciclista.(detalle);

            ciclista.setClave(securityToolsBean.md5Hex(ciclista.getClave()));

            detalle.setIdCiclista(ciclista);
            List<DetCiclistas> det = new ArrayList<DetCiclistas>(0);
            det.add(detalle);
//            
            ciclista.setDetCiclistasList(det);

            ciclistasFacade.create(ciclista);
            getEntityManager().flush();

//            if (ciclista.getIdCiclista() != null) {
//
//                logger.info("id_ciclista: " + ciclista.getIdCiclista());
//                detalle.setIdCiclista(ciclista);
//                detCiclistasFacade.create(detalle);
//            } else {
//                logger.info("Ni mierda!!!");
//            }

            //getEntityManager().refresh(ciclista);

//            logger.info("ciclista: " + ciclista);
//
//            if (ciclista.getIdCiclista() != null) {
//
//                detalle.setIdCiclista(ciclista.getIdCiclista());
//                detalle.setCiclistas(ciclista);
//                detCiclistasFacade.create(detalle);
//            }

        } catch (Exception e) {
            logger.error("Error al ejecutar el metodo: guardarCiclista ", e);
        }

        return ciclista;

    }

    public Ciclistas actualizarCiclista(Ciclistas ciclista, DetCiclistas detalle) {

        try {

            ciclista.setClave(securityToolsBean.md5Hex(ciclista.getClave()));

            detalle.setIdCiclista(ciclista);
            List<DetCiclistas> det = new ArrayList<DetCiclistas>(0);
            det.add(detalle);
            ciclista.setDetCiclistasList(det);
            ciclistasFacade.edit(ciclista);
            getEntityManager().flush();

        } catch (Exception e) {
            logger.error("Error al ejecutar el metodo: actualizarCiclista ", e);
        }


        return ciclista;
    }

    public void borrarCiclista(Ciclistas ciclista) {

        try {

//            for (DetCiclistas det : ciclista.getDetCiclistasList()) {
//                detCiclistasFacade.remove(det);
//            }

            ciclistasFacade.remove(ciclista);
            getEntityManager().flush();

        } catch (Exception e) {
            logger.error("Error al ejecutar el metodo: borrarCiclista ", e);
        }
    }
}
