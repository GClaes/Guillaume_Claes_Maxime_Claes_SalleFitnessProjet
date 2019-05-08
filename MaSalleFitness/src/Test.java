import business.CandidatServiceImp;
import dataAccess.AdresseDao;
import dataAccess.CandidatDao;
import dataAccess.CandidatDaoImp;
import model.Adresse;
import model.Candidat;

public class Test {
    public static void main(String[] args) {
        CandidatDao dao = CandidatDaoImp.getInstance();
        Candidat candidat = dao.rechercherCandidat(2);
        Adresse adr = new Adresse("vdssdv", "2332", "ffsdfdss", "23");

        candidat.setNom("neymar");
        candidat.setPrenom("jean");
        candidat.setAdresse(adr);

        dao.modifierCandidat(candidat);
    }
}
