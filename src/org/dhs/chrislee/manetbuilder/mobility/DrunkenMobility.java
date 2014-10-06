/*
 * DrunkenMobility.java
 *
 * Created on August 21, 2004, 11:26 AM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import javax.swing.JOptionPane;
/**
 *
 * @author  chris
 */
public class DrunkenMobility extends Mobility {
    double minspeed, maxspeed, minwait, maxwait;
    
    /** Creates a new instance of DrunkenMobility */
    public DrunkenMobility() {
    }
    
    public void addTimedPoint(java.awt.geom.Point2D.Double point, double time) {
    }
    
    public void addTimedPoint(double x, double y, double time) {
    }
    
    public String getName() {
        return ( "Drunken" );
    }
    
    public TimedPoint[] getTimedPoints() {
        return ( null );
    }
    
    public boolean isPlottable() {
        return ( false );
    }
    
    public void addTimedPoint(TimedPoint tp) {
    }

    public void paintMobility(java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color) {
    }

    public void showConfigurationDialog(java.awt.Component component) {
        int retry = 0;
        while ( retry < 3 ) {
            try {
                minspeed = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the minimum speed of movement",
                            "Drunken Mobility Configuration", 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, 
                            null, null, new Double(0.0) ) );
                maxspeed = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the maximum speed of movement",
                            "Drunken Mobility Configuration", 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, 
                            null, null, new Double(0.0) ) );
                minwait = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the minimum wait time when the node reachs a random destination",
                            "Drunken Mobility Configuration", 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, 
                            null, null, new Double(0.0) ) );
                maxwait = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the maximum wait time when the node reachs a random destination",
                            "Drunken Mobility Configuration", 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, 
                            null, null, new Double(0.0) ) );
                if ( maxspeed > minspeed )
                    retry = 3;
                else
                    retry++;
            } catch ( NumberFormatException e ) {
                retry++;
            }
        }
    }

    public java.awt.geom.Point2D.Double getCurrentLocation(double time, double startx, double starty) {
        return ( new java.awt.geom.Point2D.Double( startx, starty ) );
    }
    
}
