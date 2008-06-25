package org.krayne.gollum.client.ui;

import org.krayne.gollum.client.localization.Locale;
import org.krayne.gollum.client.localization.LocaleConstants;
import org.krayne.gollum.client.ui.util.SharedStyles;
import org.krayne.gollum.client.ui.util.WidgetContainer;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DetailsPanel extends DockPanel {
    private static final Widget EMPTY_WIDGET = new Label(" ");
    private static final String DISCLOSURE_PANEL_STYLE_NAME = "gollumDetailsPanel";
    private static final boolean DEFAULT_IS_OPEN = true;
    private final DisclosurePanel disclosurePanel;
    private final Label headerLabel;
    
    public DetailsPanel() {
        LocaleConstants localeConstants = Locale.getConstants();
        this.headerLabel = new Label(localeConstants.defaultDetailsHeading());
        this.disclosurePanel = new DisclosurePanel(this.headerLabel);
        this.disclosurePanel.setStyleName(DISCLOSURE_PANEL_STYLE_NAME);
        this.disclosurePanel.addStyleName(SharedStyles.STRETCH);
        this.disclosurePanel.setOpen(DEFAULT_IS_OPEN);
        this.setWidget(EMPTY_WIDGET);
        this.add(this.disclosurePanel, DockPanel.CENTER);
    }
    
    public void setHeaderText(String text) {
        this.headerLabel.setText(text);
    }
    
    public void setWidget(Widget w) {
        this.disclosurePanel.setContent(new WidgetContainer(w));
    }
    
    public void removeWidget() {
        this.setWidget(EMPTY_WIDGET);
    }
}
