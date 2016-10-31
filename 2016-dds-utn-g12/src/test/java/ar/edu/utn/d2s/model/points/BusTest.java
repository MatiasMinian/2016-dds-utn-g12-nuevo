package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BusTest {

    private Bus bus114;

    @Before
    public void setUp() throws Exception {

        byte nullByte = Byte.parseByte("0");

        BusStop stop1 = mock(BusStop.class);
        when(stop1.getAddress()).thenReturn(new Address(null, null, null, 0, nullByte, nullByte, nullByte, nullByte, null, null, null, null,
                new Point(-34.608357, -58.380407))); // Av. Rivadavia almost Av. 9 de Julio

        BusStop stop2 = mock(BusStop.class);
        when(stop2.getAddress()).thenReturn(new Address(null, null, null, 0, nullByte, nullByte, nullByte, nullByte, null, null, null, null,
                new Point(-34.604591, -58.405802))); // Av. Corrientes almost Av. Pueyrredon

        Set<BusStop> stops = new HashSet<>();
        stops.add(stop1);
        stops.add(stop2);


        bus114 = new Bus("114", "", null, stops);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isCloseTest() throws Exception {
        assertTrue(bus114.isClose(new Point(-34.604150, -58.405333)));
        assertTrue(bus114.isClose(new Point(-34.608391, -58.381113)));
        assertFalse(bus114.isClose(new Point(-34.659685, -58.468769))); // UTN Lugano address

    }

    @Test
    public void isOpenTest() throws Exception {
        assertTrue(bus114.isOpen(DayEnum.MONDAY, LocalTime.of(12, 0), ""));
        assertTrue(bus114.isOpen(DayEnum.WEDNESDAY, LocalTime.of(12, 0), ""));
        assertTrue(bus114.isOpen(DayEnum.SATURDAY, LocalTime.of(12, 0), ""));

        assertTrue(bus114.isOpen(DayEnum.MONDAY, LocalTime.of(23, 0), ""));
        assertTrue(bus114.isOpen(DayEnum.TUESDAY, LocalTime.of(23, 0), ""));
        assertTrue(bus114.isOpen(DayEnum.SUNDAY, LocalTime.of(23, 0), ""));
    }
}