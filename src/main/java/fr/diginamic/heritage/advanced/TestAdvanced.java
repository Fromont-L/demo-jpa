package fr.diginamic.heritage.advanced;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestAdvanced {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Bus bus = new Bus();
        bus.setCapacite(69);
        bus.setImmatriculation("J41F41M");
        em.persist(bus);

        Tramway tram = new Tramway();
        tram.setNbRames(13);
        tram.setImmatriculation("P3T1TM415V1T3");
        em.persist(tram);

        Trajet trajet1 = new Trajet();
        trajet1.setVehicule(bus);
        trajet1.setDepart("Carcassonne");
        trajet1.setArrivee("Séoul");
        em.persist(trajet1);

        Trajet trajet2 = new Trajet();
        trajet2.setVehicule(tram);
        trajet2.setDepart("Montricoux-Ouest");
        trajet2.setArrivee("Montricoux-Est");
        em.persist(trajet2);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Insertion terminée ?");
    }
}
