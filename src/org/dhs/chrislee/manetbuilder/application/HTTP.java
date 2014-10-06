/*
 * HTTP.java
 *
 * Created on August 28, 2004, 6:56 PM
 */

package org.dhs.chrislee.manetbuilder.application;
import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author  chris
 */
public class HTTP extends Application {
    org.dhs.chrislee.manetbuilder.Node targetnode;
    
    /** Creates a new instance of HTTP */
    public HTTP() {
    }

    public String getName() {
        return ( "HTTP" );
    }

    public boolean isConfigurable() {
        return ( true );
    }

    public boolean isPlottable() {
        return ( true );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes) {
    }

    public void draw(java.awt.Graphics2D g, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes, java.awt.Color color, double zoom, double time) {
        g.setColor( color );
        float[] dashpattern = { 3, 3 };
        Stroke stroke = g.getStroke();
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dashpattern, 0 ));
        Point2D.Double p1 = node.getCurrentLocation( time );
        Point2D.Double p2 = targetnode.getCurrentLocation( time );
        g.draw( new Line2D.Double( p1.getX()/zoom, p1.getY()/zoom, p2.getX()/zoom, p2.getY()/zoom ) );
        g.drawString( this.getName(), (float)((p1.getX()+p2.getX())/(2*zoom)), (float)((p1.getY()+p2.getY())/(2*zoom)) );
        g.setStroke( stroke );
    }
    
}
