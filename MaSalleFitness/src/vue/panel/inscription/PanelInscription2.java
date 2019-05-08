package vue.panel.inscription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInscription2 extends PanelInscriptionBase<PanelFormulaire2> {
    private PersonalData data;
    private PanelInscription3 panelInscription3;
    public PanelInscription2(PersonalData data){
        super("<html><h1>Inscription nouveau candidat [2/3]</h1></html>","Suivant", new PanelFormulaire2());
        setListener(new SuivantListener());
        this.data = data;
    }
    private class SuivantListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(getFormulaire().validation()){
                data.setAdresse(getFormulaire().getAdresse());


                panelInscription3 = new PanelInscription3(data);
                PanelInscription2.this.removeAll();
                PanelInscription2.this.add(panelInscription3);
                PanelInscription2.this.repaint();
                PanelInscription2.this.revalidate();
            }
        }
    }
}
