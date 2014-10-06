/*
 * RoutingLayer.java
 *
 * Created on August 26, 2004, 8:52 PM
 */

package org.dhs.chrislee.manetbuilder.routing;

/**
 *
 * @author  chris
 */
public abstract class RoutingLayer implements java.io.Serializable {
    
    /** Creates a new instance of RoutingLayer */
    public RoutingLayer() {
    }
    
    public abstract String getName();
}
