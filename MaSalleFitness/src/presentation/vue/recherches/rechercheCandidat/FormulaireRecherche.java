package presentation.vue.recherches.rechercheCandidat;

import presentation.vue.element.ElementFormulaireJTextField;
import presentation.vue.inscription.formulaire.PanelFormulaireBase;
import presentation.vue.validateur.AndValidation;
import presentation.vue.validateur.PasVideValidation;
import presentation.vue.validateur.PatternValidation;

import java.awt.*;


public class FormulaireRecherche extends PanelFormulaireBase {

    public FormulaireRecherche(){
        setLayout(new FlowLayout());
    }
    public int getId(){
        return Integer.parseInt((String)getComposantes().get("id").getValue());
    }
    public void rafraichir(){
        removeAll();
        setComposantes("id",new ElementFormulaireJTextField("Numéro d'identifiant", 30, new AndValidation(new PasVideValidation(),new PatternValidation("[0-9]+"))));
        initList();
    }

}
