package vue;

import vue.element.*;
import vue.inscription.Inscription;
import vue.listener.ListenerMenu;
import vue.listing.Listing;
import vue.recherche.rechercheCandidat.Recherche;
import vue.recherche.rechercheCoachs.ListingCoach;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu extends JMenuBar {
    private FramePrincipale frame;

    public MyMenu(FramePrincipale frame) {
        this.frame = frame;

        JMenu inscriptionMenu = new ElementMenu("Inscription");
        JMenuItem inscripCandidat = new ElementMenuItem("Inscrire un nouveau candidat",inscriptionMenu, new ListenerMenu(frame, new Inscription(frame)));
        JMenuItem modifCandidat = new ElementMenuItem("Modifier/Supprimer un candidat",inscriptionMenu,new ListenerMenu(frame,new Recherche(frame)));

        JMenu rechercheMenu = new ElementMenu("Rechercher");
        JMenuItem candidatRecherche = new ElementMenuItem("Rechercher un candidat", rechercheMenu, new ListenerMenu(frame,new Recherche(frame)));
        JMenuItem coachRecherche = new ElementMenuItem("Rechercher les candidats isncrits par un responsable", rechercheMenu, new ListenerMenu(frame,new ListingCoach(frame)));
        //JMenuItem responsableRecherche = new ElementMenuItemOld("Rechercher un responsable", rechercheMenu, new ListenerMenu(this,new PanelRecherche(3)));

        JMenu afficherListeMenu = new ElementMenu("Afficher");
        JMenuItem afficherListCandidat = new ElementMenuItem("Afficher la liste des candidats", afficherListeMenu, new ListenerMenu(frame, new Listing(frame)));

        JMenu optionMenu = new ElementMenu("Options");
        //JMenuItem info = new ElementMenuItemOld("Infos",optionMenu, new ListenerMenu(this,new PanelInfo()));
        JMenuItem exit = new ElementMenuItem("Quitter", optionMenu, new ActionListener() {
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
