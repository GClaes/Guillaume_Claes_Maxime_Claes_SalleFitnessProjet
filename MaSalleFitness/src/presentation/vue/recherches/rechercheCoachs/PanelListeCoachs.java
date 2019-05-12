package presentation.vue.recherches.rechercheCoachs;

import model.Responsable;
import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheCoachs.RetourMenuListener;

public class PanelListeCoachs extends PanelBase<FormulaireTableCoach> {

    private FormulaireTableCoach formulaireTableCoach = new FormulaireTableCoach();
    public PanelListeCoachs(RechercheCoach rechercheCoach) {
        super("<html><h1>Liste des coachs des candidats inscrits par ce responsable</h1></html>","Retour","");
        addFormulaire(formulaireTableCoach);
        setListenerBoutonGauche(new RetourMenuListener(rechercheCoach));
    }

    public void setResponsable(Responsable responsable){
        formulaireTableCoach.setResponsable(responsable);
    }
}
