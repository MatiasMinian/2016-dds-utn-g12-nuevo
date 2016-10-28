package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.openhours.AttentionSchedule;
import ar.edu.utn.d2s.model.openhours.DayEnum;

import java.time.LocalTime;
import java.util.Calendar;

public class Service {

    private String name;
    private AttentionSchedule attentionSchedule;

    public Service(String name, AttentionSchedule attentionSchedule) {
        this.name = name;
        this.attentionSchedule = attentionSchedule;
    }

    //********** METHODS **********//

    public boolean isOpen(DayEnum day, LocalTime time) {
        return attentionSchedule.isOpenHour(day, time);
    }

    //********** GETTERS & SETTERS **********//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttentionSchedule getAttentionSchedule() {
        return attentionSchedule;
    }

    public void setAttentionSchedule(AttentionSchedule attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}
