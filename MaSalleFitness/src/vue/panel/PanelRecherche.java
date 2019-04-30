package vue.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRecherche extends JPanel {
    private JLabel titre;
    private JButton rechercher;
    private PanelFormulaireRecherche formulaire;
    private int categorie;

    public PanelRecherche(int categorie){
        setLayout(new BorderLayout());

        this.categorie = categorie;
        String nomCategorie = (categorie == 1)?"candidat":(categorie == 2)?"coach":"responsable";
        setBounds(15,80,750,200);
        titre = new JLabel("<html><h1>Recherche d'un "+nomCategorie+"</h1></html>");
        titre.setFont(new Font("Gras",Font.BOLD,30));
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire = new PanelFormulaireRecherche();
        rechercher = new JButton("Rechercher");
        rechercher.setFont(new Font("Gras",Font.BOLD,20));
        rechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(PanelRecherche.this.categorie){
                    case 1 :
                        //RECHERHCE A EFFECTUER
                        PanelRecherche.this.removeAll();
                        PanelRecherche.this.add(new PanelCandidat());
                        PanelRecherche.this.repaint();
                        PanelRecherche.this.revalidate();
                    break;
                    case 2 : System.out.println("Recherche coach");
                    break;
                    case 3 : System.out.println("Recherche responsable");
                    break;
                }
            }
        });


        this.add(titre, BorderLayout.NORTH);
        this.add(formulaire, BorderLayout.CENTER);
        this.add(rechercher,BorderLayout.SOUTH);
    }
}
