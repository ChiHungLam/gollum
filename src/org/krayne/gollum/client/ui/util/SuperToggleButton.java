package org.krayne.gollum.client.ui.util;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ToggleButton;

/**
 * A {@code SuperToggleButton} lets the user programmatically "click" the
 * toggle button.
 * 
 * @author dhsu
 */
public class SuperToggleButton extends ToggleButton {
    private final Collection<ClickListener> clickListeners;
    
    public SuperToggleButton() {
        super();
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(Image upImage, ClickListener listener) {
        super(upImage, listener);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(Image upImage, Image downImage, ClickListener listener) {
        super(upImage, downImage, listener);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(Image upImage, Image downImage) {
        super(upImage, downImage);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(Image upImage) {
        super(upImage);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(String upText, ClickListener listener) {
        super(upText, listener);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(String upText, String downText) {
        super(upText, downText);
        this.clickListeners = new ArrayList<ClickListener>();
    }

    public SuperToggleButton(String upText) {
        super(upText);
        this.clickListeners = new ArrayList<ClickListener>();
    }
    
    public void addClickListener(ClickListener listener) {
        super.addClickListener(listener);
        this.clickListeners.add(listener);
    }
    
    public void removeClickListener(ClickListener listener) {
        super.removeClickListener(listener);
        this.clickListeners.remove(listener);
    }
    
    public void fireClickEvent() {
        for(ClickListener listener : this.clickListeners) {
            listener.onClick(this);
        }
    }
}
