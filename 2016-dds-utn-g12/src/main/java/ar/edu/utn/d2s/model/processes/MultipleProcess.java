package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.processes.dtos.ExecuteInfo;

import java.util.HashSet;
import java.util.Set;

public class MultipleProcess implements Runnable {

    private Set<SingleProcess> processes = new HashSet<>();

    @Override
    public void run() {
        processes.forEach(SingleProcess::execute);
    }

    public void addProcess(SingleProcess process) {
        processes.add(process);
    }

    public void removeProcess(SingleProcess process) {
        processes.remove(process);
    }
}
