/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.entidades;

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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
@Table(name = "departamentos", catalog = "infopais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIdDepto", query = "SELECT d FROM Departamentos d WHERE d.idDepto = :idDepto"),
    @NamedQuery(name = "Departamentos.findByAbreviatura", query = "SELECT d FROM Departamentos d WHERE d.abreviatura = :abreviatura"),
    @NamedQuery(name = "Departamentos.findByNombreDepto", query = "SELECT d FROM Departamentos d WHERE d.nombreDepto = :nombreDepto")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Departamentos.encontrarLikeAbreviatura", query = "select * from departamentos where abreviatura like #paramLike", resultClass = Departamentos.class)
})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_depto", nullable = false)
    private Integer idDepto;
    @Basic(optional = false)
    @Column(name = "abreviatura", nullable = false, length = 5)
    private String abreviatura;
    @Basic(optional = false)
    @Column(name = "nombre_depto", nullable = false, length = 35)
    private String nombreDepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepto",fetch= FetchType.LAZY)
    private List<Municipios> municipiosList;

    public Departamentos() {
    }

    public Departamentos(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public Departamentos(Integer idDepto, String abreviatura, String nombreDepto) {
        this.idDepto = idDepto;
        this.abreviatura = abreviatura;
        this.nombreDepto = nombreDepto;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    @XmlTransient
    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepto != null ? idDepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDepto == null && other.idDepto != null) || (this.idDepto != null && !this.idDepto.equals(other.idDepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.modelo.entidades.Departamentos[ idDepto=" + idDepto + " ]";
    }
}
