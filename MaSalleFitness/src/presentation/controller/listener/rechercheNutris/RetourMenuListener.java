package presentation.controller.listener.rechercheNutris;

import presentation.vue.recherches.rechercheNutritionnistes.ListingNutritionniste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private ListingNutritionniste listingNutritionniste;
    public RetourMenuListener(ListingNutritionniste listingNutritionniste) {
        this.listingNutritionniste = listingNutritionniste;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listingNutritionniste.retour();
    }
}
