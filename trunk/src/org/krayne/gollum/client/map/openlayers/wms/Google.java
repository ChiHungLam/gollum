package org.krayne.gollum.client.map.openlayers.wms;

import org.krayne.gollum.client.map.openlayers.Layer;

import com.google.gwt.core.client.JavaScriptObject;

public class Google {

    public static class SatelliteLayer extends Layer {
        public SatelliteLayer(String layerName, boolean isSphericalMercator) {
            super(_createSatelliteLayer(layerName, isSphericalMercator));
        }
    }
    
    public static class HybridLayer extends Layer {
        public HybridLayer(String layerName, boolean isSphericalMercator) {
            super(_createHybridLayer(layerName, isSphericalMercator));
        }
    }
    
    public static class NormalLayer extends Layer {
        public NormalLayer(String layerName, boolean isSphericalMercator) {
            super(_createNormalLayer(layerName, isSphericalMercator));
        }
    }
    
    public static class PhysicalLayer extends Layer {
        public PhysicalLayer(String layerName, boolean isSphericalMercator) {
            super(_createPhysicalLayer(layerName, isSphericalMercator));
        }
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _createSatelliteLayer(String layerName, boolean isSphericalMercator) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_SATELLITE_MAP, sphericalMercator: isSphericalMercator});
    }-*/;

    private static native JavaScriptObject _createHybridLayer(String layerName, boolean isSphericalMercator) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_HYBRID_MAP, sphericalMercator: isSphericalMercator});
    }-*/;
    
    private static native JavaScriptObject _createNormalLayer(String layerName, boolean isSphericalMercator) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_NORMAL_MAP, sphericalMercator: isSphericalMercator});
    }-*/;
    
    private static native JavaScriptObject _createPhysicalLayer(String layerName, boolean isSphericalMercator) /*-{
        return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_PHYSICAL_MAP, sphericalMercator: isSphericalMercator});
    }-*/;
}
