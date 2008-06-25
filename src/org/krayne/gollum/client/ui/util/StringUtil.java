package org.krayne.gollum.client.ui.util;

import org.krayne.gollum.client.localization.Locale;

/**
 * Various string utility function.
 * 
 * @author dhsu
 */
public class StringUtil {

    /**
     * Gets a localized key value string (e.g. Zoom: 12) given the key and value.
     * 
     * @param key the key
     * @param value the value
     * @return key value string
     */
    public static String getKeyValue(String key, String value) {
        return key + Locale.getConstants().keyValueSeparator() + value;
    }
    
    /**
     * Gets a key, value units string. (e.g. Latitude: 23.24243 degrees) given
     * the key, value and units.
     * 
     * @param key the key
     * @param value the value
     * @param units the units
     * @return key, value, units string
     */
    public static String getKeyValueUnits(String key, String value, String units) {
        return getKeyValue(key, value) + " " + units;
    }
}
