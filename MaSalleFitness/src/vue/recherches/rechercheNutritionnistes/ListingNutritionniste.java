package vue.recherches.rechercheNutritionnistes;

import model.Coach;
import vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class ListingNutritionniste extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelRechercheCoach panelRechercheCoach;
    private PanelListeNutri panelListeNutri;

    public ListingNutritionniste(FramePrincipale frame) {
        this.frame = frame;

        setLayout(layout);

        panelRechercheCoach = new PanelRechercheCoach(this);
        panelListeNutri = new PanelListeNutri(this);

        add(panelRechercheCoach,"coach");
        add(panelListeNutri,"nutri");
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void afficherListingNutri(Coach coach){
        panelListeNutri.setCoach(coach);
        layout.show(this,"nutri");
    }
    public void rafraichir(){
        panelRechercheCoach.rafraichir();
        layout.show(this, "coach");
    }
}