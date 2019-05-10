package model;

import java.util.Date;

public class Coach extends Personne {
    private Integer matricule;
    private double salaireHoraire;
    private String recompenses;
    private Date dateDebutCoaching;

    public Coach(Integer matricule, String nom, String prenom, String recompenses, double salaireHoraire, Date dateDebutCoaching) {
        super(nom, prenom);
        this.matricule = matricule;
        this.recompenses = recompenses;
        this.salaireHoraire = salaireHoraire;
        this.dateDebutCoaching = dateDebutCoaching;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public String getRecompenses() {
        return recompenses;
    }

    public Date getDateDebutCoaching() {
        return dateDebutCoaching;
    }

}
