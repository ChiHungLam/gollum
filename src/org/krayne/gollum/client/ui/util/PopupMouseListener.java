package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A {@code PopupMouseListener} is a general mouse listener that will
 * display a popup when the mouse rolls over some parent widget. The popup follows
 * the mouse and immediately shows up when the mouse is over the parent widget.
 * It immediately disappears as the mouse rolls off the parent widget.
 * 
 * This can be useful if you want to display some detailed information that
 * shouldn't be taking up precious screen real estate. It's also more
 * responsive and flexible compared to the standard tooltips.
 * 
 * author dhsu
 */
public class PopupMouseListener extends MouseListenerAdapter {
    public static final String STYLE_NAME = SharedStyles.TOOLTIP;
    private static final int DEFAULT_X_OFFSET = 10;
    private static final int DEFAULT_Y_OFFSET = 10;
    private final PopupPanel popupPanel;
    private int xOffsetPixels;
    private int yOffsetPixels;

    /**
     * Constructs a {@code PopupMouseListener} with the specified widget.
     * The popup will follow the mouse at some default offset.
     * 
     * @param popupWidget the popup widget
     */
    public PopupMouseListener(Widget popupWidget) {
        this(popupWidget, DEFAULT_X_OFFSET, DEFAULT_Y_OFFSET);
    }
    
    /**
     * Constructs a {@code PopupMouseListener} with the specified widget,
     * following the mouse at the specified offset.
     * 
     * @param popupWidget the popup widget
     * @param xOffsetPixels the x offset in pixels
     * @param yOffsetPixels the y offset in pixels
     */
    public PopupMouseListener(Widget popupWidget, int xOffsetPixels, int yOffsetPixels) {
        this.popupPanel = new PopupPanel(true);
        this.popupPanel.setStyleName(STYLE_NAME);
        this.setPopupWidget(popupWidget);
        this.setOffset(xOffsetPixels, yOffsetPixels);
    }
    
    /**
     * Replaces the current popup widget with the one specified.
     * 
     * @param popupWidget the new popup widget
     */
    public void setPopupWidget(Widget popupWidget) {
        this.popupPanel.setWidget(popupWidget);
    }
    
    /**
     * Sets the popup to mouse offset.
     * 
     * @param xOffsetPixels the x offset in pixels
     * @param yOffsetPixels the y offset in pixels
     */
    public void setOffset(int xOffsetPixels, int yOffsetPixels) {
        this.xOffsetPixels = xOffsetPixels;
        this.yOffsetPixels = yOffsetPixels;
    }
    
    /**
     * {@inheritDoc}
     */
    public void onMouseEnter(Widget sender) {
        this.popupPanel.show();
    }

    /**
     * {@inheritDoc}
     */
    public void onMouseLeave(Widget sender) {
        this.popupPanel.hide();
    }

    /**
     * {@inheritDoc}
     */
    public void onMouseMove(Widget sender, int x, int y) {
        int left = sender.getAbsoluteLeft() + x + this.xOffsetPixels;
        int top = sender.getAbsoluteTop() + y + this.yOffsetPixels;
        this.popupPanel.setPopupPosition(left, top);
    }
}
