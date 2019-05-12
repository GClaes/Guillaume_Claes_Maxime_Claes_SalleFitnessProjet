package presentation.vue.inscription.formulaire;


import utilitaires.ConstantesRegex;
import presentation.vue.elements.ElementFormulaireJComboBox;
import presentation.vue.elements.ElementFormulaireJSpinnerDate;
import presentation.vue.elements.ElementFormulaireJTextField;
import presentation.vue.validateurs.*;

import java.awt.*;
import java.util.Date;

public class FormulaireDonneesPerso extends PanelFormulaireBase {

    public FormulaireDonneesPerso() {
        setLayout(new GridLayout(6, 2,25,25));
    }

    public void rafraichir(){
        removeAll();
        setComposantes("nom",new ElementFormulaireJTextField("Nom", 30,new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_NOM)),""));
        setComposantes("prenom", new ElementFormulaireJTextField("Prénom", 30, new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_PRENOM)),""));
        String[] valuesSexe = {"Homme","Femme"};
        setComposantes("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe));
        setComposantes("dateNaissance", new ElementFormulaireJSpinnerDate("Date de naissance", new AgeValidation()));
        setComposantes("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10, new OrValidation(new VideValidation(), new PatternValidation(ConstantesRegex.REGEX_NUMTEL)),""));
        String[] valuesExp = {"Non","Oui"};
        setComposantes("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp));

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


}
