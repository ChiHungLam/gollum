package org.krayne.gollum.client.ui.controlpanel;

import com.google.gwt.user.client.ui.Widget;

public interface ControlPanelSection {

    String getName();
    
    Widget getWidget();
    
    public void handleSelectEvent();
    
    public void handleUnselectEvent();
}
