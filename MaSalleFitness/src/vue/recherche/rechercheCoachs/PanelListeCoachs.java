package vue.recherche.rechercheCoachs;

import model.Responsable;
import vue.inscription.PanelBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListeCoachs extends PanelBase<PanelListingCoachFormulaire> {
    private ListingCoach listingCoach;
    private PanelListingCoachFormulaire panelListingCoachFormulaire = new PanelListingCoachFormulaire();

    public PanelListeCoachs(ListingCoach listingCoach) {
        super("Liste des coachs gérants les candidats inscrits par ce responsable","Retour","Afficher");
        addFormulaire(panelListingCoachFormulaire);
        this.listingCoach = listingCoach;

        setListenerBouton1(new RetourListener());
    }

    private class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listingCoach.retour();
        }
    }
    public void setResponsable(Responsable responsable){
        panelListingCoachFormulaire.setResponsable(responsable);
    }
}
