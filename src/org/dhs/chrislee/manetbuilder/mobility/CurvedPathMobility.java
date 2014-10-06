/*
 * CurvedPathMobility.java
 *
 * Created on August 25, 2004, 10:54 PM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import java.awt.geom.*;
import java.awt.*;
/**
 *
 * @author  chris
 */
public class CurvedPathMobility extends Mobility {
    java.util.TreeSet timedPoints;
    
    /** Creates a new instance of CurvedPathMobility */
    public CurvedPathMobility() {
    }
    
    public void addTimedPoint(java.awt.geom.Point2D.Double point, double time) {
        addTimedPoint( new TimedPoint( point, time ) );
    }
    
    public void addTimedPoint(double x, double y, double time) {
        addTimedPoint( new TimedPoint( x, y, time ) );
    }
    
    public String getName() {
        return ( "Curved Path (broken)" );
    }
    
    public TimedPoint[] getTimedPoints() {
        if ( timedPoints == null || timedPoints.size() == 0 )
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

    public java.awt.geom.Point2D.Double getCurrentLocation(double time, double startx, double starty) {
        return ( new java.awt.geom.Point2D.Double( startx, starty ) );
    }

    public void paintMobility(java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color) {
        if ( timedPoints == null )
            return;
        g.setColor( color );

        java.util.Iterator tpi = timedPoints.tailSet( timedPoints.first() ).iterator();
        TimedPoint p1, p2, p3;
        if ( timedPoints.size() < 4 ) {
            if ( timedPoints.size() == 1 ) {
                p1 = (TimedPoint)tpi.next();
                g.draw( new Line2D.Double( startx/zoom, starty/zoom, p1.getX()/zoom, p1.getY()/zoom ) );
                g.drawString( Double.toString( p1.getTime() ), (float) (p1.getX()/zoom), (float) (p1.getY()/zoom) );
            } else if ( timedPoints.size() == 2 ) {
                p1 = (TimedPoint)tpi.next();
                p2 = (TimedPoint)tpi.next();
                g.draw( new QuadCurve2D.Double( startx/zoom, starty/zoom, p1.getX()/zoom, p1.getY()/zoom, p2.getX()/zoom, p2.getY()/zoom ) );
            } else if ( timedPoints.size() == 3 ) {
                p1 = (TimedPoint)tpi.next();
                p2 = (TimedPoint)tpi.next();
                p3 = (TimedPoint)tpi.next();
                g.draw( new CubicCurve2D.Double( startx/zoom, starty/zoom, p1.getX()/zoom, p1.getY()/zoom, p2.getX()/zoom, p2.getY()/zoom, p3.getX()/zoom, p3.getY()/zoom ) );
            }
            return;
        }
        while ( tpi.hasNext() ) {
            TimedPoint tps = (TimedPoint)tpi.next();
            g.draw( new Ellipse2D.Double( (tps.getX()/zoom), (tps.getY()/zoom), 1, 1 ) );
            g.draw( new Ellipse2D.Double( (tps.getX()/zoom) - 2, (tps.getY()/zoom) - 2, 5, 5 ) );
            g.drawString( Double.toString( tps.getTime() ), (float) (tps.getX()/zoom), (float) (tps.getY()/zoom) );
        }
    }

    public void showConfigurationDialog(java.awt.Component component) {
    }
    
}
