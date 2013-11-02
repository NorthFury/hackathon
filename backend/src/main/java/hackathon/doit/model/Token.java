package hackathon.doit.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Token extends BaseEntity {

    private String token;

    @ManyToOne
    private Account account;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
