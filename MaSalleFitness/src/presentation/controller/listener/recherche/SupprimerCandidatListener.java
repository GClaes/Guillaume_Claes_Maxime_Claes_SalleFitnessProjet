package presentation.controller.listener.recherche;

import presentation.vue.recherches.PanelCandidatInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupprimerCandidatListener implements ActionListener {
    private PanelCandidatInfo panelCandidatInfo;

    public SupprimerCandidatListener(PanelCandidatInfo panelCandidatInfo) {
        this.panelCandidatInfo = panelCandidatInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelCandidatInfo.supprimerCandidat();
    }


}
