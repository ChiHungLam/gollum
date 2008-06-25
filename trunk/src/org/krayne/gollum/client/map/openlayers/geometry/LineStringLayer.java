package org.krayne.gollum.client.map.openlayers.geometry;

import org.krayne.gollum.client.jsni.JsWrapperFactory;
import org.krayne.gollum.client.map.openlayers.Control;
import org.krayne.gollum.client.map.openlayers.DrawControl;

import com.google.gwt.core.client.JavaScriptObject;


public class LineStringLayer extends AbstractGeometryLayer<LineString> {
    private static final JsWrapperFactory<LineString> JS_WRAPPER_FACTORY = new LineStringWrapperFactory();
    private Control drawControl; // lazy initialized
        
    public LineStringLayer(String layerName, int maxNumFeatures) {
        super(layerName, JS_WRAPPER_FACTORY, maxNumFeatures);
        this.drawControl = null;
    }

    public Control getDrawControl() {
        if(this.drawControl == null) {
            this.drawControl = new LineStringDrawControl(this);
        }
        return this.drawControl;
    }
    
    //--------------------------------------------------------------------------
    
    private static class LineStringWrapperFactory implements JsWrapperFactory<LineString> {
        public LineString wrap(JavaScriptObject jsObject) {
            return new LineString(jsObject);
        }
    }

    //--------------------------------------------------------------------------
    
    public static class LineStringDrawControl extends DrawControl {
        public LineStringDrawControl(LineStringLayer lineStringLayer) {
            super(_createLineStringDrawControl(lineStringLayer.getJavaScriptObject()));
        }

        private static native JavaScriptObject _createLineStringDrawControl(JavaScriptObject pointLayer) /*-{
            var control = new $wnd.OpenLayers.Control.DrawFeature(
                pointLayer, 
                $wnd.OpenLayers.Handler.Path
            );
            return control;
        }-*/;
    }
}
