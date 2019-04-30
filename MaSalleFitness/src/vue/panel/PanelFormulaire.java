package vue;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelFormulaire extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;

    public PanelFormulaire() {
        setLayout(new GridLayout(6, 2,25,25));

        composantes = new LinkedHashMap<>();
        composantes.put("nom",new ElementFormulaireJTextField("Nom", 30));
        composantes.put("prenom", new ElementFormulaireJTextField("Prénom", 30));
        String[] valuesSexe = {"Homme","Femme"};
        composantes.put("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe));
        composantes.put("dateNaissance", new ElementFormulaireJSpinner("DateNaissance"));
        composantes.put("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10));
        String[] valuesExp = {"Non","Oui"};
        composantes.put("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp));


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

    public String getPrénom() {
        return (String)composantes.get("prenom").getValue();
    }

    public String getNumTel() {
        return (String)composantes.get("numTel").getValue();
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

}
