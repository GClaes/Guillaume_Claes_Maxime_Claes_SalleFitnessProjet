package presentation.controller.listener;

import presentation.vue.FramePrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourMenuListener implements ActionListener {
    private FramePrincipale frame;

    public RetourMenuListener(FramePrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.afficherAccueil();
    }
}
