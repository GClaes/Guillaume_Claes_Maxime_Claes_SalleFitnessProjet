package presentation.controleurs.rechercheAdresse;

import presentation.vue.listing.listingAdresse.thread.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvoyerCourrierListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new MyFrame();
    }
}
