package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class MarkerListener implements JsWrapper {
    private final JavaScriptObject jsFunction;
    
    public MarkerListener() {
        this.jsFunction = _newInstance(this);
    }
    
    public abstract void handleClickEvent();
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsFunction;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(MarkerListener markerListener) /*-{
        clickCallback = function(evt) {
            markerListener.@org.krayne.gollum.client.map.openlayers.MarkerListener::handleClickEvent()();
        }
        return clickCallback;
    }-*/;
}
