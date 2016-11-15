package ar.edu.utn.d2s.model.processes.failurestrategies;

import ar.edu.utn.d2s.model.processes.dtos.FailureInfo;

public interface FailureStrategy {

    public void handleFailure(FailureInfo failureInfo);
}
