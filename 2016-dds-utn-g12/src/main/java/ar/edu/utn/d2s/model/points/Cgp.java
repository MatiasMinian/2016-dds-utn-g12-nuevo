package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;

public class Cgp extends PointOfInterest {

    Commune commune;

    //TODO Take this constructor out and create corresponding one when all fields are defined
    public Cgp(String name, String icon, Address address) {
        super(name, icon, address);
    }
}
