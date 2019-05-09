package vue.recherche;

import vue.element.ElementFormulaireJTextField;
import vue.inscription.formulaire.PanelFormulaireBase;
import vue.validateur.AndValidation;
import vue.validateur.PasVideValidation;
import vue.validateur.PatternValidation;

import java.awt.*;

public class FormulaireRecherche extends PanelFormulaireBase {

    public FormulaireRecherche(){
        setLayout(new GridLayout(1,2,25,25));

        setComposantes("id",new ElementFormulaireJTextField("Numéro d'identifiant", 30, new AndValidation(new PasVideValidation(),new PatternValidation("[0-9]+"))));
        initList();
    }
    public int getId(){
        return Integer.parseInt((String)getComposantes().get("id").getValue());
    }
}
