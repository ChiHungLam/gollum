package org.krayne.gollum.client.ui.controlpanel.bookmarkssection;

import org.krayne.gollum.client.bookmarks.BookmarksSource;
import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.controlpanel.ControlPanelSection;

import com.google.gwt.user.client.ui.Widget;

public class BookmarksSection implements ControlPanelSection {
    private final BookmarksPanel bookmarksPanel;
    
    public BookmarksSection(Map map) {
        this.bookmarksPanel = new BookmarksPanel(map);
    }
    
    public String getName() {
        return Locale.getConstants().bookmarksHeading();
    }

    public Widget getWidget() {
        return this.bookmarksPanel;
    }
    
    public void addSource(BookmarksSource bookmarksSource) {
        this.bookmarksPanel.addSource(bookmarksSource);
    }

    public void handleSelectEvent() {}
    public void handleUnselectEvent() {}
}
