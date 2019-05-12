package presentation.controleurs.rechercheNutris;

import presentation.vue.recherches.rechercheNutritionnistes.RechercheNutri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private RechercheNutri rechercheNutri;
    public RetourMenuListener(RechercheNutri rechercheNutri) {
        this.rechercheNutri = rechercheNutri;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rechercheNutri.retour();
    }
}
