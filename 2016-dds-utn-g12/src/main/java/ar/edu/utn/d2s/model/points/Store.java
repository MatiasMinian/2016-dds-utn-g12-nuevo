package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import org.uqbar.geodds.Point;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Store extends PointOfInterest {

    private String timeSchedule;
    private Category category;
    private Set<String> keywords;

    public Store(String name, String icon, Address address, String timeSchedule, Category category, Set<String> keywords) {
        super(name, icon, address);
        this.timeSchedule = timeSchedule;
        this.category = category;
        this.keywords = keywords;
        this.closeRange = category.getCloseRange();
    }

    //********** METHODS **********//

    @Override
    public boolean isClose(Point point) {
        return point.distance(address.getPoint()) < category.getCloseRange();
    }

    @Override
    public boolean isOpen(DayEnum day, LocalTime time, String value) {
        //TODO Implement this method
        return false;
    }

    //********** GETTERS & SETTERS **********//

    public String getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(String timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<String> getKeywords() {
        if (keywords == null) {
            keywords = new HashSet<>();
        }
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }
}
