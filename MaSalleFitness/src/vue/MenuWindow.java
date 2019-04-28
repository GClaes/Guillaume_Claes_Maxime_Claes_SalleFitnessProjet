package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MenuWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu inscriptionMenu, rechercheMenu, afficherListeMenu, optionMenu;
    private JMenuItem inscripCandidat, modifCandidat, supprCandidat, candidatRecherche, coachRecherche, responsableRecherche, afficherListCandidat, info, exit;
    private Font fontTitre;
    private Font fontSousTitre;

    public MenuWindow(){
        //CREATION FRAME
        super("MaSalleFitness");
        setBounds(0,0,800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        fontTitre = new Font("Gras",Font.BOLD,20);
        fontSousTitre = new Font("Gras",Font.BOLD,15);

        //CREATION MENU
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        inscriptionMenu = new JMenu("Inscription");
        inscriptionMenu.setFont(fontTitre);
        menuBar.add(inscriptionMenu);
        inscripCandidat = new JMenuItem("Inscrire un nouveau candidat");
        inscripCandidat.setFont(fontSousTitre);
        inscripCandidat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
        inscripCandidat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelInscription());
                repaint();
            }
        });
        inscriptionMenu.add(inscripCandidat);
        modifCandidat = new JMenuItem("Modifier un candidat");
        modifCandidat.setFont(fontSousTitre);
        modifCandidat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelRecherche(1));
                repaint();
            }
        });
        inscriptionMenu.add(modifCandidat);
        supprCandidat = new JMenuItem("Supprimer un candidat");
        supprCandidat.setFont(fontSousTitre);
        supprCandidat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelRecherche(1));
                repaint();
            }
        });
        inscriptionMenu.add(supprCandidat);

        rechercheMenu = new JMenu("Rechercher");
        rechercheMenu.setFont(fontTitre);
        menuBar.add(rechercheMenu);
        candidatRecherche = new JMenuItem("Rechercher un candidat");
        candidatRecherche.setFont(fontSousTitre);
        candidatRecherche.addActionListener(new ActionListener() {
            //NON FONCTIONNEL
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelRecherche(1));
                repaint();
            }
        });
        rechercheMenu.add(candidatRecherche);
        coachRecherche = new JMenuItem("Rechercher un coach");
        coachRecherche.setFont(fontSousTitre);
        coachRecherche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        coachRecherche.addActionListener(new ActionListener() {
            //NON FONCTIONNEL
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelRecherche(2));
                repaint();
            }
        });
        rechercheMenu.add(coachRecherche);

        responsableRecherche = new JMenuItem("Rechercher un responsable");
        responsableRecherche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
        responsableRecherche.setFont(fontSousTitre);
        responsableRecherche.addActionListener(new ActionListener() {
            //NON FONCTIONNEL
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelRecherche(3));
                repaint();
            }
        });
        rechercheMenu.add(responsableRecherche);


        afficherListeMenu = new JMenu("Afficher");
        afficherListeMenu.setFont(fontTitre);
        menuBar.add(afficherListeMenu);

        afficherListCandidat = new JMenuItem("Afficher la liste des candidats");
        afficherListCandidat.setFont(fontSousTitre);
        afficherListCandidat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        afficherListeMenu.add(afficherListCandidat);

        optionMenu = new JMenu("Options");
        optionMenu.setFont(fontTitre);
        menuBar.add(optionMenu);

        info = new JMenuItem("Infos");
        info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        info.setFont(fontSousTitre);
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new PanelInfo());
                repaint();
            }
        });
        optionMenu.add(info);

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        exit.setFont(fontSousTitre);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        optionMenu.add(exit);




        setContentPane(new PanelMenu());
        setVisible(true);
    }
}
