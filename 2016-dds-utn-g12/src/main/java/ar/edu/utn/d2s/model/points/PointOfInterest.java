package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.config.PointOfInterestConfig;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import org.uqbar.geodds.Point;

import java.time.LocalTime;

public abstract class PointOfInterest {

    protected Long id;
    protected String name;
    protected String icon;
    protected Address address;
    protected double closeRange = PointOfInterestConfig.POI_CLOSE_RANGE;

    public PointOfInterest(String name, String icon, Address address) {
        this.name = name;
        this.icon = icon;
        this.address = address;
    }

    //********** METHODS **********//

    public boolean isClose(Point point) {
        return point.distance(address.getPoint()) < closeRange;
    }

    public abstract boolean isOpen(DayEnum day, LocalTime time, String value);


    //********** GETTERS & SETTERS **********//


    public Long getId() {
        return id;
    }

    public String getName() {
        if(name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        if (icon == null) {
            icon = "";
        }
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getCloseRange() {
        return closeRange;
    }

    public void setCloseRange(double closeRange) {
        this.closeRange = closeRange;
    }
}
