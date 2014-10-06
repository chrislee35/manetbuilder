/*
 * GifGenerator.java
 *
 * Created on August 19, 2004, 8:42 PM
 */

package org.dhs.chrislee.manetbuilder.fileformat;
import java.io.File;
import org.dhs.chrislee.manetbuilder.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.font.*;
import com.sun.image.codec.jpeg.*;

/**
 *
 * @author  chris
 */
public class PngFileFormat extends FileFormat {    
    /** Creates a new instance of GifGenerator */
    public PngFileFormat() {
    }
    
    public String getFileExtention() {
        return ( "png" );
    }
    
    public String getFileTypeDescription() {
        return ( "PNG Image (*.png)" );
    }
    
    public boolean isReadable() {
        return ( false );
    }

    public boolean isImage() {
        return ( true );
    }
    
    public MapPanel readFile(File myfile) {
        return null;
    }
    
    public void saveFile(java.io.File myfile, MapPanel map) {
        java.util.HashMap options = new java.util.HashMap();
        saveImage( myfile, map, options );
    }
    
    public void saveImage(java.io.File myfile, MapPanel map, java.util.HashMap options) {
        double width, height, zoom = 1.0;
        java.awt.Dimension d = map.getMapSize();
        width = d.getWidth();
        height = d.getHeight();
        if ( options != null )
            if ( options.containsKey( "zoom" ) )
                zoom = ((Double)options.get( "zoom" )).doubleValue();
        BufferedImage img = new BufferedImage( (int)(width/zoom), (int)(height/zoom), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.setBackground( Color.white );
        g.clearRect( 0, 0, (int)(width/zoom), (int)(height/zoom) );
        redrawMap( g, new Dimension( (int)(width/zoom), (int)(height/zoom) ), map, options );
        try {
            javax.imageio.ImageIO.write( img, getFileExtention(), myfile );
            g.dispose();
        } catch ( java.io.IOException e ) {
            e.printStackTrace();
        }            
    }

    public String getName() {
        return ( "PNG" );
    }
}
