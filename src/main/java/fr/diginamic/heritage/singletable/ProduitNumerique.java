package fr.diginamic.heritage.singletable;

import jakarta.persistence.Entity;

@Entity
public class ProduitNumerique extends Produit{
    private String tailleFichier;

    @Override
    public void setTailleFichier(String tailleFichier) {
        this.tailleFichier = tailleFichier;
    }
}
