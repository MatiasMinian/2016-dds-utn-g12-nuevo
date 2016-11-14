package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

public class AddUserActionsProcess extends Process {

    public static final String ADD_USER_ACTIONS_PROCESS_NAME = "Add user actions";

    public AddUserActionsProcess(Administrator administrator) {
        super(administrator);
    }

    @Override
    public void execute(Administrator administrator) {

    }
}
