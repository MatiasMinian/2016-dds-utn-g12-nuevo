package ar.edu.utn.d2s.model.processes.dtos;

import ar.edu.utn.d2s.model.actions.Action;
import ar.edu.utn.d2s.model.processes.failurestrategies.FailureStrategy;
import ar.edu.utn.d2s.model.users.Administrator;

import java.util.HashSet;
import java.util.Set;

public class ExecuteInfo {

    private Administrator administrator;
    private Set<Action> actions;
    private FailureStrategy failureStrategy;

    public ExecuteInfo(Administrator administrator, Set<Action> actions, FailureStrategy failureStrategy) {
        this.administrator = administrator;
        this.actions = actions;
        this.failureStrategy = failureStrategy;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Set<Action> getActions() {
        if (actions == null) {
            actions = new HashSet<>();
        }
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public FailureStrategy getFailureStrategy() {
        return failureStrategy;
    }

    public void setFailureStrategy(FailureStrategy failureStrategy) {
        this.failureStrategy = failureStrategy;
    }
}
