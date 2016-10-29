package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.openhours.TimeSchedule;
import ar.edu.utn.d2s.model.openhours.DayEnum;

import java.time.LocalTime;

public class Service {

    private String name;
    private TimeSchedule timeSchedule;

    public Service(String name, TimeSchedule timeSchedule) {
        this.name = name;
        this.timeSchedule = timeSchedule;
    }

    //********** METHODS **********//

    public boolean isOpen(DayEnum day, LocalTime time) {
        return timeSchedule.isOpenHour(day, time);
    }

    //********** GETTERS & SETTERS **********//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeSchedule getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(TimeSchedule timeSchedule) {
        this.timeSchedule = timeSchedule;
    }
}
