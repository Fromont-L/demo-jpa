package fr.diginamic.heritage.mappedsuperclass;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public class Audit {

    private LocalDate dateCreation;
    private LocalDate dateModification;
    private String creePar;

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public String getCreePar() {
        return creePar;
    }

    public void setCreePar(String creePar) {
        this.creePar = creePar;
    }
}
