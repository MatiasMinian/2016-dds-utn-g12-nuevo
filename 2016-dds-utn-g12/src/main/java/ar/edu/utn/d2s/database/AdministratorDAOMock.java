package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.users.Administrator;

import java.util.ArrayList;
import java.util.List;

public class AdministratorDAOMock {

    /**
     * TODO
     * Change this to a Administrator DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for Administrator entity that will be persisted in the future.
     */

    public static List<Administrator> administrators = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(Administrator administrator) {
        Administrator targetAdministrator = findById(administrator.getId());
        if (targetAdministrator == null) {
            administrators.add(administrator);
        } else {
            targetAdministrator = administrator;
        }
    }

    public static void delete(Administrator administrator) {
        administrators.remove(administrator);
    }

    public static Administrator findById(Long id) {
        return administrators.stream().filter(admin -> admin.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Administrator> getAdministrators() {
        return administrators;
    }

    public static void setAdministrators(List<Administrator> administrators) {
        AdministratorDAOMock.administrators = administrators;
    }
}
