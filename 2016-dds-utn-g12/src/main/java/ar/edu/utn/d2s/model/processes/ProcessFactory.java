package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.processes.dtos.ExecuteInfo;
import ar.edu.utn.d2s.model.users.Administrator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ProcessFactory {

    // Available processes: Id, Name
    // TODO Check if this is ok
    public static final Set<String> AVAILABLE_PROCESSES = new HashSet<>();

    {
        AVAILABLE_PROCESSES.add(UpdateStoresProcess.UPDATE_STORES_PROCESS_NAME);
        AVAILABLE_PROCESSES.add(DeletePOIsProcess.DELETE_POIS_PROCESS_NAME);
        AVAILABLE_PROCESSES.add(AddUserActionsProcess.ADD_USER_ACTIONS_PROCESS_NAME);
    }

    public static SingleProcess createByName(String processName, ExecuteInfo executeInfo) {
        if (processName.equalsIgnoreCase(UpdateStoresProcess.UPDATE_STORES_PROCESS_NAME)) {
            return new UpdateStoresProcess(executeInfo);
        }
        if (processName.equalsIgnoreCase(DeletePOIsProcess.DELETE_POIS_PROCESS_NAME)) {
            return new DeletePOIsProcess(executeInfo);
        }
        if (processName.equalsIgnoreCase(AddUserActionsProcess.ADD_USER_ACTIONS_PROCESS_NAME)) {
            return new AddUserActionsProcess(executeInfo);
        }
        throw new IllegalArgumentException("Field name must be a valid process name");
    }

    public static MultipleProcess createAllByName(Set<String> processNames, ExecuteInfo executeInfo) {
        if (processNames == null) {
            throw new IllegalArgumentException("Field names must have at least one name");
        }
        MultipleProcess multipleProcess = new MultipleProcess();
        processNames.forEach(processName -> multipleProcess.addProcess(createByName(processName, executeInfo)));
        return multipleProcess;
    }
}
