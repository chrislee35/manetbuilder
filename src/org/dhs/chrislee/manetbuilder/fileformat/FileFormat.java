/*
 * Generator.java
 *
 * Created on August 18, 2004, 10:29 PM
 */

package org.dhs.chrislee.manetbuilder.fileformat;
import org.dhs.chrislee.manetbuilder.*;
import java.awt.geom.*;
import java.awt.*;

/**
 *
 * @author  chris
 */
public abstract class FileFormat implements java.io.Serializable {
    public abstract String getName();
    public abstract String getFileExtention();
    public abstract String getFileTypeDescription();
    public abstract boolean isReadable();
    public abstract boolean isImage();
    public abstract void saveFile( java.io.File myfile, MapPanel map );
    public abstract void saveImage( java.io.File myfile, MapPanel map,
        java.util.HashMap options );
    public abstract MapPanel readFile( java.io.File myfile );
    
    public void redrawMap( Graphics2D g, Dimension mapSize, 
        MapPanel map, java.util.HashMap options ) {
        boolean grid = false, distances = true, coordinates = true, ranges = true, links = true, mobility = true;
        double zoom = 1.0;
        int selectedNodeId = 0;
        int time = 0;
        
        if ( options != null ) {
            if ( options.containsKey( "grid" ) ) 
                grid = ((Boolean)options.get( "grid" )).booleanValue();
            if ( options.containsKey( "links" ) ) 
                links = ((Boolean)options.get( "links" )).booleanValue();
            if ( options.containsKey( "ranges" ) ) 
                ranges = ((Boolean)options.get( "ranges" )).booleanValue();
            if ( options.containsKey( "distances" ) ) 
                distances = ((Boolean)options.get( "distances" )).booleanValue();
            if ( options.containsKey( "coordinates" ) ) 
                coordinates = ((Boolean)options.get( "coordinates" )).booleanValue();        
            if ( options.containsKey( "mobility" ) ) 
                mobility = ((Boolean)options.get( "mobility" )).booleanValue();        
            if ( options.containsKey( "selectedNodeId" ) ) 
                selectedNodeId = ((Integer)options.get( "selectedNodeId" )).intValue();        
            if ( options.containsKey( "time" ) ) 
                time = ((Integer)options.get( "time" )).intValue();        
            if ( options.containsKey( "zoom" ) ) 
                zoom = ((Double)options.get( "zoom" )).doubleValue();        
        }
        java.util.ArrayList nodes = map.getNodes();
        if ( nodes == null )
            return;
        if ( grid )
            MapPainter.drawGrid( g, mapSize, zoom );
        g.setFont( new java.awt.Font( "Helvetica", Font.PLAIN, 10 ) );
        if ( map.getBackgroundImage() != null )
            g.drawImage( map.getBackgroundImage(), 0, 0, (int)(mapSize.getWidth()/zoom), (int)(mapSize.getHeight()/zoom), map );
        for ( int i = 0; i < nodes.size(); i++ ) {
            Node node = (Node)nodes.get(i);
            if ( node == null ) continue;
            boolean selected = ( selectedNodeId == node.nodeId );
            if ( links )
                MapPainter.drawLink( g, node, zoom, time, nodes, distances, false );
            if ( ranges )
                MapPainter.drawRange( g, node, zoom, time, selected );
            MapPainter.drawNode( g, node, zoom, time, selected, coordinates );
            if ( mobility )
                MapPainter.drawMobility( g, node, zoom, selected, time );

        }
    }
}
