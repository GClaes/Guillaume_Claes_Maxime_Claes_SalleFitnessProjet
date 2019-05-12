package presentation.vue.listing.listingCoachs;

import presentation.controleurs.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;

public class ListingCoach extends PanelBase<FormulaireListingCoach> {

    private FormulaireListingCoach panelListingCoachFormulaire = new FormulaireListingCoach();

    public ListingCoach(FramePrincipale frame) {
        super("<html><h1>Liste des coachs et leur(s) candidat(s)</h1></html>","Retour","");
        addFormulaire(panelListingCoachFormulaire);
        setListenerBoutonGauche(new RetourMenuListener(frame));
    }

    public void rafraichir(){
        panelListingCoachFormulaire.rafraichir();
    }
}
