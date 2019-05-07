package model;

import java.util.ArrayList;

public class Nutritionniste extends Personne {
    private Integer numReference;
    private String nom;
    private String prenom;
    private String avis;
    private ArrayList <Candidat> candidats = new ArrayList <>();

    public Nutritionniste(Integer numReference, String nom, String prenom, String avis) {
        super(nom, prenom);
        this.numReference = numReference;
        this.avis = avis;
    }

    public Integer getNumReference() {
        return numReference;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAvis() {
        return avis;
    }

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }
}
