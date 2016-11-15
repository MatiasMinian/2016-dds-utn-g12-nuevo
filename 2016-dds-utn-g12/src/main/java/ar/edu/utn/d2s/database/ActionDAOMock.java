package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class ActionDAOMock {

    /**
     * TODO
     * Change this to a Action DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Action entity that will be persisted in the future.
     */

    public static List<Action> actions = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(Action action) {
        Action targetAction = findById(action.getId());
        if (targetAction == null) {
            actions.add(action);
        } else {
            targetAction = action;
        }
    }

    public static void delete(Action action) {
        actions.remove(action);
    }

    public static Action findById(Long id) {
        return actions.stream().filter(action -> action.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Action> getActions() {
        return actions;
    }

    public static void setActions(List<Action> actions) {
        ActionDAOMock.actions = actions;
    }
}
