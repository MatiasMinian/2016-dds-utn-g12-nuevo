package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMock {

    /**
     * TODO
     * Change this to a User DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for User entity that will be persisted in the future.
     */

    public static List<User> users = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdate(User user) {
        User targetUser = findById(user.getId());
        if (targetUser == null) {
            users.add(user);
        } else {
            targetUser = user;
        }
    }

    public static void delete(User user) {
        users.remove(user);
    }

    public static User findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserDAOMock.users = users;
    }
}
