package Vue;

import javax.swing.*;
import java.awt.*;

public class PanelCandidatInfo extends JPanel {
    private JLabel nomLabel, prénomLabel, sexeLabel, dateNaissanceLabel;
    private JLabel nom, prénom, sexe, dateNaissance;
    private Font gras;
    public PanelCandidatInfo(){
        setLayout(new GridLayout(4,2,25,15));
        gras = new Font("Gras",Font.BOLD,20);


        nomLabel = new JLabel("Nom");
        nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabel.setFont(gras);
        nom = new JLabel("RECHERCHE A FAIRE");
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        nom.setFont(gras);

        prénomLabel = new JLabel("Prénom");
        prénomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prénomLabel.setFont(gras);
        prénom = new JLabel("RECHERCHE A FAIRE");
        prénom.setHorizontalAlignment(SwingConstants.CENTER);
        prénom.setFont(gras);

        sexeLabel = new JLabel("Sexe");
        sexeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sexeLabel.setFont(gras);
        sexe = new JLabel("RECHERCHE A FAIRE");
        sexe.setHorizontalAlignment(SwingConstants.CENTER);
        sexe.setFont(gras);

        dateNaissanceLabel = new JLabel("Date de naissance");
        dateNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateNaissanceLabel.setFont(gras);
        dateNaissance = new JLabel("RECHERCHE A FAIRE");
        dateNaissance.setHorizontalAlignment(SwingConstants.CENTER);
        dateNaissance.setFont(gras);


        this.add(nomLabel);
        this.add(nom);
        this.add(prénomLabel);
        this.add(prénom);
        this.add(sexeLabel);
        this.add(sexe);
        this.add(dateNaissanceLabel);
        this.add(dateNaissance);
    }
}
