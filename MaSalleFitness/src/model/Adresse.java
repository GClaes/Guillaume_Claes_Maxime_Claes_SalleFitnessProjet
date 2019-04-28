package model;

import model.exceptions.*;

import java.util.ArrayList;

public class Adresse {
    private String hash;
    private String localite;
    private String codePostal;
    private String rue;
    private String numero;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Adresse(String localite, String codePostal, String rue, String numero) throws Exception {
        setLocalite(localite);
        setCodePostal(codePostal);
        this.rue = rue;
        this.numero = numero;
    }

    public void setHash(String hash) {
        //Calcul du hash grace à l'adresse
    }

    public void setCodePostal(String codePostal) throws CodePostalException {
        Integer codePostalCast = Integer.parseInt(codePostal);

        if (codePostalCast == null || codePostalCast < 1000 || codePostalCast > 9992) {
            throw new CodePostalException(codePostal);
        }
        this.codePostal = codePostal;
    }

    public void setLocalite(String localite) throws LocaliteException {
        if (localite == null) {
            throw new LocaliteException(localite);
        }
    }



}
