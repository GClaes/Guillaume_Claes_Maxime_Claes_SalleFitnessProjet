package presentation.controller.listener.recherche;

import presentation.vue.recherches.rechercheCandidat.FormulaireRecherche;
import presentation.vue.recherches.rechercheCandidat.Recherche;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechercheCandidatListener implements ActionListener {
    private Recherche recherche;
    private FormulaireRecherche formulaire;

    public RechercheCandidatListener(Recherche recherche, FormulaireRecherche formulaire) {
        this.recherche = recherche;
        this.formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(formulaire.validation()) {
            recherche.recherche(formulaire.getId());
        }
    }
}
