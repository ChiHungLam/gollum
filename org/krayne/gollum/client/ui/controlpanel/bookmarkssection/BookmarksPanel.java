package org.krayne.gollum.client.ui.controlpanel.bookmarkssection;

import org.krayne.gollum.client.bookmarks.BookmarksSource;
import org.krayne.gollum.client.map.Map;

import com.google.gwt.user.client.ui.VerticalPanel;

public class BookmarksPanel extends VerticalPanel {
    private final Map map;
    
    public BookmarksPanel(Map map) {
        this.map = map;
    }

    public void addSource(BookmarksSource bookmarksSource) {
        BookmarksSourceLinks links = new BookmarksSourceLinks(bookmarksSource, map);
        this.add(links);
    }
}
