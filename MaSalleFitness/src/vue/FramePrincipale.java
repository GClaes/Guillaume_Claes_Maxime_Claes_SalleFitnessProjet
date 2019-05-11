package vue;


import model.Candidat;
import vue.inscription.Inscription;
import vue.listing.Listing;
import vue.recherches.rechercheAdresse.ListingAdresse;
import vue.recherches.rechercheCandidat.Recherche;
import vue.recherches.rechercheCoachs.ListingCoach;
import vue.recherches.rechercheNutritionnistes.ListingNutritionniste;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private CardLayout layout = new CardLayout();
    private PanelMenu panelMenu;
    private Inscription inscription;
    private Listing listing;
    private Recherche recherche;
    private ListingCoach listingCoach;
    private ListingNutritionniste listingNutritionniste;
    private ListingAdresse listingAdresse;

    private JMenuBar menuBar;

    public FramePrincipale() {
        super("Ma Salle Fitness");
        this.setSize( 800, 700);
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
        listingCoach = new ListingCoach(this);
        listingNutritionniste = new ListingNutritionniste(this);
        listingAdresse = new ListingAdresse(this);

        add(panelMenu,"menu");
        add(inscription,"inscription");
        add(listing, "listing");
        add(recherche, "recherche");
        add(listingCoach, "coachs");
        add(listingNutritionniste,"nutris");
        add(listingAdresse,"adresses");
    }
    public void afficherAccueil(){
        layout.show(this.getContentPane(),"menu");
    }
    public void afficherPanel(JPanel panel){
        //reset
        if(panel instanceof Inscription) {
            inscription.rafraichir();
            layout.show(this.getContentPane(), "inscription");
        }
        else if (panel instanceof Listing){
            listing.rafraichir();
            layout.show(this.getContentPane(), "listing");
        }
        else if (panel instanceof Recherche){
            recherche.rafraichir();
            layout.show(this.getContentPane(),"recherche");
        }
        else if (panel instanceof ListingCoach){
            listingCoach.rafraichir();
            layout.show(this.getContentPane(),"coachs");
        }
        else if (panel instanceof ListingNutritionniste){
            listingNutritionniste.rafraichir();
            layout.show(this.getContentPane(), "nutris");
        }
        else if (panel instanceof ListingAdresse){
            listingAdresse.rafraichir();
            layout.show(this.getContentPane(),"adresses");
        }
    }

    public void afficherCandidatInfo(Candidat candidat){
        layout.show(this.getContentPane(),"recherche");
        recherche.afficherCandidatInfo(candidat);
    }


}
