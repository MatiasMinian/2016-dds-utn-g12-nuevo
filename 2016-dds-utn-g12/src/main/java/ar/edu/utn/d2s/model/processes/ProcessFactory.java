package ar.edu.utn.d2s.model.processes;

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

    public static SingleProcess createByName(String processName, Administrator administrator) {
        if (processName.equalsIgnoreCase(UpdateStoresProcess.UPDATE_STORES_PROCESS_NAME)) {
            return new UpdateStoresProcess();
        }
        if (processName.equalsIgnoreCase(DeletePOIsProcess.DELETE_POIS_PROCESS_NAME)) {
            return new DeletePOIsProcess();
        }
        if (processName.equalsIgnoreCase(AddUserActionsProcess.ADD_USER_ACTIONS_PROCESS_NAME)) {
            return new AddUserActionsProcess();
        }
        throw new IllegalArgumentException("Field name must be a valid process name");
    }

    public static MultipleProcess createAllByName(Set<String> processNames, Administrator administrator) {
        if (processNames == null) {
            throw new IllegalArgumentException("Field names must have at least one name");
        }
        MultipleProcess multipleProcess = new MultipleProcess(administrator);
        processNames.forEach(processName -> multipleProcess.addProcess(createByName(processName, administrator)));
        return multipleProcess;
    }
}
