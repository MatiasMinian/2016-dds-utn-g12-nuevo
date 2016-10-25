package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;

public class PointOfInterest {

    private String name;
    private String icon;
    private Address address;

    public PointOfInterest(String name, String icon, Address address) {
        this.name = name;
        this.icon = icon;
        this.address = address;
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
}
