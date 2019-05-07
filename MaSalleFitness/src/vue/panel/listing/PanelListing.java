package vue.panel.listing;

import vue.panel.inscription.PanelInscriptionBase;
import vue.panel.listing.PanelListingFormulaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListing extends PanelInscriptionBase<PanelListingFormulaire> {
    public PanelListing() {
        super("<html><h1>Listing des candidats inscrits</h1></html>","Retour", new PanelListingFormulaire());
        setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
