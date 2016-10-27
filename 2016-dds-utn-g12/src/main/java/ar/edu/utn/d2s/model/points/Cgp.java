package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import org.uqbar.geodds.Point;

import java.util.List;

public class Cgp extends PointOfInterest {

    private Commune commune;
    private List<Service> services;

    public Cgp(String name, String icon, Address address, Commune commune, List<Service> services) {
        super(name, icon, address);
        this.commune = commune;
        this.services = services;
    }

    //********** METHODS **********//

    @Override
    public boolean isClose(Point point) {
        return commune.hasPointInside(point);
    }

    //********** GETTERS & SETTERS **********//

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
