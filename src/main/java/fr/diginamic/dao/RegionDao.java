package fr.diginamic.dao;

import fr.diginamic.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class RegionDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public RegionDao(){
        this.emf = Persistence.createEntityManagerFactory("pu_essai");
        this.em = emf.createEntityManager();
    }

    public void createRegion(String nom){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Region region = new Region(nom);
        em.persist(region);

        transaction.commit();
    }

    public Region readRegion(int id){
        Region region = em.find(Region.class, id);
        return region;
    }

    public List<Region> getAllRegions(){
        List<Region> regions = em.createQuery("SELECT u FROM Region u", Region.class).getResultList();
        return regions;
    }

    public void updateRegion(int id, String nouveauNom){
        em.getTransaction().begin();

        Region region = em.find(Region.class, id);

        if(region != null){
            region.setNom(nouveauNom);
        }

        em.getTransaction().commit();
    }

    public void deleteRegion(int id){
        em.getTransaction().begin();

        Region region = em.find(Region.class, id);

        if(region != null){
            em.remove(region);
        }

        em.getTransaction().commit();
    }

    public void close() {
        if (em != null && em.isOpen()) em.close();
        if (emf != null && emf.isOpen()) emf.close();
    }
}
