/*
 * PhysicalLayer.java
 *
 * Created on August 26, 2004, 8:41 PM
 */

package org.dhs.chrislee.manetbuilder.physical;
/**
 *
 * @author  chris
 */
public abstract class PhysicalLayer implements java.io.Serializable {
    
    /** Creates a new instance of PhysicalLayer */
    public PhysicalLayer() {
    }
    
    public abstract boolean getIsWireless();
    public abstract void setPower( double power_dbm );
    public abstract double getPower();
    public abstract void setTransmissionRange( double range_m );
    public abstract double getTransmissionRange( );
    public abstract void setJammingRange( double range_m );
    public abstract double getJammingRange( );
    public abstract void setFullDuplex( boolean duplex );
    public abstract boolean getIsFullDuplex();
    public abstract boolean getIsSwitched();
    public abstract boolean getIsBus();
    public abstract String getName();
    public abstract void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node );
}
