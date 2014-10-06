/*
 * RandomMobility.java
 *
 * Created on August 21, 2004, 11:25 AM
 */

package org.dhs.chrislee.manetbuilder.mobility;
import javax.swing.JOptionPane;
/**
 *
 * @author  chris
 */
public class RandomMobility extends Mobility {
    double maxspeed;
    double minspeed;
    /** Creates a new instance of RandomMobility */
    public RandomMobility() {
    }
    
    public void addTimedPoint(java.awt.geom.Point2D.Double point, double time) {
    }
    
    public void addTimedPoint(double x, double y, double time) {
    }
    
    public String getName() {
        return ( "Random" );
    }
    
    public TimedPoint[] getTimedPoints() {
        return ( null );
    }
    
    public boolean isPlottable() {
        return ( false );
    }
    
    public void addTimedPoint(TimedPoint tp) {
    }

    public void showConfigurationDialog(java.awt.Component component) {
        int retry = 0;
        while ( retry < 3 ) {
            try {
                minspeed = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the minimum speed of movement",
                            "Random Mobility Configuration", 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, 
                            null, null, new Double(0.0) ) );
                maxspeed = Double.parseDouble( 
                    (String) new JOptionPane()
                        .showInputDialog( component, 
                            "Enter the maximum speed of movement",
                            "Random Mobility Configuration", 
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

    public void paintMobility(java.awt.Graphics2D g, double startx, double starty, double zoom, java.awt.Color color) {
        
    }

    public java.awt.geom.Point2D.Double getCurrentLocation(double time, double startx, double starty) {
        return ( new java.awt.geom.Point2D.Double( startx, starty ) );
    }
    
    
}
