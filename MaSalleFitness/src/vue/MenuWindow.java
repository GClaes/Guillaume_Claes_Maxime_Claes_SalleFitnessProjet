package vue;

import vue.element.ElementMenu;
import vue.element.ElementMenuItem;
import vue.listener.ListenerMenu;
import vue.panel.*;
import vue.panel.inscription.PanelInscription;
import vue.panel.recherche.PanelRecherche;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    private Container content;

    private JMenuBar menuBar;
    private JMenu inscriptionMenu,rechercheMenu,afficherListeMenu,optionMenu;
    private JMenuItem inscripCandidat, modifCandidat,supprCandidat, candidatRecherche,coachRecherche,responsableRecherche,
            afficherListCandidat, info, exit;

    public MenuWindow(){
        //CREATION FRAME
        super("MaSalleFitness");
        content = this.getContentPane();
        setBounds(0,0,800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //CREATION MENU
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        inscriptionMenu = new ElementMenu("Inscription");
        inscripCandidat = new ElementMenuItem("Inscrire un nouveau candidat",inscriptionMenu, new ListenerMenu(this, new PanelInscription()));
        modifCandidat = new ElementMenuItem("Modifier un candidat",inscriptionMenu,new ListenerMenu(this,new PanelRecherche(1)));

        supprCandidat = new ElementMenuItem("Supprimer un candidat", inscriptionMenu,new ListenerMenu(this,new PanelRecherche(1)));


        rechercheMenu = new ElementMenu("Recherche");
        candidatRecherche = new ElementMenuItem("Rechercher un candidat", rechercheMenu, new ListenerMenu(this,new PanelRecherche(1)));
        coachRecherche = new ElementMenuItem("Rechercher un coach", rechercheMenu, new ListenerMenu(this,new PanelRecherche(2)));
        responsableRecherche = new ElementMenuItem("Rechercher un responsable", rechercheMenu, new ListenerMenu(this,new PanelRecherche(3)));

        afficherListeMenu = new ElementMenu("Afficher");
        afficherListCandidat = new ElementMenuItem("Afficher la liste des candidats", afficherListeMenu, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        optionMenu = new ElementMenu("Options");
        info = new ElementMenuItem("Infos",optionMenu, new ListenerMenu(this,new PanelInfo()));
        exit = new ElementMenuItem("Quitter", optionMenu, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        menuBar.add(inscriptionMenu);
        menuBar.add(rechercheMenu);
        menuBar.add(afficherListeMenu);
        menuBar.add(optionMenu);


        //Affichage fond d'écran
        setContentPane(new PanelMenu());
        setVisible(true);
    }
}
