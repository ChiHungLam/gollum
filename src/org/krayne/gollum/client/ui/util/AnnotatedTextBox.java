package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AnnotatedTextBox extends TextBox {
    private static final String POPUP_STYLE_NAME = SharedStyles.TOOLTIP;
    private final PopupPanel popupPanel;
    
    public AnnotatedTextBox(String annotation) {
        this.popupPanel = new PopupPanel(false);
        this.popupPanel.setStyleName(POPUP_STYLE_NAME);
        this.popupPanel.setWidget(new Label(annotation));
        
        // annotation is shown when text box is in focus
        this.addFocusListener(new FocusListener() {
            public void onFocus(Widget sender) {
                int left = sender.getAbsoluteLeft();
                int top = sender.getAbsoluteTop() + sender.getOffsetHeight();
                AnnotatedTextBox.this.popupPanel.setPopupPosition(left, top);
                AnnotatedTextBox.this.popupPanel.show();
            }

            public void onLostFocus(Widget sender) {
                AnnotatedTextBox.this.popupPanel.hide();
            }
        });
        
        // hitting escape removes focus
        this.addKeyboardListener(new KeyboardListenerAdapter() {
            public void onKeyUp(Widget sender, char keyCode, int modifiers) {
                if(keyCode == (char) KeyboardListener.KEY_ESCAPE) {
                    AnnotatedTextBox.this.setFocus(false);
                }
            }
        });
    }
}
