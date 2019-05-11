package presentation.vue.recherches;

import model.Candidat;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.recherche.ModifierListener;
import presentation.controller.listener.recherche.RetourMenuListener;
import presentation.vue.recherches.rechercheCandidat.Recherche;

public class PanelModification extends PanelBase<FormulaireModification> {
    public PanelModification(Recherche recherche, Candidat candidat) {
        super("<html><h1>Modification d'un candidat</h1></html>","Annuler", "Valider", new FormulaireModification(candidat));

        setListenerBouton1(new RetourMenuListener(recherche));
        setListenerBouton2(new ModifierListener(getFormulaire(),recherche));
    }
}
