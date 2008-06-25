package org.krayne.gollum.client.map.openlayers.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public class LineString implements Geometry {
    private final JavaScriptObject jsLineString;
    
    public LineString() {
        this.jsLineString = _newInstance();
    }
    
    public LineString(JavaScriptObject jsLineString) {
        this.jsLineString = jsLineString;
    }

    public JavaScriptObject getJavaScriptObject() {
        return this.jsLineString;
    }

    public void addPoint(Point p) {
        _addPoint(this.jsLineString, p.getJavaScriptObject());
    }
    
    public int getNumPoints() {
        return _getNumPoints(this.jsLineString);
    }
    
    public Point getPoint(int index) {
        if(index < this.getNumPoints() && index >= 0) {
            return new Point(_getPoint(this.jsLineString, index));
        }
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance() /*-{
        return new $wnd.OpenLayers.Geometry.LineString([]);
    }-*/;
    
    private static native void _addPoint(JavaScriptObject lineString, JavaScriptObject point) /*-{
        lineString.addPoint(point);
    }-*/;
    
    private static native int _getNumPoints(JavaScriptObject lineString) /*-{
        return lineString.components.length;
    }-*/;
    
    private static native JavaScriptObject _getPoint(JavaScriptObject lineString, int index) /*-{
        return lineString.components[index];
    }-*/;
}
