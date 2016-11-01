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

    //********** METHODS **********//

    public static void saveOrUpdate(Store storePoint) {
        Store targetStorePoint = findById(storePoint.getId());
        if (targetStorePoint == null) {
            storePoints.add(storePoint);
        } else {
            targetStorePoint = storePoint;
        }
    }

    public static void delete(Store storePoint) {
        storePoints.remove(storePoint);
    }

    public static Store findById(Long id) {
        return storePoints.stream().filter(store -> store.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Store> getStorePoints() {
        return storePoints;
    }

    public static void setStorePoints(List<Store> storePoints) {
        StoreDAOMock.storePoints = storePoints;
    }
}
