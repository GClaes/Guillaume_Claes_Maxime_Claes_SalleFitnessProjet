package vue.panel.inscription;

import vue.element.ElementFormulaire;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class PanelFormulaireBase extends JPanel {
    private LinkedHashMap<String, ElementFormulaire> composantes;

    public PanelFormulaireBase() {
        composantes = new LinkedHashMap<>();
    }

    public boolean validation(){
        for(Map.Entry<String,ElementFormulaire> entree : composantes.entrySet()){
            if(!entree.getValue().valider()) {
                //A MODIFIER
                return false;
            }
        }
        return true;
    }
    public LinkedHashMap<String, ElementFormulaire> getComposantes() {
        return composantes;
    }

    public void setComposantes(String cle, ElementFormulaire entree) {
        composantes.put(cle, entree);
    }
}
