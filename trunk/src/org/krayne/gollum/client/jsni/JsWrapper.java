package org.krayne.gollum.client.jsni;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An interface for some object that we can get a {@code JavaScriptObject} out
 * of. This is used for objects we would like to use with JSNI.
 * @author dhsu
 *
 */
public interface JsWrapper {
    /**
     * Gets the {@code JavaScriptObject}.
     * 
     * @return a {@code JavaScriptObject}
     */
    JavaScriptObject getJavaScriptObject();
}
