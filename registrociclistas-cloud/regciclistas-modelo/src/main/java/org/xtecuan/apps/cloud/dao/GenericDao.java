/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author xtecuan
 */
public interface GenericDao<T> extends Serializable {

    /**
     *
     * @param entity to create in JPA Container
     * @return The same entity but with the generated id
     */
    public T create(T entity);

    /**
     *
     * @param entity to update in JPA Container
     * @return The same entity but updated
     */
    public T edit(T entity);

    /**
     *
     * @param entity to be deleted in JPA container
     */
    public void remove(Object entity);

    /**
     *
     * @param entityId id for entity to be found
     * @return The entity found
     */
    public T find(Object entityId);

    /**
     *
     * @return an ArrayList of entities
     */
    public List<T> findAll();

    /**
     *
     * @param range an Array of int to limit findAll query
     * @return an ArrayList of entities
     */
    public List<T> findRange(int[] range);

    /**
     *
     * @return the number of entities in some table
     */
    public int count();

    /**
     *
     * @return A String to test this service
     */
    public String sayHello();

    /**
     *
     * @param entity to verify for OneToMany relationship
     * @param errorMessage Error message to be printed
     * @return ArrayList of errors
     */
    public List<String> verifyForChildsFKs(Object entity, String errorMessage);

    /**
     *
     * @param first number of element to begin
     * @param pageSize number of entities to retrieve
     * @return ArrayList of entities for this iteration
     */
    public List<T> findSomeRange(int first, int pageSize);
}
