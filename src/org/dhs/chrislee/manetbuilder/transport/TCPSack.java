/*
 * TCPSack.java
 *
 * Created on August 29, 2004, 9:01 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class TCPSack extends TransportLayer {
    
    /** Creates a new instance of TCPSack */
    public TCPSack() {
    }

    public String getName() {
        return ( "TCP SACK" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
