package vue.listing;

import business.CandidatService;
import business.imp.CandidatServiceImp;
import model.Candidat;
import vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class Listing extends JPanel {
    private CardLayout layout = new CardLayout();
    private FramePrincipale frame;
    private PanelListing panelListing;

    public Listing(FramePrincipale frame) {
        this.setLayout(layout);
        this.frame = frame;

        panelListing = new PanelListing(this);
        add(panelListing, "listing");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void afficherCandidat(int id){
        CandidatService candidatService = CandidatServiceImp.getInstance();
        Candidat candidat = candidatService.rechercherCandidat(id);
        frame.afficherCandidatInfo(candidat);
    }

    public void rafraichir(){
        panelListing.rafraichir();
    }
}
