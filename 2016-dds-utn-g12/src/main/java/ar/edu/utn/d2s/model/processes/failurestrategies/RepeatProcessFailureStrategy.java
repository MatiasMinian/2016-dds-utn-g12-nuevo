package ar.edu.utn.d2s.model.processes.failurestrategies;

import ar.edu.utn.d2s.model.processes.ProcessFactory;
import ar.edu.utn.d2s.model.processes.dtos.FailureInfo;

public class RepeatProcessFailureStrategy implements FailureStrategy {

    private int timesToRepeat;
    private int timesExecuted = 0;

    public RepeatProcessFailureStrategy(int timesToRepeat) {
        this.timesToRepeat = timesToRepeat;
    }

    @Override
    public void handleFailure(FailureInfo failureInfo) {
        timesExecuted = 1;
        if (timesToRepeat > timesExecuted) {
            failureInfo.getProcess().execute();
        }
    }
}
