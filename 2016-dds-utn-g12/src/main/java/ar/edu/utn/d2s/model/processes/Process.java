package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

public abstract class Process implements Runnable {

    private Administrator administrator;

    public Process(Administrator administrator) {
        this.administrator = administrator;
    }

    public void run() {
        execute(administrator);
    }

    public abstract void execute(Administrator administrator);
}
