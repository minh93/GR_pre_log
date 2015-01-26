/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctv.logservice.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhamDucMinh
 */
@Entity
@Table(name = "Log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogID", query = "SELECT l FROM Log l WHERE l.logID = :logID"),
    @NamedQuery(name = "Log.findByTimestp", query = "SELECT l FROM Log l WHERE l.timestp = :timestp"),
    @NamedQuery(name = "Log.findByValue", query = "SELECT l FROM Log l WHERE l.value = :value")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "logID")
    private Integer logID;
    @Column(name = "timestp")
    @Temporal(TemporalType.DATE)
    private Date timestp;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "appID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AppInDevice appID;
    @JoinColumn(name = "eventName", referencedColumnName = "eventName")
    @ManyToOne(optional = false)
    private EventTbl eventName;

    public Log() {
    }

    public Log(Integer logID) {
        this.logID = logID;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public Date getTimestp() {
        return timestp;
    }

    public void setTimestp(Date timestp) {
        this.timestp = timestp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AppInDevice getAppID() {
        return appID;
    }

    public void setAppID(AppInDevice appID) {
        this.appID = appID;
    }

    public EventTbl getEventName() {
        return eventName;
    }

    public void setEventName(EventTbl eventName) {
        this.eventName = eventName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logID != null ? logID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logID == null && other.logID != null) || (this.logID != null && !this.logID.equals(other.logID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctv.logservice.jpa.entities.Log[ logID=" + logID + " ]";
    }
    
}
