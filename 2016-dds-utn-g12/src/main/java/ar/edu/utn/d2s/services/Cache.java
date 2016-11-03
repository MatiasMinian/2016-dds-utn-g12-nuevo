package ar.edu.utn.d2s.services;

public class Cache {

    private static Cache instance = null;

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

}
