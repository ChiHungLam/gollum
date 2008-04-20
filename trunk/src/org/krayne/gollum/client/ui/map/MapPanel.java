package org.krayne.gollum.client.ui.map;

import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.util.SharedStyles;
import org.krayne.gollum.client.ui.util.WidgetContainer;

import com.google.gwt.user.client.ui.DockPanel;

public class MapPanel extends DockPanel {
    public static final String STYLE_NAME = SharedStyles.STRETCH;
    private final Map map;
    private final MapWidget mapWidget;
    private final LocationBar locationBar;
    
    public MapPanel(MapWidget mapWidget) {
        this.setStyleName(STYLE_NAME);
        this.mapWidget = mapWidget;
        this.map = mapWidget.getMap();
        this.locationBar = new LocationBar(this.map);

        WidgetContainer locationBarContainer = new WidgetContainer(this.locationBar);
        this.add(locationBarContainer, DockPanel.NORTH);
        this.setCellHeight(locationBarContainer, "10px");
        this.add(this.mapWidget, DockPanel.CENTER);
    }
}
