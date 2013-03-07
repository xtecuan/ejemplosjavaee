/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "bicicletas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bicicleta.findAll", query = "SELECT b FROM Bicicleta b"),
    @NamedQuery(name = "Bicicleta.findByIdbici", query = "SELECT b FROM Bicicleta b WHERE b.idbici = :idbici"),
    @NamedQuery(name = "Bicicleta.findByDesbici", query = "SELECT b FROM Bicicleta b WHERE b.desbici = :desbici"),
    @NamedQuery(name = "Bicicleta.findBySeriebici", query = "SELECT b FROM Bicicleta b WHERE b.seriebici = :seriebici"),
    @NamedQuery(name = "Bicicleta.findByColor", query = "SELECT b FROM Bicicleta b WHERE b.color = :color"),
    @NamedQuery(name = "Bicicleta.findByObservaciones", query = "SELECT b FROM Bicicleta b WHERE b.observaciones = :observaciones")})
public class Bicicleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbici")
    private Integer idbici;
    @Column(name = "desbici")
    private String desbici;
    @Basic(optional = false)
    @Column(name = "seriebici")
    private String seriebici;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "codmodelo", referencedColumnName = "codmodelo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Modelo codmodelo;
    @JoinColumn(name = "id_ciclista", referencedColumnName = "id_ciclista")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclista idCiclista;

    public Bicicleta() {
    }

    public Bicicleta(Integer idbici) {
        this.idbici = idbici;
    }

    public Bicicleta(Integer idbici, String seriebici, String color) {
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

    public Modelo getCodmodelo() {
        return codmodelo;
    }

    public void setCodmodelo(Modelo codmodelo) {
        this.codmodelo = codmodelo;
    }

    public Ciclista getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(Ciclista idCiclista) {
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
        if (!(object instanceof Bicicleta)) {
            return false;
        }
        Bicicleta other = (Bicicleta) object;
        if ((this.idbici == null && other.idbici != null) || (this.idbici != null && !this.idbici.equals(other.idbici))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.Bicicleta[ idbici=" + idbici + " ]";
    }
    
}
