package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

public class Controls {

    public static class LayerSwitcher extends Control {
        public LayerSwitcher() {
            super(_createLayerSwitcher());
        }
        
        private static native JavaScriptObject _createLayerSwitcher() /*-{
            return new $wnd.OpenLayers.Control.LayerSwitcher();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    public static class Navigation extends Control {
        public Navigation() {
            super(_createNavigation());
        }
        
        private static native JavaScriptObject _createNavigation() /*-{
            return new $wnd.OpenLayers.Control.Navigation();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    public static class PanZoomBar extends Control {
        public PanZoomBar() {
            super(_createPanZoomBar());
        }
        
        private static native JavaScriptObject _createPanZoomBar() /*-{
            return new $wnd.OpenLayers.Control.PanZoomBar();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    public static class PanZoom extends Control {
        public PanZoom() {
            super(_createPanZoom());
        }
        
        private static native JavaScriptObject _createPanZoom() /*-{
            return new $wnd.OpenLayers.Control.PanZoomBar();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    public static class MousePosition extends Control {
        public MousePosition() {
            super(_createMousePosition());
        }
        
//        public MousePosition(Element domElement) {
//            
//        }
        
        private static native JavaScriptObject _createMousePosition()  /*-{
            return new $wnd.OpenLayers.Control.MousePosition();
        }-*/;
    }
}
