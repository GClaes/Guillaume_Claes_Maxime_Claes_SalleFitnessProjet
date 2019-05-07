package model;

import java.util.ArrayList;

public class Responsable extends Personne {
    private Integer numeroTravailleur;
    private String nom;
    private String prenom;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Responsable(Integer numeroTravailleur, String nom, String prenom) {
        super(nom, prenom);
        this.numeroTravailleur = numeroTravailleur;
    }

    public Integer getNumeroTravailleur() {
        return numeroTravailleur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }
}
