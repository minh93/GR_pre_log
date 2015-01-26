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
@Table(name = "Device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findByImei", query = "SELECT d FROM Device d WHERE d.imei = :imei"),
    @NamedQuery(name = "Device.findByName", query = "SELECT d FROM Device d WHERE d.name = :name"),
    @NamedQuery(name = "Device.findByManufactory", query = "SELECT d FROM Device d WHERE d.manufactory = :manufactory"),
    @NamedQuery(name = "Device.findByOs", query = "SELECT d FROM Device d WHERE d.os = :os")})
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "imei")
    private String imei;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "manufactory")
    private String manufactory;
    @Size(max = 45)
    @Column(name = "os")
    private String os;
    @OneToMany(mappedBy = "deviceID")
    private Collection<AppInDevice> appInDeviceCollection;

    public Device() {
    }

    public Device(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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
        hash += (imei != null ? imei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.imei == null && other.imei != null) || (this.imei != null && !this.imei.equals(other.imei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctv.logservice.jpa.entities.Device[ imei=" + imei + " ]";
    }
    
}
