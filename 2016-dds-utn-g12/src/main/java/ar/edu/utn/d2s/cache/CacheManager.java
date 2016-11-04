package ar.edu.utn.d2s.cache;

import ar.edu.utn.d2s.model.points.PointOfInterest;

import java.util.HashMap;
import java.util.List;

public class CacheManager {

    /**
     * Used for managing caches, general cache and user caches.
     * General cache: For caching all searches made in the entire app by any user.
     * User cache: For caching searches made by a specific user.
     * TODO If there's time, imlement user cache.
     */

    private static CacheManager instance = null;
    private Cache<String, List<PointOfInterest>> cache = new Cache<>(CacheConfig.GENERAL_CACHE_SIZE);

    public static CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public List<PointOfInterest> matchSearch(String search) {
        return cache.get("search");
    }

    public void addSearch(String search, List<PointOfInterest> points) {
        cache.put(search, points);
    }
}
