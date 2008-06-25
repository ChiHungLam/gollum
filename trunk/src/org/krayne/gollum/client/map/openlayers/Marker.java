package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author dhsu
 */
public class Marker implements JsWrapper {
    private final JavaScriptObject jsMarker;

    public Marker(LonLat lonLat, Icon icon) {
        this.jsMarker = _newInstance(lonLat.getJavaScriptObject(), icon.getJavaScriptObject());
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsMarker;
    }
    
    public void destroy() {
        _destroy(this.jsMarker);
    }
    
    public void addMarkerListener(MarkerListener listener) {
        _addClickListener(this.jsMarker, listener.getJavaScriptObject());
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(JavaScriptObject lonLat, JavaScriptObject icon) /*-{
        return new $wnd.OpenLayers.Marker(lonLat, icon);
    }-*/;
    
    private static native JavaScriptObject _destroy(JavaScriptObject marker) /*-{
        marker.destroy();
    }-*/;
    
    private static native void _addClickListener(JavaScriptObject marker, JavaScriptObject clickCallback) /*-{
        marker.events.register('mousedown', marker, clickCallback);
    }-*/;
}
