package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A base class for all OpenLayers layers.
 * 
 * @author dhsu
 */
public abstract class Layer implements JsWrapper {
    private final JavaScriptObject jsLayer;
    
    /**
     * Constructs a {@code Layer} with the specified OpenLayers layer object.
     * 
     * @param jsLayer an OpenLayers layer object
     */
    public Layer(JavaScriptObject jsLayer) {
        this.jsLayer = jsLayer;
    }

    /**
     * {@inheritDoc}
     */
    public JavaScriptObject getJavaScriptObject() {
        return this.jsLayer;
    }
    
    /**
     * Redraws the layer.
     */
    public void redraw() {
        _redraw(this.jsLayer);
    }
    
    /**
     * Sets whether or not this layer is a base layer.
     * 
     * @param isBaseLayer whether or not this is a base layer
     */
    public void setIsBaseLayer(boolean isBaseLayer) {
        _setIsBaseLayer(this.jsLayer, isBaseLayer);
    }

    /**
     * Gets whether or not this is a base layer.
     * 
     * @return true if this layer is a base layer, false otherwise
     */
    public boolean isBaseLayer() {
        return _isBaseLayer(this.jsLayer);
    }

    /**
     * Gets the ID of this layer.
     * 
     * @return the layer id
     */
    public String getId() {
        return _getId(this.jsLayer);
    }

    /**
     * Sets the opacity of this layer, value should be in [0.0, 1.0].
     * 
     * @param opacity the opacity
     */
    public void setOpacity(float opacity) {
        _setOpacity(this.jsLayer, opacity);
    }

    //--------------------------------------------------------------------------
    
    private static native void _redraw(JavaScriptObject layer) /*-{
        layer.redraw();
    }-*/;
    
    private static native void _setIsBaseLayer(JavaScriptObject layer, boolean isBaseLayer) /*-{
        layer.setIsBaseLayer(isBaseLayer);
    }-*/;
    
    private static native boolean _isBaseLayer(JavaScriptObject layer) /*-{
        return layer.isBaseLayer;
    }-*/;
    
    private static native String _getId(JavaScriptObject layer) /*-{
        return layer.id;
    }-*/;
    
    private static native void _setOpacity(JavaScriptObject layer, float opacity) /*-{
        layer.setOpacity(opacity);
    }-*/;
}
