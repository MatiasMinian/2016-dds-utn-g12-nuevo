package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.openhours.DayEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CgpTest {

    private Cgp cgp;

    @Before
    public void setUp() throws Exception {

        Service service1 = mock(Service.class);
        when(service1.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0))).thenReturn(true);
        when(service1.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0))).thenReturn(false);
        when(service1.getName()).thenReturn("Service1");

        Service service2 = mock(Service.class);
        when(service2.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0))).thenReturn(false);
        when(service2.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0))).thenReturn(false);
        when(service2.getName()).thenReturn("Service2");

        Service service3 = mock(Service.class);
        when(service3.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0))).thenReturn(false);
        when(service3.isOpen(DayEnum.TUESDAY, LocalTime.of(12, 0))).thenReturn(false);
        when(service3.getName()).thenReturn("Service3");

        Set<Service> services = new HashSet<>();
        services.add(service1);
        services.add(service2);
        services.add(service3);

        cgp = new Cgp("CGP", "", null, null, services);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isOpenTest() throws Exception {
        assertTrue(cgp.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0), null));
        assertTrue(cgp.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0), "Service1"));
        assertFalse(cgp.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0), "Service2"));

        assertFalse(cgp.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0), null));
        assertFalse(cgp.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0), "Service1"));
        assertFalse(cgp.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0), "Service2"));
        assertFalse(cgp.isOpen(DayEnum.TUESDAY, LocalTime.of(18, 0), "Service3"));
    }
}