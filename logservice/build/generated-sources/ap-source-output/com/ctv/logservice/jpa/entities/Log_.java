package com.ctv.logservice.jpa.entities;

import com.ctv.logservice.jpa.entities.AppInDevice;
import com.ctv.logservice.jpa.entities.EventTbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-02T10:46:07")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, AppInDevice> appID;
    public static volatile SingularAttribute<Log, EventTbl> eventName;
    public static volatile SingularAttribute<Log, Integer> logID;
    public static volatile SingularAttribute<Log, Date> timestp;
    public static volatile SingularAttribute<Log, String> value;

}