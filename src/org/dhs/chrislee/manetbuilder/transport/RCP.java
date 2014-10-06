/*
 * RCP.java
 *
 * Created on August 29, 2004, 9:02 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public class RCP extends TransportLayer {
    
    /** Creates a new instance of RCP */
    public RCP() {
    }

    public String getName() {
        return ( "RCP" );
    }

    public boolean isConfigurable() {
        return ( false );
    }

    public void showConfigurationDialog(java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node) {
    }
    
}
