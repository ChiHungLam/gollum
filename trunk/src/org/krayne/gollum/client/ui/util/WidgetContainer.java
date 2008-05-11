package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A container widget that holds any widget. This can be used to style
 * multiple components with a uniform style.
 * 
 * @author dhsu
 */
public class WidgetContainer extends DockPanel {
    public static final String STYLE_NAME = "gollumWidgetContainer";
    
    /**
     * Constructs a {@code WidgetContainer} that holds the
     * specified widget.
     * 
     * @param w the contained widget
     */
    public WidgetContainer(Widget w) {
        this.setStyleName(STYLE_NAME);
        this.add(w, DockPanel.CENTER);
    }
}
