package vue.panel.recherche;

import vue.element.ElementFormulaireJTextField;
import vue.panel.inscription.PanelFormulaireBase;
import vue.validateur.*;


import java.awt.*;

public class PanelFormulaireRecherche extends PanelFormulaireBase {


    public PanelFormulaireRecherche(){
        setLayout(new GridLayout(1,2,25,25));

        setComposantes("id",new ElementFormulaireJTextField("Numéro d'identifiant", 30, new AndValidation(new EstEntierValidation(),new PasVideValidation())));
        initList();
    }
    public int getId(){
        return (int)getComposantes().get("id").getValue();
    }
}
