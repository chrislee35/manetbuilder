/*
 * Plugin.java
 *
 * Created on August 28, 2004, 6:48 PM
 */

package org.dhs.chrislee.manetbuilder.plugin;

/**
 *
 * @author  chris
 */
public abstract class Plugin implements java.io.Serializable {
    public static final int PLUGIN_TYPE_APPLICATION = 0;
    public static final int PLUGIN_TYPE_CHANNEL = 1;
    public static final int PLUGIN_TYPE_FILETYPE = 2;
    public static final int PLUGIN_TYPE_MAC = 3;
    public static final int PLUGIN_TYPE_MOBILITY = 4;
    public static final int PLUGIN_TYPE_PHYSICAL = 5;
    public static final int PLUGIN_TYPE_POWER = 6;
    public static final int PLUGIN_TYPE_ROUTING = 7;
    
    /** Creates a new instance of Plugin */
    public Plugin() {
    }
    
    public abstract String getName();
    public abstract int getPluginType();
    public abstract void showConfigurationDialog( java.awt.Frame frame );
    public abstract boolean isPlottable();
    public abstract boolean isConfigurable();
    public abstract void draw( java.awt.Graphics2D g, org.dhs.chrislee.manetbuilder.Node node, double zoom );
}
