package model;

import java.util.ArrayList;

public class Nutritionniste extends Personne {
    private Integer numReference;
    private String avis;
    private ArrayList <Candidat> candidats = new ArrayList <>();

    public Nutritionniste(Integer numReference, String nom, String prenom, String avis) {
        super(nom, prenom);
        this.numReference = numReference;
        this.avis = avis;
    }

    public void ajouterCandidat(Candidat candidat) {
        if (candidat != null) {
            candidats.add(candidat);
        }
    }

    public Integer getNumReference() {
        return numReference;
    }

    public String getAvis() {
        return avis;
    }

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }
}
