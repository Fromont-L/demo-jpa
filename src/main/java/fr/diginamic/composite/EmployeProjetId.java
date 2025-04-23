package fr.diginamic.composite;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeProjetId implements Serializable {

    private long idEmploye;
    private long idProjet;

    public EmployeProjetId() {}

    public EmployeProjetId(long idEmploye, long idProjet) {
        this.idEmploye = idEmploye;
        this.idProjet = idProjet;
    }

    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(long idProjet) {
        this.idProjet = idProjet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeProjetId that)) return false;
        return Objects.equals(idEmploye, that.idEmploye) &&
                Objects.equals(idProjet, that.idProjet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmploye, idProjet);
    }
}
