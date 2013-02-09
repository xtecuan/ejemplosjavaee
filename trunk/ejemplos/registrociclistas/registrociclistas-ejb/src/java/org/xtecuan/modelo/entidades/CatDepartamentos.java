/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "cat_departamentos", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatDepartamentos.findAll", query = "SELECT c FROM CatDepartamentos c"),
    @NamedQuery(name = "CatDepartamentos.findByCoddepto", query = "SELECT c FROM CatDepartamentos c WHERE c.coddepto = :coddepto"),
    @NamedQuery(name = "CatDepartamentos.findByDesdepto", query = "SELECT c FROM CatDepartamentos c WHERE c.desdepto = :desdepto")})
public class CatDepartamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "coddepto", nullable = false)
    private Integer coddepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desdepto", nullable = false, length = 50)
    private String desdepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddepto", fetch = FetchType.LAZY)
    private List<CatMunicipios> catMunicipiosList;

    public CatDepartamentos() {
    }

    public CatDepartamentos(Integer coddepto) {
        this.coddepto = coddepto;
    }

    public CatDepartamentos(Integer coddepto, String desdepto) {
        this.coddepto = coddepto;
        this.desdepto = desdepto;
    }

    public Integer getCoddepto() {
        return coddepto;
    }

    public void setCoddepto(Integer coddepto) {
        this.coddepto = coddepto;
    }

    public String getDesdepto() {
        return desdepto;
    }

    public void setDesdepto(String desdepto) {
        this.desdepto = desdepto;
    }

    @XmlTransient
    public List<CatMunicipios> getCatMunicipiosList() {
        return catMunicipiosList;
    }

    public void setCatMunicipiosList(List<CatMunicipios> catMunicipiosList) {
        this.catMunicipiosList = catMunicipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddepto != null ? coddepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatDepartamentos)) {
            return false;
        }
        CatDepartamentos other = (CatDepartamentos) object;
        if ((this.coddepto == null && other.coddepto != null) || (this.coddepto != null && !this.coddepto.equals(other.coddepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.CatDepartamentos[ coddepto=" + coddepto + " ]";
    }
    
}
