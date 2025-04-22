package fr.diginamic.heritage.advanced;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String immatriculation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
