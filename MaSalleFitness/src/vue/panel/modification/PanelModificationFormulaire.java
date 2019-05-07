package vue.panel.modification;

import model.*;
import vue.element.*;
import vue.panel.inscription.PanelFormulaireBase;
import vue.validateur.*;

import java.awt.*;
import java.util.Date;


public class PanelModificationFormulaire extends PanelFormulaireBase {
    public PanelModificationFormulaire(Candidat candidat){
        setLayout(new GridLayout(11, 2,25,15));
        //String nom = candidat.getNom();
        setComposantes("nom",new ElementFormulaireJTextField("Nom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                candidat.getNom()));
        setComposantes("prenom", new ElementFormulaireJTextField("Prénom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                candidat.getPrenom()));
        String[] valuesSexe = {"Homme","Femme"};
        setComposantes("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe,
                new PasVideValidation(),
                candidat.getSexe()=='h'?0:1));
        setComposantes("dateNaissance", new ElementFormulaireJSpinnerDate("Date de naissance",
                new PasVideValidation(),
                candidat.getDateNaissance()));
        setComposantes("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10,
                new OrValidation(new VideValidation(), new PatternValidation("0[1-9][0-9]{8}"))));
        String[] valuesExp = {"Non","Oui"};
        setComposantes("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp,
                new PasVideValidation(),
                candidat.getDebutant()?0:1));
        setComposantes("rue",new ElementFormulaireJTextField("Rue", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                candidat.getAdresse().getRue()));
        setComposantes("num", new ElementFormulaireJTextField("Numéro", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation("[0-9]*[a-zA-Z0-9]{1,5}")),
                candidat.getAdresse().getNumero()));
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation("[0-9]{4}")),
                candidat.getAdresse().getCodePostal()));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                candidat.getAdresse().getLocalite()));
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré",
                new NbValidation(1,'>'),
                candidat.getNbHeuresCoaching()));



        initList();

    }

    public String getNom(){
        return (String)getComposantes().get("nom").getValue();
    }
    public String getPrenom(){
        return (String)getComposantes().get("prenom").getValue();
    }
    public char getSexe(){
        return (int)getComposantes().get("sexe").getValue()==0?'h':'f';
    }
    public Date getDateNaissance(){
        return (Date)getComposantes().get("dateNaissance").getValue();
    }
    public String getNumTel(){
        return (String)getComposantes().get("numTel").getValue();
    }
    public boolean getExp(){
        return (int)getComposantes().get("experience").getValue()==0;
    }
    public String getLocalite() {
        return (String)getComposantes().get("localite").getValue();
    }

    public String getNumero() {
        return (String)getComposantes().get("num").getValue();
    }


    public String getRue() {
        return (String)getComposantes().get("rue").getValue();
    }


    public String getCodePostal() {
        return (String)getComposantes().get("codePostal").getValue();
    }

    public Adresse getAdresse(){
        return new Adresse(getLocalite(), getCodePostal(), getRue(), getNumero());
    }
    public int getNbHeures(){
        return (int)getComposantes().get("nbHeures").getValue();
    }
    public String getMaladies(){
        return (String)getComposantes().get("maladie").getValue();
    }
    public Coach getCoach(){
        return (Coach)getComposantes().get("coach").getValue();
    }
    public Nutritionniste getNutri(){
        return (Nutritionniste)getComposantes().get("nutri").getValue();
    }
    public Responsable getResponsable(){
        return(Responsable)getComposantes().get("responsable").getValue();
    }
}
