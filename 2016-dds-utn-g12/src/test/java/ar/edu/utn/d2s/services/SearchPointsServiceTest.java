package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.database.BankBranchDAOMock;
import ar.edu.utn.d2s.database.BusDAOMock;
import ar.edu.utn.d2s.database.CgpDAOMock;
import ar.edu.utn.d2s.database.StoreDAOMock;
import ar.edu.utn.d2s.model.points.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SearchPointsServiceTest {

    private DefaultSearchPointsService defaultSearchPointsService;

    private BankBranch bankBranchHSBC;
    private BankBranch bankBranchBankNorth;
    private BankBranch bankBranchBankWest;

    private Bus bus114;
    private Bus bus161;
    private Bus bus157;

    private Cgp cgp30;
    private Cgp cgp110;
    private Cgp cgp54;

    private Store storeSamsung;
    private Store storeBookshop;
    private Store storeTech;


    @Before
    public void setUp() throws Exception {

        defaultSearchPointsService = new DefaultSearchPointsService();

        //********** BANK BRANCH SET UP **********//

        bankBranchHSBC = new BankBranch("HSBC", "", null, null, null);
        bankBranchBankNorth = new BankBranch("Bank North", "", null, null, null);
        bankBranchBankWest = new BankBranch("Bank West", "", null, null, null);
        List<BankBranch> bankBranchPoints = new ArrayList<>();
        bankBranchPoints.add(bankBranchHSBC);
        bankBranchPoints.add(bankBranchBankNorth);
        bankBranchPoints.add(bankBranchBankWest);

        // TODO Replace the DatabaseMock initialization for Mocked DAOs
        BankBranchDAOMock.setBankBranchPoints(bankBranchPoints);

        //********** BUS SET UP **********//

        bus114 = new Bus("114", "", null, null);
        bus161 = new Bus("161", "", null, null);
        bus157 = new Bus("157", "", null, null);
        List<Bus> busPoints = new ArrayList<>();
        busPoints.add(bus114);
        busPoints.add(bus161);
        busPoints.add(bus157);

        // TODO Replace the DatabaseMock initialization for Mocked DAOs
        BusDAOMock.setBusPoints(busPoints);

        //********** CGP SET UP **********//

        Set<Service> cgp30Services = new HashSet<>();
        Service sales = new Service("Sales", null);
        cgp30Services.add(sales);
        cgp30 = new Cgp("CGP30", "", null, new Commune("30", null), cgp30Services);

        Set<Service> cgp110Services = new HashSet<>();
        Service customeSupport = new Service("Customer Support", null);
        cgp110Services.add(customeSupport);
        cgp110 = new Cgp("CGP110", "", null, new Commune("110", null), cgp110Services);

        Set<Service> cgp54Services = new HashSet<>();
        Service salaries = new Service("Salaries", null);
        cgp54Services.add(salaries);
        cgp54 = new Cgp("CGP54", "", null, new Commune("54", null), cgp54Services);

        List<Cgp> cgpPoints = new ArrayList<>();
        cgpPoints.add(cgp30);
        cgpPoints.add(cgp110);
        cgpPoints.add(cgp54);

        // TODO Replace the DatabaseMock initialization for Mocked DAOs
        CgpDAOMock.setCgpPoints(cgpPoints);

        //********** STORE SET UP **********//

        Category technology = new Category("Technology", 0);

        Set<String> storeSamsungKeywords = new HashSet<>();
        storeSamsungKeywords.add("Cellphones");
        storeSamsungKeywords.add("Smartphones");
        storeSamsung = new Store("Samsung Store", "", null, null, technology, storeSamsungKeywords);

        storeBookshop = new Store("Good Reading", "", null, null, new Category("Books", 0), null);

        Set<String> storeTechKeywords = new HashSet<>();
        storeTechKeywords.add("Samsung");
        storeTechKeywords.add("Iphone");
        storeTechKeywords.add("Cellphones");
        storeTech = new Store("Electronic Things", "", null, null, technology, storeTechKeywords);

        List<Store> storePoints = new ArrayList<>();
        storePoints.add(storeSamsung);
        storePoints.add(storeTech);
        storePoints.add(storeBookshop);

        // TODO Replace the DatabaseMock initialization for Mocked DAOs
        StoreDAOMock.setStorePoints(storePoints);
    }

    @After
    public void tearDown() throws Exception {

    }

    // TODO Change all this test for one with searchPoints. All the search methods here change them to private

    @Test
    public void searchBankBranchByTextTest() throws Exception {
        List<BankBranch> bankBranchPoints = defaultSearchPointsService.searchBankBranchByText("Ban");
        assertTrue(bankBranchPoints.contains(bankBranchBankNorth));
        assertTrue(bankBranchPoints.contains(bankBranchBankWest));

    }

    @Test
    public void searchBusByTextTest() throws Exception {
        Bus bus = defaultSearchPointsService.searchBusByText("161");
        assertTrue(bus.equals(bus161));

    }

    @Test
    public void searchCgpByTextTest() throws Exception {
        List<Cgp> cgpPoints = defaultSearchPointsService.searchCgpByText("110");
        assertTrue(cgpPoints.contains(cgp110));

        cgpPoints = defaultSearchPointsService.searchCgpByText("Sal");
        assertTrue(cgpPoints.contains(cgp30));
        assertTrue(cgpPoints.contains(cgp54));
    }

    @Test
    public void searchStoreByTextTest() throws Exception {
        List<Store> storePoints = defaultSearchPointsService.searchStoreByText("Samsung");
        assertTrue(storePoints.contains(storeSamsung));
        assertTrue(storePoints.contains(storeTech));

        storePoints = defaultSearchPointsService.searchStoreByText("Books");
        assertTrue(storePoints.contains(storeBookshop));
    }
}