package ar.edu.utn.d2s.model.points;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class Commune {

    private String number;
    private Polygon surface;

    public Commune(String number, Polygon surface) {
        this.number = number;
        this.surface = surface;
    }

    //********** METHODS **********//

    public boolean hasPointInside(Point point) {
        return surface.isInside(point);
    }

    //********** GETTERS & SETTERS **********//

    public String getNumber() {
        if (number == null) {
            number = "";
        }
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Polygon getSurface() {
        return surface;
    }

    public void setSurface(Polygon surface) {
        this.surface = surface;
    }
}
