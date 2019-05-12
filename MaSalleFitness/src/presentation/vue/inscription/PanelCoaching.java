package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.FormulaireCoaching;
import presentation.controleurs.inscription.EnvoyerListener;
import presentation.controleurs.inscription.RetourMenuListener;


public class PanelCoaching extends PanelBase<FormulaireCoaching> {
    private FormulaireCoaching formulaireCoaching = new FormulaireCoaching();

    public PanelCoaching(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [3/3]</h1></html>", "Annuler","Envoyer");
        addFormulaire(formulaireCoaching);
        setListenerBoutonGauche(new RetourMenuListener(inscription));
        setListenerBoutonDroite(new EnvoyerListener(getFormulaire(), inscription));
    }

    public void rafraichir(){
        formulaireCoaching.rafraichir();
    }
}
