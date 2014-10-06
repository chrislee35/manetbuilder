/*
 * TimePointComparator.java
 *
 * Created on 2004/10/15, 23:32
 */

package org.dhs.chrislee.manetbuilder.mobility;

/**
 *
 * @author  chris
 */
public class TimedPointComparator implements java.util.Comparator, java.io.Serializable {
    
    /** Creates a new instance of TimePointComparator */
    public TimedPointComparator() {
    }
    
    public int compare( Object one, Object two ) {
        if ( ((TimedPoint)two).getTime() == ((TimedPoint)one).getTime() )
            return 0;
        if ( ((TimedPoint)two).getTime() > ((TimedPoint)one).getTime() )
            return -1;
        return 1;
    }
}
