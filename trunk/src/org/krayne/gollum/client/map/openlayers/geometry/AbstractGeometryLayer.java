package org.krayne.gollum.client.map.openlayers.geometry;

import java.util.ArrayList;
import java.util.Collection;

import org.krayne.gollum.client.jsni.JsWrapperFactory;
import org.krayne.gollum.client.map.openlayers.Control;
import org.krayne.gollum.client.map.openlayers.Layer;
import org.krayne.gollum.client.map.openlayers.Style;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class AbstractGeometryLayer<G extends Geometry> extends Layer implements GeometryLayer<G> {
    private static final Style DEFAULT_STYLE;
    private static final Style SELECT_STYLE;
    static {
        DEFAULT_STYLE = new Style();
        SELECT_STYLE = new Style();
        SELECT_STYLE.setFillColor("#FF5000");
        SELECT_STYLE.setStrokeColor("#FF5000");
    }
    
    private final JavaScriptObject jsLayer;
    private final JavaScriptObject jsCounter;
    private final Collection<GeometryLayerListener<G>> geometryLayerListeners;
    private final JsWrapperFactory<G> jsWrapperFactory;
    private final int maxNumFeatures;
    private Control selectControl; // lazy initialized
    
    public AbstractGeometryLayer(String layerName, JsWrapperFactory<G> jsWrapperFactory, int maxNumFeatures) {
        super(_createVectorLayer(layerName, DEFAULT_STYLE.getJavaScriptObject(), SELECT_STYLE.getJavaScriptObject()));
        this.geometryLayerListeners = new ArrayList<GeometryLayerListener<G>>();
        this.jsWrapperFactory = jsWrapperFactory;
        this.maxNumFeatures = maxNumFeatures;
        this.jsLayer = this.getJavaScriptObject();
        this.selectControl = null;
        this.jsCounter = _newCounter();
        _initFeatureAddedCallback(this, this.jsLayer, this.jsCounter, this.maxNumFeatures);
    }

    public Control getSelectControl() {
        if(this.selectControl == null) {
            this.selectControl = new Control(_createSelectControl(this, this.jsLayer));
        }
        return this.selectControl;
    }
    
    public void addLayerListener(GeometryLayerListener<G> listener) {
        if(!this.geometryLayerListeners.contains(listener)) {
            this.geometryLayerListeners.add(listener);
        }
    }

    public void removeLayerListener(GeometryLayerListener<G> listener) {
        this.geometryLayerListeners.remove(listener);
    }
    
    public void add(G geometry) {
        this.add(geometry, null);
    }

    public void add(G geometry, Style style) {
        if(style == null) {
            _addGeometry(this.getJavaScriptObject(), geometry.getJavaScriptObject());
        } else {
            _addGeometry(this.getJavaScriptObject(), geometry.getJavaScriptObject(), style.getJavaScriptObject());
        }
    }

    public void setDefaultStyle(Style style) {
        _setDefaultStyle(this.jsLayer, style.getJavaScriptObject());
    }
    
    public void setSelectStyle(Style style) {
        _setSelectStyle(this.jsLayer, style.getJavaScriptObject());
    }
    
    public void clear() {
        _destroyFeatures(this, this.jsLayer);
    }
    
    public int getCount() {
        return _getFeatureCount(this.jsLayer);
    }
    
    public G getGeometry(int index) {
        int count = this.getCount();
        if(index >= 0 && index < count) {
            return this.jsWrapperFactory.wrap(_getGeometry(this.jsLayer, index));
        }
        return null;
    }
    
    public G getLastGeometry() {
        int count = this.getCount();
        if(count > 0) {
            return this.jsWrapperFactory.wrap(_getGeometry(this.jsLayer, count-1));
        }
        return null;
    }
    
    /**
     * Notifies listeners of a feature being added to this layer.
     * 
     * @param featureIndex the feature index
     * @param jsGeometry the javascript geometry object
     */
    protected void fireFeatureAddedEvent(int featureIndex, JavaScriptObject jsGeometry) {
        G geometry = this.jsWrapperFactory.wrap(jsGeometry);
        for(GeometryLayerListener<G> listener : this.geometryLayerListeners) {
            listener.handleAddEvent(featureIndex, geometry);
        }
    }
    
    /** 
     * Notifies listeners of a feature being selected on this layer.
     * 
     * @param featureIndex the feature index
     * @param jsGeometry the javascript geometry object
     */
    protected void fireFeatureSelectedEvent(int featureIndex, JavaScriptObject jsGeometry) {
        G geometry = this.jsWrapperFactory.wrap(jsGeometry);
        for(GeometryLayerListener<G> listener : this.geometryLayerListeners) {
            listener.handleSelectEvent(featureIndex, geometry);
        }
    }
    
    /**
     * Notifies listeners of a feature being unselected on this layer.
     * 
     * @param featureIndex the feature index
     * @param jsGeometry the javascript geometry object
     */
    protected void fireFeatureUnselectedEvent(int featureIndex, JavaScriptObject jsGeometry) {
        G geometry = this.jsWrapperFactory.wrap(jsGeometry);
        for(GeometryLayerListener<G> listener : this.geometryLayerListeners) {
            listener.handleUnselectEvent(featureIndex, geometry);
        }
    }
    
    /**
     * Notifies listeners that all features were removed from the layer.
     */
    protected void fireClearEvent() {
        for(GeometryLayerListener<G> listener : this.geometryLayerListeners) {
            listener.handleClearEvent();
        }
    }

    //--------------------------------------------------------------------------
    
    /**
     * Creates a javascript vector layer.
     * 
     * @param layerName the name of the layer
     * @param defaultStyle the default style for the elements on this layer
     * @param selectStyle the style for selected elements on this layer
     */
    private static native JavaScriptObject _createVectorLayer(String layerName, JavaScriptObject defaultStyle, JavaScriptObject selectStyle) /*-{
        //stylemap for features
        var layerStyleMap = new $wnd.OpenLayers.StyleMap({
            'default': defaultStyle,
            'select': selectStyle
        });
        
        var layer = new $wnd.OpenLayers.Layer.Vector(layerName);

        // configure layer options
        var layerOptions = {
            styleMap: layerStyleMap
        };
        layer.addOptions(layerOptions);
        return layer;
    }-*/;
    
    /**
     * Initializes the feature added event handler.
     * 
     * @param geometryLayer the geometry layer to call back to
     * @param layer the javascript version of the geometry layer
     */
    private static native void _initFeatureAddedCallback(AbstractGeometryLayer geometryLayer, JavaScriptObject layer, JavaScriptObject counter, int maxNumFeatures) /*-{
        featureAddedCallback = function(feature) {
            if(layer.features.length > maxNumFeatures) {
                var featureToRemove = layer.features[0];
                layer.removeFeatures(featureToRemove);
            }
        
            var featureIndex = counter.count;
            counter.count = counter.count + 1;
            var geometry = feature.geometry

            // store the feature index in the feature so that we can get it again
            // later to reference the exact geometry.
            feature.attributes["index"] = featureIndex;

            geometryLayer.@org.krayne.gollum.client.map.openlayers.geometry.AbstractGeometryLayer::fireFeatureAddedEvent(ILcom/google/gwt/core/client/JavaScriptObject;)(featureIndex, geometry);
        }
        
        layer.onFeatureInsert = featureAddedCallback;
    }-*/;
    
    private static native JavaScriptObject _createSelectControl(AbstractGeometryLayer geometryLayer, JavaScriptObject layer) /*-{
        onFeatureSelect = function(feature) {
            var featureIndex = feature.attributes["index"];
            var geometry = feature.geometry
            geometryLayer.@org.krayne.gollum.client.map.openlayers.geometry.AbstractGeometryLayer::fireFeatureSelectedEvent(ILcom/google/gwt/core/client/JavaScriptObject;)(featureIndex, geometry);
        }
        
        onFeatureUnselect = function(feature) {
            var featureIndex = feature.attributes["index"];
            var geometry = feature.geometry
            geometryLayer.@org.krayne.gollum.client.map.openlayers.geometry.AbstractGeometryLayer::fireFeatureUnselectedEvent(ILcom/google/gwt/core/client/JavaScriptObject;)(featureIndex, geometry);
        }
        
        var control = new $wnd.OpenLayers.Control.SelectFeature(layer);
        control.onSelect = onFeatureSelect;
        control.onUnseleft = onFeatureUnselect;
        return control;
    }-*/;
    
    private static native void _addGeometry(JavaScriptObject layer, JavaScriptObject geometry) /*-{
        var feature = new $wnd.OpenLayers.Feature.Vector(geometry);
        layer.addFeatures(feature);
    }-*/;
    
    private static native void _addGeometry(JavaScriptObject layer, JavaScriptObject geometry, JavaScriptObject style) /*-{
        var feature = new $wnd.OpenLayers.Feature.Vector(geometry, null, style);
        layer.addFeatures(feature);
    }-*/;
    
    private static native void _setDefaultStyle(JavaScriptObject vectorLayer, JavaScriptObject style) /*-{
        vectorLayer.styleMap.styles["default"] = new $wnd.OpenLayers.Style(style);
    }-*/;
    
    private static native void _setSelectStyle(JavaScriptObject vectorLayer, JavaScriptObject style) /*-{
        vectorLayer.styleMap.styles["select"] = new $wnd.OpenLayers.Style(style);
    }-*/;
    
    private static native void _destroyFeatures(AbstractGeometryLayer geometryLayer, JavaScriptObject vectorLayer) /*-{
        vectorLayer.destroyFeatures();
        geometryLayer.@org.krayne.gollum.client.map.openlayers.geometry.AbstractGeometryLayer::fireClearEvent()();
    }-*/;
    
    private static native int _getFeatureCount(JavaScriptObject vectorLayer) /*-{
        return vectorLayer.features.length;
    }-*/;
    
    private static native JavaScriptObject _getGeometry(JavaScriptObject vectorLayer, int index) /*-{
        return vectorLayer.features[index].geometry;
    }-*/;
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newCounter() /*-{
        return {count: 0};
    }-*/;
}
