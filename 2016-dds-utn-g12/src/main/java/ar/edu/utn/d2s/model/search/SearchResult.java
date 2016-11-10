package ar.edu.utn.d2s.model.search;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class SearchResult {

    private Long id;
    private String text;
    private int numberOfResults;
    private long searchTime;
    private Calendar date;
    private Set<PointOfInterest> points;

    public SearchResult(String text, int numberOfResults, long searchTime, Calendar date, Set<PointOfInterest> points) {
        this.text = text;
        this.numberOfResults = numberOfResults;
        this.searchTime = searchTime;
        this.date = date;
        this.points = points;
    }

    public Long getId() {
        return id;
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
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
