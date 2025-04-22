package fr.diginamic.heritage.joined;

import jakarta.persistence.Entity;

@Entity(name = "ClientJoined")
public class Client extends Personne {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String rouc) {
    }

    public void setPrenom(String coole) {
    }
}
