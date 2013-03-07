/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "cat_marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByCodmarca", query = "SELECT m FROM Marca m WHERE m.codmarca = :codmarca"),
    @NamedQuery(name = "Marca.findByDesmarca", query = "SELECT m FROM Marca m WHERE m.desmarca = :desmarca")})
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codmarca")
    private Integer codmarca;
    @Basic(optional = false)
    @Column(name = "desmarca")
    private String desmarca;
    @OneToMany(mappedBy = "codmarca", fetch = FetchType.LAZY)
    private List<Modelo> modeloList;

    public Marca() {
    }

    public Marca(Integer codmarca) {
        this.codmarca = codmarca;
    }

    public Marca(Integer codmarca, String desmarca) {
        this.codmarca = codmarca;
        this.desmarca = desmarca;
    }

    public Integer getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Integer codmarca) {
        this.codmarca = codmarca;
    }

    public String getDesmarca() {
        return desmarca;
    }

    public void setDesmarca(String desmarca) {
        this.desmarca = desmarca;
    }

    @XmlTransient
    public List<Modelo> getModeloList() {
        return modeloList;
    }

    public void setModeloList(List<Modelo> modeloList) {
        this.modeloList = modeloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmarca != null ? codmarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.codmarca == null && other.codmarca != null) || (this.codmarca != null && !this.codmarca.equals(other.codmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Marca[ codmarca=" + codmarca + " ]";
    }
    
}
