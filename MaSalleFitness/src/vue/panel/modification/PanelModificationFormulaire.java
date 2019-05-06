package vue.panel.modification;

import model.Candidat;
import vue.element.*;
import vue.panel.inscription.PanelFormulaireBase;
import vue.validateur.*;

import java.awt.*;
import java.util.Date;
import java.util.Map;


public class PanelModificationFormulaire extends PanelFormulaireBase {
    public PanelModificationFormulaire(){//Candidat candidat) {
        setLayout(new GridLayout(11, 2,25,15));
        //String nom = candidat.getNom();
        setComposantes("nom",new ElementFormulaireJTextField("Nom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                "Peet"));
        setComposantes("prenom", new ElementFormulaireJTextField("Prénom", 30,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                "Dimitri"));
        String[] valuesSexe = {"Homme","Femme"};
        setComposantes("sexe", new ElementFormulaireJComboBox("Sexe", valuesSexe,
                new PasVideValidation(),
                0));
        setComposantes("dateNaissance", new ElementFormulaireJSpinnerDate("Date de naissance",
                new PasVideValidation(),
                new Date()));
        setComposantes("numTel",new ElementFormulaireJTextField("Numéro de téléphone", 10,
                new OrValidation(new VideValidation(), new PatternValidation("0[1-9][0-9]{8}"))));
        String[] valuesExp = {"Non","Oui"};
        setComposantes("experience", new ElementFormulaireJComboBox("Avez-vous de l'expérience dans les salles de sport?",valuesExp,
                new PasVideValidation(),
                1));
        setComposantes("rue",new ElementFormulaireJTextField("Rue", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                "Ici"));
        setComposantes("num", new ElementFormulaireJTextField("Numéro", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation("[0-9]*[a-zA-Z0-9]{1,5}")),
                "123"));
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255,
                new AndValidation(new PasVideValidation(), new PatternValidation("[0-9]{4}")),
                "4500"));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255,
                new AndValidation(new PasVideValidation(),new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$")),
                "Andenne"));
        setComposantes("nbHeures", new ElementFormulaireJSpinnerNb("Nombre d'heures de coaching désiré",
                new NbValidation(1,'>'),
                15));



        initList();

    }
}
