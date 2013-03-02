/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.vistacontrolador.dto;

import java.io.Serializable;

/**
 *
 * @author xtecuan
 */
public class UserDTO implements Serializable {

    public static final String ADMIN = "admin";
    public static final String ADMIN_PWD = "welcome1";
    public static final String USER = "xtecuan";
    public static final String USER_PWD = "123456";
    private String usuario;
    private String clave;

    public UserDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
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

    public UserDTO() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
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
        final UserDTO other = (UserDTO) obj;
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
}
