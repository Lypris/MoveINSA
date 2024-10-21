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
        gmaps.setCenter(new LatLon(0, 0));
        gmaps.addMarker("Center", new LatLon(0, 0), true, "");
        GoogleMapPolygon gmp = gmaps.addPolygon(Arrays.asList(new GoogleMapPoint(gmaps.getCenter()),
                new GoogleMapPoint(gmaps.getCenter().getLat(), gmaps.getCenter().getLon() + 1),
                new GoogleMapPoint(gmaps.getCenter().getLat() + 1, gmaps.getCenter().getLon())));
        add(gmaps);
    }
}