package fr.diginamic.heritage.advanced;

import jakarta.persistence.Entity;

@Entity
public class Bus extends Vehicule{
    private int capacite;

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
