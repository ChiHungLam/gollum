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
    public void jumpTo(Bookmark bookmark);
    
    public int getZoomLevel();
    public int getNumZoomLevels();
    public void setZoomLevel(int zoomLevel);
}
