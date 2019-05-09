package model;

import java.util.Date;

import model.exceptions.*;
import utilitaires.DateUtilitaire;

public class Candidat extends Personne {
    private Integer numInscription;
    private Integer nbHeuresCoaching;
    private String maladiesChroniques;
    private String numeroGSM;
    private Date dateNaissance;
    private Date dateTestValide;
    private Date dateInscription;
    private boolean estDebutant;
    private char sexe;
    private Coach coach;
    private Responsable responsable;
    private Nutritionniste nutritionniste;
    private Adresse adresse;
    private final Integer AGE_MINIMUM = 16;

    public Candidat(Integer nbHeuresCoaching, String nom, String prenom, Date dateNaissance, char sexe, Coach coach, Responsable responsable, Nutritionniste nutritionniste, Adresse adresse) {
        super(nom, prenom);
        setNbHeuresCoaching(nbHeuresCoaching);
        setDateNaissance(dateNaissance);
        setSexe(sexe);
        dateInscription = new Date();
        this.coach = coach;
        this.responsable = responsable;
        this.nutritionniste = nutritionniste;
        this.adresse = adresse;
    }

    public void setNumInscrit(int numero) {
        this.numInscription = numero;
    }

    public void setNbHeuresCoaching(Integer nbHeuresCoaching) {
        if (nbHeuresCoaching == null || nbHeuresCoaching < 1) {
            throw new NbHeuresCoachingException(nbHeuresCoaching);
        }
        this.nbHeuresCoaching = nbHeuresCoaching;
    }

    public void setDateNaissance(Date dateNaissance) {
        if (dateNaissance == null || DateUtilitaire.age(dateNaissance) < AGE_MINIMUM) {
            throw new DateNaissanceException(dateNaissance);
        }
        this.dateNaissance = dateNaissance;
    }

    public void setSexe(char sexe) {
        if (sexe == '\0' || sexe != 'h' && sexe != 'f' && sexe != 'H' && sexe != 'F') {
            throw new SexeException(sexe);
        }
        this.sexe = sexe;
    }

    public void setMaladiesChroniques(String maladiesChroniques) {      //Mettre une longueur pour la validation
        this.maladiesChroniques = maladiesChroniques;
    }

    public void setNumeroGSM(String numeroGSM) {
        if (numeroGSM != null && numeroGSM.length() != 0) {
            if (numeroGSM.charAt(0) != '0') {
                throw new NumeroGSMException(numeroGSM);
            } else {
                if (numeroGSM.charAt(1) == '4') {
                    if (numeroGSM.length() != 10) {
                        throw new NumeroGSMException(numeroGSM);
                    }
                } else {
                    if (numeroGSM.length() != '9') {
                        throw new NumeroGSMException(numeroGSM);
                    }
                }
            }
        }
        this.numeroGSM = numeroGSM;
    }

    public void setDateTestValide(Date dateTestValide) {
        Date today = new Date();

        if (dateTestValide != null && dateInscription.compareTo(dateTestValide) > 0 && today.compareTo(dateTestValide) < 0) {      //Pas de validation de null car la db l'utilise et peut etre null dans la db
            throw new DateTestValideException(dateTestValide);
        }
        this.dateTestValide = dateTestValide;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setEstDebutant(boolean estDebutant) {
        this.estDebutant = estDebutant;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Integer getNumInscription() {
        return numInscription;
    }

    public Integer getNbHeuresCoaching() {
        return nbHeuresCoaching;
    }

    public String getMaladiesChroniques() {
        return maladiesChroniques;
    }

    public String getNumeroGSM() {
        return numeroGSM;
    }

    public java.util.Date getDateNaissance() {
        return dateNaissance;
    }

    public Date getDateTestValide() {
        return dateTestValide;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public boolean getDebutant() {
        return estDebutant;
    }

    public char getSexe() {
        return sexe;
    }

    public Coach getCoach() {
        return coach;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Nutritionniste getNutritionniste() {
        return nutritionniste;
    }

    public Adresse getAdresse() {
        return adresse;
    }
}
