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
@Table(name = "cat_municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCodmuni", query = "SELECT m FROM Municipio m WHERE m.codmuni = :codmuni"),
    @NamedQuery(name = "Municipio.findByDesmuni", query = "SELECT m FROM Municipio m WHERE m.desmuni = :desmuni"),
    @NamedQuery(name = "Municipio.findByCoddepto", query = "SELECT m FROM Municipio m WHERE m.coddepto.coddepto=:coddepto")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codmuni")
    private Integer codmuni;
    @Column(name = "desmuni")
    private String desmuni;
    @JoinColumn(name = "coddepto", referencedColumnName = "coddepto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento coddepto;
    @OneToMany(mappedBy = "codmuni", fetch = FetchType.LAZY)
    private List<DetalleCiclista> detalleCiclistaList;

    public Municipio() {
    }

    public Municipio(Integer codmuni) {
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

    public Departamento getCoddepto() {
        return coddepto;
    }

    public void setCoddepto(Departamento coddepto) {
        this.coddepto = coddepto;
    }

    @XmlTransient
    public List<DetalleCiclista> getDetalleCiclistaList() {
        return detalleCiclistaList;
    }

    public void setDetalleCiclistaList(List<DetalleCiclista> detalleCiclistaList) {
        this.detalleCiclistaList = detalleCiclistaList;
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
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codmuni == null && other.codmuni != null) || (this.codmuni != null && !this.codmuni.equals(other.codmuni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Municipio[ codmuni=" + codmuni + " ]";
    }
}
