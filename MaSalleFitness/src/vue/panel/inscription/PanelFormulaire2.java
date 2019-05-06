package vue.panel.inscription;

import model.Adresse;
import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.AndValidation;
import vue.validateur.PasVideValidation;
import vue.validateur.PatternValidation;

import java.awt.*;
import java.util.Map;

public class PanelFormulaire2 extends PanelFormulaireBase {
    public PanelFormulaire2() {
        setLayout(new GridLayout(4,2,25,25));

        //AMELIROER VALIDATEURS
        setComposantes("rue",new ElementFormulaireJTextField("Rue", 255, new AndValidation(new PasVideValidation(), new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));
        setComposantes("num", new ElementFormulaireJTextField("Numéro", 255, new AndValidation(new PasVideValidation(),new PatternValidation("[0-9]*[a-zA-Z0-9]{1,5}"))));
        setComposantes("codePostal", new ElementFormulaireJTextField("Code postal", 255, new AndValidation(new PasVideValidation(), new PatternValidation("[0-9]{4}"))));
        setComposantes("localite", new ElementFormulaireJTextField("Localité", 255, new AndValidation(new PasVideValidation(),new PatternValidation("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$"))));

        initList();
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

}
