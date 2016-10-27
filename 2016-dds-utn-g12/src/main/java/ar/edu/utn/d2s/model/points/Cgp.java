package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import org.uqbar.geodds.Point;

import java.util.*;

public class Cgp extends PointOfInterest {

    private Commune commune;
    private Set<Service> services;

    public Cgp(String name, String icon, Address address, Commune commune, Set<Service> services) {
        super(name, icon, address);
        this.commune = commune;
        this.services = services;
    }

    //********** METHODS **********//

    @Override
    public boolean isClose(Point point) {
        return commune.hasPointInside(point);
    }

    @Override
    public boolean isOpen(Calendar date, String serviceName) {
        if (getServices().isEmpty()) {
            throw new RuntimeException("CGP doesn't have services. Should have one at least.");
        }

        if (serviceName == null) {
            return getServices().stream().anyMatch(service -> service.isOpen(date));
        } else {
            Optional<Service> serviceOptional = services.stream().filter(service -> service.getName().equals(serviceName)).findFirst();
            return serviceOptional.orElseThrow(() -> new IllegalArgumentException("Field serviceName must have a valid name of a service.")).isOpen(date);
        }
    }

    //********** GETTERS & SETTERS **********//

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Set<Service> getServices() {
        if (services == null) {
            return new HashSet<>();
        }
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
