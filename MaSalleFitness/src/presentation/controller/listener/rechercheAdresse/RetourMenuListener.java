package presentation.controller.listener.rechercheAdresse;

import presentation.vue.recherches.rechercheAdresse.ListingAdresse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private ListingAdresse listingAdresse;

    public RetourMenuListener(ListingAdresse listingAdresse) {
        this.listingAdresse = listingAdresse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listingAdresse.retour();
    }
}
