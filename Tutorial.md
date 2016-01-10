
---


### Step 1 ###

Using gollum is like using any other GWT module. Simply add the following line in your module xml file:

`<inherits name='org.krayne.gollum.Gollum'/>`


---


### Step 2 ###

Add the gollum jar to the classpath of your shell and compile scripts created by GWT.


---


### Step 3 ###

You need to create a `div` in your project's html file that will be replaced with the Gollum UI. The following is a sample html file in the `public` folder of your GWT project.

```
<html>
    <head>
        <title>Gollum Test</title>

        <!-- map scripts -->
        <script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAA8XqpSOkvALpfwaOo2BYzDxTwM0brOpm-All5BF6PoaKBxRWWERTUDxiDtbPuxCo_5VOntOgI6pp2Nw"></script>

        <!--                                           -->
        <!-- This script loads your compiled module.   -->
        <!-- If you add any GWT meta tags, they must   -->
        <!-- be added before this line.                -->
        <!--                                           -->
        <script language='javascript' src='org.krayne.gollumtest.GollumTest.nocache.js'></script>
    </head>
    <body>
        <!-- OPTIONAL: include this if you want history support -->
        <iframe src="javascript:''" id="__gwt_historyFrame" style="width:0;height:0;border:0"></iframe>
        <div id="gollum"></div>
    </body>
</html>
```


---


### Step 4 ###

You must replace the targeted `div` from step 3 with a `GollumPanel`. The most common place to do this is in your project's `EntryPoint`. For example:

```
package org.krayne.gollumtest.client;

import org.krayne.gollum.client.bookmarks.Bookmark;
import org.krayne.gollum.client.bookmarks.StaticBookmark;
import org.krayne.gollum.client.debug.DebugBookmarksSource;
import org.krayne.gollum.client.map.LatLon;
import org.krayne.gollum.client.map.Map;
import org.krayne.gollum.client.ui.GollumPanel;
import org.krayne.gollum.client.ui.controlpanel.bookmarkssection.BookmarksSection;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GollumTest implements EntryPoint {
    private static final Bookmark DEFAULT_START_BOOKMARK = new StaticBookmark("Start", new LatLon(34.055389, -118.249789), new Integer(3));
    private final GollumPanel gollumPanel;
    
    public GollumTest() {
        this.gollumPanel = new GollumPanel(true);
        Map map = this.gollumPanel.getMap();
        
        BookmarksSection bookmarksSection = new BookmarksSection(map);
        bookmarksSection.addSource(new DebugBookmarksSource());
        this.gollumPanel.addControlPanelSection(bookmarksSection);
    }
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("gollum").add(this.gollumPanel);
        Map map = this.gollumPanel.getMap();
        map.jumpTo(DEFAULT_START_BOOKMARK);
    }
}
```