/*
 * MacLayer.java
 *
 * Created on August 26, 2004, 8:51 PM
 */

package org.dhs.chrislee.manetbuilder.mac;

/**
 *
 * @author  chris
 */
public abstract class MacLayer implements java.io.Serializable {
    
    /** Creates a new instance of MacLayer */
    public MacLayer() {
    }
    
    public abstract String getName();
    public abstract boolean requiresDuplex();
    public abstract boolean requiresBusyTone();
    public abstract boolean requiresGlobalTiming();
    public abstract boolean requiresLocalTiming();
    public abstract boolean requiresCarrierSensing();
    public abstract boolean isPlottable();
    public abstract boolean isConfigurable();
    public abstract void draw( java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, double zoom, double time );
}
