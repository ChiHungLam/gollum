package org.krayne.gollum.client.jsni;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A generic factory that produces {@code JsWrapper}s of a particular type
 * given a {@code JavaScriptObject}.
 * 
 * @author dhsu
 *
 * @param <T> the type of {@code JsWrapper} this factory produces
 */
public interface JsWrapperFactory<T extends JsWrapper> {
    
    /**
     * Wraps the specified {@code JavaScriptObject} in a particular type
     * of {@code JsWrapper}.
     * 
     * @param jsObject the javascript object to be wrapped
     * @return the wrapped javascript object
     */
    T wrap(JavaScriptObject jsObject);
}
