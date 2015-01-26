package com.ctv.logservice.jpa.entities;

import com.ctv.logservice.jpa.entities.AppInDevice;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-02T10:46:07")
@StaticMetamodel(App.class)
public class App_ { 

    public static volatile SingularAttribute<App, String> appName;
    public static volatile SingularAttribute<App, String> appID;
    public static volatile CollectionAttribute<App, AppInDevice> appInDeviceCollection;
    public static volatile SingularAttribute<App, String> category;

}