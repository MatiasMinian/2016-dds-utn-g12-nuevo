package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.database.PointsOfInterestDAOMock;
import ar.edu.utn.d2s.model.points.PointOfInterest;
import ar.edu.utn.d2s.model.processes.governmentservice.POIsRemovalAPI;
import ar.edu.utn.d2s.model.processes.governmentservice.POIsRemovalAPIImplMock;
import ar.edu.utn.d2s.model.users.Administrator;
import ar.edu.utn.d2s.services.DefaultSearchPointsService;
import ar.edu.utn.d2s.services.SearchPointsService;

import java.util.*;

public class DeletePOIsProcess implements SingleProcess {

    public static final String DELETE_POIS_PROCESS_NAME = "Delete POIs";
    private POIsRemovalAPI pointsRemovalAPI = POIsRemovalAPIImplMock.getInstance();
    private SearchPointsService defaultSearchPointsService = DefaultSearchPointsService.getInstance();

    @Override
    public void execute(Administrator administrator) {

        ProcessResult processResult = new ProcessResult();
        processResult.setStartTime(Calendar.getInstance());
        processResult.setProcessName(DELETE_POIS_PROCESS_NAME);
        processResult.setUserName(administrator.getUsername());

        Set<PointOfInterest> pointsToRemove = new HashSet<>();

        Map<String, Calendar> govAPIPointsToRemove = new HashMap<>(pointsRemovalAPI.getPointsToRemove());

        if (govAPIPointsToRemove.isEmpty()) {
            processResult.setEndTime(Calendar.getInstance());
            processResult.setResult(ProcessResult.RESULT_ERROR);
            processResult.setErrorMessage("There are no points to delete");
            ProcessResult.saveProcessResult(processResult);
            return;
        }

        govAPIPointsToRemove.forEach((text, deletionDate) -> {
            if (deletionDate.before(Calendar.getInstance())) {
                pointsToRemove.addAll(defaultSearchPointsService.searchPoints(text, administrator.getId()));
            }
        } );

        // TODO Access with real DAO and delete them in DB
        pointsToRemove.forEach(PointsOfInterestDAOMock::delete);

        processResult.setEndTime(Calendar.getInstance());
        processResult.setResult(ProcessResult.RESULT_OK);
        ProcessResult.saveProcessResult(processResult);
    }
}
