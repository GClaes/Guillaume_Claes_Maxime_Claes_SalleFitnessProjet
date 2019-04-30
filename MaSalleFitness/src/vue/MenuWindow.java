package vue;

import vue.element.ElementMenu;
import vue.element.ElementMenuItem;
import vue.listener.ListenerMenu;
import vue.panel.PanelInfo;
import vue.panel.PanelInscription;
import vue.panel.PanelMenu;
import vue.panel.PanelRecherche;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {

    public MenuWindow(){
        //CREATION FRAME
        super("MaSalleFitness");
        setBounds(0,0,800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //CREATION MENU
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu inscriptionMenu = new ElementMenu("Inscription");
        JMenuItem inscripCandidat = new ElementMenuItem("Inscrire un nouveau candidat",inscriptionMenu, new ListenerMenu(this, new PanelInscription()));
        JMenuItem modifCandidat = new ElementMenuItem("Modifier un candidat",inscriptionMenu,new ListenerMenu(this,new PanelRecherche(1)));
        JMenuItem supprCandidat = new ElementMenuItem("Supprimer un candidat", inscriptionMenu,new ListenerMenu(this,new PanelRecherche(1)));


        JMenu rechercheMenu = new ElementMenu("Recherche");
        JMenuItem candidatRecherche = new ElementMenuItem("Rechercher un candidat", rechercheMenu, new ListenerMenu(this,new PanelRecherche(1)));
        JMenuItem coachRecherche = new ElementMenuItem("Rechercher un coach", rechercheMenu, new ListenerMenu(this,new PanelRecherche(2)));
        JMenuItem responsableRecherche = new ElementMenuItem("Rechercher un responsable", rechercheMenu, new ListenerMenu(this,new PanelRecherche(3)));

        JMenu afficherListeMenu = new ElementMenu("Afficher");
        JMenuItem afficherListCandidat = new ElementMenuItem("Afficher la liste des candidats", afficherListeMenu, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenu optionMenu = new ElementMenu("Options");
        JMenuItem info = new ElementMenuItem("Infos",optionMenu, new ListenerMenu(this,new PanelInfo()));
        JMenuItem exit = new ElementMenuItem("Quitter", optionMenu, new ActionListener() {
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
