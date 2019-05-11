package vue.recherches;

import model.*;
import utilitaires.ConstantesRegex;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinnerDate;
import vue.element.ElementFormulaireJSpinnerNb;
import vue.element.ElementFormulaireJTextField;
import vue.inscription.formulaire.PanelFormulaireBase;
import vue.validateur.*;

import java.awt.*;
import java.util.Date;

public class FormulaireModification extends PanelFormulaireBase {
    private Candidat candidat;
    public FormulaireModification(Candidat candidat){
        this.candidat = candidat;
        setLayout(new GridLayout(13, 2,25,15));
        setComposantes("nom",new ElementFormulaireJTextField("Nom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_NOM)),
                candidat.getNom()));
        setComposantes("prenom", new ElementFormulaireJTextField("Prénom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_PRENOM)),
                candidat.getPrenom()));
        String[] valuesSexe = {"Homme","Femme"};
        setComposantes("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe,
                candidat.getSexe()=='h'?0:1));
        setComposantes("dateNaissance", new ElementFormulaireJSpinnerDate("Date de naissance",
                new AgeValidation(),
                candidat.getDateNaissance()));
        setComposantes("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10,
                new OrValidation(new VideValidation(), new PatternValidation(ConstantesRegex.REGEX_NUMTEL)),
                candidat.getNumeroGSM()));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies éventuelles", 255,
                candidat.getMaladiesChroniques()));
        setComposantes("rue",new ElementFormulaireJTextField("Rue", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_RUE)),
                candidat.getAdresse().getRue()));
        setComposantes("num", new ElementFormulaireJTextField("Numéro", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation(ConstantesRegex.REGEX_NUM)),
                candidat.getAdresse().getNumero()));
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_CODEPOSTAL)),
                candidat.getAdresse().getCodePostal()));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation(ConstantesRegex.REGEX_LOCALITE)),
                candidat.getAdresse().getLocalite()));
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré",
                new NbValidation(1,'>'),
                candidat.getNbHeuresCoaching()));
        String[]values = {"Oui","Non"};
        setComposantes("validerTest", new ElementFormulaireJComboBox("Valider la date du test?", values,
                candidat.getDateTestValide()==null?1:0));
        try {
            setComposantes("dateTest", new ElementFormulaireJSpinnerDate("Date du test",
                    new DateValidation(candidat.getDateInscription()),
                    candidat.getDateTestValide()));
        }catch (Exception e){
            setComposantes("dateTest", new ElementFormulaireJSpinnerDate("Date du test",
                    new DateValidation(candidat.getDateInscription()),
                    new Date()));
        }
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
    public boolean getValiderTest(){
        return (int)getComposantes().get("validerTest").getValue() == 0;
    }
    public Date getDateTestValide(){
        if(getValiderTest()) {
            return (Date) getComposantes().get("dateTest").getValue();
        }
        else{
            return null;
        }
    }
    public int getNumInscription(){
        return candidat.getNumInscription();
    }
    public Date getDateInscription(){
        return candidat.getDateInscription();
    }


    public String getMaladies(){
        return (String)getComposantes().get("maladie").getValue();
    }
    public Coach getCoach(){
        return candidat.getCoach();
    }
    public Nutritionniste getNutri(){
        return candidat.getNutritionniste();
    }
    public Responsable getResponsable(){
        return candidat.getResponsable();
    }
}
