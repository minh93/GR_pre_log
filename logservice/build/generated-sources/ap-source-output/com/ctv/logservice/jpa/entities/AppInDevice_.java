package com.ctv.logservice.jpa.entities;

import com.ctv.logservice.jpa.entities.App;
import com.ctv.logservice.jpa.entities.Device;
import com.ctv.logservice.jpa.entities.Log;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-02T10:46:07")
@StaticMetamodel(AppInDevice.class)
public class AppInDevice_ { 

    public static volatile SingularAttribute<AppInDevice, App> appID;
    public static volatile CollectionAttribute<AppInDevice, Log> logCollection;
    public static volatile SingularAttribute<AppInDevice, Integer> id;
    public static volatile SingularAttribute<AppInDevice, Device> deviceID;

}