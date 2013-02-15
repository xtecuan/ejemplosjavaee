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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cat_modelos", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatModelos.findAll", query = "SELECT c FROM CatModelos c"),
    @NamedQuery(name = "CatModelos.findByCodmodelo", query = "SELECT c FROM CatModelos c WHERE c.codmodelo = :codmodelo"),
    @NamedQuery(name = "CatModelos.findByDesmodelo", query = "SELECT c FROM CatModelos c WHERE c.desmodelo = :desmodelo")})
public class CatModelos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codmodelo", nullable = false)
    private Integer codmodelo;
    @Size(max = 65)
    @Column(name = "desmodelo", length = 65)
    private String desmodelo;
    @JoinColumn(name = "codmarca", referencedColumnName = "codmarca")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatMarcas codmarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmodelo", fetch = FetchType.LAZY)
    private List<Bicicletas> bicicletasList;

    public CatModelos() {
    }

    public CatModelos(Integer codmodelo) {
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

    public CatMarcas getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(CatMarcas codmarca) {
        this.codmarca = codmarca;
    }

    @XmlTransient
    public List<Bicicletas> getBicicletasList() {
        return bicicletasList;
    }

    public void setBicicletasList(List<Bicicletas> bicicletasList) {
        this.bicicletasList = bicicletasList;
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
        if (!(object instanceof CatModelos)) {
            return false;
        }
        CatModelos other = (CatModelos) object;
        if ((this.codmodelo == null && other.codmodelo != null) || (this.codmodelo != null && !this.codmodelo.equals(other.codmodelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.CatModelos[ codmodelo=" + codmodelo + " ]";
    }
    
}
