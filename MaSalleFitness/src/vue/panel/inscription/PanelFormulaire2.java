package vue.panel;

import vue.element.ElementFormulaire;
import vue.element.ElementFormulaireJTextField;
import vue.validateur.AndValidation;
import vue.validateur.PasVideValidation;
import vue.validateur.PatternValidation;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PanelFormulaire2 extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;
    public PanelFormulaire2() {
        setLayout(new GridLayout(4,2,25,25));
        composantes = new LinkedHashMap<>();

        //AMELIROER VALIDATEURS
        composantes.put("rue",new ElementFormulaireJTextField("Rue", 255, new AndValidation(new PasVideValidation(), new PatternValidation("s"))));
        composantes.put("num", new ElementFormulaireJTextField("Numéro", 255, new AndValidation(new PasVideValidation(),new PatternValidation("s"))));
        composantes.put("codePostal", new ElementFormulaireJTextField("Code postal", 255, new AndValidation(new PasVideValidation(), new PatternValidation("s"))));
        composantes.put("localite", new ElementFormulaireJTextField("Localité", 255, new AndValidation(new PasVideValidation(),new PatternValidation("s"))));

        for(Map.Entry<String,ElementFormulaire> entree : composantes.entrySet()){
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }
    }

    public String getLocalite() {
        return (String)composantes.get("localite").getValue();
    }
    public boolean localiteValide(){
        return composantes.get("localite").valider();
    }

    public String getNumero() {
        return (String)composantes.get("num").getValue();
    }
    public boolean numeroValide(){
        return composantes.get("num").valider();
    }


    public String getRue() {
        return (String)composantes.get("rue").getValue();
    }
    public boolean rueValide(){
        return composantes.get("rue").valider();
    }


    public String getCodePostal() {
        return (String)composantes.get("codePostal").getValue();
    }
    public boolean codePostalValide(){
        return composantes.get("codePostal").valider();
    }


}
