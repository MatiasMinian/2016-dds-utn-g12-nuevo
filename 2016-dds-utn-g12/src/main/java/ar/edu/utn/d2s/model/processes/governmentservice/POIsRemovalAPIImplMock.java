package ar.edu.utn.d2s.model.processes.governmentservice;

import java.util.*;

public class POIsRemovalAPIImplMock implements POIsRemovalAPI {

    private static POIsRemovalAPIImplMock instance = null;

    private Map<String, Calendar> pointsToRemove = new HashMap<>();

    public POIsRemovalAPIImplMock() {
        initialize();
    }

    public static POIsRemovalAPIImplMock getInstance() {
        if (instance == null) {
            instance = new POIsRemovalAPIImplMock();
        }
        return instance;
    }

    public void initialize() {
        Calendar removalDate114 = Calendar.getInstance();
        removalDate114.set(2017, 3, 18);
        pointsToRemove.put("114", removalDate114);

        Calendar removalDateHsbc = Calendar.getInstance();
        removalDateHsbc.set(2017, 6, 22);
        pointsToRemove.put("HSBC", removalDateHsbc);
    }

    @Override
    public Map<String, Calendar> getPointsToRemove() {
        return pointsToRemove;
    }
}
