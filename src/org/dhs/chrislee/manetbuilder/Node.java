package org.dhs.chrislee.manetbuilder;

/*
 * Node.java
 *
 * Created on August 14, 2004, 11:39 AM
 */
import org.dhs.chrislee.manetbuilder.application.*;
import org.dhs.chrislee.manetbuilder.mobility.*;
import org.dhs.chrislee.manetbuilder.mac.*;
import org.dhs.chrislee.manetbuilder.physical.*;
import org.dhs.chrislee.manetbuilder.routing.*;
import org.dhs.chrislee.manetbuilder.power.*;
import org.dhs.chrislee.manetbuilder.transport.*;

import java.awt.geom.Point2D;
/**
 *
 * @author  chris
 */
public class Node implements java.io.Serializable {
    public int nodeId;
    
    public double x;
    public double y;
    public double range;
    
    public Mobility mobility;
    public PhysicalLayer phy;
    public MacLayer mac;
    public PowerModel power;
    public RoutingLayer routing;
    public TransportLayer transport;

    java.util.ArrayList app;
    
    public static final int UNILINK_TO = -1;
    public static final int NOLINK = 0;
    public static final int UNILINK = 1;
    public static final int BILINK = 2;
    
    /** Creates a new instance of Node */
    public Node( int node_id, double x_loc, double y_loc, double node_range ) {
        nodeId = node_id;
        x = x_loc;
        y = y_loc;
        phy = new org.dhs.chrislee.manetbuilder.physical.IdealPhy();
        phy.setTransmissionRange( node_range );
    }

    public String toString() {
        return ( "Node: nodeId="+nodeId+" x="+x+", y="+y+", range="+range );
    }
    
    public void addApplication( Application a ) {
        if ( app == null )
            app = new java.util.ArrayList();
        app.add(a);
    }
    
    public int getLinkStatus( Node othernode ) {
        double distance = Math.sqrt( Math.pow(x - othernode.x,2) + Math.pow(y - othernode.y,2) );
        if ( distance < this.getTransmissionRange() ) {
            if ( distance < othernode.getTransmissionRange() ) {
                return ( BILINK );
            } else {
                return ( UNILINK );
            }
        } else if ( distance < othernode.getTransmissionRange() ) {
            return ( UNILINK_TO );
        } else {
            return ( NOLINK );
        }
    }
 
    public int getLinkStatus( Node othernode, double time ) {
        Point2D.Double myloc = getCurrentLocation( time );
        Point2D.Double otherloc = othernode.getCurrentLocation( time );
        
        double distance = Math.sqrt( Math.pow(myloc.x - otherloc.x,2) + Math.pow(myloc.y - otherloc.y,2) );
        if ( distance < this.getTransmissionRange() ) {
            if ( distance < othernode.getTransmissionRange() ) {
                return ( BILINK );
            } else {
                return ( UNILINK );
            }
        } else if ( distance < othernode.getTransmissionRange() ) {
            return ( UNILINK_TO );
        } else {
            return ( NOLINK );
        }
    }

    public java.awt.geom.Point2D.Double getCurrentLocation( double time ) {
        double myx = x; double myy = y; double myt = 0;
        if ( mobility == null )
            return ( new java.awt.geom.Point2D.Double( x, y ) );
        return ( mobility.getCurrentLocation( time, x, y ) );
    }
    
    public double getTransmissionRange() {
        return ( phy.getTransmissionRange() );
    }
    
    public double getJammingRange() {
        return ( phy.getJammingRange() );
    }
}
