package presentation.controller.listener.rechercheCoachs;

import presentation.vue.recherches.rechercheCoachs.RechercheCoach;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private RechercheCoach rechercheCoach;

    public RetourMenuListener(RechercheCoach rechercheCoach) {
        this.rechercheCoach = rechercheCoach;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rechercheCoach.retour();
    }
}
