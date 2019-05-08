package business;

import dataAccess.AdresseDao;
import dataAccess.AdresseDaoImp;

public class AdresseServiceImp implements AdresseService {
    private static AdresseDao adresseDao;       //AdresseDao adresseDao = new AdresseDaoImp();



    private AdresseServiceImp() {
        setAdresseDao(new AdresseDaoImp());
    }

    public static AdresseDao getInstance() {
        if (adresseDao == null) {
            new AdresseServiceImp();
            //adresseDao = new AdresseDaoImp();     En commentaire dans le constructeur
            //setAdresseDao(new AdresseDaoImp());   En commentaire dans le constructeur
        }
        return adresseDao;
    }

    private void setAdresseDao(AdresseDao adresseDao) {
        this.adresseDao = adresseDao;
    }
}
