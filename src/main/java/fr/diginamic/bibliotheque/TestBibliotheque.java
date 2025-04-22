package fr.diginamic.bibliotheque;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBibliotheque {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();
        // Chercher le livre avec l'id 1
        Livre livre = em.find(Livre.class, 1);
        if (livre != null) {
            System.out.println(livre.getId());
            System.out.println("Livre ID: " + livre.getId());
        } else {
            System.out.println("Aucun livre trouvé");
        }
        em.close();



        EntityManager emm = emf.createEntityManager();
        EntityTransaction et = emm.getTransaction();
        et.begin();

        // Création d'un nouveau client
        Client client = new Client();
        client.setNom("Garcia");
        client.setPrenom("José");

        emm.persist(client);

        // Création de deux nouveaux livres
        Livre livre1 = new Livre("Martine va à la plage", "Le Pape François II");
        Livre livre2 = new Livre("Marine va en prison", "Nicolas Sarkozy");
        emm.persist(livre1);
        emm.persist(livre2);


        // Création d'un emprunt
        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(LocalDate.now());
        emprunt.setDelai(51);
        emprunt.setClient(client);

        emprunt.setLivres(Arrays.asList(livre1, livre2));

        emm.persist(emprunt);

        et.commit();
        emm.close();


        EntityManager em2 = emf.createEntityManager();
        Client c = em2.find(Client.class, client.getId());
        System.out.println("Livres empruntés par " + c.getPrenom() + " " + c.getNom() + " :");

        for (Emprunt e : c.getEmprunts()) {
            for (Livre l : e.getLivres()) {
                System.out.println(l.getTitre() + " écrit par : " + l.getAuteur());
            }
        }

        em2.close();


        EntityManager em3 = emf.createEntityManager();
        EntityTransaction et2 = em3.getTransaction();
        et2.begin();

        // Récupérer un emprunt
        Emprunt e = em3.find(Emprunt.class, emprunt.getId());

        // Créer un nouveau livre
        Livre nouveauLivre = new Livre("Le temps des raclettes", "Riche Mont");
        em3.persist(nouveauLivre);

        if (e.getLivres() == null) {
            e.setLivres(new ArrayList<>());
        }
        e.getLivres().add(nouveauLivre);

        et2.commit();
        em3.close();




        EntityManager em4 = emf.createEntityManager();
        EntityTransaction et3 = em4.getTransaction();
        et3.begin();

        Emprunt e2 = em4.find(Emprunt.class, emprunt.getId());
        em4.remove(e2);

        et3.commit();
        em4.close();

    }
}
