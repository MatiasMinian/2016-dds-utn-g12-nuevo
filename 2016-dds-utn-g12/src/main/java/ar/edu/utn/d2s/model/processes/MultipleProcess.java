package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.model.users.Administrator;

import java.util.HashSet;
import java.util.Set;

public class MultipleProcess extends Process {

    private Set<Process> processes = new HashSet<>();

    public MultipleProcess(Administrator administrator) {
        super(administrator);
    }

    @Override
    public void execute(Administrator administrator) {
        processes.forEach(Process::run);
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public void deleteProcess(Process process) {
        processes.remove(process);
    }
}
