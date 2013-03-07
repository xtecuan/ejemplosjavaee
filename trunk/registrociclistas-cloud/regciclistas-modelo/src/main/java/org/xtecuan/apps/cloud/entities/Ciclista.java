/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "ciclistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclista.findAll", query = "SELECT c FROM Ciclista c"),
    @NamedQuery(name = "Ciclista.findByIdCiclista", query = "SELECT c FROM Ciclista c WHERE c.idCiclista = :idCiclista"),
    @NamedQuery(name = "Ciclista.findByCorreo", query = "SELECT c FROM Ciclista c WHERE c.correo = :correo"),
    @NamedQuery(name = "Ciclista.findByAlias", query = "SELECT c FROM Ciclista c WHERE c.alias = :alias"),
    @NamedQuery(name = "Ciclista.findByClave", query = "SELECT c FROM Ciclista c WHERE c.clave = :clave")})
public class Ciclista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciclista")
    private Integer idCiclista;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiclista", fetch = FetchType.LAZY)
    private List<DetalleCiclista> detalleCiclistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiclista", fetch = FetchType.LAZY)
    private List<Bicicleta> bicicletaList;

    public Ciclista() {
    }

    public Ciclista(Integer idCiclista) {
        this.idCiclista = idCiclista;
    }

    public Ciclista(Integer idCiclista, String correo, String alias, String clave) {
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

    @XmlTransient
    public List<DetalleCiclista> getDetalleCiclistaList() {
        return detalleCiclistaList;
    }

    public void setDetalleCiclistaList(List<DetalleCiclista> detalleCiclistaList) {
        this.detalleCiclistaList = detalleCiclistaList;
    }

    @XmlTransient
    public List<Bicicleta> getBicicletaList() {
        return bicicletaList;
    }

    public void setBicicletaList(List<Bicicleta> bicicletaList) {
        this.bicicletaList = bicicletaList;
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
        if (!(object instanceof Ciclista)) {
            return false;
        }
        Ciclista other = (Ciclista) object;
        if ((this.idCiclista == null && other.idCiclista != null) || (this.idCiclista != null && !this.idCiclista.equals(other.idCiclista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Ciclista[ idCiclista=" + idCiclista + " ]";
    }
    
}
