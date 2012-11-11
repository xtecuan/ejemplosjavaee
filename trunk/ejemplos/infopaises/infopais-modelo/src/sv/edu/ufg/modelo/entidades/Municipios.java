/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "municipios", catalog = "infopais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIdMuni", query = "SELECT m FROM Municipios m WHERE m.idMuni = :idMuni"),
    @NamedQuery(name = "Municipios.findByNombreMuni", query = "SELECT m FROM Municipios m WHERE m.nombreMuni = :nombreMuni"),
    @NamedQuery(name = "Municipios.findByCabecera", query = "SELECT m FROM Municipios m WHERE m.cabecera = :cabecera")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_muni", nullable = false)
    private Integer idMuni;
    @Basic(optional = false)
    @Column(name = "nombre_muni", nullable = false, length = 50)
    private String nombreMuni;
    @Basic(optional = false)
    @Column(name = "cabecera", nullable = false)
    private int cabecera;
    @JoinColumn(name = "id_depto", referencedColumnName = "id_depto", nullable = false)
    @ManyToOne(optional = false)
    private Departamentos idDepto;

    public Municipios() {
    }

    public Municipios(Integer idMuni) {
        this.idMuni = idMuni;
    }

    public Municipios(Integer idMuni, String nombreMuni, int cabecera) {
        this.idMuni = idMuni;
        this.nombreMuni = nombreMuni;
        this.cabecera = cabecera;
    }

    public Integer getIdMuni() {
        return idMuni;
    }

    public void setIdMuni(Integer idMuni) {
        this.idMuni = idMuni;
    }

    public String getNombreMuni() {
        return nombreMuni;
    }

    public void setNombreMuni(String nombreMuni) {
        this.nombreMuni = nombreMuni;
    }

    public int getCabecera() {
        return cabecera;
    }

    public void setCabecera(int cabecera) {
        this.cabecera = cabecera;
    }

    public Departamentos getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Departamentos idDepto) {
        this.idDepto = idDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMuni != null ? idMuni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMuni == null && other.idMuni != null) || (this.idMuni != null && !this.idMuni.equals(other.idMuni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.modelo.entidades.Municipios[ idMuni=" + idMuni + " ]";
    }
    
}
