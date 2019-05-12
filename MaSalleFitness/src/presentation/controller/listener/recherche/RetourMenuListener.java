package presentation.controller.listener.recherche;

import presentation.vue.recherches.rechercheCandidat.Recherche;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private Recherche recherche;

    public RetourMenuListener(Recherche recherche) {
        this.recherche = recherche;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        recherche.retour();
    }
}
