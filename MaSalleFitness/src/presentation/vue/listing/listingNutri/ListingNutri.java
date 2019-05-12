package presentation.vue.listing.listingNutri;

import presentation.controleurs.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;

public class ListingNutri extends PanelBase<FormulaireListingNutri> {

    private FormulaireListingNutri listingNutriFormulaire = new FormulaireListingNutri();

    public ListingNutri(FramePrincipale frame){
        super("<html><h1>Liste des nutritionnistes travaillant avec ce coach</h1></html>","Retour","");
        addFormulaire(listingNutriFormulaire);
        setListenerBoutonGauche(new RetourMenuListener(frame));
    }

    public void rafraichir(){
        listingNutriFormulaire.rafraichir();
    }
}
