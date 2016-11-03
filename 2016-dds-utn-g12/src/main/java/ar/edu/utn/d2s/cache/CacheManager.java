package ar.edu.utn.d2s.cache;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.HashMap;
import java.util.List;

public class CacheManager {

    /**
     * Used for managing caches, general cache and user caches.
     * General cache: For caching all searches made in the entire app by any user.
     * User cache: For caching searches made by a specific user.
     */

    private static CacheManager instance = null;

    public static CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    //private Cache<String, List<PointOfInterest>>

    // TODO Finish CacheManager with its caches
}
