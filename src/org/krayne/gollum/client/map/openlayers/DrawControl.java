package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An abstract base class that should be used for all draw controls.
 * 
 * @author dhsu
 */
public abstract class DrawControl extends Control {

    /**
     * Constructs a {@code DrawControl} using the specified OpenLayers
     * draw control object.
     * 
     * @param jsControl an OpenLayers draw contorl object
     */
    public DrawControl(JavaScriptObject jsControl) {
        super(jsControl);
    }

}
