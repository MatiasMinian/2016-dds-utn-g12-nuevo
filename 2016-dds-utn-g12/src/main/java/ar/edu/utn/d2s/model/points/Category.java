package ar.edu.utn.d2s.model.points;

public class Category {

    private String name;
    private double closeRange;

    public Category(String name, double closeRange) {
        this.name = name;
        this.closeRange = closeRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCloseRange() {
        return closeRange;
    }

    public void setCloseRange(double closeRange) {
        this.closeRange = closeRange;
    }
}
