package presentation.controller.listener.recherche;

import presentation.vue.recherches.PanelCandidatInfo;
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
