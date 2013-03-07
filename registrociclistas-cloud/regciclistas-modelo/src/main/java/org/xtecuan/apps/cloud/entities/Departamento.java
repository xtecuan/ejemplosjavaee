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
@Table(name = "cat_departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByCoddepto", query = "SELECT d FROM Departamento d WHERE d.coddepto = :coddepto"),
    @NamedQuery(name = "Departamento.findByDesdepto", query = "SELECT d FROM Departamento d WHERE d.desdepto = :desdepto"),
    @NamedQuery(name = "Departamento.findByCodPais", query = "SELECT d FROM Departamento d WHERE d.codpais.idPais=:idPais")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "coddepto")
    private Integer coddepto;
    @Basic(optional = false)
    @Column(name = "desdepto")
    private String desdepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddepto", fetch = FetchType.LAZY)
    private List<Municipio> municipioList;
    @JoinColumn(name = "codpais", referencedColumnName = "id_pais")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais codpais;

    public Departamento() {
    }

    public Departamento(Integer coddepto) {
        this.coddepto = coddepto;
    }

    public Departamento(Integer coddepto, String desdepto) {
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
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public Pais getCodpais() {
        return codpais;
    }

    public void setCodpais(Pais codpais) {
        this.codpais = codpais;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.coddepto == null && other.coddepto != null) || (this.coddepto != null && !this.coddepto.equals(other.coddepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Departamento[ coddepto=" + coddepto + " ]";
    }
}
