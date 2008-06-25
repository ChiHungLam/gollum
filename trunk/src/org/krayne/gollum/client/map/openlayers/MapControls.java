package org.krayne.gollum.client.map.openlayers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A set of standard OpenLayers map controls that we can access using Java.
 * 
 * @author dhsu
 */
public class MapControls {

    /**
     * A layer switcher control.
     */
    public static class LayerSwitcher extends Control {
        /**
         * Constructs a {@code LayerSwitcher}.
         */
        public LayerSwitcher() {
            super(_createLayerSwitcher());
        }
        
        private static native JavaScriptObject _createLayerSwitcher() /*-{
            return new $wnd.OpenLayers.Control.LayerSwitcher();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * A navigation control that lets the user pan.
     */
    public static class Navigation extends Control {
        /**
         * Constructs a {@code Navigation} control.
         */
        public Navigation() {
            super(_createNavigation());
        }
        
        private static native JavaScriptObject _createNavigation() /*-{
            return new $wnd.OpenLayers.Control.Navigation();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * A pan and zoom bar that lets users pan and zoom the map.
     */
    public static class PanZoomBar extends Control {
        /**
         * Constructs a {@code PanZoomBar}.
         */
        public PanZoomBar() {
            super(_createPanZoomBar());
        }
        
        private static native JavaScriptObject _createPanZoomBar() /*-{
            return new $wnd.OpenLayers.Control.PanZoomBar();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * A pan and zoom control.
     */
    public static class PanZoom extends Control {
        /**
         * Constructs a {@code PanZoom} control.
         */
        public PanZoom() {
            super(_createPanZoom());
        }
        
        private static native JavaScriptObject _createPanZoom() /*-{
            return new $wnd.OpenLayers.Control.PanZoomBar();
        }-*/;
    }
    
    //--------------------------------------------------------------------------
    
    /**
     * A control that shows the position of the mouse cursor on the map.
     */
    public static class MousePosition extends Control {
        /**
         * Constructs a {@code MousePosition} control.
         */
        public MousePosition() {
            super(_createMousePosition());
        }
        
        private static native JavaScriptObject _createMousePosition()  /*-{
            return new $wnd.OpenLayers.Control.MousePosition();
        }-*/;
    }
}
