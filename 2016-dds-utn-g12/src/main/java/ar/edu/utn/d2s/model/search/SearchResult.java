package ar.edu.utn.d2s.model.search;

public class SearchResult {

    private String text;
    private int numberOfResults;
    private long searchTime;

    public SearchResult(String text, int numberOfResults, long searchTime) {
        this.text = text;
        this.numberOfResults = numberOfResults;
        this.searchTime = searchTime;
    }

    public String getText() {
        if (text == null) {
            text = "";
        }
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(int numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public long getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(long searchTime) {
        this.searchTime = searchTime;
    }
}
