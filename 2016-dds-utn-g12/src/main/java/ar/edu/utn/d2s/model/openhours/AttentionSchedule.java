package ar.edu.utn.d2s.model.openhours;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class AttentionSchedule {

    private Map<DayEnum, WorkHours> openHours;

    public AttentionSchedule(Map<DayEnum, WorkHours> openHours) {
        this.openHours = openHours;
    }

    //********** STATIC METHODS **********//

    /**
     * Obtains an AttentionSchedule with the same work hours for the entire
     * business week (From Monday to Saturday)
     * @return an AttentionSchedule
     */
    public static AttentionSchedule forBusinessWeek(WorkHours workHours) {
        Map<DayEnum, WorkHours> openHours = new HashMap<>();
        openHours.put(DayEnum.MONDAY, workHours);
        openHours.put(DayEnum.TUESDAY, workHours);
        openHours.put(DayEnum.WEDNESDAY, workHours);
        openHours.put(DayEnum.THURSDAY, workHours);
        openHours.put(DayEnum.FRIDAY, workHours);
        openHours.put(DayEnum.SATURDAY, workHours);
        return new AttentionSchedule(openHours);

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


    public Map<DayEnum, WorkHours> getOpenHours() {
        if (openHours == null) {
            openHours = new HashMap<>();
        }
        return openHours;
    }

    public void setOpenHours(HashMap<DayEnum, WorkHours> openHours) {
        this.openHours = openHours;
    }
}
