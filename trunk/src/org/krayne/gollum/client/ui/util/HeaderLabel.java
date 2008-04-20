package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.Label;

public class HeaderLabel extends Label {
    public static final String STYLE_NAME = "headerLabel";
    
    public HeaderLabel() {
        super();
        this.addStyleName(STYLE_NAME);
    }
    
    public HeaderLabel(String text) {
        super(text);
        this.addStyleName(STYLE_NAME);
    }
    
    public HeaderLabel(String text, boolean wordWrap) {
        super(text, wordWrap);
        this.addStyleName(STYLE_NAME);
    }
}
