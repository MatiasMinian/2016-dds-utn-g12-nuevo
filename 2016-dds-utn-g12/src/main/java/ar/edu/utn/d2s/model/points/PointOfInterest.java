package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.Address;

public class PointOfInterest {

    String name;
    String icon;
    Address address;

    public PointOfInterest(String name, String icon, Address address) {
        this.name = name;
        this.icon = icon;
        this.address = address;
    }

    public String getName() {
        if(name == null) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        if (icon == null) {
            return "";
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
}
