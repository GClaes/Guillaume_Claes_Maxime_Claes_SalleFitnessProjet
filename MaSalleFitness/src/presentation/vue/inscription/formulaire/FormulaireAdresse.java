package presentation.vue.inscription.formulaire;

import model.Adresse;
import utilitaires.ConstantesRegex;
import presentation.vue.elements.ElementFormulaireJTextField;
import presentation.vue.validateurs.AndValidation;
import presentation.vue.validateurs.NombreValidation;
import presentation.vue.validateurs.PasVideValidation;
import presentation.vue.validateurs.PatternValidation;


import java.awt.*;

public class FormulaireAdresse extends PanelFormulaireBase {
    public FormulaireAdresse() {
        setLayout(new GridLayout(4,2,25,25));
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
        try {
            return new Adresse(getLocalite(), getCodePostal(), getRue(), getNumero());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void rafraichir(){
        removeAll();
        setComposantes("rue",new ElementFormulaireJTextField("Rue", 255, new AndValidation(new PasVideValidation(), new PatternValidation(ConstantesRegex.REGEX_RUE))));
        setComposantes("num", new ElementFormulaireJTextField("Numéro", 255, new AndValidation(new PasVideValidation(),new PatternValidation(ConstantesRegex.REGEX_NUM))));
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255, new AndValidation(new PasVideValidation(), new AndValidation(new PatternValidation(ConstantesRegex.REGEX_CODEPOSTAL),new NombreValidation(9992, NombreValidation.Sens.PLUS_PETIT)))));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255, new AndValidation(new PasVideValidation(),new PatternValidation(ConstantesRegex.REGEX_LOCALITE))));

        initList();
    }
}
