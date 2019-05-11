package presentation.vue.recherches.rechercheCoachs;

import model.Responsable;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheCoachs.RetourMenuListener;

public class PanelListeCoachs extends PanelBase<FormulaireListingCoach> {
    private FormulaireListingCoach panelListingCoachFormulaire = new FormulaireListingCoach();

    public PanelListeCoachs(ListingCoach listingCoach) {
        super("<html><h1>Liste des coachs des candidats inscrits par ce responsable</h1></html>","Retour","");
        addFormulaire(panelListingCoachFormulaire);

        setListenerBouton1(new RetourMenuListener(listingCoach));
    }

    public void setResponsable(Responsable responsable){
        panelListingCoachFormulaire.setResponsable(responsable);
    }
}
