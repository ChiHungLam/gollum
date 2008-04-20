package org.krayne.gollum.client.bookmarks;

import org.krayne.gollum.client.map.LatLon;

/**
 * A static bookmark.
 * 
 * @author dhsu
 */
public class StaticBookmark implements Bookmark {
    private final LatLon location;
    private final String name;
    private final Integer zoomLevel;
    
    /**
     * Constructs a bookmark with the specified name and location and
     * unspecified zoom level.
     * 
     * @param name the bookmark name
     * @param location the location
     */
    public StaticBookmark(String name, LatLon location) {
        this(name, location, null);
    }
    
    /**
     * Constructs a bookmark that has the same parameters as the specified
     * bookmark at construction time.
     * 
     * @param bookmark the bookmark to copy parameters from
     */
    public StaticBookmark(Bookmark bookmark) {
        this(bookmark.getBookmarkName(), bookmark.getLocation(), bookmark.getZoomLevel());
    }
    
    /**
     * Constructs a bookmark with the specified name, location and zoom level.
     * 
     * @param name the bookmark name
     * @param location the location
     * @param zoomLevel the map zoom level
     */
    public StaticBookmark(String name, LatLon location, Integer zoomLevel) {
        this.name = name;
        this.location = location;
        this.zoomLevel = zoomLevel;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getBookmarkName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    public LatLon getLocation() {
        return this.location;
    }

    /**
     * {@inheritDoc}
     */
    public Integer getZoomLevel() {
        return this.zoomLevel;
    }
}
