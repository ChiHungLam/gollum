package org.krayne.gollum.client.map.openlayers.geometry;

import org.krayne.gollum.client.jsni.JsWrapperFactory;
import org.krayne.gollum.client.map.openlayers.Control;
import org.krayne.gollum.client.map.openlayers.DrawControl;

import com.google.gwt.core.client.JavaScriptObject;

public class PolygonLayer extends AbstractGeometryLayer<Polygon> {
    private static final JsWrapperFactory<Polygon> JS_WRAPPER_FACTORY = new PolygonWrapperFactory();
    private final boolean rectangleOnlyDrawControl;
    private Control drawControl;
    
    public PolygonLayer(String layerName, int maxNumFeatures, boolean rectangleOnlyDrawControl) {
        super(layerName, JS_WRAPPER_FACTORY, maxNumFeatures);
        this.rectangleOnlyDrawControl = rectangleOnlyDrawControl;
        this.drawControl = null;
    }

    public Control getDrawControl() {
        if(this.drawControl == null) {
            this.drawControl = new PolygonDrawControl(this, this.rectangleOnlyDrawControl);
        }
        return this.drawControl;
    }
    
    //--------------------------------------------------------------------------
    
    private static class PolygonWrapperFactory implements JsWrapperFactory<Polygon> {
        public Polygon wrap(JavaScriptObject jsObject) {
            return new Polygon(jsObject);
        }
    }

    //--------------------------------------------------------------------------
    
    public static class PolygonDrawControl extends DrawControl {
        public PolygonDrawControl(PolygonLayer polygonLayer, boolean rectanglesOnly) {
            super(_createPolygonDrawControl(polygonLayer.getJavaScriptObject(), rectanglesOnly));
        }

        private static native JavaScriptObject _createPolygonDrawControl(JavaScriptObject pointLayer, boolean rectanglesOnly) /*-{
            if(rectanglesOnly) {
                return new $wnd.OpenLayers.Control.DrawFeature(
                    pointLayer, 
                    $wnd.OpenLayers.Handler.RegularPolygon,
                    {handlerOptions: {irregular: true}}
                );
            } else {
                return new $wnd.OpenLayers.Control.DrawFeature(
                    pointLayer, 
                    $wnd.OpenLayers.Handler.Polygon
                );
            }
        }-*/;
    }
}
