package org.dhs.chrislee.manetbuilder.application;
import java.util.HashMap;
/*
 * Application.java
 *
 * Created on August 14, 2004, 11:47 AM
 */

/**
 *
 * @author  chris
 */
public abstract class Application implements java.io.Serializable {    
    public int getPluginType() {
        return ( org.dhs.chrislee.manetbuilder.plugin.Plugin.PLUGIN_TYPE_APPLICATION );
    }
    
    public abstract String getName();
    public abstract void showConfigurationDialog( java.awt.Frame frame, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes );
    public abstract boolean isPlottable();
    public abstract boolean isConfigurable();
    public abstract void draw( java.awt.Graphics2D g, org.dhs.chrislee.manetbuilder.Node node, java.util.ArrayList nodes, java.awt.Color color, double zoom, double time );
}
