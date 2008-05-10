package org.krayne.gollum.client;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.StaticBookmark;
import org.krayne.gollum.client.debug.DebugBookmarksSource;
import org.krayne.gollum.client.map.LatLon;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.GollumPanel;
import org.krayne.gollum.client.ui.controlpanel.bookmarkssection.BookmarksSection;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gollum implements EntryPoint {
    private static final Bookmark DEFAULT_START_BOOKMARK = new StaticBookmark("Start", new LatLon(34.055389, -118.249789), new Integer(3));
    private final GollumPanel gollumPanel;
    
    public Gollum() {
        this.gollumPanel = new GollumPanel();
        Map map = this.gollumPanel.getMap();
        
        BookmarksSection bookmarksSection = new BookmarksSection(map);
        bookmarksSection.addSource(new DebugBookmarksSource());
        this.gollumPanel.addControlPanelSection(bookmarksSection);
        
        this.gollumPanel.addTab("Test Tab", new Label("Just a test tab"));
    }
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("gollum").add(this.gollumPanel);
        Map map = this.gollumPanel.getMap();
        map.jumpTo(DEFAULT_START_BOOKMARK);
    }

}
