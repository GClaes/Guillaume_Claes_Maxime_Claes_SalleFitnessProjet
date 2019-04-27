package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.exceptions.*;

public class Candidat extends Personne {
    private Integer numInscrit;
    private Integer nbHeuresCoaching;
    private String nom;
    private String prenom;
    private String maladiesChroniques;
    private Date dateNaissance;
    private Date dateTestValide;
    private Date dateInscription;
    private boolean estDebutant;
    private char sexe;
    private Nutritionniste nutritionniste;
    private Coach coach;
    private Responsable responsable;
    private Adresse adresse;
    private final Integer AGE_MINIMUM = 16;
    private static Integer nbInscriptions = 0;

    public Candidat(Integer nbHeuresCoaching, String nom, String prenom, String maladiesChroniques, Date dateNaissance, Date dateInscription, boolean estDebutant, char sexe, Nutritionniste nutritionniste, Coach coach, Responsable responsable, Adresse adresse) throws Exception {
        super(nom, prenom);
        setNumInscrit();
        this.nbHeuresCoaching = nbHeuresCoaching;
        this.maladiesChroniques = maladiesChroniques;
        setDateNaissance(dateNaissance);
        this.dateInscription = dateInscription;
        this.estDebutant = estDebutant;
        this.sexe = sexe;
        this.nutritionniste = nutritionniste;
        this.coach = coach;
        this.responsable = responsable;
        this.adresse = adresse;
    }

    public void setNumInscrit() {
        this.numInscrit = nbInscriptions;
        nbInscriptions++;
    }

    public void setDateNaissance(Date dateNaissance) throws DateNaissanceException {
        if (dateNaissance == null || age(dateNaissance) < AGE_MINIMUM) {
            throw new DateNaissanceException(dateNaissance);
        }
        this.dateNaissance = dateNaissance;
    }

    private int age(Date dateNaissance) {
        int anneesDifference;
        int moisDifference;
        int joursDifference;

        GregorianCalendar today = new GregorianCalendar();
        Calendar naissance = Calendar.getInstance();
        naissance.setTime(dateNaissance);

        anneesDifference = today.get(Calendar.YEAR) - naissance.get(Calendar.YEAR);
        moisDifference = today.get(Calendar.MONTH) - naissance.get(Calendar.MONTH);
        joursDifference = today.get(Calendar.DAY_OF_MONTH) - naissance.get(Calendar.DAY_OF_MONTH);

        if (moisDifference < 0) {
            return anneesDifference - 1;
        }

        if (moisDifference > 0) {
            return anneesDifference;
        }

        if (joursDifference < 0) {
            return anneesDifference - 1;
        }

        return anneesDifference;
    }

    public void setDateTestValide(Date dateTestValide) {

    }
}
