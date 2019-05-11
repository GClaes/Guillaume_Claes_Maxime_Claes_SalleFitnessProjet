package presentation.vue.recherches.rechercheCandidat;

import business.CandidatService;
import business.impl.CandidatServiceImpl;
import model.Candidat;
import presentation.vue.FramePrincipale;
import presentation.vue.recherches.PanelCandidatInfo;
import presentation.vue.recherches.PanelModification;

import javax.swing.*;
import java.awt.*;

public class Recherche extends JPanel {
    private CardLayout layout = new CardLayout();
    private FramePrincipale frame;
    private PanelRecherche panelRecherche;
    private PanelCandidatInfo panelCandidatInfo;
    private PanelModification panelModification;

    private CandidatService candidatService = CandidatServiceImpl.getInstance();
    private Candidat candidat;

    public Recherche(FramePrincipale frame) {
        this.frame = frame;

        this.setLayout(layout);

        panelRecherche = new PanelRecherche(this);
        panelCandidatInfo = new PanelCandidatInfo(this);
        add(panelRecherche, "recherche");
        add(panelCandidatInfo, "info");

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
            afficherCandidatInfo(candidat);
        }
    }

    public void supprimer(Candidat candidat){
        Object[] options = { "OK", "Annuler" };
        int valeur = JOptionPane.showOptionDialog(null, "Cliquez sur OK pour supprimer", "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if(valeur == JOptionPane.OK_OPTION){
            CandidatService candidatService = CandidatServiceImpl.getInstance();
            candidatService.supprimerCandidat(candidat.getNumInscription());
            frame.afficherAccueil();
            layout.show(this,"menu");
        }
    }

    public void modifier(Candidat candidat){
        panelModification = new PanelModification(this, candidat);
        add(panelModification, "modif");
        layout.show(this,"modif");
    }

    public void afficherCandidatInfo(Candidat candidat) {
        panelCandidatInfo.setCandidat(candidat);
        layout.show(this, "info");
    }
    public void modifierCandidat(Candidat candidat){
        CandidatService candidatService = CandidatServiceImpl.getInstance();
        candidatService.modifierCandidat(candidat);
        frame.afficherAccueil();
    }

    public void rafraichir(){
        panelRecherche.rafraichir();
        layout.show(this,"recherche");
    }
}
