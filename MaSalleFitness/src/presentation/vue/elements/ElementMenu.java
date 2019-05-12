package presentation.vue.elements;

import javax.swing.*;
import java.awt.*;

public class ElementMenu extends JMenu {

    public ElementMenu(String nom) {
        super(nom);
        this.setFont(new Font("Gras", Font.BOLD,20));
    }
}
