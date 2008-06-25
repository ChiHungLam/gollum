package org.krayne.gollum.client.map.openlayers.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public final class Point implements Geometry {
    private JavaScriptObject jsPoint;
    
    public Point(double x, double y) {
        this.jsPoint = _newInstance(x, y);
    }
    
    public Point(JavaScriptObject jsPoint) {
        this.jsPoint = jsPoint;
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsPoint;
    }
    
    public double getX() {
        return _x(this.jsPoint);
    }
    
    public double getY() {
        return _y(this.jsPoint);
    }
    
    public double distanceTo(Point point) {
        return _distanceTo(this.jsPoint, point.getJavaScriptObject());
    }
    
    public boolean intersects(Geometry geometry) {
        return _intersects(this.jsPoint, geometry.getJavaScriptObject());
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(double x, double y) /*-{
        return new $wnd.OpenLayers.Geometry.Point(x, y);
    }-*/;
    
    private static native double _x(JavaScriptObject point) /*-{
        return point.x;
    }-*/;
    
    private static native double _y(JavaScriptObject point) /*-{
        return point.y;
    }-*/;
    
    private static native double _distanceTo(JavaScriptObject fromPoint, JavaScriptObject toPoint) /*-{
        return fromPoint.distanceTo(toPoint);
    }-*/;
    
    private static native boolean _intersects(JavaScriptObject point, JavaScriptObject geometry) /*-{
        return point.intersects(geometry);
    }-*/;
}
