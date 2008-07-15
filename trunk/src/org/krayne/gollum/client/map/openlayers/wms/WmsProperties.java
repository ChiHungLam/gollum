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
    
    public WmsProperties(int height, int width, String layers, String styles,
            String srs, String format, boolean tiled, LonLat tilesOrigin) {
        this.height = height;
        this.width = width;
        this.layers = layers;
        this.styles = styles;
        this.srs = srs;
        this.format = format;
        this.tiled = tiled;
        this.tilesOrigin = tilesOrigin;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getLayers() {
        return layers;
    }

    public String getStyles() {
        return styles;
    }

    public String getSrs() {
        return srs;
    }

    public String getFormat() {
        return format;
    }

    public boolean isTiled() {
        return tiled;
    }

    public LonLat getTilesOrigin() {
        return tilesOrigin;
    }
}
