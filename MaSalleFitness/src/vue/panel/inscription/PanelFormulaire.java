package vue.panel.inscription;

import vue.validateur.*;
import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinnerDate;
import vue.element.ElementFormulaireJTextField;

import java.awt.*;
import java.util.*;

public class PanelFormulaire extends PanelFormulaireBase {

    public PanelFormulaire() {
        setLayout(new GridLayout(6, 2,25,25));

        setComposantes("nom",new ElementFormulaireJTextField("Nom", 30,new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));
        setComposantes("prenom", new ElementFormulaireJTextField("Prénom", 30, new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));
        String[] valuesSexe = {"Homme","Femme"};
        setComposantes("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe, new PasVideValidation()));
        setComposantes("dateNaissance", new ElementFormulaireJSpinnerDate("Date de naissance", new PasVideValidation()));
        setComposantes("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10, new OrValidation(new VideValidation(), new PatternValidation("0[1-9][0-9]{8}"))));
        String[] valuesExp = {"Non","Oui"};
        setComposantes("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp,new PasVideValidation()));

        for(Map.Entry<String,ElementFormulaire> entree : getComposantes().entrySet()){
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }

    }

}
