package vue.panel;

import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PanelFormulaire3 extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;
    public PanelFormulaire3() {
        setLayout(new GridLayout(2, 2, 50, 100));
        composantes = new LinkedHashMap<>();

        //AMELIROER VALIDATEURS
        composantes.put("nbHeures", new ElementFormulaireJTextField("Nombre d'heures de coaching désirées", 2, new AndValidation(new PasVideValidation(), new NbValidation(1))));
        composantes.put("maladie", new ElementFormulaireJTextField("Maladies chroniques éventuelles", 255, new VideValidation()));

        for (Map.Entry<String, ElementFormulaire> entree : composantes.entrySet()) {
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }
    }
    public int getNbHeures(){
        return (int)composantes.get("nbHeures").getValue();
    }
    public String getMaladies(){
        return (String)composantes.get("maladie").getValue();
    }
}
