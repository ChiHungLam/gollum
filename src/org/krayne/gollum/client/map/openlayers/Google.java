package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

public class Google {

    public static class SatelliteLayer extends Layer {
        public SatelliteLayer(String layerName) {
            super(_createSatelliteLayer(layerName));
        }
    }
    
    public static class HybridLayer extends Layer {
        public HybridLayer(String layerName) {
            super(_createHybridLayer(layerName));
        }
    }
    
    public static class NormalLayer extends Layer {
        public NormalLayer(String layerName) {
            super(_createNormalLayer(layerName));
        }
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _createSatelliteLayer(String layerName) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_SATELLITE_MAP});
    }-*/;

    private static native JavaScriptObject _createHybridLayer(String layerName) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_HYBRID_MAP});
    }-*/;
    
    private static native JavaScriptObject _createNormalLayer(String layerName) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_NORMAL_MAP});
    }-*/;
}
