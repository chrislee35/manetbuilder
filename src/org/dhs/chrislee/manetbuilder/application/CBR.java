/*
 * CBR.java
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
public class CBR extends Application {
    public double starttime = 0;
    public double endtime = 600;
    public double packetInterval = 1.0;
    public int packetSize = 500;
    public int packetCount = 600;
    public double throughput = 300000;
    org.dhs.chrislee.manetbuilder.Node targetnode;
    
    /** Creates a new instance of CBR */
    public CBR() {
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

    public String getName() {
        return ( "CBR" );
    }

    public boolean isConfigurable() {
        return true;
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes) {
        CBRDialog cbrd = new CBRDialog( frame, true, node, nodes );
        cbrd.setVisible( true );
        if ( cbrd.returncode == CBRDialog.OK ) {
            targetnode = (org.dhs.chrislee.manetbuilder.Node)nodes.get( cbrd.targetnodeid );
            starttime = cbrd.starttime;
            endtime = cbrd.endtime;
            packetCount = cbrd.packetCount;
            packetSize = cbrd.packetSize;
            packetInterval = cbrd.packetInterval;
            System.out.println("CBRDialog props: "+targetnode.nodeId );
        }
    }

    public boolean isPlottable() {
        return ( true );
    }

}
