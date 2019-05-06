package vue.panel.inscription;

import vue.element.ElementFormulaire;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class PanelFormulaireBase extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;

    public PanelFormulaireBase() {
        composantes = new LinkedHashMap<>();

    }
    public void initList(){
        for(Map.Entry<String,ElementFormulaire> entree : getComposantes().entrySet()){
            add(entree.getValue().getLabel());
            Component component = entree.getValue().getField();
            component.setFont(new Font("gras", Font.BOLD, 20));
            add(component);
        }
    }

    public boolean validation(){
        boolean valide = true;
        StringBuilder texte = new StringBuilder();
        texte.append("Veuillez remplir ces champs d'une façon valide:\n");
        for(Map.Entry<String,ElementFormulaire> entree : composantes.entrySet()){
            if(!entree.getValue().valider()) {
                texte.append(entree.getValue().getLabel().getText()+'\n');
                valide = false;
            }
        }
        if(!valide){
            JOptionPane.showMessageDialog(null,texte.toString(),"Erreur lors de l'inscription",JOptionPane.ERROR_MESSAGE);
        }
        return valide;
    }
    public LinkedHashMap<String, ElementFormulaire> getComposantes() {
        return composantes;
    }

    public void setComposantes(String cle, ElementFormulaire entree) {
        composantes.put(cle, entree);
    }

}
