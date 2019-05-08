package vue.panel.listing;

import vue.panel.PanelMenu;
import vue.panel.Raffraichissable;
import vue.panel.inscription.PanelInscriptionBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListing extends PanelInscriptionBase<PanelListingFormulaire> implements Raffraichissable {
    public PanelListing() {
        super("<html><h1>Listing des candidats inscrits</h1></html>","Retour", new PanelListingFormulaire());
        setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelListing.this.removeAll();
                PanelListing.this.add(new PanelMenu());
                PanelListing.this.repaint();
                PanelListing.this.revalidate();
            }
        });

    }

    @Override
    public void raffraichir() {
        ((Raffraichissable)getFormulaire()).raffraichir();
    }
}
