package ar.edu.utn.d2s.model.users;

import ar.edu.utn.d2s.model.actions.Action;
import ar.edu.utn.d2s.model.search.SearchResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Terminal extends User {

    private boolean storeSearchResults;
    private List<SearchResult> searchResults;
    private Set<Action> actions;

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
        if (searchResults == null) {
            searchResults = new ArrayList<>();
        }
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public Set<Action> getActions() {
        if (actions == null) {
            actions = new HashSet<>();
        }
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }
}
