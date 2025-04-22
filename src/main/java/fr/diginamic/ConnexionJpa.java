package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(("pu_essai"));
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Connexion établie !");

            em.getTransaction().begin();

            // Insérer une région
            Region r = new Region("Vendée");
            em.persist(r);
            em.getTransaction().commit();
            System.out.println("Région ajoutée : " + r);

            Region region = em.find(Region.class, 1);
            if (region != null) {
                System.out.println("Région trouvée : " + region);
            } else {
                System.out.println("Aucune région trouvée...");
            }

            em.getTransaction().begin();
            Region ancienneRegion = em.find(Region.class, 1);
            ancienneRegion.setNom("Bretagne");
            em.getTransaction().commit();

            em.getTransaction().begin();
            em.remove(ancienneRegion);
            em.getTransaction().commit();

            List<Region> regions = Arrays.asList(
                    new Region("Jaj"),
                    new Region("Jej"),
                    new Region("Juj"),
                    new Region("Joj"),
                    new Region("Jij")
            );

            // Insérer toutes les régions de la table
            em.getTransaction().begin();
            for (Region reg : regions) {
                em.persist(reg);
            }
            em.getTransaction().commit();

            // Récupérer toutes les régions de la table
            List<Region> toutesRegions = em.createQuery("SELECT r FROM Region r", Region.class).getResultList();
            for(Region toute : toutesRegions) {
                System.out.println(toute.getNom());
            }


        } finally {
            em.close();
            emf.close();
        }


    }
}
