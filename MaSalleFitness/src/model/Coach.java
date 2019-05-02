package model;

import java.util.ArrayList;
import java.util.Date;

public class Coach extends Personne {
    private Integer matricule;
    private Integer salaireHoraire;
    private String nom;
    private String prenom;
    private String recompenses;
    private Date dateDebutCoaching;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Coach(Integer matricule, String nom, String prenom, String recompenses, Integer salaireHoraire, Date dateDebutCoaching) {
        super(nom, prenom);
        this.matricule = matricule;
        this.recompenses = recompenses;
        this.salaireHoraire = salaireHoraire;
        this.dateDebutCoaching = dateDebutCoaching;
    }

    public Integer getMatricule() {
        return matricule;
    }
}
