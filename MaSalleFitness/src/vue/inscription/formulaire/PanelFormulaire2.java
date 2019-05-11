package vue.inscription.formulaire;

import model.Adresse;
import utilitaires.ConstantesRegex;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.AndValidation;
import vue.validateur.NbValidation;
import vue.validateur.PasVideValidation;
import vue.validateur.PatternValidation;


import java.awt.*;

public class PanelFormulaire2 extends PanelFormulaireBase {
    public PanelFormulaire2() {
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
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255, new AndValidation(new PasVideValidation(), new AndValidation(new PatternValidation(ConstantesRegex.REGEX_CODEPOSTAL),new NbValidation(9992, '<')))));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255, new AndValidation(new PasVideValidation(),new PatternValidation(ConstantesRegex.REGEX_LOCALITE))));

        initList();
    }
}
