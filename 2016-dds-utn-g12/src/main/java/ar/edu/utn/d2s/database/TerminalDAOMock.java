package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.users.Terminal;

import java.util.ArrayList;
import java.util.List;

public class TerminalDAOMock {

    /**
     * TODO
     * Change this to a Terminal DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Terminal entity that will be persisted in the future.
     */

    public static List<Terminal> terminals = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(Terminal terminal) {
        Terminal targetTerminal = findById(terminal.getId());
        if (targetTerminal == null) {
            terminals.add(terminal);
        } else {
            targetTerminal = terminal;
        }
    }

    public static void delete(Terminal terminal) {
        terminals.remove(terminal);
    }

    public static Terminal findById(Long id) {
        return terminals.stream().filter(terminal -> terminal.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Terminal> getTerminals() {
        return terminals;
    }

    public static void setTerminals(List<Terminal> terminals) {
        TerminalDAOMock.terminals = terminals;
    }
}
