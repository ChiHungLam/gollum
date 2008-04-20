package org.krayne.gollum.client.localization;

import com.google.gwt.i18n.client.Constants;

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
    
    // layers
    String googleSatellite();
    String googleHybrid();
    String googleNormal();
    
    // units
    String degrees();
}
