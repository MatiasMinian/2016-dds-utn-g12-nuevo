package ar.edu.utn.d2s.model.openhours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TimeScheduleTest {

    private TimeSchedule timeSchedule;

    @Before
    public void setUp() throws Exception {

        Map<DayEnum, WorkHours> openHours = new HashMap<>();
        openHours.put(DayEnum.MONDAY, new WorkHours(LocalTime.of(10, 15), LocalTime.of(18, 0)));
        openHours.put(DayEnum.WEDNESDAY, new WorkHours(LocalTime.of(11,0), LocalTime.of(17,0)));
        timeSchedule = new TimeSchedule(openHours);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isOpenHourTest() throws Exception {
        assertTrue(timeSchedule.isOpenHour(DayEnum.MONDAY, LocalTime.of(14, 0)));
        assertTrue(timeSchedule.isOpenHour(DayEnum.WEDNESDAY, LocalTime.of(11, 15)));

        assertFalse(timeSchedule.isOpenHour(DayEnum.MONDAY, LocalTime.of(10, 0)));
        assertFalse(timeSchedule.isOpenHour(DayEnum.FRIDAY, LocalTime.of(12, 0)));
    }
}