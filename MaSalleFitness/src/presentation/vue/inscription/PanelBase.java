package presentation.vue.inscription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class PanelBase<T extends JPanel> extends JPanel {
    private JLabel titre;
    private BoutonsInscription boutonsInscription;
    private T formulaire;


    public PanelBase(String titre, String textBouton1, String textBouton2, T formulaire) {
        setBounds(10,80,200,400);
        this.titre = new JLabel(titre);
        this.titre.setHorizontalAlignment(SwingConstants.CENTER);

        boutonsInscription = new BoutonsInscription(textBouton1, textBouton2);
        this.formulaire = formulaire;

        setLayout(new BorderLayout());
        add(this.titre, BorderLayout.NORTH);
        add(boutonsInscription, BorderLayout.SOUTH);
        add(formulaire, BorderLayout.CENTER);
    }

    public PanelBase(String titre, String textBouton1, String textBouton2){
        setBounds(10,80,200,400);
        this.titre = new JLabel(titre);
        this.titre.setHorizontalAlignment(SwingConstants.CENTER);

        boutonsInscription = new BoutonsInscription(textBouton1, textBouton2);

        setLayout(new BorderLayout());
        add(this.titre, BorderLayout.NORTH);
        add(boutonsInscription, BorderLayout.SOUTH);
    }

    protected void setListenerBoutonGauche(ActionListener listener){
        boutonsInscription.getBoutonGauche().addActionListener(listener);
    }
    protected void setListenerBoutonDroite(ActionListener listener){
        boutonsInscription.getBoutonDroite().addActionListener(listener);
    }


    public void addFormulaire(T formulaire) {
        this.formulaire = formulaire;
        add(formulaire, BorderLayout.CENTER);
    }

    public T getFormulaire() {
        return formulaire;
    }

}

