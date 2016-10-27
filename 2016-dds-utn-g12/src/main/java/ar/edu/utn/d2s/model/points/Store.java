package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Address;
import org.uqbar.geodds.Point;

import java.util.List;

public class Store extends PointOfInterest {

    private String attentionSchedule;
    private Category category;
    private List<String> keywords;

    public Store(String name, String icon, Address address, String attentionSchedule, Category category, List<String> keywords) {
        super(name, icon, address);
        this.attentionSchedule = attentionSchedule;
        this.category = category;
        this.keywords = keywords;
        this.closeRange = category.getCloseRange();
    }

    //********** METHODS **********//

    @Override
    public boolean isClose(Point point) {
        return point.distance(address.getPoint()) < category.getCloseRange();
    }

    //********** GETTERS & SETTERS **********//

    public String getAttentionSchedule() {
        return attentionSchedule;
    }

    public void setAttentionSchedule(String attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
