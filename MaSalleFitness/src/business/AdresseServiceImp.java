package business;

import dataAccess.AdresseDao;
import dataAccess.AdresseDaoImp;

public class AdresseServiceImp implements AdresseService {
    private AdresseDao adresseDao;

    public AdresseServiceImp() {
        setAdresseDao(new AdresseDaoImp());
    }

    public void setAdresseDao(AdresseDao adresseDao) {
        this.adresseDao = adresseDao;
    }
}
