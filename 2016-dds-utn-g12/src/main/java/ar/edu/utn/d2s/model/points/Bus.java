package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;

import java.util.ArrayList;
import java.util.List;

public class Bus extends PointOfInterest {

    List<BusStop> stops;

    public Bus(String name, String icon, Address address, List<BusStop> stops) {
        super(name, icon, address);
        this.stops = stops;
    }

    public List<BusStop> getStops() {
        if (stops == null) {
            stops = new ArrayList<>();
        }
        return stops;
    }

    public void setStops(List<BusStop> stops) {
        this.stops = stops;
    }
}
