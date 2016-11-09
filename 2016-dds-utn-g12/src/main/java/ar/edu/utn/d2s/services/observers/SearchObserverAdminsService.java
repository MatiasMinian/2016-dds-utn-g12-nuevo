package ar.edu.utn.d2s.services.observers;

import ar.edu.utn.d2s.database.AdministratorDAOMock;
import ar.edu.utn.d2s.model.users.Administrator;
import ar.edu.utn.d2s.utils.mail.MailConfig;
import ar.edu.utn.d2s.utils.mail.MailService;

import java.util.HashSet;
import java.util.Set;

public class SearchObserverAdminsService implements SearchObserver {

    private static SearchObserverAdminsService instance = null;

    private Set<Administrator> admins = new HashSet<>();
    private MailService mailService = MailService.getInstance();

    public static SearchObserverAdminsService getInstance() {
        if (instance == null) {
            instance = new SearchObserverAdminsService();
        }
        return instance;
    }

    private SearchObserverAdminsService() {
        // TODO Instead access data with DAO and DB

        admins.addAll(AdministratorDAOMock.getAdministrators());
    }

    @Override
    public void handleNewSearch(long searchTime, int results) {
        admins.forEach(admin -> {
            if (searchTime > admin.getSearchTimeLimit()) {
                if (!admin.getMail().isEmpty()){
                    mailService.sendMail(admin.getMail(), MailConfig.LONG_SEARCH_ADMIN_SUBJECT, makeMailBody(searchTime, results));
                }
            }
        });
    }

    private String makeMailBody(long searchTime, int results) {
        StringBuilder body = new StringBuilder();
        body.append(MailConfig.LONG_SEARCH_ADMIN_SUBJECT);
        body.append("/n");
        body.append(MailConfig.LONG_SEARCH_ADMIN_TIME);
        body.append(searchTime);
        body.append("/n");
        body.append(MailConfig.LONG_SEARCH_ADMIN_RESULTS);
        body.append(results);
        return body.toString();
    }
}
