/*
 * MapPainter.java
 *
 * Created on August 20, 2004, 7:56 PM
 */

package org.dhs.chrislee.manetbuilder;
import java.awt.*;
import java.awt.geom.*;
import org.dhs.chrislee.manetbuilder.mobility.*;
import org.dhs.chrislee.manetbuilder.application.*;

/**
 *
 * @author  chris
 */
public class MapPainter {
    
    /** Creates a new instance of MapPainter */
    public MapPainter() {
    }
    
    public static void drawNode( Graphics2D g, Node node, double zoom, double time, boolean selected, boolean printCoords ) {
        Point2D.Double loc = node.getCurrentLocation( time );
        Ellipse2D.Double marker = new Ellipse2D.Double( (loc.x/zoom) - 2, (loc.y/zoom) - 2, 5, 5 );
        if ( selected ) g.setColor( Color.orange ); else g.setColor( Color.black );
        g.fill( marker );
        if ( printCoords )
            g.drawString( "("+(Math.round( loc.x * 100 )/100)+","+(Math.round( loc.y * 100 )/100)+")", (int)((loc.x/zoom) + 5), (int)((loc.y/zoom) - 5) );         
    }
    
    public static void drawRange( Graphics2D g, Node node, double zoom, double time, boolean selected ) {
        Point2D.Double loc = node.getCurrentLocation( time );
        double transmissionRange = node.getTransmissionRange();
        double jammingRange = node.getJammingRange();
        
        Ellipse2D.Double range = new Ellipse2D.Double( (loc.x - transmissionRange)/zoom, (loc.y - transmissionRange)/zoom, (2*transmissionRange)/zoom, (2*transmissionRange)/zoom );     
        float[] dashpattern = { 5, 3 };
        Stroke stroke = g.getStroke();
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dashpattern, 0 ));
        if ( selected ) g.setColor( Color.gray ); else g.setColor( Color.lightGray );
        g.draw( range );
        if ( transmissionRange != jammingRange ) {
            Color color = g.getColor();
            color = new Color( color.getRed(), color.getGreen(), color.getBlue(), (int)(color.getAlpha() / 2) );
            g.setColor( color );
            g.draw( new Ellipse2D.Double( ( loc.x - jammingRange )/zoom, ( loc.y - jammingRange )/zoom, ( 2 * jammingRange )/zoom, ( 2 * jammingRange )/zoom ) );
        }
        g.setStroke( stroke );
    }
    
    public static void drawLink( Graphics2D g, Node node, double zoom, double time, java.util.ArrayList nodes, boolean lengths, boolean checkUnidirectionalLinksToThisNode ) {
        Point2D.Double loc = node.getCurrentLocation( time );
        for ( int i = 0; i < nodes.size(); i++ ) {
            Node othernode = (Node)nodes.get( i );
            if ( othernode == null ) continue;
            if ( node.equals( othernode ) )
                continue;
            Point2D.Double loc2 = othernode.getCurrentLocation( time );
            int linkstatus = node.getLinkStatus( othernode, time );
            if ( linkstatus == Node.NOLINK )
                continue;            
            if ( linkstatus == Node.BILINK )
                g.setColor( Color.blue );
            else
                g.setColor( Color.red );
            Line2D.Double link = new Line2D.Double( loc.x/zoom, loc.y/zoom, loc2.x/zoom, loc2.y/zoom );     
            float[] dashpattern = { 1, 5 };
            Stroke stroke = g.getStroke();
            g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dashpattern, 0 ));
            g.draw( link );
            g.setStroke( stroke );
            
            if ( lengths ) {
                double mid_x = ( loc.x + loc2.x )/2;
                double mid_y = ( loc.y + loc2.y )/2;
                double length = Math.sqrt( Math.pow( loc.x - loc2.x, 2 ) + Math.pow( loc.y - loc2.y, 2 ) );
                g.setColor( Color.magenta );
                g.drawString( "<"+(Math.round(length*100)/100)+">", (int)(mid_x/zoom), (int)(mid_y/zoom) );
            }
        }
    }
    
    public static void drawGrid( Graphics2D g, Dimension mapSize, double zoom ) {
        double min = mapSize.getWidth();
        double spacer;
        if ( min > mapSize.getHeight() )
            min = mapSize.getHeight();
        if ( min < 1e4 )
            spacer = 1e1;
        else if ( min < 1e5 )
            spacer = 1e2;
        else if ( min < 1e6 )
            spacer = 1e3;
        else
            spacer = 1e2;
        
        spacer /= zoom;
        
        float[] dashpattern = { 1, 5 };
        Stroke stroke = g.getStroke();
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dashpattern, 0 ));
        Color majorc = new Color( 180, 180, 255 );
        Color minorc = new Color( 220, 220, 255 );
        int major = 0;
        for ( double x = spacer; x < mapSize.getWidth(); x += spacer ) {
            if ( major++ % 10 == 0 )
                g.setColor( majorc );
            else
                g.setColor( minorc );
            g.draw( new Line2D.Double( x, 0, x, mapSize.getHeight() ) ); 
        }
        major = 0;
        for ( double y = spacer; y < mapSize.getHeight(); y += spacer ) {
            if ( major++ % 10 == 0 )
                g.setColor( majorc );
            else
                g.setColor( minorc );
            g.draw( new Line2D.Double( 0, y, mapSize.getWidth(), y ) );        
        }
        g.setStroke( stroke );               
    }
    
    public static void drawMobility( Graphics2D g, Node node, double zoom, boolean selected, double time ) {
        if ( node.mobility == null || ! node.mobility.isPlottable() )
            return;
        Color color;
        if ( selected ) color = Color.green;
        else color = new Color( 0, 128, 0 );
        node.mobility.paintMobility( g, node.x, node.y, zoom, color );
    }
    
    public static void drawApplication( Graphics2D g, Node node, java.util.ArrayList nodes, double zoom, boolean selected, double time ) {
        if ( node.app == null || node.app.size() == 0 )
            return;
        java.awt.Color color;
        if ( selected ) color = Color.yellow;
        else color = new Color( 128, 128, 0 );
        for ( int i = 0; i < node.app.size(); i++ ) {
            Application app = (Application)node.app.get( i );
            if ( app == null )
                continue;
            if ( app.isPlottable() )
                app.draw( g, node, nodes, color, zoom, time );
        }
    }
    
    public static void drawMapProperties( Graphics2D g, double zoom, double time, double mousex, double mousey ) {
        g.drawString( "zoom: "+ Math.round( (1/zoom)*1000 )/10 +" time: "+ time +" "+mousex+","+mousey, 0, 0 );
    }
}
