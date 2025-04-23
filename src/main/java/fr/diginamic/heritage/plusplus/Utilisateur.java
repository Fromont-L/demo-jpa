package fr.diginamic.heritage.plusplus;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<MoyenPaiement> moyensPaiement = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<MoyenPaiement> getMoyensPaiement() {
        return moyensPaiement;
    }

    public void setMoyensPaiement(List<MoyenPaiement> moyensPaiement) {
        this.moyensPaiement = moyensPaiement;
    }

    public void ajouterMoyenPaiement(MoyenPaiement moyenPaiement) {
        moyensPaiement.add(moyenPaiement);
        moyenPaiement.setUtilisateur(this);
    }
}
