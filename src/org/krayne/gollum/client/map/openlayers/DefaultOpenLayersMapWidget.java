package org.krayne.gollum.client.map.openlayers;

import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;
import org.krayne.gollum.client.map.openlayers.wms.Google;

/**
 * A default {@code OpenLayersMapWidget} that come pre-populated with
 * commonly used controls and map layers.
 * 
 * @author dhsu
 */
public class DefaultOpenLayersMapWidget extends OpenLayersMapWidget {
    
    /**
     * Constructs a {@code DefaultOpenLayersMapWidget}.
     */
    public DefaultOpenLayersMapWidget(boolean isSphericalMercator) {
        super(isSphericalMercator);
        LocaleConstants localeConstants = Locale.getConstants();
        OpenLayersMap map = (OpenLayersMap) this.getMap();
        map.addLayer(new Google.SatelliteLayer(localeConstants.googleSatellite(), isSphericalMercator));
        map.addLayer(new Google.PhysicalLayer(localeConstants.googlePhysical(), isSphericalMercator));
        map.addLayer(new Google.HybridLayer(localeConstants.googleHybrid(), isSphericalMercator));
        map.addLayer(new Google.NormalLayer(localeConstants.googleNormal(), isSphericalMercator));
        map.addControl(new MapControls.Navigation());
        map.addControl(new MapControls.LayerSwitcher());
        map.addControl(new MapControls.PanZoomBar());
        map.addControl(new MapControls.MousePosition());
    }
}
