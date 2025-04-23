package fr.diginamic.heritage.plusplus;

import jakarta.persistence.Entity;

@Entity
public class VirementBancaire extends MoyenPaiement{
    private String iban;
    private String banque;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }
}
