package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;

import java.util.List;

public class BankBranch extends PointOfInterest {

    private List<String> services;
    private String attentionSchedule;

    public BankBranch(String name, String icon, Address address, List<String> services, String attentionSchedule) {
        super(name, icon, address);
        this.services = services;
        this.attentionSchedule = attentionSchedule;
    }

    //********** METHODS **********//

    //********** GETTERS & SETTERS **********//


    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getAttentionSchedule() {
        return attentionSchedule;
    }

    public void setAttentionSchedule(String attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}
