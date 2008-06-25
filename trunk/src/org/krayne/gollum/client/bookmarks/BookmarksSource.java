package org.krayne.gollum.client.bookmarks;

import java.util.List;

/**
 * A source of map bookmarks.
 * 
 * @author dhsu
 */
public interface BookmarksSource {
    
    /**
     * Gets the source name.
     * 
     * @return the source name
     */
    String getName();
    
    /**
     * Gets the bookmarks in this source.
     * 
     * @return bookmarks
     */
    List<Bookmark> getBookmarks();
}
