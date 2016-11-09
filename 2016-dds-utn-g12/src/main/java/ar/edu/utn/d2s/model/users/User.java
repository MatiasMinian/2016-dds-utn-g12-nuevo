package ar.edu.utn.d2s.model.users;

public abstract class User {

    protected Long id;
    protected String username;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
