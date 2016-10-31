package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BankBranchTest {

    BankBranch bankHSBC;

    @Before
    public void setUp() throws Exception {

        Address address = mock(Address.class);
        when(address.getPoint()).thenReturn(new Point(-34.604351, -58.458408)); // Av. Juan B. Justo almost Av. San Martin

        bankHSBC = new BankBranch("HSBC", "", address, null, null);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isCloseTest() throws Exception {
        assertTrue(bankHSBC.isClose(new Point(-34.606647, -58.461713)));
        assertFalse(bankHSBC.isClose(new Point(-34.624223, -58.483748)));
    }
}