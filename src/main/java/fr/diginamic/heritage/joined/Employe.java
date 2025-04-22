package fr.diginamic.heritage.joined;

import jakarta.persistence.Entity;

@Entity
public class Employe extends Personne{
    private double salaire;
    private String poste;

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setEmail(String mail) {

    }
}
