package ar.edu.utn.d2s.model.users;

public class Administrator {

    private String mail;

    public Administrator(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        if (mail == null) {
            mail = "";
        }
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
