package vue.panel;

import vue.validateur.*;
import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinner;
import vue.element.ElementFormulaireJTextField;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelFormulaire extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;

    public PanelFormulaire() {
        setLayout(new GridLayout(6, 2,25,25));

        composantes = new LinkedHashMap<>();
        composantes.put("nom",new ElementFormulaireJTextField("Nom", 30,new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));
        composantes.put("prenom", new ElementFormulaireJTextField("Prénom", 30, new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));
        String[] valuesSexe = {"Homme","Femme"};
        composantes.put("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe, null));
        composantes.put("dateNaissance", new ElementFormulaireJSpinner("DateNaissance", null));
        composantes.put("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10, new OrValidation(new VideValidation(), new PatternValidation("0[1-9][0-9]{8}"))));
        String[] valuesExp = {"Non","Oui"};
        composantes.put("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp,null));

        for(Map.Entry<String,ElementFormulaire> entree : composantes.entrySet()){
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }

    }

    public String getNom() {
        return (String)composantes.get("nom").getValue();
    }
    public boolean nomValide(){
        return composantes.get("nom").valider();
    }

    public String getPrénom() {
        return (String)composantes.get("prenom").getValue();
    }
    public boolean prénomValide(){
        return composantes.get("prenom").valider();
    }


    public String getNumTel() {
        return (String)composantes.get("numTel").getValue();
    }
    public boolean numTelValide(){
        return composantes.get("numTel").valider();
    }

    public int getSexe() {
        return (int)composantes.get("sexe").getValue();
    }

    public int getExperience() {
        return (int)composantes.get("experience").getValue();
    }

    public Date getDateNaissance() {
        return (Date)composantes.get("dateNaissance").getValue();
    }
    public boolean dateNaissanceValide(){
        return composantes.get("dateNaissance").valider();
    }

}
