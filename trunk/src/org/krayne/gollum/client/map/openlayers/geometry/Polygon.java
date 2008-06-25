package org.krayne.gollum.client.map.openlayers.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public class Polygon implements Geometry {
    private final JavaScriptObject jsPolygon;
    
    public Polygon(LinearRing linearRing) {
        this.jsPolygon = _newInstance(linearRing.getJavaScriptObject());
    }

    public Polygon(JavaScriptObject jsPolygon) {
        this.jsPolygon = jsPolygon;
    }
    
    public JavaScriptObject getJavaScriptObject() {
        return this.jsPolygon;
    }
    
    public double getArea() {
        return _getArea(this.jsPolygon);
    }
    
    public int getNumPoints() {
        return _getNumPoints(this.jsPolygon);
    }
    
    public Point getPoint(int index) {
        if(index >=0 && index < this.getNumPoints()) {
            return new Point(_getPoint(this.jsPolygon, index));
        }
        return null;
    }
    
    public boolean intersects(Geometry geometry) {
        return _intersects(this.jsPolygon, geometry.getJavaScriptObject());
    }

    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance(JavaScriptObject linearRing) /*-{
        return new $wnd.OpenLayers.Geometry.Polygon(linearRing);
    }-*/;
    
    private static native double _getArea(JavaScriptObject polygon) /*-{
        return polygon.getArea();
    }-*/;
    
    private static native int _getNumPoints(JavaScriptObject polygon) /*-{
        return polygon.components[0].components.length;
    }-*/;
    
    // TODO: should we new up a point here?
    private static native JavaScriptObject _getPoint(JavaScriptObject polygon, int index) /*-{
        return polygon.components[0].components[index];
    }-*/;
    
    private static native boolean _intersects(JavaScriptObject polygon, JavaScriptObject geometry) /*-{
        return polygon.intersects(geometry);
    }-*/;
}
