/*
 * ChannelModel.java
 *
 * Created on August 28, 2004, 2:15 PM
 */

package org.dhs.chrislee.manetbuilder.channel;
/**
 *
 * @author  chris
 */
public abstract class ChannelModel implements java.io.Serializable {
    
    /** Creates a new instance of ChannelModel */
    public ChannelModel() {
    }
    
    public abstract String getName();
}
