package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import ar.edu.utn.d2s.model.openhours.TimeSchedule;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class BankBranch extends PointOfInterest {

    private Set<String> services;
    private TimeSchedule timeSchedule;

    public BankBranch(String name, String icon, Address address, Set<String> services, TimeSchedule timeSchedule) {
        super(name, icon, address);
        this.services = services;
        this.timeSchedule = timeSchedule;
    }

    //********** METHODS **********//

    @Override
    public boolean isOpen(DayEnum day, LocalTime time, String serviceName) {
        if (getServices().isEmpty()) {
            throw new RuntimeException("BankBranch doesn't have services. Must have one at least.");
        }

        if (!services.contains(serviceName)) {
            throw new IllegalArgumentException("Field serviceName must have a valid name of a service.");
        }

        return timeSchedule.isOpenHour(day, time);
    }

    //********** GETTERS & SETTERS **********//


    public Set<String> getServices() {
        if (services == null) {
            services = new HashSet<>();
        }
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }

    public TimeSchedule getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(TimeSchedule timeSchedule) {
        this.timeSchedule = timeSchedule;
    }
}
