package fr.diginamic.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reservation {
    @EmbeddedId
    private ReservationId id;
    private int nbPlaces;

    public Object ReservationId(ReservationId id) {
        return id;
    }

    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }
}
