/*
 * ManetBuilderGenerator.java
 *
 * Created on August 18, 2004, 10:34 PM
 */

package org.dhs.chrislee.manetbuilder.fileformat;
import org.dhs.chrislee.manetbuilder.*;
import org.dhs.chrislee.manetbuilder.mobility.*;
import java.awt.Image;
/**
 *
 * @author  chris
 */
public class ManetBuilderFileFormat extends FileFormat {
    
    /** Creates a new instance of ManetBuilderGenerator */
    public ManetBuilderFileFormat() {
    }
    
    public String getFileExtention() {
        return ( "top" );
    }
    
    public String getFileTypeDescription() {
        return ( "ManetBuilder (*.top)" );
    }
    
    public MapPanel readFile(java.io.File myfile) {
        MapPanel mapPanel = null;
        try {
            if ( ! myfile.exists() )
                return null;
            
            java.io.FileInputStream fis = new java.io.FileInputStream( myfile );
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream( fis );
            mapPanel = (MapPanel)ois.readObject();
            ois.close();
            fis.close();
            if ( mapPanel.getImageFilename() != null ) {
                java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
                java.awt.Image background = toolkit.getImage( mapPanel.getImageFilename() );
                mapPanel.setBackgroundImage( background );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return ( mapPanel );
    }
    
    public void saveFile(java.io.File myfile, MapPanel map) {
        try {
            java.io.FileOutputStream fos = new java.io.FileOutputStream( myfile );
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream( fos );
            oos.writeObject( map );
            oos.close();
            fos.close();
        } catch ( java.io.IOException e ) {
            e.printStackTrace();
        }
    }
    
    public boolean isReadable() {
        return ( true );
    }
    
    public boolean isImage() {
        return ( false );
    }
    
    public void saveImage(java.io.File myfile, MapPanel map, java.util.HashMap options) {
        System.out.println("ManetBuilderGenerator.saveImage(...) should never be called!");
    }

    public String getName() {
        return ( "ManetBuilder" );
    }
}
