package ar.edu.utn.d2s.model.openhours;

import java.time.LocalTime;

public enum DayEnum {

    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    DayEnum(String name) {
        this.name = name;
    }

    public static DayEnum getDayByName(String dayName) {
        if (dayName.equalsIgnoreCase(MONDAY.getName())) {
            return MONDAY;
        }

        if (dayName.equalsIgnoreCase(TUESDAY.getName())) {
            return TUESDAY;
        }

        if (dayName.equalsIgnoreCase(WEDNESDAY.getName())) {
            return WEDNESDAY;
        }

        if (dayName.equalsIgnoreCase(THURSDAY.getName())) {
            return THURSDAY;
        }

        if (dayName.equalsIgnoreCase(FRIDAY.getName())) {
            return FRIDAY;
        }

        if (dayName.equalsIgnoreCase(SATURDAY.getName())) {
            return SATURDAY;
        }

        if (dayName.equalsIgnoreCase(SUNDAY.getName())) {
            return SUNDAY;
        }

        throw new IllegalArgumentException("Field dayName is not a valid name for a day.");
    }

    public String getName() {
        return name;
    }
}
