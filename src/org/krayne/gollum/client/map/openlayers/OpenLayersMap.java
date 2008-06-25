package org.krayne.gollum.client.map.openlayers;

import java.util.ArrayList;
import java.util.List;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.jsni.JsWrapper;
import org.krayne.gollum.client.map.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class OpenLayersMap implements Map, JsWrapper {
    private static final int DEFAULT_NUM_ZOOM_LEVELS = 20;
    private final JavaScriptObject jsMap;
    private final List<Control> controls;
    private final List<DrawControl> drawControls;
    private final boolean isSphericalMercator;
    
    public OpenLayersMap(Element domElement, boolean isSphericalMercator) {
        this(domElement, DEFAULT_NUM_ZOOM_LEVELS, isSphericalMercator);
    }
    
    public OpenLayersMap(Element domElement, int numZoomLevels, boolean isSphericalMercator) {
        this.jsMap = _newInstance(domElement, numZoomLevels, isSphericalMercator);
        this.controls = new ArrayList<Control>();
        this.drawControls = new ArrayList<DrawControl>();
        this.isSphericalMercator = isSphericalMercator;
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsMap;
    }

    public void jumpTo(Bookmark bookmark) {
        double latDegrees = bookmark.getLocation().getLatDegrees();
        double lonDegrees = bookmark.getLocation().getLonDegrees();
        LonLat lonLat = new LonLat(lonDegrees, latDegrees);
        LonLat projectedLonLat = ProjectionUtil.mapToModel(lonLat, this.isSphericalMercator);
        if(bookmark.getZoomLevel() != null) {
            int newZoomLevel = bookmark.getZoomLevel().intValue();
            this.setZoomLevel(newZoomLevel);
        }
        _panTo(this.jsMap, projectedLonLat.getJavaScriptObject());
        
        // this hack is for certain browsers (apparent in firefox 3 rc1)
        // if you jump to a far away area on the map using map's panTo,
        // vector layers won't show up unless you do some zooming change.
        // TODO: find out the real cause
        int currentZoomLevel = this.getZoomLevel();
        this.setZoomLevel(currentZoomLevel + 1);
        this.setZoomLevel(currentZoomLevel);
    }
    
    public void addControl(Control control) {
        _addControl(this.jsMap, control.getJavaScriptObject());
        this.controls.add(control);
        if(control instanceof DrawControl) {
            this.drawControls.add((DrawControl) control);
        }
    }

    public void deactivateDrawControls() {
        for(DrawControl control : this.drawControls) {
            control.setActivated(false);
        }
    }
    
    public void addLayer(Layer layer) {
        _addLayer(this.jsMap, layer.getJavaScriptObject());
    }
    
    public void removeLayer(Layer layer) {
        _removeLayer(this.jsMap, layer.getJavaScriptObject());
    }
    
    public void setLayerIndex(Layer layer, int index) {
        _setLayerIndex(this.jsMap, layer.getJavaScriptObject(), index);
    }
    
    public void redraw() {
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
    
    public boolean isSphericalMercator() {
        return this.isSphericalMercator;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(Element mapDomElement, int totalNumZoomLevels, boolean isSphericalMercator) /*-{
        // projection, displayProjection, units, maxRes and maxExtent allow
        // layers like Google, Yahoo, Virtual Earth, etc. to be projected correctly
        var mapOptions;
        if(isSphericalMercator) {
            mapOptions = {
                numZoomLevels: totalNumZoomLevels,
                controls: [],
                projection: new $wnd.OpenLayers.Projection("EPSG:900913"),
                displayProjection: new $wnd.OpenLayers.Projection("EPSG:4326"),
                units: "m",
                maxResolution: 156543.0339,
                maxExtent: new $wnd.OpenLayers.Bounds(-20037508.34, -20037508.34, 20037508.34, 20037508.34)
            };
        } else {
            mapOptions = {
                numZoomLevels: totalNumZoomLevels,
                controls: []
            };
        }

        return new $wnd.OpenLayers.Map(mapDomElement, mapOptions);
    }-*/;
    
    private static native void _addControl(JavaScriptObject map, JavaScriptObject control) /*-{
        map.addControl(control);
    }-*/;
    
    private static native void _addLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
        map.addLayer(layer);
    }-*/;
    
    private static native void _removeLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
        map.removeLayer(layer);
    }-*/;
    
    private static native void _setLayerIndex(JavaScriptObject map, JavaScriptObject layer, int index) /*-{
        map.setLayerIndex(layer, index);
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
