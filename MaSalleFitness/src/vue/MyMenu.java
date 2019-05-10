package vue;

import vue.element.*;
import vue.inscription.Inscription;
import vue.listener.ListenerMenu;
import vue.listing.Listing;
import vue.recherches.rechercheCandidat.Recherche;
import vue.recherches.rechercheCoachs.ListingCoach;
import vue.recherches.rechercheNutritionnistes.ListingNutritionniste;

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
        new ElementMenuItem("Rechercher les coachs travaillant avec un responsable", rechercheMenu, new ListenerMenu(frame,new ListingCoach(frame)));
        new ElementMenuItem("Rechercher les nutritionnistes travaillant avec un coach", rechercheMenu, new ListenerMenu(frame,new ListingNutritionniste(frame)));

        JMenu afficherListeMenu = new ElementMenu("Afficher");
        new ElementMenuItem("Afficher la liste des candidats", afficherListeMenu, new ListenerMenu(frame, new Listing(frame)));

        JMenu optionMenu = new ElementMenu("Options");
        //JMenuItem info = new ElementMenuItemOld("Infos",optionMenu, new ListenerMenu(this,new PanelInfo()));
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
