package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.database.*;
import ar.edu.utn.d2s.model.points.*;
import ar.edu.utn.d2s.model.search.SearchResult;
import ar.edu.utn.d2s.model.users.Terminal;
import ar.edu.utn.d2s.model.users.User;
import ar.edu.utn.d2s.services.observers.SearchObserverAdminsService;
import ar.edu.utn.d2s.services.observers.SearchObserver;
import ar.edu.utn.d2s.utils.StringUtil;
import ar.edu.utn.d2s.utils.Timer;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultSearchPointsService implements SearchPointsService {

    private static DefaultSearchPointsService instance = null;

    private SearchPointsService searchExternalPointsService = ExternalSearchPointsService.getInstance();
    private SearchObserver observerAdminsService = SearchObserverAdminsService.getInstance();

    public static DefaultSearchPointsService getInstance() {
        if (instance == null) {
            instance = new DefaultSearchPointsService();
        }
        return instance;
    }

    public Set<PointOfInterest> searchPoints(String text, Long userId) {
        // TODO Instead access data with a PointOfInterest DAO to bring all together

        Timer myTimer = new Timer();
        myTimer.start();

        Set<String> words = StringUtil.getUniqueWordsFromText(text);

        Set<PointOfInterest> points = new HashSet<>();

        words.forEach(word -> {
            points.addAll(searchBankBranchByText(word));
            points.add((PointOfInterest) searchBusByText(word));
            points.addAll(searchCgpByText(word));
            points.addAll(searchStoreByText(word));
        });
        points.addAll(searchExternalPointsService.searchPoints(text, userId));

        myTimer.stop();

        LogManager.getLogger(this.getClass()).info("Search: %s. Number of results: %d. Response time: %d.", text, points.size(), myTimer.getDuration());

        notifyObservers(myTimer.getDuration(), points.size());

        // TODO Instead access data with Terminal DAO
        User user = UserDAOMock.findById(userId);
        if (user instanceof Terminal) {
            Terminal terminal = (Terminal) user;
            if (terminal.isStoreSearchResults()) {
                SearchResult searchResult = new SearchResult(text, points.size(), myTimer.getDuration(), points);
                terminal.addSearchResult(searchResult);
                TerminalDAOMock.saveOrUpdate(terminal);
                UserDAOMock.saveOrUpdate(terminal);
            }
        }

        return points;
    }

    public List<BankBranch> searchBankBranchByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to just use PointOfInterest DAO)
        List<BankBranch> bankBranchPoints = new ArrayList<>(BankBranchDAOMock.bankBranchPoints);
        return bankBranchPoints.stream().filter(bankBranch -> bankBranch.getName().startsWith(text)).collect(Collectors.toList());
    }

    public Bus searchBusByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to just use PointOfInterest DAO)
        List<Bus> busPoints = new ArrayList<>(BusDAOMock.busPoints);
        return busPoints.stream().filter(bus -> text.equals(bus.getName())).findFirst().orElse(null);
    }

    public List<Cgp> searchCgpByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to just use PointOfInterest DAO)
        List<Cgp> cgpPoints = new ArrayList<>(CgpDAOMock.cgpPoints);
        return cgpPoints.stream().filter(cgp -> cgp.getCommune().getNumber().equals(text) ||
                        cgp.getServices().stream().anyMatch(service -> service.getName().startsWith(text)))
                .collect(Collectors.toList());
    }

    public List<Store> searchStoreByText(String text) {
        // TODO Instead access data with DAO (Don't do it if it's possible to just use PointOfInterest DAO)
        List<Store> storePoints = new ArrayList<>(StoreDAOMock.storePoints);
        return storePoints.stream().filter(store -> storeFilterCriteria(store, text)).collect(Collectors.toList());
    }

    public boolean storeFilterCriteria(Store store, String text) {
        return store.getName().startsWith(text) || store.getKeywords().contains(text) || store.getCategory().getName().equals(text);
    }

    private void notifyObservers(long searchTime, int results) {
        observerAdminsService.handleNewSearch(searchTime, results);
    }
}
