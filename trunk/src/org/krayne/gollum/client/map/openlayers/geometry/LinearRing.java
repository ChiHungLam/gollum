package org.krayne.gollum.client.map.openlayers.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public class LinearRing implements Geometry {
    private final JavaScriptObject jsLinearRing;
    
    public LinearRing() {
        this.jsLinearRing = _newInstance();
    }

    public JavaScriptObject getJavaScriptObject() {
        return this.jsLinearRing;
    }

    public void addPoint(Point p) {
        _addComponent(this.jsLinearRing, p.getJavaScriptObject());
    }
    
    public int getNumPoints() {
        return _getNumPoints(this.jsLinearRing);
    }
    
    public Point getPoint(int index) {
        if(index < this.getNumPoints() && index >= 0) {
            return new Point(_getPoint(this.jsLinearRing, index));
        }
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance() /*-{
        return new $wnd.OpenLayers.Geometry.LinearRing();
    }-*/;
    
    private static native void _addComponent(JavaScriptObject linearRing, JavaScriptObject point) /*-{
        linearRing.addComponent(point, linearRing.components.length);
    }-*/;
    
    private static native int _getNumPoints(JavaScriptObject linearRing) /*-{
        return linearRing.components.length;
    }-*/;
    
    private static native JavaScriptObject _getPoint(JavaScriptObject linearRing, int index) /*-{
        return linearRing.components[index];
    }-*/;
}
