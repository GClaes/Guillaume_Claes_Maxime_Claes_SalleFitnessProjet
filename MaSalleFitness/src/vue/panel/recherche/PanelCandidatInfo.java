package vue.panel.recherche;

import model.Candidat;
import vue.element.ElementFormulaireLabel;
import vue.panel.inscription.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class PanelCandidatInfo extends PanelFormulaireBase {

    public PanelCandidatInfo(Candidat candidat){
        setLayout(new GridLayout(4,2,25,25));
        Date date = new Date();
        setComposantes("nom",new ElementFormulaireLabel("Nom", null, new JLabel(candidat.getNom())));
        setComposantes("prénom",new ElementFormulaireLabel("Prénom", null, new JLabel(candidat.getPrenom())));
        setComposantes("dateNaissance",new ElementFormulaireLabel("Date de naissance", null, new JLabel(candidat.getDateNaissance().toString())));
        setComposantes("nbHeures",new ElementFormulaireLabel("Nombre d'heures de coaching", null, new JLabel(candidat.getNbHeuresCoaching().toString())));
        initList();
    }


}
