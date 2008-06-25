package org.krayne.gollum.client.map.openlayers.geometry;

import org.krayne.gollum.client.jsni.JsArray;

import com.google.gwt.core.client.JavaScriptObject;

public class PointArray extends JsArray {

    public PointArray() {
        super();
    }
    
    public void push(Point p) {
        this.push(p.getJavaScriptObject());
    }
    
    public Point getPoint(int index) {
        JavaScriptObject jsPoint = this.get(index);
        return (jsPoint == null) ? null : new Point(jsPoint);
    }
    
    public Point getLastPoint() {
        JavaScriptObject jsPoint = this.getLast();
        return (jsPoint == null) ? null : new Point(jsPoint);
    }
}
