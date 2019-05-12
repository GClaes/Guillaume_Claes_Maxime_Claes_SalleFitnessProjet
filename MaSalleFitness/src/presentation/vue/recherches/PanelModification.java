package presentation.vue.recherches;

import model.Candidat;
import presentation.vue.inscription.PanelBase;
import presentation.controleurs.recherche.ModifierListener;
import presentation.controleurs.recherche.RetourMenuListener;
import presentation.vue.recherches.rechercheCandidat.Recherche;

public class PanelModification extends PanelBase<FormulaireModification> {
    public PanelModification(Recherche recherche, Candidat candidat) {
        super("<html><h1>Modification d'un candidat</h1></html>","Annuler", "Valider", new FormulaireModification(candidat));

        setListenerBoutonGauche(new RetourMenuListener(recherche));
        setListenerBoutonDroite(new ModifierListener(getFormulaire(),recherche));
    }
}
