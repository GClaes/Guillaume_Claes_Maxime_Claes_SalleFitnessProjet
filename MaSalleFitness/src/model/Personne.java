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
        if (nom == null || nom.trim().length() == 0) {
            throw new NomException(nom);
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().length() == 0) {
            throw new PrenomException(prenom);
        }
        this.prenom = prenom;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
