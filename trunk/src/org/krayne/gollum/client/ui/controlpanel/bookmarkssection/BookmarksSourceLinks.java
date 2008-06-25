package org.krayne.gollum.client.ui.controlpanel.bookmarkssection;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.BookmarksSource;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.util.HeaderLabel;

import com.google.gwt.user.client.ui.VerticalPanel;

public class BookmarksSourceLinks extends VerticalPanel {

    public BookmarksSourceLinks(BookmarksSource bookmarksSource, Map map) {
        HeaderLabel headerLabel = new HeaderLabel(bookmarksSource.getName());
        this.add(headerLabel);
        for(Bookmark bookmark : bookmarksSource.getBookmarks()) {
            BookmarkLink bookmarkLink = new BookmarkLink(bookmark, map);
            this.add(bookmarkLink);
        }
    }

}
