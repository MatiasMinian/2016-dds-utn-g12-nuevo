package ar.edu.utn.d2s.services;

import ar.edu.utn.d2s.database.DatabaseMock;
import ar.edu.utn.d2s.model.points.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPointsService {

    /**
     * TODO
     * When UI should be implemented include this four methods in one to respond
     * to the search pooints by text request, see what data is necessary to know
     * if you can return just a list of PointOfInterest or each type of PointOfInterest
     * should be returned
     */

    public Bus searchBusByText(String text) {
        // TODO Instead access data with DAO
        List<Bus> busPoints = new ArrayList<>(DatabaseMock.busPoints);
        return busPoints.stream().filter(bus -> text.equals(bus.getName())).findFirst().orElse(null);
    }

}
