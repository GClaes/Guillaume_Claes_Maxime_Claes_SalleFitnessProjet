package model;

import model.exceptions.*;

public abstract class Personne {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
    }

    public void setNom(String nom) {
        nom = nom.trim();

        if (nom == null || nom.length() == 0) {
            throw new NomException(nom);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        prenom = prenom.trim();

        if (prenom == null || nom.length() == 0) {
            throw new PrenomException(prenom);
        }
        this.prenom = prenom;
    }

}
