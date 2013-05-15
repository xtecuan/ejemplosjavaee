/*
 * UsuarioServiceImpl.java
 * Generated by Xtecuannet-framework Code Generator version 0.2.0
 * Created on 2013-04-27T10:39:54-06
 */


package org.xtecuan.ejemplos.spring.crud.modelo.services.impl;

import org.xtecuan.ejemplos.spring.crud.modelo.entidades.Usuario;
import org.xtecuan.ejemplos.spring.crud.modelo.services.UsuarioService;
import com.xtesoft.xtecuannet.framework.model.services.impl.GenericServiceImpl;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;


/**
 *
 * @author xtecuan
 */
@Repository
@Transactional
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService,Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public UsuarioServiceImpl(){
        super(Usuario.class);
    }
}