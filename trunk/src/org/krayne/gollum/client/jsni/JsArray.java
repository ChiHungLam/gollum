package org.krayne.gollum.client.jsni;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A {@code JsArray} lets us treat javascript arrays as a java object.
 * GWT (as of version 1.5.0) can only pass java arrays to javascript, but
 * the javascript is unable to read or access the array. It can only return
 * the array back the way it was passed in. We can create a {@code JsArray}
 * that we can use in Java which will be treated as a normal array in
 * javascript.
 * 
 * @author dhsu
 */
public class JsArray implements JsWrapper {
    private final JavaScriptObject jsArray;
    
    /**
     * Constructs an empty array object.
     */
    public JsArray() {
        this.jsArray = _newInstance();
    }
    
    /**
     * Wraps the specified javascript array as a {@code JsArray}.
     * 
     * @param jsArray the javavscript array
     */
    public JsArray(JavaScriptObject jsArray) {
        this.jsArray = jsArray;
    }
    
    /**
     * {@inheritDoc}
     */
    public JavaScriptObject getJavaScriptObject() {
        return this.jsArray;
    }
    
    /**
     * Appends an element to the array.
     * 
     * @param element the element to append
     */
    public void push(JavaScriptObject element) {
        _push(this.jsArray, element);
    }

    /**
     * Removes the last element in the array.
     */
    public void pop() {
        _pop(this.jsArray);
    }
    
    /**
     * Gets the length of the array.
     * 
     * @return the length of the array
     */
    public int length() {
        return _length(this.jsArray);
    }
    
    /**
     * Gets the element at the specified index.
     * 
     * @param index the element index
     * @return the element, null if the index was out of bounds
     */
    public JavaScriptObject get(int index) {
        if(index < this.length() && index >= 0) {
            return _get(this.jsArray, index);
        }
        return null;
    }
    
    /**
     * A convenience method to get the last element of the array.
     * 
     * @return the last element of the array
     */
    public JavaScriptObject getLast() {
        int length = this.length();
        if(length > 0) {
            return this.get(length - 1);
        }
        return null;
    }
    
    //--------------------------------------------------------------------------
    
    private static native JavaScriptObject _newInstance() /*-{
        return [];
    }-*/;
    
    private static native JavaScriptObject _push(JavaScriptObject jsArray, JavaScriptObject element) /*-{
        jsArray.push(element);
    }-*/;
    
    private static native JavaScriptObject _pop(JavaScriptObject jsArray) /*-{
        jsArray.pop();
    }-*/;
    
    private static native int _length(JavaScriptObject jsArray) /*-{
        return jsArray.length;
    }-*/;
    
    private static native JavaScriptObject _get(JavaScriptObject jsArray, int index) /*-{
        return jsArray[index];
    }-*/;
}
