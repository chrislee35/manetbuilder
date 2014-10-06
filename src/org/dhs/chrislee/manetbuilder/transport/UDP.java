/*
 * UDP.java
 *
 * Created on August 29, 2004, 9:02 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class UDP extends TransportLayer {
    
    /** Creates a new instance of UDP */
    public UDP() {
    }

    public String getName() {
        return ( "UDP" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
