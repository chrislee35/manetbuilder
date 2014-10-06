/*
 * IdealPhy.java
 *
 * Created on August 29, 2004, 4:00 PM
 */

package org.dhs.chrislee.manetbuilder.physical;

/**
 *
 * @author  chris
 */
public class IdealPhy extends PhysicalLayer {
    double range = 200;
    
    /** Creates a new instance of IdealPhy */
    public IdealPhy() {
    }

    public boolean getIsBus() {
        return ( false );
    }

    public boolean getIsFullDuplex() {
        return ( false );
    }

    public boolean getIsSwitched() {
        return ( false );
    }

    public boolean getIsWireless() {
        return ( true );
    }

    public double getJammingRange() {
        return ( range );
    }

    public String getName() {
        return ( "Ideal" );
    }

    public double getPower() {
        return ( 0 );
    }

    public double getTransmissionRange() {
        return ( range );
    }

    public void setTransmissionRange(double range_m) {
        range = range_m;
    }

    public void setFullDuplex(boolean duplex) {
    }

    public void setJammingRange(double range_m) {
        range = range_m;
    }

    public void setPower(double power_dbm) {
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node ) {
        javax.swing.JOptionPane op = new javax.swing.JOptionPane();
        int tries = 3;
        while ( tries > 0 ) {
            try {
                String myrange = (String)op.showInputDialog( frame, 
                    "Input the range in meters for this ideal physical layer.", 
                    "Ideal Physical Layer Properties", 
                    javax.swing.JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    null, 
                    ""+range );
                double newrange = Double.parseDouble( myrange );
                if ( newrange > 0 ) {
                    range = newrange;
                    tries = 0;
                }
            } catch ( NumberFormatException e ) {
                tries--;
            }
        }
    }
    
}
