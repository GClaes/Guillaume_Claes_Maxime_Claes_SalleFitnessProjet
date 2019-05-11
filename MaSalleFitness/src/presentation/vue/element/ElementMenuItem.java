package presentation.vue.element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ElementMenuItem extends JMenuItem {
    private JMenu menu;

    public ElementMenuItem(String nom, JMenu menu, ActionListener action) {
        super(nom);
        this.menu = menu;
        this.addActionListener(action);
        this.setFont(new Font("Gras",Font.BOLD,15));
        menu.add(this);
    }
}
