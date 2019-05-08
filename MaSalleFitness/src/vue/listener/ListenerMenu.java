package vue.listener;

import vue.panel.Raffraichissable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    public ListenerMenu(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(panel instanceof Raffraichissable){
            ((Raffraichissable) panel).raffraichir();
        }
        frame.setContentPane(panel);
        frame.repaint();
        frame.revalidate();
    }
}
