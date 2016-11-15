package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

public class PointsOfInterestDAOMock {

    /**
     * TODO
     * Change this to a PointOfInterest DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for PointOfInterest entity that will be persisted in the future.
     */

    public static List<PointOfInterest> pointsOfInterest = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(PointOfInterest point) {
        PointOfInterest targetPoint = findById(point.getId());
        if (targetPoint == null) {
            pointsOfInterest.add(point);
        } else {
            targetPoint = point;
        }
    }

    public static void delete(PointOfInterest point) {
        pointsOfInterest.remove(point);
    }

    public static PointOfInterest findById(Long id) {
        return pointsOfInterest.stream().filter(point -> point.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<PointOfInterest> getPoints() {
        return pointsOfInterest;
    }

    public static void setPoints(List<PointOfInterest> points) {
        PointsOfInterestDAOMock.pointsOfInterest = points;
    }
}
