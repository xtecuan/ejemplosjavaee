/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "ciclistas", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclistas.findAll", query = "SELECT c FROM Ciclistas c"),
    @NamedQuery(name = "Ciclistas.findByIdCiclista", query = "SELECT c FROM Ciclistas c WHERE c.idCiclista = :idCiclista"),
    @NamedQuery(name = "Ciclistas.findByCorreo", query = "SELECT c FROM Ciclistas c WHERE c.correo = :correo"),
    @NamedQuery(name = "Ciclistas.findByAlias", query = "SELECT c FROM Ciclistas c WHERE c.alias = :alias"),
    @NamedQuery(name = "Ciclistas.findByClave", query = "SELECT c FROM Ciclistas c WHERE c.clave = :clave")})
public class Ciclistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciclista", nullable = false)
    private Integer idCiclista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "alias", nullable = false, length = 25)
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clave", nullable = false, length = 50)
    private String clave;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ciclistas", fetch = FetchType.LAZY)
    private DetCiclistas detCiclistas;

    public Ciclistas() {
    }

    public Ciclistas(Integer idCiclista) {
        this.idCiclista = idCiclista;
    }

    public Ciclistas(Integer idCiclista, String correo, String alias, String clave) {
        this.idCiclista = idCiclista;
        this.correo = correo;
        this.alias = alias;
        this.clave = clave;
    }

    public Integer getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(Integer idCiclista) {
        this.idCiclista = idCiclista;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public DetCiclistas getDetCiclistas() {
        return detCiclistas;
    }

    public void setDetCiclistas(DetCiclistas detCiclistas) {
        this.detCiclistas = detCiclistas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclista != null ? idCiclista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclistas)) {
            return false;
        }
        Ciclistas other = (Ciclistas) object;
        if ((this.idCiclista == null && other.idCiclista != null) || (this.idCiclista != null && !this.idCiclista.equals(other.idCiclista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.Ciclistas[ idCiclista=" + idCiclista + " ]";
    }
    
}
