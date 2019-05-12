package presentation.vue.listing.listingAdresse.thread;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("Test");
        setSize(800,800);
        setResizable(false);
        this.add(new PanelAnim(this));
        setVisible(true);
    }
}
