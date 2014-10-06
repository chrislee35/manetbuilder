/*
 * TeleportMobility.java
 *
 * Created on August 25, 2004, 10:50 PM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author  chris
 */
public class TeleportMobility extends Mobility {
    java.util.TreeSet timedPoints;
    
    /** Creates a new instance of TeleportMobility */
    public TeleportMobility() {
    }
    
    public void addTimedPoint(TimedPoint tp) {
        //System.out.println("StraightPathMobility: "+tp.getTime());
        if ( timedPoints == null )
            timedPoints = new java.util.TreeSet( new java.util.Comparator() {
                public int compare( Object one, Object two ) {
                    if ( ((TimedPoint)two).getTime() == ((TimedPoint)one).getTime() )
                        return 0;
                    if ( ((TimedPoint)two).getTime() > ((TimedPoint)one).getTime() )
                        return -1;
                    return 1;
                }
            });
        
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
    
    public void addTimedPoint(java.awt.geom.Point2D.Double point, double time) {
        addTimedPoint( new TimedPoint( point, time ) );
    }
    
    public void addTimedPoint(double x, double y, double time) {
        addTimedPoint( new TimedPoint( x, y, time ) );
    }
    
    public String getName() {
        return ( "Teleport" );
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

    public void showConfigurationDialog(java.awt.Component component) {
    }

    public void paintMobility(java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color ) {
        if ( timedPoints == null )
            return;
        g.setColor( color );
        g.draw( new Ellipse2D.Double( (startx/zoom),  (starty/zoom),  1, 1 ) );
        g.draw( new Ellipse2D.Double( (startx/zoom) - 2,  (starty/zoom) - 2,  5, 5 ) );
        g.drawString( "0.0", (float) (startx/zoom), (float) (starty/zoom) );
        
        java.util.Iterator tpi = timedPoints.tailSet( timedPoints.first() ).iterator();
        while ( tpi.hasNext() ) {
            TimedPoint tps = (TimedPoint)tpi.next();
            g.draw( new Ellipse2D.Double( (tps.getX()/zoom), (tps.getY()/zoom), 1, 1 ) );
            g.draw( new Ellipse2D.Double( (tps.getX()/zoom) - 2, (tps.getY()/zoom) - 2, 5, 5 ) );
            g.drawString( Double.toString( tps.getTime() ), (float) (tps.getX()/zoom), (float) (tps.getY()/zoom) );
        }
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
            if ( tps.getTime() > time )
                return ( new java.awt.geom.Point2D.Double( myx, myy ) );
            myx = tps.getX();
            myy = tps.getY();
            myt = tps.getTime();
        }
        return ( new java.awt.geom.Point2D.Double( myx, myy ) );
    }
 
    
}
