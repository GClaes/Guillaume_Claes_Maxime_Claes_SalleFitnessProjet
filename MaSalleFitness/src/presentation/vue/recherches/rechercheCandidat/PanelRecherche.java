package presentation.vue.recherches.rechercheCandidat;

import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.recherche.RechercheCandidatListener;
import presentation.controller.listener.recherche.RetourMenuListener;

public class PanelRecherche extends PanelBase<FormulaireRecherche> {
    private FormulaireRecherche formulaireRecherche = new FormulaireRecherche();
    public PanelRecherche(Recherche recherche){
        super("<html><h1>Recherche d'un candidat","Annuler","Rechercher");
        addFormulaire(formulaireRecherche);
        setListenerBouton1(new RetourMenuListener(recherche));
        setListenerBouton2(new RechercheCandidatListener(recherche,getFormulaire()));

    }
    public void rafraichir(){
        formulaireRecherche.rafraichir();
    }
}
