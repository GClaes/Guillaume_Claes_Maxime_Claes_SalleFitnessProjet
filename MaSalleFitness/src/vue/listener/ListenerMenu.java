package vue.listener;

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
        System.out.println("ping");
        frame.setContentPane(panel);
        //panel.repaint();
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
    }
}
