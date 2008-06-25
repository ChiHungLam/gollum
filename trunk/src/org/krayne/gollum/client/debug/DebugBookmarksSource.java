package org.krayne.gollum.client.debug;

import java.util.ArrayList;
import java.util.List;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.BookmarksSource;
import org.krayne.gollum.client.bookmarks.StaticBookmark;
import org.krayne.gollum.client.map.LatLon;

/**
 * A static bookmark source used for debugging.
 * 
 * @author dhsu
 */
public class DebugBookmarksSource implements BookmarksSource {
    private static final String SOURCE_NAME = "Debugging Bookmarks";
    private static final Bookmark bookmarkA = new StaticBookmark("Zero zero", new LatLon(0.0, 0.0), new Integer(2));
    private static final Bookmark bookmarkB = new StaticBookmark("Disney Concert Hall", new LatLon(34.055389, -118.249789), new Integer(18));
    private static final Bookmark bookmarkC = new StaticBookmark("Taipei", new LatLon(25.038766, 121.563737), new Integer(12));

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return SOURCE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    public List<Bookmark> getBookmarks() {
        List<Bookmark> list = new ArrayList<Bookmark>();
        list.add(bookmarkA);
        list.add(bookmarkB);
        list.add(bookmarkC);
        return list;
    }
}
