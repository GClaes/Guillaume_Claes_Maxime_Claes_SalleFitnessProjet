package presentation.controller.listener;

import presentation.vue.FramePrincipale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener {
    private FramePrincipale frame;
    private JPanel panel;
    public ListenerMenu(FramePrincipale frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.afficherPanel(panel);
    }
}
