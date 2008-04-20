package org.krayne.gollum.client.ui.controlpanel.bookmarkssection;

import java.util.Iterator;
import java.util.List;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.BookmarksSource;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.util.HeaderLabel;

import com.google.gwt.user.client.ui.VerticalPanel;

public class BookmarksSourceLinks extends VerticalPanel {

    public BookmarksSourceLinks(BookmarksSource bookmarksSource, Map map) {
        List bookmarks = bookmarksSource.getBookmarks();
        Iterator iterator = bookmarks.iterator();
        
        HeaderLabel headerLabel = new HeaderLabel(bookmarksSource.getName());
        this.add(headerLabel);
        while(iterator.hasNext()) {
            Bookmark bookmark = (Bookmark) iterator.next();
            BookmarkLink bookmarkLink = new BookmarkLink(bookmark, map);
            this.add(bookmarkLink);
        }
    }

}
