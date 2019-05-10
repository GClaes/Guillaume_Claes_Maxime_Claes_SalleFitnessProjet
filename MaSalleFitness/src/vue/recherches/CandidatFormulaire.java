package vue.recherches;

import model.Candidat;
import vue.element.ElementFormulaireLabel;
import vue.inscription.formulaire.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;

public class CandidatFormulaire extends PanelFormulaireBase {
    public CandidatFormulaire() {
        setLayout(new GridLayout(7,2,25,25));
    }
    public void setCandidat(Candidat candidat){
        removeAll();
        setComposantes("id",new ElementFormulaireLabel("ID", new JLabel(candidat.getNumInscription().toString())));
        setComposantes("nom",new ElementFormulaireLabel("Nom", new JLabel(candidat.getNom())));
        setComposantes("prenom",new ElementFormulaireLabel("Prénom", new JLabel(candidat.getPrenom())));
        setComposantes("dateNaissance", new ElementFormulaireLabel("Date de naissance", new JLabel(candidat.getDateNaissance().toString())));
        setComposantes("nbHeures",new ElementFormulaireLabel("Nombre d'heures de coaching", new JLabel(candidat.getNbHeuresCoaching().toString()+" heures par semaine")));
        setComposantes("coach", new ElementFormulaireLabel("Nom du coach", new JLabel(candidat.getCoach().getNom()+" "+candidat.getCoach().getPrenom())));
        setComposantes("nutri", new ElementFormulaireLabel("Nom du nutritionniste", new JLabel(candidat.getNutritionniste().getNom()+" "+candidat.getNutritionniste().getPrenom())));

        initList();
    }
}
