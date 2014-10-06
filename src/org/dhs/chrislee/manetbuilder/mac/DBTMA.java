/*
 * DBTMA.java
 *
 * Created on August 29, 2004, 4:50 PM
 */

package org.dhs.chrislee.manetbuilder.mac;

/**
 *
 * @author  chris
 */
public class DBTMA extends MacLayer {
    
    /** Creates a new instance of DBTMA */
    public DBTMA() {
    }
    
    public String getName() {
        return ( "DBTMA" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public boolean isPlottable() {
        return ( false );
    }

    public boolean requiresBusyTone() {
        return ( true );
    }

    public boolean requiresDuplex() {
        return ( true );
    }

    public boolean requiresGlobalTiming() {
        return ( false );
    }

    public boolean requiresLocalTiming() {
        return ( false );
    }

    public boolean requiresCarrierSensing() {
        return ( true );
    }

    public void draw(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, double zoom, double time) {
    }
}
