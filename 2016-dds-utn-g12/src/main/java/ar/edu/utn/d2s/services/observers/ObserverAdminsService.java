package ar.edu.utn.d2s.services.observers;

import ar.edu.utn.d2s.database.AdministratorDAOMock;
import ar.edu.utn.d2s.model.users.Administrator;
import ar.edu.utn.d2s.utils.mail.MailService;

import java.util.HashSet;
import java.util.Set;

public class ObserverAdminsService implements SearchObserver {

    private static ObserverAdminsService instance = null;

    private Set<Administrator> admins = new HashSet<>();
    private MailService mailService = MailService.getInstance();

    public static ObserverAdminsService getInstance() {
        if (instance == null) {
            instance = new ObserverAdminsService();
        }
        return instance;
    }

    private ObserverAdminsService() {
        admins.addAll(AdministratorDAOMock.getAdministrators());
    }

    @Override
    public void handleNewSearch(long searchTime) {
        admins.forEach(admin -> {
            if (searchTime > admin.getSearchTimeLimit()) {

            }
        });
    }
}
