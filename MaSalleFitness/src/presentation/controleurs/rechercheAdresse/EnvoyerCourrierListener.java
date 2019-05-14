package presentation.controleurs.rechercheAdresse;

import presentation.vue.courrier.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvoyerCourrierListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new MyFrame();
    }
}
