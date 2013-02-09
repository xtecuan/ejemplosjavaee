/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "det_ciclistas", catalog = "regciclistas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetCiclistas.findAll", query = "SELECT d FROM DetCiclistas d"),
    @NamedQuery(name = "DetCiclistas.findByIdCiclista", query = "SELECT d FROM DetCiclistas d WHERE d.idCiclista = :idCiclista"),
    @NamedQuery(name = "DetCiclistas.findByPrimernombre", query = "SELECT d FROM DetCiclistas d WHERE d.primernombre = :primernombre"),
    @NamedQuery(name = "DetCiclistas.findBySegundonombre", query = "SELECT d FROM DetCiclistas d WHERE d.segundonombre = :segundonombre"),
    @NamedQuery(name = "DetCiclistas.findByPrimerapellido", query = "SELECT d FROM DetCiclistas d WHERE d.primerapellido = :primerapellido"),
    @NamedQuery(name = "DetCiclistas.findBySegundoapellido", query = "SELECT d FROM DetCiclistas d WHERE d.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "DetCiclistas.findByFechanac", query = "SELECT d FROM DetCiclistas d WHERE d.fechanac = :fechanac"),
    @NamedQuery(name = "DetCiclistas.findByTelefonofijo", query = "SELECT d FROM DetCiclistas d WHERE d.telefonofijo = :telefonofijo"),
    @NamedQuery(name = "DetCiclistas.findByTelefonomovil", query = "SELECT d FROM DetCiclistas d WHERE d.telefonomovil = :telefonomovil"),
    @NamedQuery(name = "DetCiclistas.findByDireccion", query = "SELECT d FROM DetCiclistas d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DetCiclistas.findByFacebook", query = "SELECT d FROM DetCiclistas d WHERE d.facebook = :facebook"),
    @NamedQuery(name = "DetCiclistas.findByTwitter", query = "SELECT d FROM DetCiclistas d WHERE d.twitter = :twitter")})
public class DetCiclistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclista", nullable = false)
    private Integer idCiclista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "primernombre", nullable = false, length = 55)
    private String primernombre;
    @Size(max = 55)
    @Column(name = "segundonombre", length = 55)
    private String segundonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "primerapellido", nullable = false, length = 55)
    private String primerapellido;
    @Size(max = 55)
    @Column(name = "segundoapellido", length = 55)
    private String segundoapellido;
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Size(max = 10)
    @Column(name = "telefonofijo", length = 10)
    private String telefonofijo;
    @Size(max = 10)
    @Column(name = "telefonomovil", length = 10)
    private String telefonomovil;
    @Size(max = 200)
    @Column(name = "direccion", length = 200)
    private String direccion;
    @Size(max = 100)
    @Column(name = "facebook", length = 100)
    private String facebook;
    @Size(max = 100)
    @Column(name = "twitter", length = 100)
    private String twitter;
    @JoinColumn(name = "codpais", referencedColumnName = "id_pais", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CatPaises codpais;
    @JoinColumn(name = "id_ciclista", referencedColumnName = "id_ciclista", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclistas ciclistas;
    @JoinColumn(name = "codmuni", referencedColumnName = "codmuni")
    @ManyToOne(fetch = FetchType.LAZY)
    private CatMunicipios codmuni;

    public DetCiclistas() {
    }

    public DetCiclistas(Integer idCiclista) {
        this.idCiclista = idCiclista;
    }

    public DetCiclistas(Integer idCiclista, String primernombre, String primerapellido) {
        this.idCiclista = idCiclista;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
    }

    public Integer getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(Integer idCiclista) {
        this.idCiclista = idCiclista;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(String telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getTelefonomovil() {
        return telefonomovil;
    }

    public void setTelefonomovil(String telefonomovil) {
        this.telefonomovil = telefonomovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public CatPaises getCodpais() {
        return codpais;
    }

    public void setCodpais(CatPaises codpais) {
        this.codpais = codpais;
    }

    public Ciclistas getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(Ciclistas ciclistas) {
        this.ciclistas = ciclistas;
    }

    public CatMunicipios getCodmuni() {
        return codmuni;
    }

    public void setCodmuni(CatMunicipios codmuni) {
        this.codmuni = codmuni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclista != null ? idCiclista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetCiclistas)) {
            return false;
        }
        DetCiclistas other = (DetCiclistas) object;
        if ((this.idCiclista == null && other.idCiclista != null) || (this.idCiclista != null && !this.idCiclista.equals(other.idCiclista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.modelo.entidades.DetCiclistas[ idCiclista=" + idCiclista + " ]";
    }
    
}
