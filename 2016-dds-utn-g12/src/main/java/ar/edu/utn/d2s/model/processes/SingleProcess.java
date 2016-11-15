package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.processes.dtos.ExecuteInfo;
import ar.edu.utn.d2s.model.users.Administrator;

public abstract class SingleProcess {

    protected ExecuteInfo executeInfo;

    public SingleProcess(ExecuteInfo executeInfo) {
        this.executeInfo = executeInfo;
    }

    public abstract void execute();
}
