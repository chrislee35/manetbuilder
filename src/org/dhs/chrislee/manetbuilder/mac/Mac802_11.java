/*
 * Mac802_11.java
 *
 * Created on August 29, 2004, 4:46 PM
 */

package org.dhs.chrislee.manetbuilder.mac;

/**
 *
 * @author  chris
 */
public class Mac802_11 extends MacLayer {
    
    /** Creates a new instance of Mac802_11 */
    public Mac802_11() {
    }

    public String getName() {
        return ( "802.11 MAC" );
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
