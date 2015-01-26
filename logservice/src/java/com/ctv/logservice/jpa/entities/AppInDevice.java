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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PhamDucMinh
 */
@Entity
@Table(name = "AppInDevice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppInDevice.findAll", query = "SELECT a FROM AppInDevice a"),
    @NamedQuery(name = "AppInDevice.findById", query = "SELECT a FROM AppInDevice a WHERE a.id = :id")})
public class AppInDevice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appID")
    private Collection<Log> logCollection;
    @JoinColumn(name = "appID", referencedColumnName = "appID")
    @ManyToOne
    private App appID;
    @JoinColumn(name = "deviceID", referencedColumnName = "imei")
    @ManyToOne
    private Device deviceID;

    public AppInDevice() {
    }

    public AppInDevice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    public App getAppID() {
        return appID;
    }

    public void setAppID(App appID) {
        this.appID = appID;
    }

    public Device getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Device deviceID) {
        this.deviceID = deviceID;
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
        if (!(object instanceof AppInDevice)) {
            return false;
        }
        AppInDevice other = (AppInDevice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctv.logservice.jpa.entities.AppInDevice[ id=" + id + " ]";
    }
    
}
