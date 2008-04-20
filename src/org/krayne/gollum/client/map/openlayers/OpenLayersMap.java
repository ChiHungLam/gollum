package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.jsni.JsWrapper;
import org.krayne.gollum.client.map.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class OpenLayersMap implements Map, JsWrapper {
    private static final int DEFAULT_NUM_ZOOM_LEVELS = 20;
    private final JavaScriptObject jsMap;
    
    public OpenLayersMap(Element domElement) {
        this(domElement, DEFAULT_NUM_ZOOM_LEVELS);
    }
    
    public OpenLayersMap(Element domElement, int numZoomLevels) {
        this.jsMap = _newInstance(domElement, numZoomLevels);
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsMap;
    }

    public void jumpTo(Bookmark bookmark) {
        double latDegrees = bookmark.getLocation().getLatDegrees();
        double lonDegrees = bookmark.getLocation().getLonDegrees();
        LonLat lonLat = new LonLat(lonDegrees, latDegrees);
        if(bookmark.getZoomLevel() != null) {
            int newZoomLevel = bookmark.getZoomLevel().intValue();
            this.setZoomLevel(newZoomLevel);
        }
        _panTo(this.jsMap, lonLat.getJavaScriptObject());
    }
    
    public void addControl(Control control) {
        _addControl(this.jsMap, control.getJavaScriptObject());
    }
    
    public void addLayer(Layer layer) {
        _addLayer(this.jsMap, layer.getJavaScriptObject());
    }
    
    public void updateSize() {
        _updateSize(this.jsMap);
    }

    public void setZoomLevel(int zoomLevel) {
        zoomLevel = (zoomLevel >= this.getNumZoomLevels()) ? this.getNumZoomLevels()-1 : zoomLevel;
        _zoomTo(this.jsMap, zoomLevel);
    }
    
    public int getNumZoomLevels() {
        return _getNumZoomLevels(this.jsMap);
    }

    public int getZoomLevel() {
        return _getZoom(this.jsMap);
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(Element mapDomElement, int totalNumZoomLevels) /*-{
        return new $wnd.OpenLayers.Map(mapDomElement, { numZoomLevels: totalNumZoomLevels, controls: [] });
    }-*/;
    
    private static native void _addControl(JavaScriptObject map, JavaScriptObject control) /*-{
        map.addControl(control);
    }-*/;
    
    private static native void _addLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
        map.addLayer(layer);
    }-*/;
    
    private static native void _panTo(JavaScriptObject map, JavaScriptObject lonLat) /*-{
        map.panTo(lonLat);
    }-*/;
    
    private static native void _updateSize(JavaScriptObject map) /*-{
        map.updateSize();
    }-*/;
    
    private static native void _zoomTo(JavaScriptObject map, int zoomLevel) /*-{
        map.zoomTo(zoomLevel);
    }-*/;
    
    private static native int _getNumZoomLevels(JavaScriptObject map) /*-{
        return map.getNumZoomLevels();
    }-*/;
    
    private static native int _getZoom(JavaScriptObject map) /*-{
        return map.getZoom();
    }-*/;
}
