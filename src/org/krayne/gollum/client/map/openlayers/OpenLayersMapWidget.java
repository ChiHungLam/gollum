package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.map.MapWidget;
import org.krayne.gollum.client.ui.util.SharedStyles;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

public class OpenLayersMapWidget extends MapWidget {
    public static final String STYLE_NAME = SharedStyles.STRETCH;
    private final OpenLayersMap map;
    
    public OpenLayersMapWidget(boolean isSphericalMercator) {
        Element mapDomElement = DOM.createDiv();
        this.setElement(mapDomElement);
        this.setStyleName(STYLE_NAME);
        this.map = new OpenLayersMap(mapDomElement, isSphericalMercator);
    }
    
    public Map getMap() {
        return this.map;
    }
    
    protected void onLoad() {
        super.onLoad();
        this.map.redraw();
    }
}
