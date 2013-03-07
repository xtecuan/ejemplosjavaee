/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "det_ciclistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCiclista.findAll", query = "SELECT d FROM DetalleCiclista d"),
    @NamedQuery(name = "DetalleCiclista.findByCoddetciclista", query = "SELECT d FROM DetalleCiclista d WHERE d.coddetciclista = :coddetciclista"),
    @NamedQuery(name = "DetalleCiclista.findByDui", query = "SELECT d FROM DetalleCiclista d WHERE d.dui = :dui"),
    @NamedQuery(name = "DetalleCiclista.findByNit", query = "SELECT d FROM DetalleCiclista d WHERE d.nit = :nit"),
    @NamedQuery(name = "DetalleCiclista.findByPrimernombre", query = "SELECT d FROM DetalleCiclista d WHERE d.primernombre = :primernombre"),
    @NamedQuery(name = "DetalleCiclista.findBySegundonombre", query = "SELECT d FROM DetalleCiclista d WHERE d.segundonombre = :segundonombre"),
    @NamedQuery(name = "DetalleCiclista.findByPrimerapellido", query = "SELECT d FROM DetalleCiclista d WHERE d.primerapellido = :primerapellido"),
    @NamedQuery(name = "DetalleCiclista.findBySegundoapellido", query = "SELECT d FROM DetalleCiclista d WHERE d.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "DetalleCiclista.findByApellidodecasada", query = "SELECT d FROM DetalleCiclista d WHERE d.apellidodecasada = :apellidodecasada"),
    @NamedQuery(name = "DetalleCiclista.findBySexo", query = "SELECT d FROM DetalleCiclista d WHERE d.sexo = :sexo"),
    @NamedQuery(name = "DetalleCiclista.findByFechanac", query = "SELECT d FROM DetalleCiclista d WHERE d.fechanac = :fechanac"),
    @NamedQuery(name = "DetalleCiclista.findByTelefonofijo", query = "SELECT d FROM DetalleCiclista d WHERE d.telefonofijo = :telefonofijo"),
    @NamedQuery(name = "DetalleCiclista.findByTelefonomovil", query = "SELECT d FROM DetalleCiclista d WHERE d.telefonomovil = :telefonomovil"),
    @NamedQuery(name = "DetalleCiclista.findByDireccion", query = "SELECT d FROM DetalleCiclista d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DetalleCiclista.findByFacebook", query = "SELECT d FROM DetalleCiclista d WHERE d.facebook = :facebook"),
    @NamedQuery(name = "DetalleCiclista.findByTwitter", query = "SELECT d FROM DetalleCiclista d WHERE d.twitter = :twitter")})
public class DetalleCiclista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coddetciclista")
    private Integer coddetciclista;
    @Column(name = "dui")
    private String dui;
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "primernombre")
    private String primernombre;
    @Column(name = "segundonombre")
    private String segundonombre;
    @Basic(optional = false)
    @Column(name = "primerapellido")
    private String primerapellido;
    @Column(name = "segundoapellido")
    private String segundoapellido;
    @Column(name = "apellidodecasada")
    private String apellidodecasada;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Column(name = "telefonofijo")
    private String telefonofijo;
    @Column(name = "telefonomovil")
    private String telefonomovil;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;
    @JoinColumn(name = "codpais", referencedColumnName = "id_pais")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais codpais;
    @JoinColumn(name = "codmuni", referencedColumnName = "codmuni")
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipio codmuni;
    @JoinColumn(name = "id_ciclista", referencedColumnName = "id_ciclista")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclista idCiclista;

    public DetalleCiclista() {
    }

    public DetalleCiclista(Integer coddetciclista) {
        this.coddetciclista = coddetciclista;
    }

    public DetalleCiclista(Integer coddetciclista, String primernombre, String primerapellido) {
        this.coddetciclista = coddetciclista;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
    }

    public Integer getCoddetciclista() {
        return coddetciclista;
    }

    public void setCoddetciclista(Integer coddetciclista) {
        this.coddetciclista = coddetciclista;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getApellidodecasada() {
        return apellidodecasada;
    }

    public void setApellidodecasada(String apellidodecasada) {
        this.apellidodecasada = apellidodecasada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public Pais getCodpais() {
        return codpais;
    }

    public void setCodpais(Pais codpais) {
        this.codpais = codpais;
    }

    public Municipio getCodmuni() {
        return codmuni;
    }

    public void setCodmuni(Municipio codmuni) {
        this.codmuni = codmuni;
    }

    public Ciclista getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(Ciclista idCiclista) {
        this.idCiclista = idCiclista;
    }

    public String getNombreCompleto() {


        StringBuilder sb = new StringBuilder();

        sb.append(primernombre).append(" ");

        if (segundonombre != null && segundonombre.length() > 0) {
            sb.append(segundonombre).append(" ");
        }

        sb.append(primerapellido).append(" ");

        if (segundoapellido != null && segundoapellido.length() > 0) {
            sb.append(segundoapellido).append(" ");
        }

        if (apellidodecasada != null && apellidodecasada.length() > 0) {
            sb.append(apellidodecasada);
        }

        return sb.toString().trim();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddetciclista != null ? coddetciclista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCiclista)) {
            return false;
        }
        DetalleCiclista other = (DetalleCiclista) object;
        if ((this.coddetciclista == null && other.coddetciclista != null) || (this.coddetciclista != null && !this.coddetciclista.equals(other.coddetciclista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.DetalleCiclista[ coddetciclista=" + coddetciclista + " ]";
    }
}
