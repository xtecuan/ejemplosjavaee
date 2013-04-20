/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.spring.ejemplogrigconspring.services.impl;

import java.util.List;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.dao.UsuarioDao;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.entidades.Usuario;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.services.UsuarioService;

/**
 *
 * @author xtecuan
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioDao dao;
    

    @Override
    public List<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioDao getDao() {
        return dao;
    }

    public void setDao(UsuarioDao dao) {
        this.dao = dao;
    }
    
    
    
}
