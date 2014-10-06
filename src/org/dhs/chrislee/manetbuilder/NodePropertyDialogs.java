/*
 * NodePropertyEditors.java
 *
 * Created on August 28, 2004, 11:12 AM
 */

package org.dhs.chrislee.manetbuilder;
import javax.swing.JOptionPane;
import java.awt.geom.Point2D;
import org.dhs.chrislee.manetbuilder.mobility.*;
import org.dhs.chrislee.manetbuilder.physical.*;
import org.dhs.chrislee.manetbuilder.mac.*;
import org.dhs.chrislee.manetbuilder.power.*;
import org.dhs.chrislee.manetbuilder.routing.*;
import org.dhs.chrislee.manetbuilder.application.*;
import org.dhs.chrislee.manetbuilder.transport.*;

/**
 *
 * @author  chris
 */
public class NodePropertyDialogs {
    
    /** Creates a new instance of NodePropertyEditors */
    public NodePropertyDialogs() {
    }
    
    public static void showLocationDialog( java.awt.Component component, Node node ) {
        JOptionPane newloc = new JOptionPane();
        String location = (String)newloc.showInputDialog( component, 
            "Enter a new location for node "+node.nodeId+" in x,y format.", 
            "Location Dialog", 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            null, 
            node.x+","+node.y );
        if ( location == null )
            return;
        String[] parts = location.split( "," );
        try {
            double x = Double.parseDouble( parts[0] );
            double y = Double.parseDouble( parts[1] );
            Point2D.Double point = new Point2D.Double( x, y );
            node.x = x; node.y = y;
        } catch ( NumberFormatException e ) {
            System.err.println( "Improper format for new coordinates for node "+node.nodeId+". Change was rejected." );
        }
    }

    public static void showMobilityDialog( java.awt.Component component, Node node ) {
        JOptionPane newmobility = new JOptionPane();
        
        String[] mobilityModels = new String[ ManetBuilderPluginFinder.mobilities.size() + 1 ];
        java.util.Iterator mk = ManetBuilderPluginFinder.mobilities.keySet().iterator();
        int i = 0;
        mobilityModels[ i++ ] = "None";
        while ( mk.hasNext() )
            mobilityModels[ i++ ] = (String)mk.next();

        String currentModel;
        if ( node.mobility == null )
            currentModel = "None";
        else
            currentModel = node.mobility.getName();
        String mobility = (String)newmobility.showInputDialog( component,
            "Select a new mobility model for node "+node.nodeId,
            "Mobility Model Dialog",
            JOptionPane.QUESTION_MESSAGE,
            null,
            mobilityModels,
            currentModel );
        if ( mobility == null )
            return;
        if ( mobility.equals( "None" ) )
            node.mobility = null;
        if ( node.mobility != null && node.mobility.getName().equals( mobility ) )
            return;
        // lookup correct mobility model, call its init function, and set it into node.mobility
        try {
            node.mobility = (Mobility)((Class)ManetBuilderPluginFinder.mobilities.get( mobility ) ).newInstance();
        } catch ( Exception e ) {
            System.err.println( e.toString() );
        }
    }
        
    public static void showPhysicalDialog( java.awt.Frame component, Node node ) {
        JOptionPane op = new JOptionPane();
        
        String[] names = new String[ ManetBuilderPluginFinder.physicallayers.size() + 1 ];
        java.util.Iterator keys = ManetBuilderPluginFinder.physicallayers.keySet().iterator();
        int i = 0;
        while ( keys.hasNext() )
            names[ i++ ] = (String)keys.next();

        String currentModel;
        if ( node.mobility == null )
            currentModel = "None";
        else
            currentModel = node.phy.getName();
        String name = (String)op.showInputDialog( component,
            "Select a new physical layer model for node "+node.nodeId,
            "Physical Layer Model Dialog",
            JOptionPane.QUESTION_MESSAGE,
            null,
            names,
            currentModel );
        if ( name == null )
            return;
        if ( node.mobility != null && node.phy.getName().equals( name ) )
            return;
        // lookup correct mobility model, call its init function, and set it into node.mobility
        try {
            node.phy = (PhysicalLayer)((Class)ManetBuilderPluginFinder.physicallayers.get( name ) ).newInstance();
            node.phy.showConfigurationDialog( component, node );
        } catch ( Exception e ) {
            System.err.println( e.toString() );
        }
    }
    public static void showPowerDialog( java.awt.Component component, Node node ) {
    }
    public static void showMacDialog( java.awt.Component component, Node node ) {
    }
    public static void showRoutingDialog( java.awt.Component component, Node node ) {
    }
    public static void showTransportDialog( java.awt.Frame frame, Node node ) {
        JOptionPane op = new JOptionPane();
        
        String[] names = new String[ ManetBuilderPluginFinder.transportlayers.size() + 1 ];
        java.util.Iterator keys = ManetBuilderPluginFinder.transportlayers.keySet().iterator();
        int i = 0;
        while ( keys.hasNext() )
            names[ i++ ] = (String)keys.next();

        String currentModel;
        if ( node.mobility == null )
            currentModel = "None";
        else
            currentModel = node.phy.getName();
        String name = (String)op.showInputDialog( frame,
            "Select a new transport layer model for node "+node.nodeId,
            "Transport Layer Model Dialog",
            JOptionPane.QUESTION_MESSAGE,
            null,
            names,
            currentModel );
        if ( name == null )
            return;
        if ( name.equals( "None" ) )
            node.phy = null;
        if ( node.mobility != null && node.phy.getName().equals( name ) )
            return;
        // lookup correct mobility model, call its init function, and set it into node.mobility
        try {
            node.transport = (TransportLayer)((Class)ManetBuilderPluginFinder.transportlayers.get( name ) ).newInstance();
            node.transport.showConfigurationDialog( frame, node );
        } catch ( Exception e ) {
            System.err.println( e.toString() );
        }
    }
    public static void showApplicationDialog( java.awt.Frame component, Node node, java.util.ArrayList nodes ) {
        JOptionPane op = new JOptionPane();
        
        String[] names = new String[ ManetBuilderPluginFinder.applications.size() ];
        java.util.Iterator keys = ManetBuilderPluginFinder.applications.keySet().iterator();
        
        int i = 0;
        while ( keys.hasNext() )
            names[ i++ ] = (String)keys.next();

        String currentModel;
        
        String name = (String)op.showInputDialog( component,
            "Select a new application to add to node "+node.nodeId,
            "Application Layer Model Dialog",
            JOptionPane.QUESTION_MESSAGE,
            null,
            names,
           "None" );
        if ( name == null )
            return;
        try {
            Application app = (Application)((Class)ManetBuilderPluginFinder.applications.get( name ) ).newInstance();
            app.showConfigurationDialog( component, node, nodes );
            node.addApplication( app );
        } catch ( Exception e ) {
            System.err.println( e.toString() );
        }
    }

}
