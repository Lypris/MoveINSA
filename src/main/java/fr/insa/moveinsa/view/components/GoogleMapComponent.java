package fr.insa.moveinsa.view.components;

import com.flowingcode.vaadin.addons.googlemaps.GoogleMap;
import com.flowingcode.vaadin.addons.googlemaps.GoogleMap.MapType;
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPolygon;
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPoint;
import com.flowingcode.vaadin.addons.googlemaps.LatLon;
import com.vaadin.flow.component.html.Div;

import java.util.Arrays;

public class GoogleMapComponent extends Div {

   public GoogleMapComponent(String apiKey) {
    GoogleMap gmaps = new GoogleMap(apiKey, null, null);
    gmaps.setMapType(MapType.SATELLITE);
    gmaps.setSizeFull();
    double lat = 48.5839;  // Default coordinates (Strasbourg)
    double lng = 7.7455;
    gmaps.setCenter(new LatLon(lat, lng));
    gmaps.addMarker("Center", new LatLon(lat, lng), true, "");
    add(gmaps);
}
}