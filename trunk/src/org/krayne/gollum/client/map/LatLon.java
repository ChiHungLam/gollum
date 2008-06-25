package org.krayne.gollum.client.map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A simple latitude/longitude class.
 * 
 * @author dhsu
 */
public class LatLon implements IsSerializable {
    private static final long serialVersionUID = 5895968482016927973L;
    private double latDegrees;
    private double lonDegrees;

    public LatLon() {
    }
    
    /**
     * Constructs a {@code LatLon}.
     * 
     * @param latDegrees the latitude in degrees
     * @param lonDegrees the longitude in degrees
     */
    public LatLon(double latDegrees, double lonDegrees){
        this.latDegrees = latDegrees;
        this.lonDegrees = lonDegrees;
    }

    /**
     * Gets the latitude in degrees.
     * 
     * @return the latitude in degrees
     */
    public double getLatDegrees() {
        return this.latDegrees;
    }

    /**
     * Gets the longitude in degrees.
     * 
     * @return the longitude in degrees
     */
    public double getLonDegrees() {
        return this.lonDegrees;
    }
    
    /**
     * Gets the latitude in radians.
     * 
     * @return the latitude in radians
     */
    public double getLatRadians() {
        return Math.toRadians(this.latDegrees);
    }
    
    /**
     * Gets the longitude in radians.
     * 
     * @return the longitude in radians
     */
    public double getLonRadians() {
        return Math.toRadians(this.lonDegrees);
    }
    
    /**
     * Gets whether or not this lat/lon is a valid lat/lon on the earth.
     * Checks lat bounds and lon bounds.
     * 
     * @return true if lat/lon is valid, false otherwise
     */
    public boolean isValid() {
        return (this.latDegrees >= -90.0 && this.latDegrees <= 90.0 &&
                this.lonDegrees >= -180.0 && this.lonDegrees <= 180.0);
    }
    
    /**
     * {@inheritDoc}
     */
    public String toString() {
        return this.latDegrees + ", " + this.lonDegrees;
    }
}
