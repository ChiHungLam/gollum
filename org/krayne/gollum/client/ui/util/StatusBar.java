package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

public class StatusBar extends DockPanel {
    public static final String STYLE_NAME = SharedStyles.STATUS_BAR;

    private final Label leftStatusLabel;
    private final Label rightStatusLabel;

    public StatusBar() {
        this.setStyleName(STYLE_NAME);
        this.addStyleName(SharedStyles.STRETCH);

        this.leftStatusLabel = new Label();
        this.rightStatusLabel = new Label();
        this.rightStatusLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

        this.add(this.leftStatusLabel, DockPanel.WEST);
        this.add(this.rightStatusLabel, DockPanel.EAST);
    }
    
    public void setLeftStatusLabelText(String text) {
        this.leftStatusLabel.setText(text);
    }
    
    public void setRightStatusLabelText(String text) {
        this.rightStatusLabel.setText(text);
    }
}
