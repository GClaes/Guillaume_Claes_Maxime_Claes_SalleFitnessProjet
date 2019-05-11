package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.PanelFormulaire2;
import presentation.controller.listener.inscription.AccesPanelCoachListener;
import presentation.controller.listener.inscription.RetourMenuListener;


public class PanelAdresse extends PanelBase<PanelFormulaire2> {
    private PanelFormulaire2 panelFormulaire2 = new PanelFormulaire2();

    public PanelAdresse(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [2/3]</h1></html>","Annuler","Suivant");
        addFormulaire(panelFormulaire2);
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new AccesPanelCoachListener(inscription,getFormulaire()));
    }


    public void rafraichir(){
        panelFormulaire2.rafraichir();
    }
}
