package org.krayne.gollum.client.map.openlayers.wms;

import org.krayne.gollum.client.map.openlayers.LonLat;

/**
 * A class that represents the parameters for an OpenLayers Wms Layer.
 * 
 * @author stphung
 */
public class WmsProperties {
    private final int height;
    private final int width;
    private final String layers;
    private final String styles;
    private final String srs;
    private final String format;
    private final boolean tiled;
    private final LonLat tilesOrigin;
    private final boolean isBaseLayer;
    private final boolean isTransparent;
    
    public WmsProperties(int height, int width, String layers, String styles,
            String srs, String format, boolean tiled, LonLat tilesOrigin, boolean isBaseLayer, boolean isTransparent) {
        this.height = height;
        this.width = width;
        this.layers = layers;
        this.styles = styles;
        this.srs = srs;
        this.format = format;
        this.tiled = tiled;
        this.tilesOrigin = tilesOrigin;
        this.isBaseLayer = isBaseLayer;
        this.isTransparent = isTransparent;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String getLayers() {
        return this.layers;
    }

    public String getStyles() {
        return this.styles;
    }

    public String getSrs() {
        return this.srs;
    }

    public String getFormat() {
        return this.format;
    }

    public boolean isTiled() {
        return this.tiled;
    }

    public LonLat getTilesOrigin() {
        return this.tilesOrigin;
    }
    
    public boolean isBaseLayer() {
    	return this.isBaseLayer;
    }
    
    public boolean isTransparent() {
    	return this.isTransparent;
    }
}
