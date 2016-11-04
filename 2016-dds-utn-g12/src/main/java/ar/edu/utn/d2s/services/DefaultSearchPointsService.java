package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.database.BankBranchDAOMock;
import ar.edu.utn.d2s.database.BusDAOMock;
import ar.edu.utn.d2s.database.CgpDAOMock;
import ar.edu.utn.d2s.database.StoreDAOMock;
import ar.edu.utn.d2s.model.points.*;
import ar.edu.utn.d2s.utils.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultSearchPointsService implements SearchPointsService {

    private static DefaultSearchPointsService instance = null;

    private SearchPointsService searchExternalPointsService = ExternalSearchPointsService.getInstance();

    public static DefaultSearchPointsService getInstance() {
        if (instance == null) {
            instance = new DefaultSearchPointsService();
        }
        return instance;
    }

    public Set<PointOfInterest> searchPoints(String text) {
        // TODO Instead access data with a PointOfInterest DAO to bring all together

        Set<String> words = StringUtil.getUniqueWordsFromText(text);

        Set<PointOfInterest> points = new HashSet<>();

        words.forEach(word -> {
            points.addAll(searchBankBranchByText(word));
            points.add((PointOfInterest) searchBusByText(word));
            points.addAll(searchCgpByText(word));
            points.addAll(searchStoreByText(word));
        });
        points.addAll(searchExternalPointsService.searchPoints(text));
        return points;
    }

    public List<BankBranch> searchBankBranchByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to jus use PointOfInterest DAO)
        List<BankBranch> bankBranchPoints = new ArrayList<>(BankBranchDAOMock.bankBranchPoints);
        return bankBranchPoints.stream().filter(bankBranch -> bankBranch.getName().startsWith(text)).collect(Collectors.toList());
    }

    public Bus searchBusByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to jus use PointOfInterest DAO)
        List<Bus> busPoints = new ArrayList<>(BusDAOMock.busPoints);
        return busPoints.stream().filter(bus -> text.equals(bus.getName())).findFirst().orElse(null);
    }

    public List<Cgp> searchCgpByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to jus use PointOfInterest DAO)
        List<Cgp> cgpPoints = new ArrayList<>(CgpDAOMock.cgpPoints);
        return cgpPoints.stream().filter(cgp -> cgp.getCommune().getNumber().equals(text) ||
                        cgp.getServices().stream().anyMatch(service -> service.getName().startsWith(text)))
                .collect(Collectors.toList());
    }

    public List<Store> searchStoreByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to jus use PointOfInterest DAO)
        List<Store> storePoints = new ArrayList<>(StoreDAOMock.storePoints);
        return storePoints.stream().filter(store -> storeFilterCriteria(store, text)).collect(Collectors.toList());
    }

    public boolean storeFilterCriteria(Store store, String text) {
        return store.getName().startsWith(text) || store.getKeywords().contains(text) || store.getCategory().getName().equals(text);
    }
}
