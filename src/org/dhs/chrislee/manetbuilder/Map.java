/*
 * Map.java
 *
 * Created on October 2, 2004, 4:25 PM
 */

package org.dhs.chrislee.manetbuilder;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author  chris
 */
public class Map implements java.io.Serializable {
    java.awt.Dimension mapSize;
    java.util.ArrayList nodes;
    double simtime;
    transient Image backgroundImage;
    String imageFilename;
    int currentlySelectedNode = -1;
    
    /** Creates a new instance of Map */
    public Map() {
        this( 1000.0, 1000.0, 600.0 );
    }
    
    public Map( double height, double width, double simtime ) {
        this( height, width, simtime, (Image)null, (String)null );
    }

    public Map( double height, double width, double simtime, Image background, String imageFilename ) {
        nodes = new java.util.ArrayList();
        mapSize = new Dimension( (int)width, (int)height );
        this.simtime = simtime;
        backgroundImage = background;
        this.imageFilename = imageFilename;
    }
    
    public java.awt.Dimension getPreferredSize() {
        return mapSize;
    }
    
    public java.awt.Dimension getMapSize() {
        return mapSize;
    }

    public void addNode( Node node ) {
        nodes.add( node );
        currentlySelectedNode = nodes.size();
    }

    public void addTimedPoint( double x, double y, double time ) {
        if ( currentlySelectedNode == -1 ) 
            return;
        if ( ((Node)nodes.get( currentlySelectedNode - 1 )).mobility == null )
            return;
        if ( ! ((Node)nodes.get( currentlySelectedNode - 1 )).mobility.isPlottable() )
            return;
        ((Node)nodes.get( currentlySelectedNode - 1 )).mobility.addTimedPoint( x, y, time );
     }

    public void setNodes( Node[] newnodes ) {
        nodes.clear();
        for ( int i = 0; i < newnodes.length; i++ )
            nodes.add( newnodes[i] );
    }
    
    public Node getNode( int nodeId ) {
        return (Node) nodes.get( nodeId - 1 );
    }
    
    public java.util.ArrayList getNodes() {
           return nodes;
    }

    public void setSimtime( double simtime ) {
        if ( simtime > this.simtime )
            this.simtime = simtime;
    }
    
    public String getImageFilename() {
        return ( imageFilename );
    }
    
    public Image getBackgroundImage() {
        return ( backgroundImage );
    }

    public void reset() {
        nodes.clear();
        currentlySelectedNode = -1;
    }
    public boolean isPointNearNode( double x, double y, double time ) {
        // this counts down since the user usually clicks towards the last few
        // nodes
        for ( int i = nodes.size() - 1; i >= 0; i-- )
            if ( nodes.get(i) == null ) continue; else {
                java.awt.geom.Point2D.Double loc = ((Node)nodes.get( i )).getCurrentLocation( time );
                if ( Math.abs( loc.getX() - x ) < 13 
                    && Math.abs( loc.getY() - y ) < 13 )
                    return true;
            }
        return false;
    }
    
    public Node getNodeNearestPoint( double x, double y, double time ) {
        double bestDist = 0.0;
        int bestNode = 0;
        java.awt.geom.Point2D.Double loc = ((Node)nodes.get( 0 )).getCurrentLocation( time );
        bestDist = Math.pow( loc.getX() - x, 2 ) + Math.pow( loc.getY() - y, 2 );      
        for ( int i = 1; i < nodes.size(); i++ ) {
            if ( nodes.get(i) == null ) continue;
            loc = ((Node)nodes.get( i )).getCurrentLocation( time );
            double thisDist = Math.pow( loc.getX() - x, 2 ) + Math.pow( loc.getY() - y, 2 );
            if ( thisDist < bestDist ) {
                bestNode = i;
                bestDist = thisDist;
            }
        }
                
        return ( (Node) nodes.get( bestNode ) );
    }
    
    public void selectNode( int nodeId ) {
        if ( nodeId <= nodes.size() )
            currentlySelectedNode = nodeId;
    }

    public int countNodes() {
        return ( nodes.size() );
    }

    public void deleteNode( int nodeId ) {
        if ( nodeId < nodes.size() && nodeId > 0 )
            nodes.set( nodeId - 1, null );
    }

    public double getSimtime() {
        return ( simtime );
    }
    
    public int getSelectedId() {
        return ( currentlySelectedNode );
    }
    
    public void setBackgroundImage( java.awt.Image background ) {
        backgroundImage = background;
    }
}
