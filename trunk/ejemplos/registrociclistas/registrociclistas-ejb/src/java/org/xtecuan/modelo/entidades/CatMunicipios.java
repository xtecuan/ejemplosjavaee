/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "cat_municipios", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatMunicipios.findAll", query = "SELECT c FROM CatMunicipios c"),
    @NamedQuery(name = "CatMunicipios.findByCodmuni", query = "SELECT c FROM CatMunicipios c WHERE c.codmuni = :codmuni"),
    @NamedQuery(name = "CatMunicipios.findByDesmuni", query = "SELECT c FROM CatMunicipios c WHERE c.desmuni = :desmuni")})
public class CatMunicipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmuni", nullable = false)
    private Integer codmuni;
    @Size(max = 255)
    @Column(name = "desmuni", length = 255)
    private String desmuni;
    @JoinColumn(name = "coddepto", referencedColumnName = "coddepto", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CatDepartamentos coddepto;
    @OneToMany(mappedBy = "codmuni", fetch = FetchType.LAZY)
    private List<DetCiclistas> detCiclistasList;

    public CatMunicipios() {
    }

    public CatMunicipios(Integer codmuni) {
        this.codmuni = codmuni;
    }

    public Integer getCodmuni() {
        return codmuni;
    }

    public void setCodmuni(Integer codmuni) {
        this.codmuni = codmuni;
    }

    public String getDesmuni() {
        return desmuni;
    }

    public void setDesmuni(String desmuni) {
        this.desmuni = desmuni;
    }

    public CatDepartamentos getCoddepto() {
        return coddepto;
    }

    public void setCoddepto(CatDepartamentos coddepto) {
        this.coddepto = coddepto;
    }

    @XmlTransient
    public List<DetCiclistas> getDetCiclistasList() {
        return detCiclistasList;
    }

    public void setDetCiclistasList(List<DetCiclistas> detCiclistasList) {
        this.detCiclistasList = detCiclistasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmuni != null ? codmuni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatMunicipios)) {
            return false;
        }
        CatMunicipios other = (CatMunicipios) object;
        if ((this.codmuni == null && other.codmuni != null) || (this.codmuni != null && !this.codmuni.equals(other.codmuni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.CatMunicipios[ codmuni=" + codmuni + " ]";
    }
    
}
