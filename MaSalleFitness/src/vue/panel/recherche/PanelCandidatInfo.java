package vue.panel.recherche;

import vue.element.ElementFormulaireLabel;
import vue.panel.inscription.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class PanelCandidatInfo extends PanelFormulaireBase {

    public PanelCandidatInfo(){
        setLayout(new GridLayout(4,2,25,25));
        Date date = new Date();
        setComposantes("nom",new ElementFormulaireLabel("Nom", null, new JLabel("Peet")));
        setComposantes("prénom",new ElementFormulaireLabel("Prénom", null, new JLabel("Dimitri")));
        setComposantes("dateNaissance",new ElementFormulaireLabel("Date de naissance", null, new JLabel(date.toString())));
        setComposantes("nbHeures",new ElementFormulaireLabel("Nombre d'heures de coaching", null, new JLabel("10")));
        initList();
    }


}
