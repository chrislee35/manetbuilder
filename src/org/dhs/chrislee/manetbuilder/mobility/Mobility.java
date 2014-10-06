/*
 * Mobility.java
 *
 * Created on August 21, 2004, 10:51 AM
 */

package org.dhs.chrislee.manetbuilder.mobility;

/**
 *
 * @author  chris
 */
public abstract class Mobility implements java.io.Serializable {
    
    /** Creates a new instance of Mobility */
    public Mobility() {
    }
    
    public abstract boolean isPlottable();
    public abstract String getName();
    public abstract void addTimedPoint( double x, double y, double time );
    public abstract void addTimedPoint( java.awt.geom.Point2D.Double point, double time );
    public abstract void addTimedPoint( TimedPoint tp );
    public abstract TimedPoint[] getTimedPoints();
    public abstract void showConfigurationDialog( java.awt.Component component );
    public abstract void paintMobility( java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color );
    public abstract java.awt.geom.Point2D.Double getCurrentLocation( double time, double startx, double starty );
}
