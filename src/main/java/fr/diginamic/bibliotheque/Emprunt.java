package fr.diginamic.bibliotheque;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    private int delai;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = true)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "compo",
            joinColumns = @JoinColumn(name = "id_emprunt"),
            inverseJoinColumns = @JoinColumn(name = "id_livre")
    )
    private List<Livre> livres;


    public Emprunt() {}

    public Emprunt(LocalDate dateDebut, int delai, LocalDate dateFin, Client client) {
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
