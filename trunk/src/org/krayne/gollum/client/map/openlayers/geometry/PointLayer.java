package org.krayne.gollum.client.map.openlayers.geometry;

import org.krayne.gollum.client.jsni.JsWrapperFactory;
import org.krayne.gollum.client.map.openlayers.Control;
import org.krayne.gollum.client.map.openlayers.DrawControl;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A vector point layer.
 * 
 * @author dhsu
 * @author smartinez
 */
public class PointLayer extends AbstractGeometryLayer<Point> {
    private static final JsWrapperFactory<Point> JS_WRAPPER_FACTORY = new PointWrapperFactory();
    private Control drawControl; // lazy initialized
    
    public PointLayer(String layerName, int maxNumFeatures) {
        super(layerName, JS_WRAPPER_FACTORY, maxNumFeatures);
        this.drawControl = null;
    }

    public Control getDrawControl() {
        if(this.drawControl == null) {
            this.drawControl = new PointDrawControl(this);
        }
        return this.drawControl;
    }
    
    //--------------------------------------------------------------------------
    
    private static class PointWrapperFactory implements JsWrapperFactory<Point> {
        public Point wrap(JavaScriptObject jsObject) {
            return new Point(jsObject);
        }
    }

    //--------------------------------------------------------------------------
    
    public static class PointDrawControl extends DrawControl {
        public PointDrawControl(PointLayer pointLayer) {
            super(_createPointDrawControl(pointLayer.getJavaScriptObject()));
        }

        private static native JavaScriptObject _createPointDrawControl(JavaScriptObject pointLayer) /*-{
            function pointDrawn(pointFeature) {
            }
            
            var pointOptions = {featureAdded: pointDrawn};

            var control = new $wnd.OpenLayers.Control.DrawFeature(
                pointLayer, 
                $wnd.OpenLayers.Handler.Point, 
                pointOptions
            );
            return control;
        }-*/;
    }
}
