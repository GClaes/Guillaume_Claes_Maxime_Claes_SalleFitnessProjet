package vue.listing;

import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListing extends PanelBase<ListingFormulaire> {
    private Listing listing;
    private ListingFormulaire listingFormulaire = new ListingFormulaire();
    public PanelListing(Listing listing) {
        super("<html><h1>Listing des candidats inscrits</h1></html>", "Retour","Afficher");
        this.listing = listing;
        addFormulaire(listingFormulaire);
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

    public void rafraichir(){
        listingFormulaire.rafraichir();
    }
}
