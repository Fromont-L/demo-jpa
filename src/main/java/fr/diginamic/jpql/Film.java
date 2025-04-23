package fr.diginamic.jpql;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Film {
    @Id
    private String idImdb;

    private String imdbHref;
    private String nom;
    private int annee;

    @OneToMany(mappedBy = "film")
    private List<Role> roles;

    @ManyToMany
    @JoinTable(name = "Film_Genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_nom"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "Film_Realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private List<Realisateur> realisateurs;

    @ManyToMany
    @JoinTable(name = "Film_Pays",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "pays_nom"))
    private List<Pays> pays;

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public String getImdbHref() {
        return imdbHref;
    }

    public void setImdbHref(String imdbHref) {
        this.imdbHref = imdbHref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public void setPays(List<Pays> pays) {
        this.pays = pays;
    }
}
