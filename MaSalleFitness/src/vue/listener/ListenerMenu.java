package vue.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerInscription implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    public ListenerInscription(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setContentPane(panel);
        frame.repaint();
    }
}
