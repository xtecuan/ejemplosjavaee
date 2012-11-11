/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.servicios.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.ufg.modelo.entidades.Municipios;
import sv.edu.ufg.modelo.servicios.MunicipiosService;

/**
 *
 * @author xtecuan
 */
@Transactional
public class MunicipiosServiceImpl implements MunicipiosService {

    private static final Logger logger = Logger.getLogger(MunicipiosServiceImpl.class);
    private static final long serialVersionUID = 1L;
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public Municipios findById(Integer idMuni) {
        return em.find(Municipios.class, idMuni);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public int contarTodos() {
        EntityManager em1 = this.getEm().getEntityManagerFactory().createEntityManager();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        Root<Object> rt = cq.from(Municipios.class);
        cq.select(em1.getCriteriaBuilder().count(rt));
        Query q = em1.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public Municipios guardarMuni(Municipios muni) {
        
        
        try {
            
            em.persist(muni);
            
            
        } catch (Exception e) {
            logger.error("Error al guardar el municipio: "+muni, e);
        }
        
        return muni;
    }
}
