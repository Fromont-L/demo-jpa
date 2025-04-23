package fr.diginamic.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Affectation {
    @EmbeddedId
    private EmployeProjetId id;
    private LocalDateTime dateDebut;

    public EmployeProjetId getId(){
        return id;
    }

    public void setId(EmployeProjetId id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }


}
