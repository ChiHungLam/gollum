package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

public class ProjectionUtil {
//    private static JavaScriptObject INTERNAL_PROJECTION = _createEpsg4326Projection();
//    
//    public static LonLat getProjected(OpenLayersMap map, LonLat lonLat) {
//        LonLat pointToTransform = new LonLat(lonLat.getLonDegrees(), lonLat.getLatDegrees());
//        _transformToProjection(INTERNAL_PROJECTION, map.getJavaScriptObject(), pointToTransform.getJavaScriptObject());
//        return pointToTransform;
//    }
//
//    public static LonLat getInverseProjected(Layer layer, LonLat lonLat) {
//        LonLat pointToTransform = new LonLat(lonLat.getLonDegrees(), lonLat.getLatDegrees());
//        _transformToProjection(layer.getJavaScriptObject(), INTERNAL_PROJECTION, pointToTransform.getJavaScriptObject());
//        return pointToTransform;
//    }
//    
//    //--------------------------------------------------------------------------
//    
//    private static native void _transformToProjection(JavaScriptObject srcProjection, JavaScriptObject destProjectionSource, JavaScriptObject pointToTransform) /*-{
//        var projectionObject = destProjectionSource.projection;
//        pointToTransform.transform(srcProjection, projectionObject);
//    }-*/;
//    
//    private static native JavaScriptObject _createEpsg4326Projection() /*-{
//        return projection = new $wnd.OpenLayers.Projection("EPSG:4326");
//    }-*/;
    
    public static LonLat modelToMap(LonLat lonLat, boolean isSphericalMercator) {
        if(isSphericalMercator) {
            return new LonLat(_inverseMercator(lonLat.getJavaScriptObject()));
        }
        return lonLat;
    }
    
    public static LonLat mapToModel(LonLat lonLat, boolean isSphericalMercator) {
        if(isSphericalMercator) {
            return new LonLat(_forwardMercator(lonLat.getJavaScriptObject()));
        }
        return lonLat;
    }
    
    //--------------------------------------------------------------------------
    
    // converts from meters to lat lon
    private static native JavaScriptObject _inverseMercator(JavaScriptObject lonLat) /*-{
        return $wnd.OpenLayers.Layer.SphericalMercator.inverseMercator(lonLat.lon, lonLat.lat);
    }-*/;
    
    // converts from lat lon to meters
    private static native JavaScriptObject _forwardMercator(JavaScriptObject lonLat) /*-{
        return $wnd.OpenLayers.Layer.SphericalMercator.forwardMercator(lonLat.lon, lonLat.lat);
    }-*/;
}
