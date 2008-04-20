package org.krayne.gollum.client.ui.controlpanel.bookmarkssection;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.StaticBookmark;
import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.util.Link;
import org.krayne.gollum.client.ui.util.PopupMouseListener;
import org.krayne.gollum.client.ui.util.StringUtil;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BookmarkLink extends Link {
    public static final String STYLE_NAME = "labelLink";
    private final StaticBookmark bookmark;
    private final Map map;
    private BookmarkPopup bookmarkPopup;
    
    public BookmarkLink(Bookmark bookmark, Map map) {
        super(bookmark.getBookmarkName());
        this.bookmark = new StaticBookmark(bookmark);
        this.map = map;
        this.setStyleName(STYLE_NAME);

        // initialize popup
        this.bookmarkPopup = new BookmarkPopup(this.bookmark);
        PopupMouseListener popupMouseListener = new PopupMouseListener(this.bookmarkPopup);
        this.addMouseListener(popupMouseListener);
        
        // initialize click behavior
        this.addClickListener(new BookmarkClickListener(this.bookmark, this.map));
    }
    
    //--------------------------------------------------------------------------
    
    private static class BookmarkClickListener implements ClickListener {
        private final Bookmark bookmark;
        private final Map map;
        
        public BookmarkClickListener(Bookmark bookmark, Map map) {
            this.bookmark = bookmark;
            this.map = map;
        }
        
        public void onClick(Widget sender) {
            this.map.jumpTo(this.bookmark);
        }
    }
    
    //--------------------------------------------------------------------------
    
    private static class BookmarkPopup extends VerticalPanel {
        private final Label latLabel;
        private final Label lonLabel;
        private final Label zoomLabel;
        
        public BookmarkPopup(Bookmark bookmark) {
            LocaleConstants constants = Locale.getConstants();
            
            // get lat label string
            String latText = StringUtil.getKeyValueUnits(
                    constants.latitude(), 
                    Double.toString(bookmark.getLocation().getLatDegrees()),
                    constants.degrees());
            
            // get lon label string
            String lonText = StringUtil.getKeyValueUnits(
                    constants.longitude(), 
                    Double.toString(bookmark.getLocation().getLonDegrees()),
                    constants.degrees());
            
            // get zoom label string
            String zoomLevelString = constants.notAvailable();
            if(bookmark.getZoomLevel() != null) {
                zoomLevelString = bookmark.getZoomLevel().toString();
            }
            String zoomText = StringUtil.getKeyValue(
                    constants.zoomLevel(),
                    zoomLevelString);
            
            this.latLabel = new Label(latText);
            this.lonLabel = new Label(lonText);
            this.zoomLabel = new Label(zoomText);
            this.add(this.latLabel);
            this.add(this.lonLabel);
            this.add(this.zoomLabel);
        }
    }
}
