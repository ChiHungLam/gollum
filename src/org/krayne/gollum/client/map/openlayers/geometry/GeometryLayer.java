package org.krayne.gollum.client.map.openlayers.geometry;

import org.krayne.gollum.client.map.openlayers.Control;
import org.krayne.gollum.client.map.openlayers.Style;

public interface GeometryLayer<G extends Geometry> {
    Control getDrawControl();
    Control getSelectControl();
    void addLayerListener(GeometryLayerListener<G> listener);
    void removeLayerListener(GeometryLayerListener<G> listener);
    void add(G geometry);
    void add(G geometry, Style style);
    void setDefaultStyle(Style style);
    void setSelectStyle(Style style);
    int getCount();
    G getGeometry(int index);
    void clear();
}
