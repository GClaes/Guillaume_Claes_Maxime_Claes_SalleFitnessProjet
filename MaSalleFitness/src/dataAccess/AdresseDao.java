package dataAccess;

import model.Adresse;

public interface AdresseDao {
    boolean adresseExiste(String codeHash);
    void ajouterAdresse(Adresse adresse);
    void supprimerAdresse(String code_hash);
}
