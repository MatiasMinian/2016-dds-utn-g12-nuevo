package ar.edu.utn.d2s.model.users;

import ar.edu.utn.d2s.model.search.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class Terminal {

    private boolean storeSearchResults;
    private List<SearchResult> searchResults;

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
}
