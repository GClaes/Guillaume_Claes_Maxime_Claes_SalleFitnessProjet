package presentation.vue.listing.listingCoachs;

import presentation.controller.listener.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;

public class ListingCoach extends PanelBase<FormulaireListingCoach> {

    private FormulaireListingCoach panelListingCoachFormulaire = new FormulaireListingCoach();
    private FramePrincipale frame;

    public ListingCoach(FramePrincipale frame) {
        super("<html><h1>Liste des coachs et leur(s) candidat(s)</h1></html>","Retour","");
        addFormulaire(panelListingCoachFormulaire);
        this.frame = frame;
        setListenerBouton1(new RetourMenuListener(frame));
    }

    public void rafraichir(){
        panelListingCoachFormulaire.rafraichir();
    }
}
