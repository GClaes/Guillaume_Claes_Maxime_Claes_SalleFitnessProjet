package presentation.controller.listener.rechercheCoachs;

import presentation.vue.recherches.rechercheCoachs.ListingCoach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private ListingCoach listingCoach;

    public RetourMenuListener(ListingCoach listingCoach) {
        this.listingCoach = listingCoach;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listingCoach.retour();
    }
}
