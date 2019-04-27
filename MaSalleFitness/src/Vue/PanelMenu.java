package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.*;
import javax.imageio.*;

public class PanelMenu extends JPanel {
    private Image img;
    private ImageObserver imo;

    public PanelMenu(){

    }
    public void paintComponent(Graphics g){
        dessinerFond(g);
        dessinerEntête(g);
    }

    public void dessinerFond(Graphics g){
        try {
            img = ImageIO.read(new File("Fond.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(img,0,0,imo);
    }
    public void dessinerEntête(Graphics g){
        try {
            img = ImageIO.read(new File("Entete.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(img,146,146,imo);
    }
}
