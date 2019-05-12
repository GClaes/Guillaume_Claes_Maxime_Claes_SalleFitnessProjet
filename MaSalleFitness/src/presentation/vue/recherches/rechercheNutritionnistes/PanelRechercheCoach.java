package presentation.vue.recherches.rechercheNutritionnistes;

import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheNutris.AccesPanelListeNutriListener;
import presentation.controleurs.rechercheNutris.RetourMenuListener;

public class PanelRechercheCoach extends PanelBase<FormulaireRechercheCoach> {
    private FormulaireRechercheCoach formulaireRechercheNutritionniste = new FormulaireRechercheCoach();

    public PanelRechercheCoach(RechercheNutri rechercheNutri) {
        super("<html><h1>Selection d'un coach</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheNutritionniste);

        setListenerBoutonGauche(new RetourMenuListener(rechercheNutri));
        setListenerBoutonDroite(new AccesPanelListeNutriListener(rechercheNutri,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheNutritionniste.rafraichir();
    }
}
