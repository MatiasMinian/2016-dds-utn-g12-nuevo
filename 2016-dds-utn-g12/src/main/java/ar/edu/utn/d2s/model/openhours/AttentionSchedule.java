package ar.edu.utn.d2s.model.openhours;

import java.time.LocalTime;
import java.util.HashMap;

public class AttentionSchedule {

    private HashMap<DayEnum, WorkHours> openHours;

    public AttentionSchedule(HashMap<DayEnum, WorkHours> openHours) {
        this.openHours = openHours;
    }

    //********** METHODS **********//

    public boolean isOpenHour(DayEnum day, LocalTime time) {
        if (getOpenHours().isEmpty()) {
            throw new RuntimeException("Attention Schedule doesn't have any open day. Must have one at least");
        }
        WorkHours workHours = openHours.get(day);
        if (workHours == null) {
            return false;
        }
        return time.isAfter(workHours.getStartTime()) && time.isBefore(workHours.getEndTime());
    }

    //********** GETTERS & SETTERS **********//


    public HashMap<DayEnum, WorkHours> getOpenHours() {
        if (openHours == null) {
            openHours = new HashMap<>();
        }
        return openHours;
    }

    public void setOpenHours(HashMap<DayEnum, WorkHours> openHours) {
        this.openHours = openHours;
    }
}
