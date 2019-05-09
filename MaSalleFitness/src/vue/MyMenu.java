package vue;

import vue.element.*;
import vue.inscription.Inscription;
import vue.listener.ListenerMenu;
import vue.listing.Listing;
import vue.recherche.Recherche;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu extends JMenuBar {
    private FramePrincipale frame;

    public MyMenu(FramePrincipale frame) {
        this.frame = frame;

        JMenu inscriptionMenu = new ElementMenu("Inscription");
        JMenuItem inscripCandidat = new ElementMenuItem("Inscrire un nouveau recherche",inscriptionMenu, new ListenerMenu(frame, new Inscription(frame)));
        JMenuItem modifCandidat = new ElementMenuItem("Modifier/Supprimer un recherche",inscriptionMenu,new ListenerMenu(frame,new Recherche(frame)));

        JMenu rechercheMenu = new ElementMenu("Rechercher");
        JMenuItem candidatRecherche = new ElementMenuItem("Rechercher un recherche", rechercheMenu, new ListenerMenu(frame,new Recherche(frame)));
        //JMenuItem coachRecherche = new ElementMenuItemOld("Rechercher un coach", rechercheMenu, new ListenerMenu(this,new PanelRecherche(2)));
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
