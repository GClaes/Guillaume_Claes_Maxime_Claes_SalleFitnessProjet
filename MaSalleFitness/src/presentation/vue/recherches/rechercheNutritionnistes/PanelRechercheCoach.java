package presentation.vue.recherches.rechercheNutritionnistes;

import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheNutris.AccesPanelListeNutriListener;
import presentation.controller.listener.rechercheNutris.RetourMenuListener;

public class PanelRechercheCoach extends PanelBase<FormulaireRechercheCoach> {
    private FormulaireRechercheCoach formulaireRechercheNutritionniste = new FormulaireRechercheCoach();

    public PanelRechercheCoach(ListingNutritionniste listingNutritionniste) {
        super("<html><h1>Selection d'un coach</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheNutritionniste);

        setListenerBouton1(new RetourMenuListener(listingNutritionniste));
        setListenerBouton2(new AccesPanelListeNutriListener(listingNutritionniste,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheNutritionniste.rafraichir();
    }
}
