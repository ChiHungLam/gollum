package org.krayne.gollum.client.localization;

import com.google.gwt.core.client.GWT;

/**
 * A singleton locale that lets you get the locale constants instead of
 * creating the constants every time you need them. This does not improve
 * performance, since GWT optimizes and inlines the static locale constants,
 * but this makes it easier to get the constants.
 * 
 * @author dhsu
 */
public class Locale {
    private static LocaleConstants localeConstants;
    
    /**
     * Private constructor.
     */
    private Locale() {}

    /**
     * Gets the locale constants.
     * 
     * @return locale constants
     */
    public static LocaleConstants getConstants() {
        if(localeConstants == null) {
            localeConstants = (LocaleConstants) GWT.create(LocaleConstants.class);
        }
        return localeConstants;
    }
}
