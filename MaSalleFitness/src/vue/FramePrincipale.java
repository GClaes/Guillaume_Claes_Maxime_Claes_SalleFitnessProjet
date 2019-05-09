package vue;


import vue.inscription.Inscription;
import vue.listing.Listing;
import vue.recherche.Recherche;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private CardLayout layout = new CardLayout();
    private PanelMenu panelMenu;
    private Inscription inscription;
    private Listing listing;
    private Recherche recherche;

    private JMenuBar menuBar;

    public FramePrincipale() {
        super("Ma Salle Fitness");
        this.setSize( 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(layout);
        this.setResizable(false);

        ajoutMenu();
        ajoutPanels();

        this.setVisible(true);
    }

    public void ajoutMenu(){
        this.setJMenuBar(new MyMenu(this));
    }

    public void ajoutPanels(){
        panelMenu = new PanelMenu();
        inscription = new Inscription(this);
        listing = new Listing(this);
        recherche = new Recherche(this);

        add(panelMenu,"menu");
        add(inscription,"inscription");
        add(listing, "listing");
        add(recherche, "recherche");
    }
    public void afficherAccueil(){
        layout.show(this.getContentPane(),"menu");
    }
    public void afficherPanel(JPanel panel){
        //reset
        if(panel instanceof Inscription) {
            layout.show(this.getContentPane(), "inscription");
        }
        else if (panel instanceof Listing){
            layout.show(this.getContentPane(), "listing");
        }
        else if (panel instanceof Recherche){
            layout.show(this.getContentPane(),"recherche");
        }
    }

}