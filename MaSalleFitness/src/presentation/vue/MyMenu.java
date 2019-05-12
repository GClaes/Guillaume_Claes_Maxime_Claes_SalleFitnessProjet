package presentation.vue;

import presentation.vue.element.*;
import presentation.vue.inscription.Inscription;
import presentation.controller.listener.ListenerMenu;
import presentation.vue.listing.listingAdresse.ListingAdresse;
import presentation.vue.listing.listingCandidats.Listing;
import presentation.vue.listing.listingCoachs.ListingCoach;
import presentation.vue.listing.listingNutri.ListingNutri;
import presentation.vue.recherches.rechercheAdresse.RechercheAdresse;
import presentation.vue.recherches.rechercheCandidat.Recherche;
import presentation.vue.recherches.rechercheCoachs.RechercheCoach;
import presentation.vue.recherches.rechercheNutritionnistes.RechercheNutri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu extends JMenuBar {
    private FramePrincipale frame;

    public MyMenu(FramePrincipale frame) {
        this.frame = frame;

        JMenu inscriptionMenu = new ElementMenu("Inscription");
        new ElementMenuItem("Inscrire un nouveau candidat",inscriptionMenu, new ListenerMenu(frame, new Inscription(frame)));
        new ElementMenuItem("Modifier/Supprimer un candidat",inscriptionMenu,new ListenerMenu(frame,new Recherche(frame)));

        JMenu rechercheMenu = new ElementMenu("Rechercher");
        new ElementMenuItem("Rechercher un candidat", rechercheMenu, new ListenerMenu(frame,new Recherche(frame)));
        new ElementMenuItem("Rechercher les coachs travaillant avec un responsable", rechercheMenu, new ListenerMenu(frame,new RechercheCoach(frame)));
        new ElementMenuItem("Rechercher les nutritionnistes travaillant avec un coach", rechercheMenu, new ListenerMenu(frame,new RechercheNutri(frame)));
        new ElementMenuItem("Rechercher les adresses des candidats s'étant inscrits entre 2 dates", rechercheMenu, new ListenerMenu(frame,new RechercheAdresse(frame)));


        JMenu afficherListeMenu = new ElementMenu("Afficher");
        new ElementMenuItem("Afficher la liste des candidats", afficherListeMenu, new ListenerMenu(frame, new Listing(frame)));
        new ElementMenuItem("Afficher la liste des coachs et leur(s) candidat(s)", afficherListeMenu, new ListenerMenu(frame, new ListingCoach(frame)));
        new ElementMenuItem("Afficher la liste des nutritionnistes et leur(s) candidat(s)", afficherListeMenu, new ListenerMenu(frame, new ListingNutri(frame)));
        new ElementMenuItem("Afficher la liste des adresses et leur(s) candidat(s)", afficherListeMenu, new ListenerMenu(frame, new ListingAdresse(frame)));


        JMenu optionMenu = new ElementMenu("Options");
        new ElementMenuItem("Quitter", optionMenu, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        this.add(inscriptionMenu);
        this.add(rechercheMenu);
        this.add(afficherListeMenu);
        this.add(optionMenu);


    }
}
