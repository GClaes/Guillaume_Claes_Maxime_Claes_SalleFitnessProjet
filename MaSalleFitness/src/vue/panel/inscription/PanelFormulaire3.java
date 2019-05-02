package vue.panel.inscription;

import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PanelFormulaire3 extends PanelFormulaireBase {
    public PanelFormulaire3() {
        setLayout(new GridLayout(2, 2, 50, 100));

        //AMELIROER VALIDATEURS
        setComposantes("nbHeures", new ElementFormulaireJTextField("Nombre d'heures de coaching désiré", 2,
                new AndValidation(new PasVideValidation(), new AndValidation(
                        new NbValidation(1, '>'),new AndValidation(
                                new PatternValidation("[0-9]*"),new NbValidation(25,'<'))))));
        setComposantes("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255, new VideValidation()));

        for (Map.Entry<String, ElementFormulaire> entree : getComposantes().entrySet()) {
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }
    }

    public int getNbHeures(){
        return (int)getComposantes().get("nbHeures").getValue();
    }
    public String getMaladies(){
        return (String)getComposantes().get("maladie").getValue();
    }
}
