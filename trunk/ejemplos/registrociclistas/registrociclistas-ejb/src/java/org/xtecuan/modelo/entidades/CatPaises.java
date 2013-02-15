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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "cat_paises", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatPaises.findAll", query = "SELECT c FROM CatPaises c"),
    @NamedQuery(name = "CatPaises.findByIdPais", query = "SELECT c FROM CatPaises c WHERE c.idPais = :idPais"),
    @NamedQuery(name = "CatPaises.findByDesPais", query = "SELECT c FROM CatPaises c WHERE c.desPais = :desPais"),
    @NamedQuery(name = "CatPaises.findByCodAreaTel", query = "SELECT c FROM CatPaises c WHERE c.codAreaTel = :codAreaTel")})
public class CatPaises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pais", nullable = false)
    private Integer idPais;
    @Size(max = 50)
    @Column(name = "des_pais", length = 50)
    private String desPais;
    @Size(max = 3)
    @Column(name = "cod_area_tel", length = 3)
    private String codAreaTel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpais", fetch = FetchType.LAZY)
    private List<CatDepartamentos> catDepartamentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpais", fetch = FetchType.LAZY)
    private List<DetCiclistas> detCiclistasList;

    public CatPaises() {
    }

    public CatPaises(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getDesPais() {
        return desPais;
    }

    public void setDesPais(String desPais) {
        this.desPais = desPais;
    }

    public String getCodAreaTel() {
        return codAreaTel;
    }

    public void setCodAreaTel(String codAreaTel) {
        this.codAreaTel = codAreaTel;
    }

    @XmlTransient
    public List<CatDepartamentos> getCatDepartamentosList() {
        return catDepartamentosList;
    }

    public void setCatDepartamentosList(List<CatDepartamentos> catDepartamentosList) {
        this.catDepartamentosList = catDepartamentosList;
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
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatPaises)) {
            return false;
        }
        CatPaises other = (CatPaises) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.CatPaises[ idPais=" + idPais + " ]";
    }
    
}
