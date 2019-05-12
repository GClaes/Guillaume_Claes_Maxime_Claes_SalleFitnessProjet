package presentation.vue.recherches.rechercheAdresse;

import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheAdresse.AccesListingAdresseListener;
import presentation.controller.listener.rechercheAdresse.RetourMenuListener;

public class PanelRechercheCandidat extends PanelBase<FormulaireRechercheDates> {
    private FormulaireRechercheDates formulaireRechercheDates = new FormulaireRechercheDates();
    public PanelRechercheCandidat(RechercheAdresse rechercheAdresse){
        super("<html><h1>Selection d'un responsable et des dates</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheDates);

        setListenerBouton1(new RetourMenuListener(rechercheAdresse));
        setListenerBouton2(new AccesListingAdresseListener(rechercheAdresse,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheDates.rafraichir();
    }
}
