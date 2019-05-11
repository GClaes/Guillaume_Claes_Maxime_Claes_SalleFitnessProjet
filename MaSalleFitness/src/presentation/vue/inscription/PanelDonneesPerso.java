package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.PanelFormulaire;
import presentation.controller.listener.inscription.RetourMenuListener;
import presentation.controller.listener.inscription.AccesPanelAdresseListener;

public class PanelDonneesPerso extends PanelBase<PanelFormulaire> {
    private PanelFormulaire panelFormulaire = new PanelFormulaire();

    public PanelDonneesPerso(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [1/3]</h1></html>", "Annuler", "Suivant");
        addFormulaire(panelFormulaire);
        setListenerBouton1(new RetourMenuListener(inscription));
        setListenerBouton2(new AccesPanelAdresseListener(inscription,getFormulaire()));

    }

    public void rafraichir(){
        panelFormulaire.rafraichir();
    }

}
