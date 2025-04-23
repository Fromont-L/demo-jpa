package fr.diginamic.heritage.plusplus;

import jakarta.persistence.Entity;

@Entity
public class Paypal extends MoyenPaiement {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
