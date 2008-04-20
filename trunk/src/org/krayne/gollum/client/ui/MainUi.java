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
import org.krayne.gollum.client.ui.util.SharedStyles;
import org.krayne.gollum.client.ui.util.StatusBar;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainUi extends DockPanel {
    private static final String STYLE_NAME = SharedStyles.STRETCH;
    private static final String DEFAULT_SPLIT_POSITION = "300px";

    private final ControlPanel controlPanel;
    private final OpenLayersMap map;
    private final OpenLayersMapWidget mapWidget;
    private final MapPanel mapPanel;
    private final StatusBar statusBar;
    private final TabPanel tabPanel;
    
    public MainUi() {
        LocaleConstants localeConstants = Locale.getConstants();
        this.controlPanel = new ControlPanel();

        // init map
        this.mapWidget = new DefaultOpenLayersMapWidget();
        this.map = (OpenLayersMap) this.mapWidget.getMap();
        this.mapPanel = new MapPanel(this.mapWidget);
        
        // init status bar
        this.statusBar = new StatusBar();
        String appVersion = localeConstants.appVersion();
        this.statusBar.setRightStatusLabelText(appVersion);
        
        // init tab panel
        this.tabPanel = new TabPanel();
        this.tabPanel.setStyleName(SharedStyles.STRETCH);
        this.tabPanel.add(this.mapPanel, "Map");
        this.tabPanel.selectTab(0);

        // layout
        DockPanel controlPanelContainer = new DockPanel();
        controlPanelContainer.add(this.controlPanel, DockPanel.CENTER);

        HorizontalSplitPanel mainSplitPanel = new HorizontalSplitPanel();
        mainSplitPanel.setSplitPosition(DEFAULT_SPLIT_POSITION);
        mainSplitPanel.setLeftWidget(this.controlPanel);
        mainSplitPanel.setRightWidget(this.tabPanel);

        this.setStyleName(STYLE_NAME);
        this.add(mainSplitPanel, DockPanel.CENTER);
        this.add(this.statusBar, DockPanel.SOUTH);
        this.setCellHeight(this.statusBar, "10px");
    }
    
    public Map getMap() {
        return this.map;
    }
    
    public void addTab(String tabName, Widget tabWidget) {
        this.tabPanel.add(tabWidget, tabName);
    }
    
    public void addControlPanelSection(ControlPanelSection section) {
        this.controlPanel.addSection(section);
    }
}
