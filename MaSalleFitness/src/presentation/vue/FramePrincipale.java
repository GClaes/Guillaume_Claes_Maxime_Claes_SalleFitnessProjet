package presentation.vue;


import model.Candidat;
import presentation.vue.inscription.Inscription;
import presentation.vue.listing.listingAdresse.ListingAdresse;
import presentation.vue.listing.listingCandidats.Listing;
import presentation.vue.listing.listingCoachs.ListingCoach;
import presentation.vue.listing.listingNutri.ListingNutri;
import presentation.vue.recherches.rechercheAdresse.RechercheAdresse;
import presentation.vue.recherches.rechercheCandidat.Recherche;
import presentation.vue.recherches.rechercheCoachs.RechercheCoach;
import presentation.vue.recherches.rechercheNutritionnistes.RechercheNutri;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private CardLayout layout = new CardLayout();
    private PanelMenu panelMenu;
    private Inscription inscription;
    private Listing listing;
    private Recherche recherche;
    private RechercheCoach rechercheCoach;
    private RechercheNutri rechercheNutri;
    private RechercheAdresse rechercheAdresse;
    private ListingCoach listingCoach;
    private ListingNutri listingNutri;
    private ListingAdresse listingAdresse;

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
        this.setJMenuBar(new MaSalleFitnessMenu(this));
    }

    public void ajoutPanels(){
        panelMenu = new PanelMenu();
        inscription = new Inscription(this);
        listing = new Listing(this);
        recherche = new Recherche(this);
        rechercheCoach = new RechercheCoach(this);
        rechercheNutri = new RechercheNutri(this);
        rechercheAdresse = new RechercheAdresse(this);
        listingCoach = new ListingCoach(this);
        listingNutri = new ListingNutri(this);
        listingAdresse = new ListingAdresse(this);

        add(panelMenu,"menu");
        add(inscription,"inscription");
        add(listing, "listing");
        add(recherche, "recherche");
        add(rechercheCoach, "coachs");
        add(rechercheNutri,"nutris");
        add(rechercheAdresse,"adresses");
        add(listingCoach,"listCoach");
        add(listingNutri,"listNutri");
        add(listingAdresse,"listAdr");
    }
    public void afficherAccueil(){
        layout.show(this.getContentPane(),"menu");
    }
    public void afficherPanel(JPanel panel){
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
        else if (panel instanceof RechercheCoach){
            rechercheCoach.rafraichir();
            layout.show(this.getContentPane(),"coachs");
        }
        else if (panel instanceof RechercheNutri){
            rechercheNutri.rafraichir();
            layout.show(this.getContentPane(), "nutris");
        }
        else if (panel instanceof RechercheAdresse){
            rechercheAdresse.rafraichir();
            layout.show(this.getContentPane(),"adresses");
        }
        else if (panel instanceof ListingCoach){
            listingCoach.rafraichir();
            layout.show(this.getContentPane(), "listCoach");
        }
        else if(panel instanceof ListingNutri){
            listingNutri.rafraichir();
            layout.show(this.getContentPane(),"listNutri");
        }
        else if(panel instanceof ListingAdresse){
            listingAdresse.rafraichir();
            layout.show(this.getContentPane(),"listAdr");
        }
    }

    public void afficherCandidatInfo(Candidat candidat){
        layout.show(this.getContentPane(),"recherche");
        recherche.afficherCandidatInfo(candidat);
    }


}
