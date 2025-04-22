package fr.diginamic.heritage.singletable;

import jakarta.persistence.Entity;

@Entity
public class ProduitPhysique extends Produit{
    private String poids;

    @Override
    public void setPoids(String poids) {
        this.poids = poids;
    }
}
