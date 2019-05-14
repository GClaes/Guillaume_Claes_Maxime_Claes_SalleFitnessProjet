package presentation.vue.listing.listingAdresse.thread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class PanelAnim extends JPanel implements Runnable {
    private MyFrame frame;
    private Thread thread;
    private ImageObserver imoLettre;
    private ImageObserver imoBoite;
    private Lettre lettre;
    private JLabel label;
    private String titre;
    private int nbPoints = 0;
    private int nbFois = 0;
    private boolean envoi = true;

    public PanelAnim(MyFrame frame){
        setLayout(new BorderLayout());
        this.frame = frame;
        lettre = new Lettre(50,600);
        titre = "Votre courrier est en cours d'envoi";
        label = new JLabel(titre);
        label.setFont(new Font("gras",Font.BOLD,30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
        initThread();
    }
    public void initThread(){
        this.setFocusable(true);
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawLettre(g);
        drawBoite(g);
        label.setText(titre);
    }

    public void drawLettre(Graphics g){
        if(lettre.isVisible()) {
            g.drawImage(lettre.getImage(), lettre.getPosX(), lettre.getPosY(), imoLettre);
        }
    }
    public void drawBoite(Graphics g){
        try {
            g.drawImage(ImageIO.read(new File("boiteLettre.png")), 450, 550, imoBoite);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void cycleAnim(){
        int posX = lettre.getPosX();

        if(posX < 450) {
            lettre.avancer();
        }
        else {
            if(interrompreThread()) {
                lettre.setPosX(50);
            }
            else{
                envoi = false;
            }
        }
        if(nbPoints == 3){
            titre = "Votre courrier est en cours d'envoi";
            nbPoints = 0;
        }
        else{
            titre+=".";
            nbPoints++;
        }
    }
    public boolean interrompreThread(){
        nbFois++;
        return(!(nbFois == 2));
    }

    @Override
    public void run() {
        while(envoi){
            repaint();
            cycleAnim();

            try{
                Thread.sleep(125);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            if(!envoi) {
                frame.dispose();
                JOptionPane.showMessageDialog(null,"Envoi(s) confirmé(s)!","Résultat de l'envoi",1);
            }
        }
    }
}
