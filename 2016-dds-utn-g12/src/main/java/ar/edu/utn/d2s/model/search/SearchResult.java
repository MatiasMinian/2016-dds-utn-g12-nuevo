package ar.edu.utn.d2s.model.search;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.HashSet;
import java.util.Set;

public class SearchResult {

    private String text;
    private int numberOfResults;
    private long searchTime;
    private Set<PointOfInterest> points;

    public SearchResult(String text, int numberOfResults, long searchTime, Set<PointOfInterest> points) {
        this.text = text;
        this.numberOfResults = numberOfResults;
        this.searchTime = searchTime;
        this.points = points;
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

    public Set<PointOfInterest> getPoints() {
        if (points == null) {
            points = new HashSet<>();
        }
        return points;
    }

    public void setPoints(Set<PointOfInterest> points) {
        this.points = points;
    }
}
