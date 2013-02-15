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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cat_marcas", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatMarcas.findAll", query = "SELECT c FROM CatMarcas c"),
    @NamedQuery(name = "CatMarcas.findByCodmarca", query = "SELECT c FROM CatMarcas c WHERE c.codmarca = :codmarca"),
    @NamedQuery(name = "CatMarcas.findByDesmarca", query = "SELECT c FROM CatMarcas c WHERE c.desmarca = :desmarca")})
public class CatMarcas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codmarca", nullable = false)
    private Integer codmarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "desmarca", nullable = false, length = 65)
    private String desmarca;
    @OneToMany(mappedBy = "codmarca", fetch = FetchType.LAZY)
    private List<CatModelos> catModelosList;

    public CatMarcas() {
    }

    public CatMarcas(Integer codmarca) {
        this.codmarca = codmarca;
    }

    public CatMarcas(Integer codmarca, String desmarca) {
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
    public List<CatModelos> getCatModelosList() {
        return catModelosList;
    }

    public void setCatModelosList(List<CatModelos> catModelosList) {
        this.catModelosList = catModelosList;
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
        if (!(object instanceof CatMarcas)) {
            return false;
        }
        CatMarcas other = (CatMarcas) object;
        if ((this.codmarca == null && other.codmarca != null) || (this.codmarca != null && !this.codmarca.equals(other.codmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.CatMarcas[ codmarca=" + codmarca + " ]";
    }
    
}
