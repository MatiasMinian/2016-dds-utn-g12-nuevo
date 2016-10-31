package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreDAOMock {

    /**
     * TODO
     * Change this to a Store DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Store entity that will be persisted in the future.
     */

    public static List<Store> storePoints = new ArrayList<>();

    public static List<Store> getStorePoints() {
        return storePoints;
    }

    public static void setStorePoints(List<Store> storePoints) {
        StoreDAOMock.storePoints = storePoints;
    }

    public static void addStorePoints(List<Store> storePoints) {
        StoreDAOMock.storePoints.addAll(storePoints);
    }
}
