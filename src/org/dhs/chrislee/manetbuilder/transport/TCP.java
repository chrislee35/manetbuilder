/*
 * TCP.java
 *
 * Created on August 29, 2004, 8:59 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class TCP extends TransportLayer {
    
    /** Creates a new instance of TCP */
    public TCP() {
    }

    public String getName() {
        return ( "TCP" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
