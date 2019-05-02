package vue.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class PanelInscriptionBase<T extends JPanel> extends JPanel {
    private JLabel titre;
    private JButton bouton;
    private T formulaire;

    public PanelInscriptionBase(String label, String textBouton, T formulaire) {
        setBounds(10,80,200,400);
        titre = new JLabel(label);
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        this.formulaire = formulaire;

        bouton = new JButton(textBouton);
        bouton.setFont(new Font("Gras",Font.BOLD,20));


        setLayout(new BorderLayout());
        add(titre, BorderLayout.NORTH);
        add(bouton, BorderLayout.SOUTH);
        add(formulaire, BorderLayout.CENTER);

    }

    public void setListener(ActionListener listener){
        bouton.addActionListener(listener);
    }

    public T getFormulaire() {
        return formulaire;
    }
}

