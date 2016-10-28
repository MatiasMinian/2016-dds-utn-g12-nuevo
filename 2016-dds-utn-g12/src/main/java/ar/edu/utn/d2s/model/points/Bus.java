package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.config.PointOfInterestConfig;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import org.uqbar.geodds.Point;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bus extends PointOfInterest {

    private List<BusStop> stops;

    public Bus(String name, String icon, Address address, List<BusStop> stops) {
        super(name, icon, address);
        this.stops = stops;
        this.closeRange = PointOfInterestConfig.BUS_CLOSE_RANGE;
    }

    //********** METHODS **********//

    @Override
    public boolean isClose(Point point) {
        return stops.stream().anyMatch(stop -> point.distance(stop.getAddress().getPoint()) < this.closeRange);
    }

    @Override
    public boolean isOpen(DayEnum day, LocalTime time, String value) {
        return true;
    }

    //********** GETTERS & SETTERS **********//

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
