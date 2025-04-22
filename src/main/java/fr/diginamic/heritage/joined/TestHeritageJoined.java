package fr.diginamic.heritage.joined;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestHeritageJoined {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Créer un employé
        Employe chomeur = new Employe();
        chomeur.setNom("Carmouze");
        chomeur.setPrenom("Patrice");
        chomeur.setSalaire(2345.60);
        chomeur.setPoste("Présentateur télé");
        chomeur.setEmail("meilleurpresentateur@ever.fr");

        // Création d'un client
        Client pigeon = new Client();
        pigeon.setNom("Rouc");
        pigeon.setPrenom("Coole");
        pigeon.setEmail("jesuis1pigeon@hotmail.de");

        em.persist(chomeur);
        em.persist(pigeon);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Insertion terminée ?");
        System.out.println();

    }
}
