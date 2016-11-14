package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

public class UpdateStoresProcess extends Process {

    public static final String UPDATE_STORES_PROCESS_NAME = "Update stores";

    public UpdateStoresProcess(Administrator administrator) {
        super(administrator);
    }

    @Override
    public void execute(Administrator administrator) {

    }
}
