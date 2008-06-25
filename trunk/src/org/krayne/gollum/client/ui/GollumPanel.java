package org.krayne.gollum.client.ui;

import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.map.openlayers.DefaultOpenLayersMapWidget;
import org.krayne.gollum.client.map.openlayers.OpenLayersMap;
import org.krayne.gollum.client.map.openlayers.OpenLayersMapWidget;
import org.krayne.gollum.client.ui.controlpanel.ControlPanel;
import org.krayne.gollum.client.ui.controlpanel.ControlPanelSection;
import org.krayne.gollum.client.ui.map.MapPanel;
import org.krayne.gollum.client.ui.map.MapWidget;
import org.krayne.gollum.client.ui.util.SharedStyles;
import org.krayne.gollum.client.ui.util.StatusBar;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class GollumPanel extends DockPanel {
    private static final String STYLE_NAME = SharedStyles.STRETCH;
    private static final String TAB_BAR_STYLE_NAME = "gollumMainTabBar";
    private static final String MAIN_SPLIT_POSITION = "250px";

    private final ControlPanel controlPanel;
    private final OpenLayersMap map;
    private final OpenLayersMapWidget mapWidget;
    private final MapPanel mapPanel;
    private final StatusBar statusBar;
    private final TabPanel tabPanel;
    private final DetailsPanel detailsPanel;
    private final HorizontalSplitPanel mainSplitPanel;
    
    public GollumPanel(boolean isSphericalMercator) {
        LocaleConstants localeConstants = Locale.getConstants();
        this.controlPanel = new ControlPanel();

        // init map
        this.mapWidget = new DefaultOpenLayersMapWidget(isSphericalMercator);
        this.map = (OpenLayersMap) this.mapWidget.getMap();
        this.mapPanel = new MapPanel(this.mapWidget);
        
        // init status bar
        this.statusBar = new StatusBar();
        String appVersion = localeConstants.appVersion();
        this.statusBar.setRightStatusLabelText(appVersion);
        
        // init tab panel
        this.tabPanel = new TabPanel() {
            public void onBrowserEvent(Event event) {
                GollumPanel.this.map.redraw();
            }
        };
        this.tabPanel.setStyleName(SharedStyles.STRETCH);
        this.tabPanel.getDeckPanel().setStyleName(SharedStyles.STRETCH);
        this.tabPanel.getTabBar().setStyleName(TAB_BAR_STYLE_NAME);
        this.tabPanel.add(this.mapPanel, localeConstants.mapTabHeading());
        this.tabPanel.selectTab(0);
        
        // init details panel
        this.detailsPanel = new DetailsPanel();
        this.detailsPanel.setStyleName(SharedStyles.STRETCH);

        // layout
        DockPanel leftPanel = new DockPanel();
        leftPanel.setStyleName(SharedStyles.STRETCH);
        leftPanel.add(this.controlPanel, DockPanel.NORTH);
        leftPanel.add(this.detailsPanel, DockPanel.SOUTH);
        leftPanel.setCellHeight(this.detailsPanel, "10px");
        
        this.mainSplitPanel = new HorizontalSplitPanel();
        this.mainSplitPanel.setSplitPosition(MAIN_SPLIT_POSITION);
        this.mainSplitPanel.setLeftWidget(leftPanel);
        this.mainSplitPanel.setRightWidget(this.tabPanel);

        this.setStyleName(STYLE_NAME);
        this.add(this.mainSplitPanel, DockPanel.CENTER);
        this.add(this.statusBar, DockPanel.SOUTH);
        this.setCellHeight(this.statusBar, "10px");
    }
    
    public Map getMap() {
        return this.map;
    }
    
    public MapWidget getMapWidget() {
        return this.mapWidget;
    }
    
    public void addTab(String tabName, Widget tabWidget) {
        this.tabPanel.add(tabWidget, tabName);
    }
    
    public void addControlPanelSection(ControlPanelSection section) {
        this.controlPanel.addSection(section);
    }
    
    public void setDetailsWidget(Widget w) {
        this.detailsPanel.setWidget(w);
    }
    
    public void setDetailsVisible(boolean visible) {
        this.detailsPanel.setVisible(visible);
    }
    
    public void setSplitPosition(String cssSplitPosition) {
        this.mainSplitPanel.setSplitPosition(cssSplitPosition);
    }
    
    public StatusBar getStatusBar() {
        return this.statusBar;
    }
}
