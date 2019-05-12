package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.FormulaireAdresse;
import presentation.controleurs.inscription.AccesPanelCoachListener;
import presentation.controleurs.inscription.RetourMenuListener;


public class PanelAdresse extends PanelBase<FormulaireAdresse> {
    private FormulaireAdresse formulaireAdresse = new FormulaireAdresse();

    public PanelAdresse(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [2/3]</h1></html>","Annuler","Suivant");
        addFormulaire(formulaireAdresse);
        setListenerBoutonGauche(new RetourMenuListener(inscription));
        setListenerBoutonDroite(new AccesPanelCoachListener(inscription,getFormulaire()));
    }


    public void rafraichir(){
        formulaireAdresse.rafraichir();
    }
}
