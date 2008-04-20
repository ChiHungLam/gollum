package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

public class LonLat implements JsWrapper {
    private JavaScriptObject jsLonLat;
    
    public LonLat(double lonDegrees, double latDegrees) {
        this.jsLonLat = _newInstance(lonDegrees, latDegrees);
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsLonLat;
    }
    
    public double getLatDegrees() {
        return _lat(this.jsLonLat);
    }
    
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
