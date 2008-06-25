package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author dhsu
 */
public class Icon implements JsWrapper {
    private final JavaScriptObject jsIcon;
    
    public Icon(String url, int width, int height, boolean useMiddleOffset) {
        this(url, width, height, useMiddleOffset? -width/2 : 0, useMiddleOffset? -height/2 : 0);
    }
    
    public Icon(String url, int width, int height, int xOffset, int yOffset) {
        this.jsIcon = _newInstance(url, width, height, xOffset, yOffset);
    }

    public JavaScriptObject getJavaScriptObject() {
        return this.jsIcon;
    }

    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(String url, int width, int height, int xOffset, int yOffset) /*-{
        var size = new $wnd.OpenLayers.Size(width, height);
        var offset = new $wnd.OpenLayers.Pixel(xOffset, yOffset);
        return new $wnd.OpenLayers.Icon(url, size, offset);
    }-*/;
}
