/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.spring.ejemplogrigconspring.dao.impl;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.dao.UsuarioDao;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.entidades.Usuario;

/**
 *
 * @author xtecuan
 */

@Repository(value = "usuarioDao")
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public List<Usuario> listarUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
}
