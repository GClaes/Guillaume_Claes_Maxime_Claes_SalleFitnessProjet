package vue.inscription;

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

    protected void setListenerBouton1(ActionListener listener){
        boutonsInscription.getBouton1().addActionListener(listener);
    }
    protected void setListenerBouton2(ActionListener listener){
        boutonsInscription.getBouton2().addActionListener(listener);
    }


    public T getFormulaire() {
        return formulaire;
    }

}

