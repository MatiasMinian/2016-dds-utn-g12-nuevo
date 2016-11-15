package ar.edu.utn.d2s.model.processes.governmentservice;

import java.util.Calendar;
import java.util.Map;

public interface POIsRemovalAPI {

    public Map<String, Calendar> getPointsToRemove();
}
