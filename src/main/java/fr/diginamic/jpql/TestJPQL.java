package fr.diginamic.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            System.out.println("Tous les films dans lesquels un acteur donné a joué\n");
            Query query = em.createQuery("SELECT r.film FROM Role r WHERE r.acteur.idImdb = :idActeur");
            query.setParameter("idActeur", "nm0465465");

            List<Film> films = query.getResultList();
            for (Film film : films) {
                System.out.println("Film : " + film.getNom() + " (" + film.getAnnee() + ")");
            }

            // Tous les acteurs ayant joué dans un film d’un genre donné
            System.out.println("\nTous les acteurs ayant joué dans un film d’un genre donné :");
            Query query2 = em.createQuery("SELECT DISTINCT r.acteur FROM Role r JOIN r.film f JOIN f.genres g WHERE g.nom = :nomGenre");
            query2.setParameter("nomGenre", "Action");

            List<Acteur> acteurs = query2.getResultList();
            System.out.println("Ayant joué dans la catégorie Action : ");
            for (Acteur acteur : acteurs) {
                System.out.println("Acteur : " + acteur.getIdentite());
            }


            // Tous les films réalisés par un réalisateur d'un pays donné
            System.out.println("\nTous les films réalisés par un réalisateur d'un pays donné :");
            Query query3 = em.createQuery("SELECT DISTINCT f FROM Film f JOIN f.pays p WHERE p.nom = :nomPays");
            query3.setParameter("nomPays", "France");

            List<Film> films2 = query3.getResultList();
            for (Film film : films2) {
                System.out.println("Film : " + film.getNom() + " (" + film.getAnnee() + ")");
            }



            // Tous les pays dans lesquels ont été diffusés les films d’un genre donné
            System.out.println("\nTous les pays dans lesquels ont été diffusés les films d’un genre donné :");
            Query query4 = em.createQuery("SELECT DISTINCT p FROM Film f JOIN f.genres g JOIN f.pays p WHERE g.nom = :genre");
            query4.setParameter("genre", "Romance");

            List<Pays> pays = query4.getResultList();
            for (Pays pi : pays) {
                System.out.println("Pays : " + pi.getNom());
            }



            // Nombre de films par genre
            Query query5 = em.createQuery("SELECT g.nom, COUNT(f) FROM Film f JOIN f.genres g GROUP BY g.nom");
            query5.getResultList();


            System.out.println(query5.getResultList());



            // Tous les réalisateurs ayant travaillé avec un acteur donné
//            System.out.println("\nTous les réalisateurs ayant travaillé avec un acteur donné");
//            Query query6 = em.createQuery("SELECT DISTINCT realisateur FROM Role r JOIN r.film f JOIN f.realisateurs realisateur WHERE r.acteur.nom = :nom");
//            query6.getResultList();
//
//            System.out.println(query6.getResultList());






            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();  // Rollback en cas d'erreur
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();  // Fermer l'EntityManager pour libérer la connexion
            }
            if (emf != null && emf.isOpen()) {
                emf.close();  // Fermer l'EntityManagerFactory
            }
        }
    }

}
