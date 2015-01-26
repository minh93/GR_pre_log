package com.ctv.logservice.jpa.entities;

import com.ctv.logservice.jpa.entities.AppInDevice;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-02T10:46:07")
@StaticMetamodel(Device.class)
public class Device_ { 

    public static volatile SingularAttribute<Device, String> os;
    public static volatile SingularAttribute<Device, String> name;
    public static volatile SingularAttribute<Device, String> imei;
    public static volatile CollectionAttribute<Device, AppInDevice> appInDeviceCollection;
    public static volatile SingularAttribute<Device, String> manufactory;

}