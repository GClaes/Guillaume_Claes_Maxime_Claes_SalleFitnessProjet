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

    public Coach(Integer matricule, Integer salaireHoraire, String nom, String prenom, String recompenses, Date dateDebutCoaching) throws Exception {
        super(nom, prenom);
        this.matricule = matricule;
        this.salaireHoraire = salaireHoraire;
        this.recompenses = recompenses;
        this.dateDebutCoaching = dateDebutCoaching;
    }

}
