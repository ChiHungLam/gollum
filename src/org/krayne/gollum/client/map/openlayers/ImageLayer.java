package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An OpenLayers Image Layer object that we can access in Java.
 * @author stphung
 */
public class ImageLayer extends Layer {
    private static final int NUM_ZOOM_LEVELS = 20;
    
    /**
     * Constructs an instance of this {@code ImageLayer}.
     * @param name the name of the image layer
     * @param url the url of the image
     * @param bounds the positioning of this image
     * @param width the width of this image
     * @param height the height of this image
     */
    public ImageLayer(String name, String url, Bounds bounds, int width, int height) {
        super(_newInstance(name, url, 
                           bounds.getJavaScriptObject(), 
                           width, height, NUM_ZOOM_LEVELS));
    }

    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(String name, String url,
        JavaScriptObject bounds, int width, int height, int totalNumZoomLevels) /*-{
        var options = {numZoomLevels: totalNumZoomLevels, maxResolution: 300000};
        var imageLayer = new $wnd.OpenLayers.Layer.Image(name, url,
                                               bounds,
                                               new $wnd.OpenLayers.Size(width, height),
                                               options);
        imageLayer.isBaseLayer = false;
        return imageLayer;
    }-*/;
}
