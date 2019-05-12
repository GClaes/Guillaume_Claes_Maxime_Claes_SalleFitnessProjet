package presentation.vue.recherches.rechercheAdresse;

import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheAdresse.AccesListingAdresseListener;
import presentation.controleurs.rechercheAdresse.RetourMenuListener;

public class PanelRechercheCandidat extends PanelBase<FormulaireRechercheDates> {
    private FormulaireRechercheDates formulaireRechercheDates = new FormulaireRechercheDates();
    public PanelRechercheCandidat(RechercheAdresse rechercheAdresse){
        super("<html><h1>Selection d'un responsable et des dates</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheDates);

        setListenerBoutonGauche(new RetourMenuListener(rechercheAdresse));
        setListenerBoutonDroite(new AccesListingAdresseListener(rechercheAdresse,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheDates.rafraichir();
    }
}
