package ar.edu.utn.d2s.model.actions;

import ar.edu.utn.d2s.database.TerminalDAOMock;
import ar.edu.utn.d2s.model.users.Terminal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportTotalSearchesTerminal implements Action {

    @Override
    public void execute(Terminal terminal) {

        Map<Terminal, Long> resultsPerTerminal = TerminalDAOMock.getTerminals().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Logger logger = LogManager.getLogger(this.getClass());
        logger.info("User, Total Results");
        resultsPerTerminal.forEach(((terminalUser, totalResults) -> logger.info(terminalUser.getUsername()+", "+totalResults.toString())));
    }
}
