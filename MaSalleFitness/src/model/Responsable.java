package model;

import java.util.ArrayList;

public class Responsable extends Personne {
    private Integer numeroTravailleur;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Responsable(Integer numeroTravailleur, String nom, String prenom) {
        super(nom, prenom);
        this.numeroTravailleur = numeroTravailleur;
    }

    public Integer getNumeroTravailleur() {
        return numeroTravailleur;
    }

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }
}
