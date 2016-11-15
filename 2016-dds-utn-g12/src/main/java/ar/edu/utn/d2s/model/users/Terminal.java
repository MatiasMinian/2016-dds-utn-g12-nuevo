package ar.edu.utn.d2s.model.users;

import ar.edu.utn.d2s.model.actions.Action;
import ar.edu.utn.d2s.model.search.SearchResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Terminal extends User {

    private boolean storeSearchResults;
    private List<SearchResult> searchResults = new ArrayList<>();
    private Set<Action> actions = new HashSet<>();
    private Set<Action> lastActions = new HashSet<>();

    public void addSearchResult(SearchResult searchResult) {
        searchResults.add(searchResult);
    }

    public Terminal(boolean storeSearchResults) {
        this.storeSearchResults = storeSearchResults;
    }

    public boolean isStoreSearchResults() {
        return storeSearchResults;
    }

    public void setStoreSearchResults(boolean storeSearchResults) {
        this.storeSearchResults = storeSearchResults;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void addActions(Set<Action> actions) {
        lastActions.clear();
        lastActions.addAll(this.actions);
        this.actions.addAll(actions);
    }
}
