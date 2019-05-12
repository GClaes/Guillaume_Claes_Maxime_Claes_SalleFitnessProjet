package presentation.controleurs.rechercheAdresse;

import presentation.vue.recherches.rechercheAdresse.RechercheAdresse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private RechercheAdresse rechercheAdresse;

    public RetourMenuListener(RechercheAdresse rechercheAdresse) {
        this.rechercheAdresse = rechercheAdresse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rechercheAdresse.retour();
    }
}
