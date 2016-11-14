package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Process implements Runnable {

    // Available processes: Id, Name
    // TODO Check if this is ok
    public static final Set<String> AVAILABLE_PROCESSES = new HashSet<>();

    {
        AVAILABLE_PROCESSES.add(UpdateStoresProcess.UPDATE_STORES_PROCESS_NAME);
        AVAILABLE_PROCESSES.add(DeletePOIsProcess.DELETE_POIS_PROCESS_NAME);
        AVAILABLE_PROCESSES.add(AddUserActionsProcess.ADD_USER_ACTIONS_PROCESS_NAME);
    }

    public static Process createByName(String name, Administrator administrator) {
        if (name.equalsIgnoreCase(UpdateStoresProcess.UPDATE_STORES_PROCESS_NAME)) {
            return new UpdateStoresProcess(administrator);
        }
        if (name.equalsIgnoreCase(DeletePOIsProcess.DELETE_POIS_PROCESS_NAME)) {
            return new DeletePOIsProcess(administrator);
        }
        if (name.equalsIgnoreCase(AddUserActionsProcess.ADD_USER_ACTIONS_PROCESS_NAME)) {
            return new AddUserActionsProcess(administrator);
        }
        throw new IllegalArgumentException("Field name must be a valid process name");
    }

    public static Process createAllByName(Set<String> name, Administrator administrator) {
        // TODO Implement this
        return null;

    }

    private Administrator administrator;

    public Process(Administrator administrator) {
        this.administrator = administrator;
    }

    public void run() {
        execute(administrator);
    }

    public abstract void execute(Administrator administrator);
}
