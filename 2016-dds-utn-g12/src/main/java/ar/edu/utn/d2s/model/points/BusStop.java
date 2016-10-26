package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;

public class BusStop {

    private Address address;

    public BusStop(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
