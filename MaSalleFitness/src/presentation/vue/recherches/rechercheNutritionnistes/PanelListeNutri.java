package presentation.vue.recherches.rechercheNutritionnistes;

import model.Coach;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheNutris.RetourMenuListener;

public class PanelListeNutri extends PanelBase<FormulaireListingNutri> {
    private FormulaireListingNutri listingNutriFormulaire = new FormulaireListingNutri();

    public PanelListeNutri(ListingNutritionniste listingNutritionniste){
        super("<html><h1>Liste des nutritionnistes travaillant avec ce coach</h1></html>","Retour","");
        addFormulaire(listingNutriFormulaire);

        setListenerBouton1(new RetourMenuListener(listingNutritionniste));
    }

    public void setCoach(Coach coach){
        listingNutriFormulaire.setCoach(coach);
    }
}
