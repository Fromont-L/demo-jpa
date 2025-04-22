package fr.diginamic.heritage.singletable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestProduitSingleTable {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Créer un produit physique
        ProduitPhysique prodPhy = new ProduitPhysique();
        prodPhy.setNom("DrinkKola");
        prodPhy.setPrix(1.55);
        prodPhy.setPoids("245g");
        em.persist(prodPhy);


        // Créer un produit numérique
        ProduitNumerique prodNum = new ProduitNumerique();
        prodNum.setNom("Logiciel tout pourri");
        prodNum.setPrix(999.99);
        prodNum.setTailleFichier("69Go");
        em.persist(prodNum);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Insertion terminée ?");
    }
}
