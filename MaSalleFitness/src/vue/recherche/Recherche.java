package vue.recherche;

import business.CandidatService;
import business.imp.CandidatServiceImp;
import model.Candidat;
import vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class Recherche extends JPanel {
    private CardLayout layout = new CardLayout();
    private FramePrincipale frame;
    private PanelRecherche panelRecherche;
    private PanelCandidatInfo panelCandidatInfo;
    private PanelModification panelModification;

    private CandidatService candidatService = new CandidatServiceImp();
    private Candidat candidat;

    public Recherche(FramePrincipale frame) {
        this.frame = frame;

        this.setLayout(layout);

        panelRecherche = new PanelRecherche(this);
        add(panelRecherche, "recherche");
    }

    public void retour(){
        frame.afficherAccueil();
    }

    public void recherche(int id){
        candidat = candidatService.rechercherCandidat(id);
        if(candidat == null){
            JOptionPane.showMessageDialog(null,"Le recherche recherché n'existe pas, veuillez entrer un identifiant correct","Erreur lors de la recherche",JOptionPane.ERROR_MESSAGE);
        }
        else{
            panelCandidatInfo = new PanelCandidatInfo(this,candidat);
            add(panelCandidatInfo, "info");
            layout.show(this, "info");
        }
    }

    public void supprimer(Candidat candidat){
        Object[] options = { "OK", "Annuler" };
        int valeur = JOptionPane.showOptionDialog(null, "Cliquez sur OK pour supprimer", "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if(valeur == JOptionPane.OK_OPTION){
            CandidatService candidatService = new CandidatServiceImp();
            candidatService.supprimerCandidat(candidat.getNumInscription());
            layout.show(this,"menu");
        }
    }

    public void modifier(Candidat candidat){
        panelModification = new PanelModification(this, candidat);
        add(panelModification, "modif");
        layout.show(this,"modif");
    }
}
