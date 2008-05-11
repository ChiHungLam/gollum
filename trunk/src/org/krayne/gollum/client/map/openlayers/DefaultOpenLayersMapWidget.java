package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;

public class DefaultOpenLayersMapWidget extends OpenLayersMapWidget {
    
    public DefaultOpenLayersMapWidget() {
        super();
        LocaleConstants localeConstants = Locale.getConstants();
        OpenLayersMap map = (OpenLayersMap) this.getMap();
        map.addLayer(new Google.SatelliteLayer(localeConstants.googleSatellite()));
        map.addLayer(new Google.PhysicalLayer(localeConstants.googlePhysical()));
        map.addLayer(new Google.HybridLayer(localeConstants.googleHybrid()));
        map.addLayer(new Google.NormalLayer(localeConstants.googleNormal()));
        map.addControl(new Controls.Navigation());
        map.addControl(new Controls.LayerSwitcher());
        map.addControl(new Controls.PanZoomBar());
        map.addControl(new Controls.MousePosition());
    }
}
