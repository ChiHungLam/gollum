package org.krayne.gollum.client.map;

import org.krayne.gollum.client.bookmarks.Bookmark;

/**
 * A {@code Map} interface.
 * 
 * @author dhsu
 */
public interface Map {
    
    /**
     * Moves the map to the bookmark location.
     * 
     * @param bookmark a bookmark
     */
    void jumpTo(Bookmark bookmark);
    
    /**
     * Gets the zoom level of the map. The bigger the value, the more zoomed in.
     * 
     * @return the zoom level of the map
     */
    int getZoomLevel();
    
    /**
     * Gets the total number of zoom levels for this map.
     * 
     * @return the total number of zoom levels for this map
     */
    int getNumZoomLevels();
    
    /**
     * Sets the map's zoom level.
     * 
     * @param zoomLevel the zoom level
     */
    void setZoomLevel(int zoomLevel);
    
    /**
     * Redraws the map.
     */
    void redraw();
}
