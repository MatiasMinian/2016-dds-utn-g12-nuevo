package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusDAOMock {

    /**
     * TODO
     * Change this to a Bus DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Bus entity that will be persisted in the future.
     */

    public static List<Bus> busPoints = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(Bus busPoint) {
        Bus targetBusPoint = findById(busPoint.getId());
        if (targetBusPoint == null) {
            busPoints.add(busPoint);
        } else {
            targetBusPoint = busPoint;
        }
    }

    public static void delete(Bus busPoint) {
        busPoints.remove(busPoint);
    }

    public static Bus findById(Long id) {
        return busPoints.stream().filter(bus -> bus.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Bus> getBusPoints() {
        return busPoints;
    }

    public static void setBusPoints(List<Bus> busPoints) {
        BusDAOMock.busPoints = busPoints;
    }
}
