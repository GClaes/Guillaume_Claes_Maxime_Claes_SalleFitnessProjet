package presentation.vue.recherches.rechercheCandidat;

import presentation.vue.inscription.PanelBase;
import presentation.controleurs.recherche.RechercheCandidatListener;
import presentation.controleurs.recherche.RetourMenuListener;

public class PanelRecherche extends PanelBase<FormulaireRecherche> {
    private FormulaireRecherche formulaireRecherche = new FormulaireRecherche();
    public PanelRecherche(Recherche recherche){
        super("<html><h1>Recherche d'un candidat","Annuler","Rechercher");
        addFormulaire(formulaireRecherche);
        setListenerBoutonGauche(new RetourMenuListener(recherche));
        setListenerBoutonDroite(new RechercheCandidatListener(recherche,getFormulaire()));

    }
    public void rafraichir(){
        formulaireRecherche.rafraichir();
    }
}
