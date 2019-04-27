package model;

import java.util.ArrayList;

public class Adresse {
    private String hash;
    private String Localite;
    private String codePostal;
    private String rue;
    private String numero;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Adresse(String hash, String localite, String codePostal, String rue, String numero) {
        this.hash = hash;
        Localite = localite;
        this.codePostal = codePostal;
        this.rue = rue;
        this.numero = numero;
    }

}
