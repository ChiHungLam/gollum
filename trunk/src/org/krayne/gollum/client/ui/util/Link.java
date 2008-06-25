package org.krayne.gollum.client.ui.util;

import com.google.gwt.user.client.ui.HTML;

public class Link extends HTML {
    public Link(String name) {
        this(name, null);
    }
    
    public Link(String name, String styleName) {
        String html = "<a onmouseover=\"status='';return true;\" href=\"#\" ";
        if(styleName != null) {
            html = html + "class=\"" + styleName + "\"";
        }
        html = html + ">" + name + "</a>";
        this.setHTML(html);
    }
}
