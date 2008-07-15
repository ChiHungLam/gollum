package org.krayne.gollum.client.map.openlayers.wms;

import org.krayne.gollum.client.map.openlayers.Layer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An OpenLayers Wms Layer that we can access in Java.
 * 
 * @author stphung
 */
public class Wms extends Layer {
    
    public Wms(String layerName, String wmsUrl, WmsProperties wmsProperties) {
        super(_createWmsLayer(layerName, wmsUrl,
                wmsProperties.getHeight() == 0 ? "" : Integer.toString(wmsProperties.getHeight()),
                wmsProperties.getWidth() == 0 ? "" : Integer.toString(wmsProperties.getWidth()),
                wmsProperties.getLayers() == null ? "" : wmsProperties.getLayers(),
                wmsProperties.getStyles() == null ? "" : wmsProperties.getStyles(),
                wmsProperties.getSrs() == null ? "" : wmsProperties.getSrs(),
                wmsProperties.getFormat() == null ? "" : wmsProperties.getFormat(),
                wmsProperties.isTiled() ? "true" : "",
                
                wmsProperties.getTilesOrigin() == null ? 
                		"" : wmsProperties.getTilesOrigin().getLonDegrees() + "," + wmsProperties.getTilesOrigin().getLatDegrees()
                ));
    }

    // --------------------------------------------------------------------------

    private static native JavaScriptObject _createWmsLayer(String layerName, String wmsUrl, 
    		String height, String width, String layers, String styles, 
    		String srs, String format, String isTiled, String tilesOrigin) /*-{
        var params = {};
        if ( height != "" ) params["height"] = height;
        if ( width != "" ) params["width"] = width;
        if ( layers != "" ) params["layers"] = layers;
        if ( styles != "" ) params["styles"] = styles;
        if ( srs != "" ) params["srs"] = srs;
        if ( format != "" ) params["format"] = format;
        if ( isTiled != "" ) params["tiled"] = isTiled;
        if ( tilesOrigin != "" ) params["tilesOrigin"] = tilesOrigin;
        
        return new $wnd.OpenLayers.Layer.WMS(layerName, wmsUrl, params);
    }-*/;
}
