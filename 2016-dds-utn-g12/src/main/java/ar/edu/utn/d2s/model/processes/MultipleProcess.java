package ar.edu.utn.d2s.model.processes;

import java.util.HashSet;
import java.util.Set;

public class MultipleProcess implements Process {

    private Set<Process> processes = new HashSet<>();

    @Override
    public void run() {

    }



    public void addProcess(Process process) {
        processes.add(process);
    }


}
