/*
 * TCPTahoe.java
 *
 * Created on August 29, 2004, 9:01 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class TCPTahoe extends TransportLayer {
    
    /** Creates a new instance of TCPTahoe */
    public TCPTahoe() {
    }

    public String getName() {
        return ( "TCP Tahoe" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
