package ar.edu.utn.d2s.model.points;

import ar.edu.utn.d2s.model.addres.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Commune {

    int number;
    List<Coordinate> coordinates;

    public Commune(int number, List<Coordinate> coordinates) {
        this.number = number;
        this.coordinates = coordinates;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Coordinate> getCoordinates() {
        if (coordinates == null) {
            coordinates = new ArrayList<>();
        }
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
