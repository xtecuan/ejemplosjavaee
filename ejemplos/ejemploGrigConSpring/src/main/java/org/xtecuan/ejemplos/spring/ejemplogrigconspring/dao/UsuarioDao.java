/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.spring.ejemplogrigconspring.dao;

import java.util.List;
import org.xtecuan.ejemplos.spring.ejemplogrigconspring.entidades.Usuario;

/**
 *
 * @author xtecuan
 */
public interface UsuarioDao {

    public List<Usuario> listarUsuarios();
}
