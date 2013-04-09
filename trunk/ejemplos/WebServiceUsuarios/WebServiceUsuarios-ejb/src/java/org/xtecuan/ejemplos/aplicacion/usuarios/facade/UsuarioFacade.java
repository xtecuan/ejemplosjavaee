/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.aplicacion.usuarios.facade;

import org.xtecuan.ejemplos.aplicacion.usuarios.facade.impl.AbstractFacade;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.beanutils.BeanUtils;
import org.xtecuan.ejemplos.aplicacion.usuarios.dto.UsuarioDTO;
import org.xtecuan.ejemplos.aplicacion.usuarios.entidades.Usuario;

/**
 *
 * @author xtecuan
 */
@Stateless()
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebServiceUsuarios-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario autenticarUsuario(String usuario, String clave) {

        Usuario usuario1 = null;


        try {

            Query query = getEntityManager().createNamedQuery("Usuario.autenticarUsuario");

            query.setParameter("usuario", usuario);
            query.setParameter("clave", clave);

            usuario1 = (Usuario) query.getSingleResult();

        } catch (Exception e) {

            getLogger().error("Error al autenticar el usuario con credenciales: " + usuario + "/" + clave);
        }


        return usuario1;

    }

    public UsuarioDTO fromEntity2DTO(Usuario ent) {

        UsuarioDTO dto = new UsuarioDTO();

        try {
            BeanUtils.copyProperties(dto, ent);
        } catch (Exception e) {
            getLogger().error("Error copiando propiedades hacia el dto desde la entidad: "+ent, e);
        }

        return dto;
    }
}
