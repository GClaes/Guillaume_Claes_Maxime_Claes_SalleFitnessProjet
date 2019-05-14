package presentation.vue.courrier;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("Envoi de courrier(s)");
        setSize(800,800);
        setResizable(false);
        this.add(new PanelAnim(this));
        setVisible(true);
    }
}
