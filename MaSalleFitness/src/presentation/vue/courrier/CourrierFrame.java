package presentation.vue.courrier;

import javax.swing.*;

public class CourrierFrame extends JFrame {
    public CourrierFrame(){
        super("Envoi(s) de courrier(s)");
        setSize(800,800);
        setResizable(false);
        this.add(new PanelAnim(this));
        setVisible(true);
    }
}
