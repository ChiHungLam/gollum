package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An OpenLayers {@code Control} that we can access in Java. A control is
 * something attached to a map that can manipulate the map or layers on the
 * map.
 * 
 * @author dhsu
 */
public class Control implements JsWrapper {
    private final JavaScriptObject jsControl;
    
    /**
     * Constructs a {@code Control} using the specified JavaScriptObject,
     * which must be an OpenLayers Control object.
     * 
     * @param jsControl an OpenLayers Control object
     */
    public Control(JavaScriptObject jsControl) {
        this.jsControl = jsControl;
    }
    
    /**
     * {@inheritDoc}
     */
    public JavaScriptObject getJavaScriptObject() {
        return this.jsControl;
    }
    
    /**
     * Activates or deactivates the control.
     * 
     * @param activated true to activate the control, false to deactivate
     */
    public void setActivated(boolean activated) {
        _setActivated(this.getJavaScriptObject(), activated);
    }
    
    //--------------------------------------------------------------------------

    private static native void _setActivated(JavaScriptObject control, boolean activated) /*-{
        if(activated) {
            control.activate();
        } else {
            control.deactivate();
        }
    }-*/;
}
