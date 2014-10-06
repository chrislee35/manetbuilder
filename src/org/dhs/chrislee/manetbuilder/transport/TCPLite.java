/*
 * TCPLite.java
 *
 * Created on August 29, 2004, 9:00 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class TCPLite extends TransportLayer {
    
    /** Creates a new instance of TCPLite */
    public TCPLite() {
    }

    public String getName() {
        return ( "TCP Lite" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
