package vue.inscription;

import model.Adresse;
import model.Coach;
import model.Nutritionniste;
import model.Responsable;

import java.util.Date;

public class PersonalData {
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private char sexe;
    private boolean estDebutant;
    private String numeroGSM;
    private Integer nbHeuresCoaching;
    private String maladiesChroniques;
    private Coach coach;
    private Nutritionniste nutri;
    private Responsable responsable;
    private Adresse adresse;


    public PersonalData() {

    }

    //SETTERS

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setEstDebutant(boolean estDebutant) {
        this.estDebutant = estDebutant;
    }

    public void setNumeroGSM(String numeroGSM) {
        this.numeroGSM = numeroGSM;
    }

    public void setNbHeuresCoaching(Integer nbHeuresCoaching) {
        this.nbHeuresCoaching = nbHeuresCoaching;
    }

    public void setMaladiesChroniques(String maladiesChroniques) {
        this.maladiesChroniques = maladiesChroniques;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setNutri(Nutritionniste nutri) {
        this.nutri = nutri;
    }


    //GETTERS

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public String getNumeroGSM() {
        return numeroGSM;
    }

    public Integer getNbHeuresCoaching() {
        return nbHeuresCoaching;
    }

    public String getMaladiesChroniques() {
        return maladiesChroniques;
    }

    public Coach getCoach() {
        return coach;
    }

    public Nutritionniste getNutri() {
        return nutri;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public boolean getEstDebutant() {
        return estDebutant;
    }
}
