/*
 * MACAW.java
 *
 * Created on August 29, 2004, 4:49 PM
 */

package org.dhs.chrislee.manetbuilder.mac;

/**
 *
 * @author  chris
 */
public class MACAW extends MacLayer {
    
    /** Creates a new instance of MACAW */
    public MACAW() {
    }

    public String getName() {
        return ( "MACAW" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public boolean isPlottable() {
        return ( false );
    }

    public boolean requiresBusyTone() {
        return ( false );
    }

    public boolean requiresDuplex() {
        return ( false );
    }

    public boolean requiresGlobalTiming() {
        return ( false );
    }

    public boolean requiresLocalTiming() {
        return ( false );
    }

    public boolean requiresCarrierSensing() {
        return ( false );
    }

    public void draw(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, double zoom, double time) {
    }
}
