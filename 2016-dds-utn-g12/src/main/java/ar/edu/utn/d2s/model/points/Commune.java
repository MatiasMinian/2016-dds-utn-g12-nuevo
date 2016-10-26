package ar.edu.utn.d2s.model.points;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class Commune {

    private int number;
    private Polygon surface;

    public Commune(int number, Polygon surface) {
        this.number = number;
        this.surface = surface;
    }

    //********** METHODS **********//

    public boolean hasPointInside(Point point) {
        return surface.isInside(point);
    }

    //********** GETTERS & SETTERS **********//

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Polygon getSurface() {
        return surface;
    }

    public void setSurface(Polygon surface) {
        this.surface = surface;
    }
}
