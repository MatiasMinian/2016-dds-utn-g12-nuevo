package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.openhours.DayEnum;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class BankBranch extends PointOfInterest {

    private Set<String> services;
    private String attentionSchedule;

    public BankBranch(String name, String icon, Address address, Set<String> services, String attentionSchedule) {
        super(name, icon, address);
        this.services = services;
        this.attentionSchedule = attentionSchedule;
    }

    //********** METHODS **********//

    @Override
    public boolean isOpen(DayEnum day, LocalTime time, String value) {
        // TODO Implement this method
        return false;
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

    public String getAttentionSchedule() {
        return attentionSchedule;
    }

    public void setAttentionSchedule(String attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}
