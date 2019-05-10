package business.imp;

import business.AdresseService;
import dataAccess.AdresseDao;
import dataAccess.imp.AdresseDaoImp;

public class AdresseServiceImp implements AdresseService {
    private final AdresseDao adresseDao = AdresseDaoImp.getInstance();
    private static AdresseService adresseService;

    private AdresseServiceImp() { }

    public static AdresseService getInstance() {
        if (adresseService == null) {
            adresseService = new AdresseServiceImp();
        }
        return adresseService;
    }
}
