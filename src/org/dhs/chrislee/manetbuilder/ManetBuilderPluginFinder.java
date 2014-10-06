/*
 * ManetBuilderPluginFinder.java
 *
 * Created on August 28, 2004, 1:29 PM
 */

package org.dhs.chrislee.manetbuilder;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.lang.reflect.*;

/**
 *
 * @author  chris
 */
public class ManetBuilderPluginFinder {
    public static HashMap mobilities;
    public static HashMap maclayers;
    public static HashMap channelmodels;
    public static HashMap applications;
    public static HashMap fileformats;
    public static HashMap powermodels;
    public static HashMap physicallayers;
    public static HashMap routinglayers;
    public static HashMap transportlayers;
    
    /** Creates a new instance of ManetBuilderPluginFinder */
    public ManetBuilderPluginFinder() {
    }
    
    public static void initPlugins() {
        System.out.println("Initializing ManetBuilder Plugins. Please wait...");
        
        // initialize the holders for all the different types of plugins
        mobilities = new HashMap();
        maclayers = new HashMap();
        channelmodels = new HashMap();
        applications = new HashMap();
        fileformats = new HashMap();
        powermodels = new HashMap();
        physicallayers = new HashMap();
        routinglayers = new HashMap();
        transportlayers = new HashMap();
        
        // set the classpath from the current running classpath
        String s = System.getProperties().getProperty("java.class.path");
        // find out the correct path separater to parse with (colon or semicolons are common)
        String pathSep = System.getProperties().getProperty("path.separator");
        // get the different parts of the classpath
        StringTokenizer st = new StringTokenizer(s, pathSep);
        // Process each classpath
        while (st.hasMoreTokens()) {
            // get the next part of the classpath
            String cand = st.nextToken();
            //System.err.println("Trying path " + cand);
            ArrayList al = null;
            // if the part is an archive, process the archive
            if (cand.endsWith(".zip") || cand.endsWith(".jar")) {
                al = readZipEntries( cand );
            } else if ( new File( cand ).isDirectory() ) {
                al = readDirectoryEntries( cand );
            }
            if ( al != null )
                processEntries( al );
        }
        
        
    }
    
	static ArrayList readZipEntries(String classes) {
        ArrayList entries = new ArrayList();
        try {
            ZipFile zippy = new ZipFile(new File(classes));
            Enumeration all = zippy.entries();
            // For each entry, get its name and put it into "entries"
            while (all.hasMoreElements()) {
                entries.add(((ZipEntry)(all.nextElement())).getName());
            }
        } catch (IOException err) {
            System.err.println("IO Error: " + err);
            return ( null );
        }
        return ( entries );
    }
    
    static ArrayList readDirectoryEntries( String directory ) {
        ArrayList entries = new ArrayList();
        File mbcp = new File( directory, "/org/dhs/chrislee/manetbuilder/" );
        if ( ! mbcp.exists() )
            return ( null );
        File dirs[] = mbcp.listFiles();
        for ( int i = 0; i < dirs.length; i++ ) {
            if ( dirs[i].isDirectory() ) {
                File classfiles[] = dirs[i].listFiles( new FilenameFilter() {
                    public boolean accept ( File dir, String name ) {
                        return name.endsWith( ".class" );
                    }
                });
                for ( int j = 0; j < classfiles.length; j++ ) entries.add( classfiles[j].getAbsolutePath() );
            }
        }
        return ( entries );
    }
    
    static void processEntries( ArrayList entries ) {
        // Sort the entries (by class name)
        Collections.sort(entries);

        // Process the entries
        for (int i=0; i< entries.size(); i++) {
            String zipname = (String)entries.get(i);
            if ( ! zipname.endsWith( ".class" ) )
                continue;
            int pathoffset = zipname.indexOf( "org/dhs/chrislee/manetbuilder/" );
            if ( pathoffset == -1 )
                continue;
            if ( zipname.substring( pathoffset + "org/dhs/chrislee/manetbuilder/".length() ).indexOf( "/" ) == -1 )
                continue;
            zipname = zipname.substring( pathoffset );
            String className = zipname.replace('/', '.').substring(0, zipname.length() - 6);	// 6 for ".class"
            //System.out.println("Trying to match: "+className);
            try {
                Class c = Class.forName(className);
                if ( ( c.getModifiers() & Modifier.ABSTRACT ) != 0 )
                    continue;
                if ( org.dhs.chrislee.manetbuilder.mobility.Mobility.class.isAssignableFrom( c ) )
                    mobilities.put( ((org.dhs.chrislee.manetbuilder.mobility.Mobility)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.application.Application.class.isAssignableFrom( c ) )
                    applications.put( ((org.dhs.chrislee.manetbuilder.application.Application)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.channel.ChannelModel.class.isAssignableFrom( c ) )
                    channelmodels.put( ((org.dhs.chrislee.manetbuilder.channel.ChannelModel)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.fileformat.FileFormat.class.isAssignableFrom( c ) )
                    fileformats.put( ((org.dhs.chrislee.manetbuilder.fileformat.FileFormat)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.mac.MacLayer.class.isAssignableFrom( c ) )
                    maclayers.put( ((org.dhs.chrislee.manetbuilder.mac.MacLayer)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.physical.PhysicalLayer.class.isAssignableFrom( c ) )
                    physicallayers.put( ((org.dhs.chrislee.manetbuilder.physical.PhysicalLayer)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.power.PowerModel.class.isAssignableFrom( c ) )
                    powermodels.put( ((org.dhs.chrislee.manetbuilder.power.PowerModel)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.routing.RoutingLayer.class.isAssignableFrom( c ) )
                    routinglayers.put( ((org.dhs.chrislee.manetbuilder.routing.RoutingLayer)c.newInstance()).getName(), c );
                else if ( org.dhs.chrislee.manetbuilder.transport.TransportLayer.class.isAssignableFrom( c ) )
                    transportlayers.put( ((org.dhs.chrislee.manetbuilder.transport.TransportLayer)c.newInstance()).getName(), c );
            } catch (ClassNotFoundException e) {
                System.err.println("Error: Class " + className + " not found!");
            } catch (Exception e) {
                System.err.println(e);
            }
        }        
    }

}
