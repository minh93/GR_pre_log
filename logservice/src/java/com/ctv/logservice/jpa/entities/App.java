/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctv.logservice.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "App")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "App.findAll", query = "SELECT a FROM App a"),
    @NamedQuery(name = "App.findByAppID", query = "SELECT a FROM App a WHERE a.appID = :appID"),
    @NamedQuery(name = "App.findByAppName", query = "SELECT a FROM App a WHERE a.appName = :appName"),
    @NamedQuery(name = "App.findByCategory", query = "SELECT a FROM App a WHERE a.category = :category")})
public class App implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "appID")
    private String appID;
    @Size(max = 45)
    @Column(name = "appName")
    private String appName;
    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "appID")
    private Collection<AppInDevice> appInDeviceCollection;

    public App() {
    }

    public App(String appID) {
        this.appID = appID;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<AppInDevice> getAppInDeviceCollection() {
        return appInDeviceCollection;
    }

    public void setAppInDeviceCollection(Collection<AppInDevice> appInDeviceCollection) {
        this.appInDeviceCollection = appInDeviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appID != null ? appID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof App)) {
            return false;
        }
        App other = (App) object;
        if ((this.appID == null && other.appID != null) || (this.appID != null && !this.appID.equals(other.appID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctv.logservice.jpa.entities.App[ appID=" + appID + " ]";
    }
    
}
