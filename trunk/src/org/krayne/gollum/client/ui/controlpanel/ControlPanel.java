package org.krayne.gollum.client.ui.controlpanel;

import java.util.HashMap;
import java.util.Map;

import org.krayne.gollum.client.ui.util.WidgetContainer;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The {@code ControlPanel} holds most controls in a Goliath application.
 * It is split up into sections, and each section is meant to contain
 * related controls relevant to the application.
 * 
 * @author dhsu
 */
public class ControlPanel extends StackPanel {
    public static final String STYLE_NAME = "gollumControlPanel";
    private final Map<Widget, ControlPanelSection> sectionMap;
    private int selectedIndex;

    /**
     * Constructs an empty (no sections) {@code ControlPanel}.
     */
    public ControlPanel() {
        this.setStyleName(STYLE_NAME);
        this.sectionMap = new HashMap<Widget, ControlPanelSection>();
        this.updateSelectedIndex();
    }

    /**
     * Adds a section to the control panel.
     * 
     * @param section the control panel section
     */
    public void addSection(ControlPanelSection section) {
        WidgetContainer container = new WidgetContainer(section.getWidget());
        this.add(container, section.getName());
        this.sectionMap.put(container, section);
        this.updateSelectedIndex();
    }
    
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.updateSelectedIndex();
    }
    
    public void insert(Widget w, int beforeIndex) {
        super.insert(w, beforeIndex);
        this.updateSelectedIndex();
    }
    
    public boolean remove(int index) {
        boolean removed = super.remove(index);
        this.updateSelectedIndex();
        return removed;
    }
    
    public boolean remove(Widget child) {
        boolean removed = super.remove(child);
        this.updateSelectedIndex();
        return removed;
    }
    
    private void updateSelectedIndex() {
        int lastSelectedIndex = this.selectedIndex;
        this.selectedIndex = this.getSelectedIndex();
        if(lastSelectedIndex != this.selectedIndex) {
            try {
                Widget sectionWidget = this.getWidget(this.selectedIndex);
                ControlPanelSection selectedSection = this.sectionMap.get(sectionWidget);
                selectedSection.handleSelectEvent();
            } catch(Exception e) {}
            try {
                Widget sectionWidget = this.getWidget(lastSelectedIndex);
                ControlPanelSection unselectedSection = this.sectionMap.get(sectionWidget);
                unselectedSection.handleUnselectEvent();
            } catch(Exception e) {}
        }
    }
}
