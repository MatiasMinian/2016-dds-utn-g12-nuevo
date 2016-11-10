package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.search.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class SearchResultDAOMock {

    /**
     * TODO
     * Change this to a Search Result DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Search Result entity that will be persisted in the future.
     */

    public static List<SearchResult> searchResults = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(SearchResult searchResult) {
        SearchResult targetSearchResult = findById(searchResult.getId());
        if (targetSearchResult == null) {
            searchResults.add(searchResult);
        } else {
            targetSearchResult = searchResult;
        }
    }

    public static void delete(SearchResult searchResult) {
        searchResults.remove(searchResult);
    }

    public static SearchResult findById(Long id) {
        return searchResults.stream().filter(searchResult -> searchResult.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public static void setSearchResults(List<SearchResult> searchResults) {
        SearchResultDAOMock.searchResults = searchResults;
    }
}
