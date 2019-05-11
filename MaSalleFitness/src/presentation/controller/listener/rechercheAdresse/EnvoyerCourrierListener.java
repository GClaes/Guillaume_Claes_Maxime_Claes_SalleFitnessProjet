package presentation.controller.listener.rechercheAdresse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvoyerCourrierListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Une lettre va être envoyée!","Envoi de lettre",1);

    }
}
