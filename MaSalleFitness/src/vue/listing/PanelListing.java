package vue.listing;

import model.Candidat;
import vue.inscription.PanelBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListing extends PanelBase<ListingFormulaire> {
    private Listing listing;
    public PanelListing(Listing listing) {
        super("<html><h1>Listing des candidats inscrits</h1></html>", "Retour","Afficher", new ListingFormulaire());
        this.listing = listing;
        setListenerBouton1(new AnnulerListener());
        setListenerBouton2(new AfficherListener());
    }

    private class AnnulerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listing.retour();
        }
    }
    private class AfficherListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().getIdSelect() != -1) {
                listing.afficherCandidat(getFormulaire().getIdSelect());
            }
        }
    }
}