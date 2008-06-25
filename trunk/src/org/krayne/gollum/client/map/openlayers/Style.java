package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

public class Style implements JsWrapper {
    private static final String FILL_COLOR_KEY = "fillColor";
    private static final String FILL_OPACITY_KEY = "fillOpacity";
    private static final String STROKE_COLOR_KEY = "strokeColor";
    private static final String STROKE_OPACITY_KEY = "strokeOpacity";
    private static final String STROKE_WIDTH_KEY = "strokeWidth";
    private static final String POINT_RADIUS_KEY = "pointRadius";
    
    private final JavaScriptObject jsStyleMap;
    
    public Style() {
        this.jsStyleMap = _newInstance();
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsStyleMap;
    }
    
    public void setFillColor(String color) {
        _setStyleProperty(this.jsStyleMap, FILL_COLOR_KEY, color);
    }
    
    public void setFillOpacity(double opacity) {
        _setStyleProperty(this.jsStyleMap, FILL_OPACITY_KEY, opacity);
    }
    
    public void setStrokeColor(String color) {
        _setStyleProperty(this.jsStyleMap, STROKE_COLOR_KEY, color);
    }
    
    public void setStrokeOpacity(double opacity) {
        _setStyleProperty(this.jsStyleMap, STROKE_OPACITY_KEY, opacity);
    }
    
    public void setStrokeWidth(int width) {
        _setStyleProperty(this.jsStyleMap, STROKE_WIDTH_KEY, width);
    }
    
    public void setPointRadius(int radius) {
        _setStyleProperty(this.jsStyleMap, POINT_RADIUS_KEY, radius);
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance() /*-{
        var style = new Array();
        style["fillColor"] = "#FFC300";
        style["fillOpacity"] = 1;
        style["strokeColor"] = "#FF5000";
        style["strokeOpacity"] = 1;
        style["strokeWidth"] = 1;
        style["strokeLinecap"] = "round";
        style["pointRadius"] = 3;
        style["hoverStrokeWidth"] = 3;
        return style;
    }-*/;
    
    private static native void _setStyleProperty(JavaScriptObject style, String property, String value) /*-{
        style[property] = value;
    }-*/;
    
    private static native void _setStyleProperty(JavaScriptObject style, String property, double value) /*-{
        style[property] = value;
    }-*/;
}
