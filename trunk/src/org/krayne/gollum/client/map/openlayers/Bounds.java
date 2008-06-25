package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.jsni.JsWrapper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An OpenLayers Bounds object that we can access in Java.
 * 
 * @author stphung
 */
public class Bounds implements JsWrapper {
    private final JavaScriptObject jsBounds;
    
    /**
     * Constructs an instance of this {@code Bounds}.
     * @param minX the minimum x coordinate
     * @param minY the minimum y coordinate
     * @param maxX the maximum x coordinate
     * @param maxY the maximum y coordinate
     */
    public Bounds(double minX, double minY, double maxX, double maxY) {
        this.jsBounds = _newInstance(minX, minY, maxX, maxY);
    }
    
    /**
     * Gets the minimum x coordinate.
     * @return the minimum x coordinate
     */
    public double getMinX() {
        return _left(this.jsBounds);
    }
    
    /**
     * Gets the minimum y coordinate.
     * @return the minimum y coordinate
     */
    public double getMinY() {
        return _bottom(this.jsBounds);
    }
    
    /**
     * Gets the maximum x coordinate.
     * @return the maximum x coordinate
     */
    public double getMaxX() {
        return _right(this.jsBounds);
    }
    
    /**
     * Gets the maximum y coordinate.
     * @return the maximum y coordinate
     */
    public double getMaxY() {
        return _top(this.jsBounds);
    }
    
    /*
     * {@inheritDoc}
     */
    public JavaScriptObject getJavaScriptObject() {
        return this.jsBounds;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(double minX, double minY, 
                                                        double maxX, double maxY) /*-{
        return new $wnd.OpenLayers.Bounds(minX, minY, maxX, maxY);
    }-*/;
    
    private static native double _left(JavaScriptObject bounds) /*-{
        return bounds.left
    }-*/;
    
    private static native double _bottom(JavaScriptObject bounds) /*-{
        return bounds.bottom
    }-*/;

    private static native double _right(JavaScriptObject bounds) /*-{
        return bounds.right
    }-*/;

    private static native double _top(JavaScriptObject bounds) /*-{
        return bounds.top
    }-*/;
}
