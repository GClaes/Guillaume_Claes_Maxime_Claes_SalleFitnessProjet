package presentation.vue.recherches.rechercheCoachs;

import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheCoachs.AccesPanelListeCoachsListener;
import presentation.controller.listener.rechercheCoachs.RetourMenuListener;

public class PanelRechercheResponsable extends PanelBase<FormulaireRechercheResponsable> {
    private FormulaireRechercheResponsable formulaireRechercheResponsable = new FormulaireRechercheResponsable();

    public PanelRechercheResponsable(RechercheCoach rechercheCoach) {
        super("<html><h1>Selection d'un responsable</h1></html>", "Retour", "Valider");
        addFormulaire(formulaireRechercheResponsable);

        setListenerBouton1(new RetourMenuListener(rechercheCoach));
        setListenerBouton2(new AccesPanelListeCoachsListener(rechercheCoach,getFormulaire()));
    }

    public void rafraichir(){
        formulaireRechercheResponsable.rafraichir();
    }
}
