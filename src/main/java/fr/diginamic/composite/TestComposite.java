package fr.diginamic.composite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestComposite {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Reservation").executeUpdate();

        //
        ReservationId reservationId = new ReservationId(1L, 1L);
        Reservation reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setNbPlaces(3);
        em.persist(reservation);

        //
        EmployeProjetId affectationId = new EmployeProjetId(2L, 1L);
        Affectation affectation = new Affectation();
        affectation.setId(affectationId);
        affectation.setDateDebut(LocalDate.of(2025, 1, 13).atStartOfDay());
        em.persist(affectation);

        //
        EmployeProjetId heuresId = new EmployeProjetId(2L, 1L);
        HeuresTravaillees heures = new HeuresTravaillees();
        heures.setId(heuresId);
        heures.setHeures(35);
        em.persist(heures);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
