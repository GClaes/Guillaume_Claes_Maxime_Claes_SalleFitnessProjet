package vue.panel.inscription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInscription extends PanelInscriptionBase<PanelFormulaire> {
    private PanelInscription2 panelInscription2;

    private JFrame frame;
    private Container cont;

    public PanelInscription(JFrame frame) {
        super("<html><h1>Inscription nouveau candidat [1/3]</h1></html>", "Suivant", new PanelFormulaire());
        this.frame = frame;
        cont = frame.getContentPane();
        setListener(new SuivantListener());
    }


    private class SuivantListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                PanelFormulaire formulaire = getFormulaire();
                PersonalData data = new PersonalData(formulaire.getNom(),
                        formulaire.getPrenom(),
                        formulaire.getDateNaissance(),
                        formulaire.getSexe(),
                        formulaire.getExp(),
                        formulaire.getNumTel());


                cont.removeAll();
                cont.add(new PanelInscription2(data, frame));
                cont.repaint();
                cont.revalidate();
                //panelInscription2 = new PanelInscription2(data);
                //PanelInscription.this.removeAll();
                //PanelInscription.this.add(panelInscription2);
                //PanelInscription.this.repaint();
                //PanelInscription.this.revalidate();
            }
        }
    }
}
