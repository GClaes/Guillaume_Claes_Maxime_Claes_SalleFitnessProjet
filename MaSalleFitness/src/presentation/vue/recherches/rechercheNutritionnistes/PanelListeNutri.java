package presentation.vue.recherches.rechercheNutritionnistes;

import model.Coach;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheNutris.RetourMenuListener;

public class PanelListeNutri extends PanelBase<FormulaireTableNutri> {

    private FormulaireTableNutri formulaireTableNutri = new FormulaireTableNutri();

    public PanelListeNutri(RechercheNutri rechercheNutri){
        super("<html><h1>Liste des nutritionnistes travaillant avec ce coach</h1></html>","Retour","");
        addFormulaire(formulaireTableNutri);
        setListenerBouton1(new RetourMenuListener(rechercheNutri));
    }

    public void setCoach(Coach coach){
        formulaireTableNutri.setCoach(coach);
    }
}
