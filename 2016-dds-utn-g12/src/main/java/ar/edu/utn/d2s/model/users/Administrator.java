package ar.edu.utn.d2s.model.users;

public class Administrator {

    private String mail;
    private long searchTimeLimit;

    public Administrator(String mail, long searchTimeLimit) {
        this.mail = mail;
        this.searchTimeLimit = searchTimeLimit;
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

    public long getSearchTimeLimit() {
        return searchTimeLimit;
    }

    public void setSearchTimeLimit(long searchTimeLimit) {
        this.searchTimeLimit = searchTimeLimit;
    }
}
