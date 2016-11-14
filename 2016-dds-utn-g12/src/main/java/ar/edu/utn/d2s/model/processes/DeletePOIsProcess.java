package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

public class DeletePOIsProcess extends Process {

    public static final String DELETE_POIS_PROCESS_NAME = "Delete POIs";

    public DeletePOIsProcess(Administrator administrator) {
        super(administrator);
    }

    @Override
    public void execute(Administrator administrator) {

    }
}
