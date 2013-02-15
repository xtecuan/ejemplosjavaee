/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "bicicletas", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bicicletas.findAll", query = "SELECT b FROM Bicicletas b"),
    @NamedQuery(name = "Bicicletas.findByIdbici", query = "SELECT b FROM Bicicletas b WHERE b.idbici = :idbici"),
    @NamedQuery(name = "Bicicletas.findByDesbici", query = "SELECT b FROM Bicicletas b WHERE b.desbici = :desbici"),
    @NamedQuery(name = "Bicicletas.findBySeriebici", query = "SELECT b FROM Bicicletas b WHERE b.seriebici = :seriebici"),
    @NamedQuery(name = "Bicicletas.findByColor", query = "SELECT b FROM Bicicletas b WHERE b.color = :color"),
    @NamedQuery(name = "Bicicletas.findByObservaciones", query = "SELECT b FROM Bicicletas b WHERE b.observaciones = :observaciones")})
public class Bicicletas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbici", nullable = false)
    private Integer idbici;
    @Size(max = 25)
    @Column(name = "desbici", length = 25)
    private String desbici;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "seriebici", nullable = false, length = 35)
    private String seriebici;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "color", nullable = false, length = 25)
    private String color;
    @Size(max = 150)
    @Column(name = "observaciones", length = 150)
    private String observaciones;
    @JoinColumn(name = "codmodelo", referencedColumnName = "codmodelo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CatModelos codmodelo;
    @Id
    @JoinColumn(name = "id_ciclista", referencedColumnName = "id_ciclista", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclistas idCiclista;

    public Bicicletas() {
    }

    public Bicicletas(Integer idbici) {
        this.idbici = idbici;
    }

    public Bicicletas(Integer idbici, String seriebici, String color) {
        this.idbici = idbici;
        this.seriebici = seriebici;
        this.color = color;
    }

    public Integer getIdbici() {
        return idbici;
    }

    public void setIdbici(Integer idbici) {
        this.idbici = idbici;
    }

    public String getDesbici() {
        return desbici;
    }

    public void setDesbici(String desbici) {
        this.desbici = desbici;
    }

    public String getSeriebici() {
        return seriebici;
    }

    public void setSeriebici(String seriebici) {
        this.seriebici = seriebici;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public CatModelos getCodmodelo() {
        return codmodelo;
    }

    public void setCodmodelo(CatModelos codmodelo) {
        this.codmodelo = codmodelo;
    }

    public Ciclistas getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(Ciclistas idCiclista) {
        this.idCiclista = idCiclista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbici != null ? idbici.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bicicletas)) {
            return false;
        }
        Bicicletas other = (Bicicletas) object;
        if ((this.idbici == null && other.idbici != null) || (this.idbici != null && !this.idbici.equals(other.idbici))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.Bicicletas[ idbici=" + idbici + " ]";
    }
    
}
