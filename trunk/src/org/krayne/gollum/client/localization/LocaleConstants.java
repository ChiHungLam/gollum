package org.krayne.gollum.client.localization;

import com.google.gwt.i18n.client.Constants;

/**
 * Localization strings that are defined in the LocaleConstants.properties
 * file.
 * 
 * @author dhsu
 */
public interface LocaleConstants extends Constants {

    // application
    String appVersion();
    
    // misc
    String keyValueSeparator();
    String notAvailable();
    
    // bookmark
    String bookmarksHeading();
    String jump();
    String enterValidLocation();
    String latitude();
    String longitude();
    String latitudeInDegrees();
    String longitudeInDegrees();
    String zoomLevel();
    
    // details
    String defaultDetailsHeading();
    
    // layers
    String googleSatellite();
    String googleHybrid();
    String googleNormal();
    String googlePhysical();
    
    // map
    String mapTabHeading();
    
    // units
    String degrees();
}
