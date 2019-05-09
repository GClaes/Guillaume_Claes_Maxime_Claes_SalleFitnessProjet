package vue.listing;

import business.CandidatService;
import business.imp.CandidatServiceImp;
import model.Candidat;
import vue.FramePrincipale;
import vue.recherche.PanelCandidatInfo;
import vue.recherche.Recherche;

import javax.swing.*;
import java.awt.*;

public class Listing extends JPanel {
    private CardLayout layout = new CardLayout();
    private FramePrincipale frame;
    private PanelListing panelListing;
    private PanelCandidatInfo candidatInfo;
    private Recherche recherche;

    public Listing(FramePrincipale frame) {
        this.setLayout(layout);
        this.frame = frame;

        recherche = new Recherche(frame);
        panelListing = new PanelListing(this);
        add(panelListing, "listing");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void afficherCandidat(int id){
        CandidatService candidatService = new CandidatServiceImp();
        Candidat candidat = candidatService.rechercherCandidat(id);
        candidatInfo = new PanelCandidatInfo(recherche,candidat);
        add(candidatInfo, "info");
        layout.show(this, "info");
    }
}
