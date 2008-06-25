package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;


public class MarkerLayer extends Layer {
    private final JavaScriptObject jsLayer;
    
    public MarkerLayer(String layerName) {
        super(_newInstance(layerName));
        this.jsLayer = this.getJavaScriptObject();
    }
    
    public void addMarker(Marker marker) {
        _addMarker(this.jsLayer, marker.getJavaScriptObject());
    }
    
    public void clear() {
        _clear(this.jsLayer);
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(String layerName) /*-{
        return new $wnd.OpenLayers.Layer.Markers(layerName);
    }-*/;
    
    private static native JavaScriptObject _addMarker(JavaScriptObject markerLayer, JavaScriptObject marker) /*-{
        markerLayer.addMarker(marker);
    }-*/;
    
    private static native JavaScriptObject _clear(JavaScriptObject markerLayer) /*-{
        markerLayer.clearMarkers();
    }-*/;
}
