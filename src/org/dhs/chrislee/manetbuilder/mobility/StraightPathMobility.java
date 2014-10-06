/*
 * StraightPathMobility.java
 *
 * Created on August 21, 2004, 11:28 AM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import java.awt.geom.*;
import java.awt.*;
/**
 *
 * @author  chris
 */
public class StraightPathMobility extends Mobility implements java.io.Serializable {
    java.util.TreeSet timedPoints;
    /** Creates a new instance of StraightPathMobility */
    public StraightPathMobility() {
    }
    
    public void addTimedPoint(java.awt.geom.Point2D.Double point, double time) {
        addTimedPoint( new TimedPoint( point, time ) );
    }
    
    public void addTimedPoint(double x, double y, double time) {
        addTimedPoint( new TimedPoint( x, y, time ) );
    }
    
    public String getName() {
        return ( "Waypoint" );
    }
    
    public TimedPoint[] getTimedPoints() {
        if ( timedPoints == null )
            return null;
        if ( timedPoints.size() == 0 )
            return null;
        TimedPoint[] tps = new TimedPoint[ timedPoints.size() ];
        java.util.SortedSet s = timedPoints.tailSet( timedPoints.first() );
        Object[] tpso = s.toArray();
        for ( int i = 0; i < tpso.length; i++ )
            tps[i] = (TimedPoint)tpso[i];
        //System.out.println("getTimedPoints: length="+tps.length);
        return ( tps );
    }
    
    public boolean isPlottable() {
        return ( true );
    }
    
    public void addTimedPoint(TimedPoint tp) {
        //System.out.println("StraightPathMobility: "+tp.getTime());
        if ( timedPoints == null )
            timedPoints = new java.util.TreeSet( new TimedPointComparator() );
        
        java.util.Iterator it = timedPoints.iterator();
        while ( it.hasNext() ) {
            TimedPoint mytp = (TimedPoint) it.next();
            if ( tp.getTime() == mytp.getTime() ) {
                mytp.setX( tp.getX() );
                mytp.setY( tp.getY() );
                break;
            }
        }
        timedPoints.add( tp );
    }

    public void showConfigurationDialog(java.awt.Component component) {
    }

    public void paintMobility(java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color ) {
        double myx = startx; double myy = starty;
        if ( timedPoints == null )
            return;
        java.util.Iterator tpi = timedPoints.tailSet( timedPoints.first() ).iterator();
        float[] dashpattern = { 3, 3 };
        Stroke stroke = g.getStroke();
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dashpattern, 0 ));
        g.setColor( color );
        while ( tpi.hasNext() ) {
            TimedPoint tps = (TimedPoint)tpi.next();
            g.draw( new Line2D.Double( myx/zoom, myy/zoom, tps.getX()/zoom, tps.getY()/zoom ) );
            g.drawString( Double.toString( tps.getTime() ), (float) (tps.getX()/zoom), (float) (tps.getY()/zoom) );
            myx = tps.getX();
            myy = tps.getY();
        }
        g.setStroke( stroke );
    }

    public java.awt.geom.Point2D.Double getCurrentLocation(double time, double startx, double starty) {
        double myx = startx; double myy = starty; double myt = 0.0;
        if ( timedPoints == null )
            return ( new java.awt.geom.Point2D.Double( startx, starty ) );;
         java.util.Iterator tpi = timedPoints.tailSet( timedPoints.first() ).iterator();
         if ( timedPoints == null || timedPoints.size() == 0 )
            return ( new java.awt.geom.Point2D.Double( startx, starty ) );
         
        while ( tpi.hasNext() ) {
            TimedPoint tps = (TimedPoint)tpi.next();
            if ( tps.getTime() >= time ) {
                double ratio = ( time - myt )/( tps.getTime() - myt );
                double x = myx + ( ( tps.getX() - myx ) * ( ratio ) );
                double y = myy + ( ( tps.getY() - myy ) * ( ratio ) );
                return ( new java.awt.geom.Point2D.Double( x, y ) );
            }
            myx = tps.getX();
            myy = tps.getY();
            myt = tps.getTime();
        }
        return ( new java.awt.geom.Point2D.Double( myx, myy ) );
    }
    
    
}
