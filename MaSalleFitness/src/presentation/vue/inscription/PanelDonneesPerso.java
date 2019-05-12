package presentation.vue.inscription;

import presentation.vue.inscription.formulaire.FormulaireDonneesPerso;
import presentation.controleurs.inscription.RetourMenuListener;
import presentation.controleurs.inscription.AccesPanelAdresseListener;

public class PanelDonneesPerso extends PanelBase<FormulaireDonneesPerso> {
    private FormulaireDonneesPerso panelFormulaire = new FormulaireDonneesPerso();

    public PanelDonneesPerso(Inscription inscription) {
        super("<html><h1>Inscription nouveau candidat [1/3]</h1></html>", "Annuler", "Suivant");
        addFormulaire(panelFormulaire);
        setListenerBoutonGauche(new RetourMenuListener(inscription));
        setListenerBoutonDroite(new AccesPanelAdresseListener(inscription,getFormulaire()));

    }

    public void rafraichir(){
        panelFormulaire.rafraichir();
    }

}
