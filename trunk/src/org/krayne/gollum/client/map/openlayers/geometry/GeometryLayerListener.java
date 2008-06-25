package org.krayne.gollum.client.map.openlayers.geometry;

public interface GeometryLayerListener<T extends Geometry> {
    void handleAddEvent(int geometryIndex, T geometry);
    void handleSelectEvent(int geometryIndex, T geometry);
    void handleUnselectEvent(int geometryIndex, T geometry);
    void handleClearEvent();
}
