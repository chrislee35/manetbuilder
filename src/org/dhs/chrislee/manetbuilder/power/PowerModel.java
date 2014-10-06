/*
 * PowerModel.java
 *
 * Created on August 26, 2004, 8:45 PM
 */

package org.dhs.chrislee.manetbuilder.power;

/**
 *
 * @author  chris
 */
public abstract class PowerModel implements java.io.Serializable {
    
    /** Creates a new instance of PowerModel */
    public PowerModel() {
    }
    
    public abstract String getName();
    public abstract boolean getIsDead();
    public abstract double getPowerLevel();
    public abstract void idle( double duration );
    public abstract void sleep( double duration );
    public abstract void transmit( double duration );
    public abstract void process( double duration );
    public abstract void listen( double duration );
    public abstract void receive( double duration );
    public abstract void move( double speed, double duration );
}
