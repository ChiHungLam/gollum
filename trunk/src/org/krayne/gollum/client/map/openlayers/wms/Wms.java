package org.krayne.gollum.client.map.openlayers.wms;

import org.krayne.gollum.client.map.openlayers.Layer;

import com.google.gwt.core.client.JavaScriptObject;

public class Wms {
    public static class BasicLayer extends Layer {
        public BasicLayer(String layerName) {
            super(_createBasicLayer(layerName));
        }
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _createBasicLayer(String layerName) /*-{
        return new $wnd.OpenLayers.Layer.WMS(layerName, "http://labs.metacarta.com/wms/vmap0?", {layers: 'basic'});
    }-*/;
}
