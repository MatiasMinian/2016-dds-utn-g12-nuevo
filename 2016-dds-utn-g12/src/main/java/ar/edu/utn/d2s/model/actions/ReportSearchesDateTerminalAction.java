package ar.edu.utn.d2s.model.actions;

import ar.edu.utn.d2s.model.search.SearchResult;
import ar.edu.utn.d2s.model.users.Terminal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportSearchesDateTerminalAction extends Action {

    @Override
    public void execute(Terminal terminal) {
        // TODO Check if this should be a logged or write in file or should a map be returned
        Map<Calendar, Long> resultsPerDate = terminal.getSearchResults().stream().collect(Collectors.groupingBy(SearchResult::getDate, Collectors.counting()));

        Logger logger = LogManager.getLogger(this.getClass());
        logger.info("Date, Number of Results");
        resultsPerDate.forEach((calendar, numberOfResults) -> logger.info(calendar.getTime().toString()+", "+numberOfResults.toString()));
    }
}
