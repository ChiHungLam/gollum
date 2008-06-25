package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An OpenLayers lon lat object that we can access in Java.
 * 
 * @author dhsu
 */
public class LonLat implements JsWrapper {
    private JavaScriptObject jsLonLat;
    
    /**
     * Constructs a {@code LonLat} with the specified longitude and latitude
     * 
     * @param lonDegrees the longitude
     * @param latDegrees the latitude
     */
    public LonLat(double lonDegrees, double latDegrees) {
        this.jsLonLat = _newInstance(lonDegrees, latDegrees);
    }
    
    /**
     * Constructs a {@code LonLat} with the specified OpenLayers lonlat object.
     * 
     * @param jsLonLat an OpenLayers lonlat object
     */
    public LonLat(JavaScriptObject jsLonLat) {
        this.jsLonLat = jsLonLat;
    }
    
    /**
     * {@inheritDoc}
     */
    public JavaScriptObject getJavaScriptObject() {
        return this.jsLonLat;
    }
    
    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public double getLatDegrees() {
        return _lat(this.jsLonLat);
    }
    
    /**
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public double getLonDegrees() {
        return _lon(this.jsLonLat);
    }

    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(double lonDegrees, double latDegrees) /*-{
        return new $wnd.OpenLayers.LonLat(lonDegrees, latDegrees);
    }-*/;
    
    private static native double _lon(JavaScriptObject lonLat) /*-{
        return lonLat.lon;
    }-*/;
    
    private static native double _lat(JavaScriptObject lonLat) /*-{
        return lonLat.lat;
    }-*/;
}
