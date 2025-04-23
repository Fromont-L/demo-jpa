package fr.diginamic.composite;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {
    private long idClient;
    private long idEvenement;

    public ReservationId() {}

    public ReservationId(long idClient, long idEvenement) {
        this.idClient = idClient;
        this.idEvenement = idEvenement;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(long idEvenement) {
        this.idEvenement = idEvenement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationId)) return false;
        ReservationId that = (ReservationId) o;
        return Objects.equals(idClient, that.idClient) && Objects.equals(idEvenement, that.idEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idEvenement);
    }
}
