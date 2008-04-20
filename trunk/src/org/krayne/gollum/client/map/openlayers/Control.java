package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Control implements JsWrapper {
    private final JavaScriptObject jsControl;
    
    public Control(JavaScriptObject jsControl) {
        this.jsControl = jsControl;
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsControl;
    }
}
