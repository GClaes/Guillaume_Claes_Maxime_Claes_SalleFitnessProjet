package presentation.vue.recherches.rechercheCoachs;

import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheCoachs.AccesPanelListeCoachsListener;
import presentation.controleurs.rechercheCoachs.RetourMenuListener;

public class PanelRechercheResponsable extends PanelBase<FormulaireRechercheResponsable> {
    private FormulaireRechercheResponsable formulaireRechercheResponsable = new FormulaireRechercheResponsable();

    public PanelRechercheResponsable(RechercheCoach rechercheCoach) {
        super("<html><h1>Selection d'un responsable</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheResponsable);

        setListenerBoutonGauche(new RetourMenuListener(rechercheCoach));
        setListenerBoutonDroite(new AccesPanelListeCoachsListener(rechercheCoach,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheResponsable.rafraichir();
    }
}
