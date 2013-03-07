/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "current_states")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurrentStates.findAll", query = "SELECT c FROM CurrentStates c"),
    @NamedQuery(name = "CurrentStates.findById", query = "SELECT c FROM CurrentStates c WHERE c.id = :id"),
    @NamedQuery(name = "CurrentStates.findByStateCode", query = "SELECT c FROM CurrentStates c WHERE c.stateCode = :stateCode"),
    @NamedQuery(name = "CurrentStates.findByName", query = "SELECT c FROM CurrentStates c WHERE c.name = :name")})
public class CurrentStates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "name")
    private String name;

    public CurrentStates() {
    }

    public CurrentStates(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrentStates)) {
            return false;
        }
        CurrentStates other = (CurrentStates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.xtecuan.apps.cloud.entities.CurrentStates[ id=" + id + " ]";
    }
    
}
