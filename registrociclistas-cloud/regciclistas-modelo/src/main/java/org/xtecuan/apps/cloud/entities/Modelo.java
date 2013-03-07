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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cat_modelos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByCodmodelo", query = "SELECT m FROM Modelo m WHERE m.codmodelo = :codmodelo"),
    @NamedQuery(name = "Modelo.findByDesmodelo", query = "SELECT m FROM Modelo m WHERE m.desmodelo = :desmodelo")})
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codmodelo")
    private Integer codmodelo;
    @Column(name = "desmodelo")
    private String desmodelo;
    @JoinColumn(name = "codmarca", referencedColumnName = "codmarca")
    @ManyToOne(fetch = FetchType.LAZY)
    private Marca codmarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmodelo", fetch = FetchType.LAZY)
    private List<Bicicleta> bicicletaList;

    public Modelo() {
    }

    public Modelo(Integer codmodelo) {
        this.codmodelo = codmodelo;
    }

    public Integer getCodmodelo() {
        return codmodelo;
    }

    public void setCodmodelo(Integer codmodelo) {
        this.codmodelo = codmodelo;
    }

    public String getDesmodelo() {
        return desmodelo;
    }

    public void setDesmodelo(String desmodelo) {
        this.desmodelo = desmodelo;
    }

    public Marca getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Marca codmarca) {
        this.codmarca = codmarca;
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
        hash += (codmodelo != null ? codmodelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.codmodelo == null && other.codmodelo != null) || (this.codmodelo != null && !this.codmodelo.equals(other.codmodelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Modelo[ codmodelo=" + codmodelo + " ]";
    }
    
}
