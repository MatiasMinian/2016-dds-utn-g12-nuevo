package ar.edu.utn.d2s.model.points;

import java.util.Calendar;

public class Service {

    private String name;
    // TODO Change it for corresponding object
    private String AttentionSchedule;

    // TODO Constructor

    //********** METHODS **********//

    public boolean isOpen(Calendar date) {
        // TODO Implement this method
        return false;
    }

    //********** GETTERS & SETTERS **********//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttentionSchedule() {
        return AttentionSchedule;
    }

    public void setAttentionSchedule(String attentionSchedule) {
        AttentionSchedule = attentionSchedule;
    }
}
