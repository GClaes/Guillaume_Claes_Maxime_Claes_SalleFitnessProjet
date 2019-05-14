package presentation.controleurs.recherche;

import presentation.vue.modif_suppression.PanelCandidatInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccesPanelModifierListener implements ActionListener {
    private PanelCandidatInfo panelCandidatInfo;

    public AccesPanelModifierListener(PanelCandidatInfo panelCandidatInfo) {
        this.panelCandidatInfo = panelCandidatInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelCandidatInfo.modifierCandidat();
    }


}
