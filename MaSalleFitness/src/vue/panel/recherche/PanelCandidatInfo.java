package vue.panel.recherche;

import model.Candidat;
import vue.element.ElementFormulaireLabel;
import vue.panel.inscription.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;


public class PanelCandidatInfo extends PanelFormulaireBase {

    public PanelCandidatInfo(Candidat candidat){
        setLayout(new GridLayout(4,2,25,25));

        setComposantes("id",new ElementFormulaireLabel("ID", null, new JLabel(candidat.getNumInscription().toString())));
        setComposantes("nom",new ElementFormulaireLabel("Nom", null, new JLabel(candidat.getNom())));
        setComposantes("prénom",new ElementFormulaireLabel("Prénom", null, new JLabel(candidat.getPrenom())));
        setComposantes("nbHeures",new ElementFormulaireLabel("Nombre d'heures de coaching", null, new JLabel(candidat.getNbHeuresCoaching().toString())));
        initList();
    }


}
