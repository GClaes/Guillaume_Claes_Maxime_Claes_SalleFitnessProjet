package presentation.vue.listing.listingNutri;

import presentation.controller.listener.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;

public class ListingNutri extends PanelBase<FormulaireListingNutri> {

    private FormulaireListingNutri listingNutriFormulaire = new FormulaireListingNutri();
    private FramePrincipale frame;

    public ListingNutri(FramePrincipale frame){
        super("<html><h1>Liste des nutritionnistes travaillant avec ce coach</h1></html>","Retour","");
        addFormulaire(listingNutriFormulaire);
        this.frame = frame;

        setListenerBouton1(new RetourMenuListener(frame));
    }

    public void rafraichir(){
        listingNutriFormulaire.rafraichir();
    }
}
