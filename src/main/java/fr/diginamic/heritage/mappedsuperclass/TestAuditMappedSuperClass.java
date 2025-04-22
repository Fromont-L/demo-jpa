package fr.diginamic.heritage.mappedsuperclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestAuditMappedSuperClass {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Créer un article
        Article article = new Article();
        article.setTitre("Article sur la reproduction des tiques des champs");
        article.setDateCreation(LocalDate.from(LocalDateTime.now()));
        article.setDateModification(LocalDate.from(LocalDateTime.now()));
        article.setCreePar("AndréleBG");
        em.persist(article);

        // Créer un commentaire
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu("C'EST DÉGUEUUUUU :emojivomit: !!!");
        commentaire.setDateCreation(LocalDate.from(LocalDateTime.now()));
        commentaire.setDateModification(LocalDate.from(LocalDateTime.now()));
        commentaire.setCreePar("sensible_13");
        em.persist(commentaire);


        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Insertion terminée ?");
    }
}
