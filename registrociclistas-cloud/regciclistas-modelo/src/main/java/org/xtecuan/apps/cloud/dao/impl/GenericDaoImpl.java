/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.xtecuan.apps.cloud.dao.GenericDao;
import org.xtecuan.apps.cloud.utils.ClassUtils;

/**
 *
 * @author xtecuan
 */
@Repository
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);
    public static final String HELLO_FROM = "Hello from ";
    private Class<T> clazz;
    @PersistenceContext
    protected EntityManager em;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public GenericDaoImpl() {
    }

    public Logger getLogger() {
        return logger;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public EntityManager getEm() {
        return em;
    }

    public T create(T entity) {
        getEm().persist(entity);
        return entity;
    }

    public T edit(T entity) {
        getEm().merge(entity);
        return entity;
    }

    public void remove(Object entity) {

        try {
            getEm().remove(getEm().merge(entity));
        } catch (Exception ex) {

            getLogger().error("Error trying to delete entity: " + entity, ex);

        }
    }

    public T find(Object entityId) {
        return getEm().find(this.getClazz(), entityId);
    }

    public List<T> findAll() {
        EntityManager em1 = this.getEm().getEntityManagerFactory().createEntityManager();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.getClazz()));
        return em1.createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {

        EntityManager em1 = this.getEm().getEntityManagerFactory().createEntityManager();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.getClazz()));
        Query q = em1.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        EntityManager em1 = this.getEm().getEntityManagerFactory().createEntityManager();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        Root<Object> rt = cq.from(this.getClazz());
        cq.select(em1.getCriteriaBuilder().count(rt));
        Query q = em1.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public String sayHello() {
        return HELLO_FROM + this.getClazz().getCanonicalName();
    }

    public List<T> findSomeRange(int first, int pageSize) {

        Query q = getEm().createQuery("SELECT a FROM " + this.getClazz().getSimpleName() + " a ");


        if (first == 0) {
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
        } else {
            if (first > 0) {
                q.setFirstResult(first);
            }

            if (pageSize > 0) {
                q.setMaxResults(pageSize);
            }
        }
        return q.getResultList();
    }

    public List<String> verifyForChildsFKs(Object entity, String errorMessage) {

        List<String> salida = new ArrayList<String>(0);

        Class clazz1 = entity.getClass();

        Field[] fields = clazz1.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            boolean oneToMany = ClassUtils.isOneToManyField(field);



            if (oneToMany) {

                logger.info("Field: " + field.getName() + " is one to many processing......");
                int size = 0;
                List<?> list = (List<?>) ClassUtils.getPropertyFromInstance(entity, field.getName());

                size = list.size();

                if (size > 0) {

                    Object first = list.get(0);

                    Class forList = first.getClass();

                    salida.add(errorMessage + " " + forList.getSimpleName());

                }


            } else {

                logger.info("Field: " + field.getName() + " is not one to many skipping");
            }
        }


        return salida;
    }
}
