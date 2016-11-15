package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

import java.util.HashSet;
import java.util.Set;

public class MultipleProcess implements Runnable {

    private Set<SingleProcess> processes = new HashSet<>();
    private Administrator administrator;

    public MultipleProcess(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void run() {
        processes.forEach(singleProcess -> singleProcess.execute(administrator));
    }

    public void addProcess(SingleProcess process) {
        processes.add(process);
    }

    public void removeProcess(SingleProcess process) {
        processes.remove(process);
    }
}
