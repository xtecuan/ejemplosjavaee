/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.aplicacion.usuarios.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xtecuan
 */
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String usuario;
    private String clave;
    private String nombres;
    private String apellidos;
    private String correo;
    private Short estaadentro;
    private Date ultimoLogin;

    public UsuarioDTO() {
    }

    
    
    public UsuarioDTO(String usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO(String usuario, String clave, String correo, Date ultimoLogin) {
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
        this.ultimoLogin = ultimoLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Short getEstaadentro() {
        return estaadentro;
    }

    public void setEstaadentro(Short estaadentro) {
        this.estaadentro = estaadentro;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDTO other = (UsuarioDTO) obj;
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "usuario=" + usuario + ", clave=" + clave + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", estaadentro=" + estaadentro + ", ultimoLogin=" + ultimoLogin + '}';
    }
}
