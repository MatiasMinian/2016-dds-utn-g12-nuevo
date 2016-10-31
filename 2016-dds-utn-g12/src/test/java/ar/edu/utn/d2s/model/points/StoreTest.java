package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class StoreTest {

    private Store store;

    @Before
    public void setUp() throws Exception {

        Address address = mock(Address.class);
        when(address.getPoint()).thenReturn(new Point(-34.580691, -58.421132)); // Plaza Italia

        Category category = mock(Category.class);
        when(category.getCloseRange()).thenReturn(0.9);

        store = new Store("Store", "", address, null, category, null);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isCloseTest() throws Exception {
        assertTrue(store.isClose(new Point(-34.577246, -58.429091)));
        assertFalse(store.isClose(new Point(-34.576460, -58.431999)));
    }
}