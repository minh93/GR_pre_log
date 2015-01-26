/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctv.logservice.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author PhamDucMinh
 */
@Entity
@Table(name = "EventTbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventTbl.findAll", query = "SELECT e FROM EventTbl e"),
    @NamedQuery(name = "EventTbl.findByEventName", query = "SELECT e FROM EventTbl e WHERE e.eventName = :eventName")})
public class EventTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eventName")
    private String eventName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventName")
    private Collection<Log> logCollection;

    public EventTbl() {
    }

    public EventTbl(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventName != null ? eventName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventTbl)) {
            return false;
        }
        EventTbl other = (EventTbl) object;
        if ((this.eventName == null && other.eventName != null) || (this.eventName != null && !this.eventName.equals(other.eventName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctv.logservice.jpa.entities.EventTbl[ eventName=" + eventName + " ]";
    }
    
}
