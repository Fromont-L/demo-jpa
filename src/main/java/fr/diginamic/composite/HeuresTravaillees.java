package fr.diginamic.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class HeuresTravaillees {
    @EmbeddedId
    private EmployeProjetId id;

    private int heures;


    public EmployeProjetId getId() {
        return id;
    }

    public void setId(EmployeProjetId id) {
        this.id = id;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}
