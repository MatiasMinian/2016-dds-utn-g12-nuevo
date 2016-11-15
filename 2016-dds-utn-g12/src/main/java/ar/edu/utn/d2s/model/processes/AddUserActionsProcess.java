package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.database.TerminalDAOMock;
import ar.edu.utn.d2s.model.processes.dtos.ExecuteInfo;
import ar.edu.utn.d2s.model.processes.dtos.FailureInfo;
import ar.edu.utn.d2s.model.processes.dtos.ProcessResult;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

public class AddUserActionsProcess extends SingleProcess {

    public static final String ADD_USER_ACTIONS_PROCESS_NAME = "Add user actions";

    public AddUserActionsProcess(ExecuteInfo executeInfo) {
        super(executeInfo);
    }

    @Override
    public void execute() {

        ProcessResult processResult = new ProcessResult();
        processResult.setStartTime(Calendar.getInstance());
        processResult.setProcessName(ADD_USER_ACTIONS_PROCESS_NAME);
        processResult.setUserName(executeInfo.getAdministrator().getUsername());

        if (executeInfo.getActions().isEmpty()) {
            processResult.setEndTime(Calendar.getInstance());
            processResult.setResult(ProcessResult.RESULT_ERROR);
            processResult.setErrorMessage("There are no actions to add to users");

            ProcessResult.saveProcessResult(processResult);
            if (executeInfo.getFailureStrategy() != null) {
                executeInfo.getFailureStrategy().handleFailure(new FailureInfo(executeInfo.getAdministrator().getMail(), processResult.getErrorMessage(), this));
            }
            return;
        }

        TerminalDAOMock.getTerminals().forEach(terminal -> terminal.addActions(executeInfo.getActions()));

        processResult.setEndTime(Calendar.getInstance());
        processResult.setResult(ProcessResult.RESULT_OK);
        ProcessResult.saveProcessResult(processResult);
    }
}
