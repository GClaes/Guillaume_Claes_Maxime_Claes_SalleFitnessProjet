package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.PanelFormulaire3;
import presentation.controller.listener.inscription.EnvoyerListener;
import presentation.controller.listener.inscription.RetourMenuListener;


public class PanelCoaching extends PanelBase<PanelFormulaire3> {
    private PanelFormulaire3 panelFormulaire3 = new PanelFormulaire3();

    public PanelCoaching(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [3/3]</h1></html>", "Annuler","Envoyer");
        addFormulaire(panelFormulaire3);
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new EnvoyerListener(getFormulaire(), inscription));
    }

    public void rafraichir(){
        panelFormulaire3.rafraichir();
    }
}
