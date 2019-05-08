package vue.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private Container container;
    public ListenerMenu(JFrame frame, JPanel panel){
        this.frame = frame;
        container = frame.getContentPane();
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        container.removeAll();
        container.add(panel);
        container.repaint();
        container.revalidate();

        //frame.setContentPane(panel);
        //frame.repaint();
        //frame.revalidate();
    }
}
