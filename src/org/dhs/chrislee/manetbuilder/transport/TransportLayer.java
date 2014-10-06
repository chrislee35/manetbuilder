/*
 * TransportLayer.java
 *
 * Created on August 29, 2004, 8:24 PM
 */

package org.dhs.chrislee.manetbuilder.transport;

/**
 *
 * @author  chris
 */
public abstract class TransportLayer implements java.io.Serializable {
    
    /** Creates a new instance of TransportLayer */
    public TransportLayer() {
    }
    
    public abstract String getName();
    public abstract boolean isConfigurable();
    public abstract void showConfigurationDialog( java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node );
}
