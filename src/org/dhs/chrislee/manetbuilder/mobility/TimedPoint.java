/*
 * TimedPoint.java
 *
 * Created on August 21, 2004, 11:14 AM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import java.awt.geom.*;

/**
 *
 * @author  chris
 */
public class TimedPoint implements java.io.Serializable {
    double x, y;
    double time;
    
    /** Creates a new instance of TimedPoint */
    public TimedPoint( Point2D.Double point, double time ) {
         x = point.x;
        y = point.y;
        this.time = time;
    }
    
    public TimedPoint( double x, double y, double time ) {
        this( new Point2D.Double( x, y ), time );
    }
    
    public double getTime() {
        return ( time );
    }
    
    public void setTime( double time ) {
        this.time = time;
    }
    
    public double getX() {
        return ( x );
    }
    
    public void setX( double x) {
        this.x = x;
    }
    
    public double getY() {
        return ( y );
    }
    
    public void setY( double y) {
        this.y = y;
    }
    
    public Point2D.Double getPoint() {
        return ( new Point2D.Double( x, y ) );
    }
    
    public void setPoint( Point2D.Double point ) {
        x = point.x;
        y = point.y;
    }
        
    public String toString() {
        return( time+": ("+x+","+y+")" );
    }
    
}
