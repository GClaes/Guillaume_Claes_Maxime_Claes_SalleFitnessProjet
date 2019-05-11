package presentation.controller.listener.inscription;

import presentation.vue.inscription.Inscription;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private Inscription inscription;

    public RetourMenuListener(Inscription inscription) {
        this.inscription = inscription;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inscription.annuler();
    }
}
