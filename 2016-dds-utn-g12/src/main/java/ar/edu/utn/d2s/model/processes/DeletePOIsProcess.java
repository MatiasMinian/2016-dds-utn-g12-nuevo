package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.database.PointsOfInterestDAOMock;
import ar.edu.utn.d2s.model.points.PointOfInterest;
import ar.edu.utn.d2s.model.processes.dtos.ExecuteInfo;
import ar.edu.utn.d2s.model.processes.dtos.FailureInfo;
import ar.edu.utn.d2s.model.processes.dtos.ProcessResult;
import ar.edu.utn.d2s.model.processes.governmentservice.POIsRemovalAPI;
import ar.edu.utn.d2s.model.processes.governmentservice.POIsRemovalAPIImplMock;
import ar.edu.utn.d2s.services.DefaultSearchPointsService;
import ar.edu.utn.d2s.services.SearchPointsService;

import java.util.*;

public class DeletePOIsProcess extends SingleProcess {

    public static final String DELETE_POIS_PROCESS_NAME = "Delete POIs";
    private POIsRemovalAPI pointsRemovalAPI = POIsRemovalAPIImplMock.getInstance();
    private SearchPointsService defaultSearchPointsService = DefaultSearchPointsService.getInstance();

    public DeletePOIsProcess(ExecuteInfo executeInfo) {
        super(executeInfo);
    }

    @Override
    public void execute() {

        ProcessResult processResult = new ProcessResult();
        processResult.setStartTime(Calendar.getInstance());
        processResult.setProcessName(DELETE_POIS_PROCESS_NAME);
        processResult.setUserName(executeInfo.getAdministrator().getUsername());

        Set<PointOfInterest> pointsToRemove = new HashSet<>();

        Map<String, Calendar> govAPIPointsToRemove = new HashMap<>(pointsRemovalAPI.getPointsToRemove());

        if (govAPIPointsToRemove.isEmpty()) {
            processResult.setEndTime(Calendar.getInstance());
            processResult.setResult(ProcessResult.RESULT_ERROR);
            processResult.setErrorMessage("There are no points to delete");
            ProcessResult.saveProcessResult(processResult);
            if (executeInfo.getFailureStrategy() != null) {
                executeInfo.getFailureStrategy().handleFailure(new FailureInfo(executeInfo.getAdministrator().getMail(), processResult.getErrorMessage(), this));
            }
            return;
        }

        govAPIPointsToRemove.forEach((text, deletionDate) -> {
            if (deletionDate.before(Calendar.getInstance())) {
                pointsToRemove.addAll(defaultSearchPointsService.searchPoints(text, executeInfo.getAdministrator().getId()));
            }
        } );

        // TODO Access with real DAO and delete them in DB
        pointsToRemove.forEach(PointsOfInterestDAOMock::delete);

        processResult.setEndTime(Calendar.getInstance());
        processResult.setResult(ProcessResult.RESULT_OK);
        ProcessResult.saveProcessResult(processResult);
    }
}
