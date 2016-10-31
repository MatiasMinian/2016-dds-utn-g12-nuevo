package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.Cgp;

import java.util.ArrayList;
import java.util.List;

public class CgpDAOMock {

    /**
     * TODO
     * Change this to a Cgp DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Cgp entity that will be persisted in the future.
     */

    public static List<Cgp> cgpPoints = new ArrayList<>();

    public static List<Cgp> getCgpPoints() {
        return cgpPoints;
    }

    public static void setCgpPoints(List<Cgp> cgpPoints) {
        CgpDAOMock.cgpPoints = cgpPoints;
    }

    public static void addCgpPoints(List<Cgp> cgpPoints) {
        CgpDAOMock.cgpPoints.addAll(cgpPoints);
    }
}
