package fr.diginamic.heritage.plusplus;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class CarteCredit extends MoyenPaiement{
    private int numero;
    private LocalDateTime dateExpiration;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
