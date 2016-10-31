package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.database.BankBranchDAOMock;
import ar.edu.utn.d2s.database.BusDAOMock;
import ar.edu.utn.d2s.database.CgpDAOMock;
import ar.edu.utn.d2s.database.StoreDAOMock;
import ar.edu.utn.d2s.model.points.BankBranch;
import ar.edu.utn.d2s.model.points.Bus;
import ar.edu.utn.d2s.model.points.Cgp;
import ar.edu.utn.d2s.model.points.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPointsService {

    /**
     * TODO
     * When UI should be implemented include this four methods in one to respond
     * to the search pooints by text request, see what data is necessary to know
     * if you can return just a list of PointOfInterest or each type of PointOfInterest
     * should be returned
     */

    public List<BankBranch> searchBankBranchByText(String text) {
        // TODO Instead access data with DAO
        List<BankBranch> bankBranchPoints = new ArrayList<>(BankBranchDAOMock.bankBranchPoints);
        return bankBranchPoints.stream().filter(bankBranch -> bankBranch.getName().startsWith(text)).collect(Collectors.toList());
    }

    public Bus searchBusByText(String text) {
        // TODO Instead access data with DAO
        List<Bus> busPoints = new ArrayList<>(BusDAOMock.busPoints);
        return busPoints.stream().filter(bus -> text.equals(bus.getName())).findFirst().orElse(null);
    }

    public List<Cgp> searchCgpByText(String text) {
        // TODO Instead access data with DAO
        List<Cgp> cgpPoints = new ArrayList<>(CgpDAOMock.cgpPoints);
        return cgpPoints.stream().filter(cgp -> cgp.getCommune().getNumber().equals(text) ||
                        cgp.getServices().stream().anyMatch(service -> service.getName().startsWith(text)))
                .collect(Collectors.toList());
    }

    public List<Store> searchStoreByText(String text) {
        // TODO Instead access data with DAO
        List<Store> storePoints = new ArrayList<>(StoreDAOMock.storePoints);
        return storePoints.stream().filter(store -> storeFilterCriteria(store, text)).collect(Collectors.toList());
    }

    private boolean storeFilterCriteria(Store store, String text) {
        return store.getName().startsWith(text) || store.getKeywords().contains(text) || store.getCategory().getName().equals(text);
    }
}
