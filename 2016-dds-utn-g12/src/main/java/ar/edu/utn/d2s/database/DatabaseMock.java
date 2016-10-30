package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.BankBranch;
import ar.edu.utn.d2s.model.points.Bus;
import ar.edu.utn.d2s.model.points.Cgp;
import ar.edu.utn.d2s.model.points.Store;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMock {

    /**
     * TODO
     * Change this varibles for daos when the database is implemented. In the meantime services should get
     * the information from this static varibles to perform requests. This class acts like a repository for
     * each entity that will be persisted in the future.
     */


    //********** BANK BRANCH REPOSITORY **********//

    public static List<BankBranch> bankBranchPoints = new ArrayList<>();

    public static List<BankBranch> getBankBranchPoints() {
        return bankBranchPoints;
    }

    public static void setBankBranchPoints(List<BankBranch> bankBranchPoints) {
        DatabaseMock.bankBranchPoints = bankBranchPoints;
    }

    public static void addBankBranchPoints(List<BankBranch> bankBranchPoints) {
        DatabaseMock.bankBranchPoints.addAll(bankBranchPoints);
    }

    //********** BUS REPOSITORY **********//

    public static List<Bus> busPoints = new ArrayList<>();

    public static List<Bus> getBusPoints() {
        return busPoints;
    }

    public static void setBusPoints(List<Bus> busPoints) {
        DatabaseMock.busPoints = busPoints;
    }

    public static void addBusPoints(List<Bus> busPoints) {
        DatabaseMock.busPoints.addAll(busPoints);
    }

    //********** CGP REPOSITORY **********//

    public static List<Cgp> cgpPoints = new ArrayList<>();

    public static List<Cgp> getCgpPoints() {
        return cgpPoints;
    }

    public static void setCgpPoints(List<Cgp> cgpPoints) {
        DatabaseMock.cgpPoints = cgpPoints;
    }

    public static void addCgpPoints(List<Cgp> cgpPoints) {
        DatabaseMock.cgpPoints.addAll(cgpPoints);
    }

    //********** STORE REPOSITORY **********//

    public static List<Store> storePoints = new ArrayList<>();

    public static List<Store> getStorePoints() {
        return storePoints;
    }

    public static void setStorePoints(List<Store> storePoints) {
        DatabaseMock.storePoints = storePoints;
    }

    public static void addStorePoints(List<Store> storePoints) {
        DatabaseMock.storePoints.addAll(storePoints);
    }
}
