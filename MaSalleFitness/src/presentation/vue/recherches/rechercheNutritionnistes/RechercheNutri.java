package presentation.vue.recherches.rechercheNutritionnistes;

import model.Coach;
import presentation.vue.FramePrincipale;

import javax.swing.*;
import java.awt.*;

public class RechercheNutri extends JPanel {
    private FramePrincipale frame;
    private CardLayout layout = new CardLayout();
    private PanelRechercheCoach panelRechercheCoach;
    private PanelListeNutri panelListeNutri;

    public RechercheNutri(FramePrincipale frame) {
        this.frame = frame;

        setLayout(layout);
    }

    public void retour(){
        frame.afficherAccueil();
    }
    public void afficherListingNutri(Coach coach){
        panelListeNutri.setCoach(coach);
        layout.show(this,"nutri");
    }
    public void rafraichir(){
        panelRechercheCoach = new PanelRechercheCoach(this);
        panelListeNutri = new PanelListeNutri(this);
        add(panelRechercheCoach,"coach");
        add(panelListeNutri,"nutri");

        panelRechercheCoach.rafraichir();
        layout.show(this, "coach");
    }
}
