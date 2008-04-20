package org.krayne.gollum.client.ui.controlpanel;

import org.krayne.gollum.client.ui.util.WidgetContainer;

import com.google.gwt.user.client.ui.StackPanel;

/**
 * The {@code ControlPanel} holds most controls in a Goliath application.
 * It is split up into sections, and each section is meant to contain
 * related controls relevant to the application.
 * 
 * @author dhsu
 */
public class ControlPanel extends StackPanel {
    public static final String STYLE_NAME = "controlPanel";

    /**
     * Constructs an empty (no sections) {@code ControlPanel}.
     */
    public ControlPanel() {
        this.setStyleName(STYLE_NAME);
    }

    /**
     * Adds a section to the control panel.
     * 
     * @param section the control panel section
     */
    public void addSection(ControlPanelSection section) {
        WidgetContainer container = new WidgetContainer(section.getWidget());
        this.add(container, section.getName());
    }
}
