package org.krayne.gollum.client.bookmarks;

import org.krayne.gollum.client.map.LatLon;

/**
 * A map "bookmark."
 * 
 * @author dhsu
 */
public interface Bookmark {
    /**
     * Gets the location.
     * 
     * @return the location
     */
    LatLon getLocation();
    
    /**
     * Gets the bookmark name
     * @return
     */
    String getBookmarkName();
    
    /**
     * Gets the map zoom level. Bookmarks should be allowed to have null zoom 
     * levels.
     *
     * @return the map zoom level
     */
    Integer getZoomLevel();
}
