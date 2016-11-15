package ar.edu.utn.d2s.model.actions;

import ar.edu.utn.d2s.model.users.Terminal;

public abstract class Action {

    private Long id;
    private String name;

    public abstract void execute(Terminal terminal);

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
