package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Layer implements JsWrapper {
    private final JavaScriptObject jsLayer;
    
    public Layer(JavaScriptObject jsLayer) {
        this.jsLayer = jsLayer;
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsLayer;
    }
    
    public void redraw() {
        _redraw(this.jsLayer);
    }
    
    public void setIsBaseLayer(boolean isBaseLayer) {
        _setIsBaseLayer(this.jsLayer, isBaseLayer);
    }

    public boolean isBaseLayer() {
        return _isBaseLayer(this.jsLayer);
    }

    public String getId() {
        return _getId(this.jsLayer);
    }

    public void setOpacity(JavaScriptObject layer, float opacity) {
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
