/*
 * Jammer.java
 *
 * Created on August 28, 2004, 6:57 PM
 */

package org.dhs.chrislee.manetbuilder.application;

/**
 *
 * @author  chris
 */
public class Jammer extends Application {
    double cycleTime;
    
    /** Creates a new instance of Jammer */
    public Jammer() {
    }

    public void draw(java.awt.Graphics2D g, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes, java.awt.Color color, double zoom, double time) {
        g.setColor( color );
        int alpha = color.getAlpha();
        double alphastep = alpha / ( node.getJammingRange() / (10*zoom) );
        double phase = time % 10;
        java.awt.geom.Point2D.Double p1 = node.getCurrentLocation( time );
        double x = p1.getX();
        double y = p1.getY();
        if ( ( ( time * 2 ) / cycleTime ) % 2 > 1 ) {
            for ( double range = 0; range < node.getJammingRange(); range += 10*zoom ) {
                g.draw( new java.awt.geom.Ellipse2D.Double( (x - range - phase)/zoom, (y - range - phase)/zoom, ( (range + phase )*2)/zoom, ( (range + phase )*2)/zoom ) );
                int currAlpha = color.getAlpha();
                if ( currAlpha < alphastep )
                    currAlpha = (int)Math.round( alphastep );
                color = new java.awt.Color( color.getRed(), color.getGreen(), color.getBlue(), (int) ( currAlpha - alphastep ) );
                g.setColor( color );
            }
        }
    }

    public String getName() {
        return ( "Jammer" );
    }

    public boolean isConfigurable() {
        return ( true );
    }

    public boolean isPlottable() {
        return ( true );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes) {
        javax.swing.JOptionPane op = new javax.swing.JOptionPane();
        int tries = 3;
        while ( tries > 0 ) {
            String cycle_time = (String) op.showInputDialog( frame, "Enter the cycle time in seconds", "Jammer Cycle Time Dialog", javax.swing.JOptionPane.QUESTION_MESSAGE );
            try {
                double ct = Double.parseDouble( cycle_time );
                cycleTime = ct;
                tries = 0;
            } catch ( NumberFormatException e ) {
                tries--;
            }
        }
    }
    
}
