package org.krayne.gollum.client.ui.map;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.StaticBookmark;
import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;
import org.krayne.gollum.client.map.LatLon;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.util.AnnotatedTextBox;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LocationBar extends HorizontalPanel {
    private static final int TEXTBOX_VISIBLE_LENGTH = 12;
    private static final int TEXTBOX_MAX_LENGTH = 15;
    private final Map map;
    private final TextBox latField;
    private final TextBox lonField;
    private final Hyperlink goButton;
    
    public LocationBar(Map map) {
        this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        this.map = map;
        
        LocaleConstants localeConstants = Locale.getConstants();
        
        this.latField = new AnnotatedTextBox(localeConstants.latitudeInDegrees());
        this.lonField = new AnnotatedTextBox(localeConstants.longitudeInDegrees());
        this.latField.setVisibleLength(TEXTBOX_VISIBLE_LENGTH);
        this.lonField.setVisibleLength(TEXTBOX_VISIBLE_LENGTH);
        this.latField.setMaxLength(TEXTBOX_MAX_LENGTH);
        this.lonField.setMaxLength(TEXTBOX_MAX_LENGTH);
        this.latField.addKeyboardListener(new MyKeyboardListener());
        this.lonField.addKeyboardListener(new MyKeyboardListener());
        
        this.goButton = new Hyperlink(localeConstants.enterValidLocation(), "jump");
        this.goButton.addClickListener(new MyClickListener());

        this.setSpacing(2);
        this.add(latField);
        this.add(lonField);
        this.add(goButton);
    }
    
    public LatLon getInputLatLon() throws NumberFormatException {
        double latDegrees = Double.parseDouble(LocationBar.this.latField.getText());
        double lonDegrees = Double.parseDouble(LocationBar.this.lonField.getText());
        return new LatLon(latDegrees, lonDegrees);
    }
    
    public boolean jumpToInputLocation() {
        try {
            LatLon latLon = this.getInputLatLon();
            Bookmark bookmark = new StaticBookmark(latLon.toString(), latLon);
            LocationBar.this.map.jumpTo(bookmark);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
    //--------------------------------------------------------------------------
    
    private class MyClickListener implements ClickListener {
        public void onClick(Widget sender) {
            LocationBar.this.jumpToInputLocation();
        }
    }
    
    private class MyKeyboardListener extends KeyboardListenerAdapter {
        public void onKeyUp(Widget sender, char keyCode, int modifiers) {
            LocaleConstants localeConstants = Locale.getConstants();
            String buttonText = localeConstants.jump();
            try {
                LatLon latLon = LocationBar.this.getInputLatLon();
                if(!latLon.isValid()) {
                    throw new NumberFormatException();
                }
            } catch(NumberFormatException e) {
                buttonText = localeConstants.enterValidLocation();
            }
            LocationBar.this.goButton.setText(buttonText);
            
            if(keyCode == (char) KeyboardListener.KEY_ENTER) {
                LocationBar.this.jumpToInputLocation();
                LocationBar.this.latField.setFocus(false);
                LocationBar.this.lonField.setFocus(false);
            }
        }
    }
}
